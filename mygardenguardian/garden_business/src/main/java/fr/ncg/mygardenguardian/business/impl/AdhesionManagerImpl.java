package fr.ncg.mygardenguardian.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.IAdhesionManager;
import fr.ncg.mygardenguardian.business.contract.IUtilisateurManager;
import fr.ncg.mygardenguardian.business.mapper.AdhesionMapper;
import fr.ncg.mygardenguardian.business.mapper.UtilisateurMapper;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.entites.Adhesion;
import fr.ncg.mygardenguardian.entites.Utilisateur;

@Transactional
@Service
public class AdhesionManagerImpl implements IAdhesionManager {

	private IDaoFactory daoFacto;
	private IUtilisateurManager userManager;

	@Override
	public AdhesionDTO renouvellementAdhesion(AdhesionDTO adhesionDTO) {
		if (this.verfierExistenceAdhesion(adhesionDTO)) {
			Adhesion adhesion = AdhesionMapper.fromAdhesionDTOToAdhesion(adhesionDTO);
			adhesion.setArchive(true);
			adhesion.setDateAnnulation(Calendar.getInstance().getTime());
			this.daoFacto.getAdhesionDao().saveAndFlush(adhesion);
			Adhesion monAdhesionRenouvellee = new Adhesion();
			monAdhesionRenouvellee.setArchive(false);
			monAdhesionRenouvellee.setDateAdhesion(Calendar.getInstance().getTime());
			monAdhesionRenouvellee.setDateAnnulation(null);
			monAdhesionRenouvellee.setParcelle(adhesion.getParcelle());
			monAdhesionRenouvellee.setUtilisateur(adhesion.getUtilisateur());
			monAdhesionRenouvellee = this.daoFacto.getAdhesionDao().saveAndFlush(monAdhesionRenouvellee);
			return AdhesionMapper.fromAdhesionToAdhesionDTO(monAdhesionRenouvellee);
		} else {
			throw new RuntimeException("L'adhésion n'existe pas.");
		}
	}

	@Override
	public AdhesionDTO nouvelleInscription(AdhesionDTO adhesionDTO) {

		if (!this.verfierExistenceAdhesion(adhesionDTO)) {
			Adhesion adhesion = AdhesionMapper.fromAdhesionDTOToAdhesion(adhesionDTO);
			// this.daoFacto.getCoordonneesUtilisateurDao()
			// .saveAndFlush(adhesion.getUtilisateur().getCoordonneeUtilisateur());
			Utilisateur monJardinier = UtilisateurMapper.fromUtilisateurDTOToUtilisateur(
					this.userManager.inscriptionUtilisateur(adhesionDTO.getUtilisateurDTO()));
			adhesion.setUtilisateur(monJardinier);
			adhesion.setDateAnnulation(null);
			adhesion = this.daoFacto.getAdhesionDao().saveAndFlush(adhesion);
			return AdhesionMapper.fromAdhesionToAdhesionDTO(adhesion);
		} else {
			Example<Adhesion> monExAdhesion = Example.of(AdhesionMapper.fromAdhesionDTOToAdhesion(adhesionDTO));
			throw new RuntimeException("L'adhesion existe deja. Adhesion N° "
					+ this.daoFacto.getAdhesionDao().findOne(monExAdhesion).get().getIdAdhesion());
		}

	}

	@Override
	public void annulerAdhesion(AdhesionDTO adhesionDTO) {
		if (this.verfierExistenceAdhesion(adhesionDTO)) {
			adhesionDTO.setDateAnnulation(Calendar.getInstance().getTime());
			adhesionDTO.setArchive(true);
			// Parcelle maParcelleLiberee =
			// ParcelleMapper.fromParcelleDTOToParcelle(adhesionDTO.getParcelleDTO());
			// maParcelleLiberee.setOccupation(false);
			// this.daoFacto.getParcelleDao().saveAndFlush(maParcelleLiberee);
			this.daoFacto.getAdhesionDao().saveAndFlush(AdhesionMapper.fromAdhesionDTOToAdhesion(adhesionDTO));
		} else {
			throw new RuntimeException("L'adhesion n'existe pas.");
		}
	}

	private boolean verfierExistenceAdhesion(AdhesionDTO adhesionDto) {
		// --verification de l'existence de l'utilisateur au prealable
		if (this.userManager.verifExistenceUtilisateur(adhesionDto.getUtilisateurDTO())) {
			Example<Utilisateur> monExUtilisateur = Example
					.of(UtilisateurMapper.fromUtilisateurDTOToUtilisateur(adhesionDto.getUtilisateurDTO()));
			adhesionDto.getUtilisateurDTO().setIdUtilisateur(
					this.getDaoFacto().getUtilisateurDao().findOne(monExUtilisateur).get().getIdUtilisateur());
			// --verification de l'existence de l'adhesion a partir de l'id de l'utilisateur
			if (this.daoFacto.getAdhesionDao().findByIdUtilisateurAndArchive(
					(adhesionDto.getUtilisateurDTO().getIdUtilisateur()), false) == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public AdhesionDTO trouverAdhesionUtilisateur(UtilisateurDTO utilisateurDTO) {
		return AdhesionMapper.fromAdhesionToAdhesionDTO(
				this.daoFacto.getAdhesionDao().findByIdUtilisateurAndArchive(utilisateurDTO.getIdUtilisateur(), false));
	}

	@Override
	public List<AdhesionDTO> trouverJardiniers() {
		List<AdhesionDTO> mesJardiniers = new ArrayList<AdhesionDTO>();
		for (Adhesion a : this.daoFacto.getAdhesionDao().findByArchive(false)) {
			mesJardiniers.add(AdhesionMapper.fromAdhesionToAdhesionDTO(a));
		}
		return mesJardiniers;
	}

	@Override
	public AdhesionDTO trouverParId(Integer idAdhesion) {
		return AdhesionMapper.fromAdhesionToAdhesionDTO(this.daoFacto.getAdhesionDao().findById(idAdhesion).get());
	}

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

	public IUtilisateurManager getUserManager() {
		return this.userManager;
	}

	@Autowired
	public void setUserManager(IUtilisateurManager userManager) {
		this.userManager = userManager;
	}

}
