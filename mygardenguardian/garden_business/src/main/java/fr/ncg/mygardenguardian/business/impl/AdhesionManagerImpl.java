package fr.ncg.mygardenguardian.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.IAdhesionManager;
import fr.ncg.mygardenguardian.business.mapper.AdhesionMapper;
import fr.ncg.mygardenguardian.business.mapper.CoordonneesUtilisateurMapper;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.entites.Adhesion;
import fr.ncg.mygardenguardian.entites.CoordonneesUtilisateur;
import fr.ncg.mygardenguardian.entites.Utilisateur;

@Transactional
@Service
public class AdhesionManagerImpl implements IAdhesionManager {

	private IDaoFactory daoFacto;

	@Override
	public AdhesionDTO saveAdhesion(AdhesionDTO adhesion) {
		Adhesion monAdhesion = AdhesionMapper.fromAdhesionDTOToAdhesion(adhesion);

		if ((this.daoFacto.getUtilisateurDao().findByNomAndPrenom(adhesion.getUtilisateurDTO().getNom(),
				adhesion.getUtilisateurDTO().getPrenom()) == null)) {
			CoordonneesUtilisateur mesCoord = this.daoFacto.getCoordonneesUtilisateurDao()
					.saveAndFlush(CoordonneesUtilisateurMapper
							.fromCoordonneeDTOToCoordonnee(adhesion.getUtilisateurDTO().getCoordonneeUtilisateurDTO()));
			Utilisateur monJardinier = monAdhesion.getUtilisateur();
			monJardinier.setCoordonneeUtilisateur(mesCoord);
			monJardinier = this.daoFacto.getUtilisateurDao().saveAndFlush(monJardinier);
			monAdhesion.setUtilisateur(monJardinier);
		}

		monAdhesion = this.daoFacto.getAdhesionDao().saveAndFlush(monAdhesion);
		return AdhesionMapper.fromAdhesionToAdhesionDTO(monAdhesion);
	}

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

}
