package fr.ncg.mygardenguardian.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.IUtilisateurManager;
import fr.ncg.mygardenguardian.business.mapper.UtilisateurMapper;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.entites.CoordonneesUtilisateur;
import fr.ncg.mygardenguardian.entites.Utilisateur;

@Transactional
@Service
public class UtilisateurManagerImpl implements IUtilisateurManager {

	private IDaoFactory daoFacto;

	@Override
	public UtilisateurDTO inscriptionUtilisateur(UtilisateurDTO utilisateur) {
		Utilisateur monUtilisateur = UtilisateurMapper.fromUtilisateurDTOToUtilisateur(utilisateur);
		if (!this.verifExistenceUtilisateur(utilisateur)) {
			CoordonneesUtilisateur mesCoordonnees = this.daoFacto.getCoordonneesUtilisateurDao()
					.saveAndFlush(monUtilisateur.getCoordonneeUtilisateur());
			monUtilisateur.setCoordonneeUtilisateur(mesCoordonnees);
			monUtilisateur.setRole(this.constructionRoleSpringSecurity(utilisateur.getRole()));
			monUtilisateur.setMdp(this.encrytePassword(utilisateur.getMdp()));
			monUtilisateur.setUuid(UUID.randomUUID().toString());
			monUtilisateur = this.daoFacto.getUtilisateurDao().saveAndFlush(monUtilisateur);
		}

		return UtilisateurMapper.fromUtilisateurToUtilisateurDTO(monUtilisateur);
	}

	@Override
	public List<UtilisateurDTO> trouverJardiniers() {
		List<UtilisateurDTO> maListeJardiniers = new ArrayList<UtilisateurDTO>();
		for (Utilisateur u : this.daoFacto.getUtilisateurDao().findGardeners("ROLE_Jardinier", false)) {
			maListeJardiniers.add(UtilisateurMapper.fromUtilisateurToUtilisateurDTO(u));
		}
		return maListeJardiniers;
	}

	@Override
	public UtilisateurDTO trouverUtilisateurParId(Integer idUtilisateur) {
		UtilisateurDTO monUtilisateur = new UtilisateurDTO();
		monUtilisateur.setIdUtilisateur(idUtilisateur);
		if (this.verifierExistenceUtilisateurParId(idUtilisateur)) {
			return UtilisateurMapper.fromUtilisateurToUtilisateurDTO(
					this.getDaoFacto().getUtilisateurDao().findById(idUtilisateur).get());
		} else {
			return monUtilisateur;
		}
	}

	@Override
	public void supprimerUtilisateur(UtilisateurDTO utilisateur) {
		if (this.verifierExistenceUtilisateurParId(utilisateur.getIdUtilisateur())) {
			this.daoFacto.getUtilisateurDao().deleteById(utilisateur.getIdUtilisateur());
		}
	}

	@Override
	public UtilisateurDTO trouverUtilisateurParNom(String nom) {
		return UtilisateurMapper
				.fromUtilisateurToUtilisateurDTO(this.daoFacto.getUtilisateurDao().findByNom(nom).get());
	}

	@Override
	public UtilisateurDTO modifierProfil(UtilisateurDTO utilisateur) {
		if (this.verifierExistenceUtilisateurParId(utilisateur.getIdUtilisateur())) {
			String role = utilisateur.getRole().split("_")[1];
			utilisateur.setRole(this.constructionRoleSpringSecurity(role));
			return UtilisateurMapper.fromUtilisateurToUtilisateurDTO(this.daoFacto.getUtilisateurDao()
					.saveAndFlush(UtilisateurMapper.fromUtilisateurDTOToUtilisateur(utilisateur)));
		} else {
			return utilisateur;
		}
	}

	@Override
	public UtilisateurDTO trouverUtilisateurParUuid(String uuidUtilisateur) {
		return UtilisateurMapper
				.fromUtilisateurToUtilisateurDTO(this.daoFacto.getUtilisateurDao().findByUuid(uuidUtilisateur).get());
	}

	// --TODO rendre privee cette methode
	@Override
	public boolean verifExistenceUtilisateur(UtilisateurDTO utilisateur) {
		Utilisateur monUtilisateur = UtilisateurMapper.fromUtilisateurDTOToUtilisateur(utilisateur);
		Example<Utilisateur> monExUtilisateur = Example.of(monUtilisateur);
		System.out.println(this.daoFacto.getUtilisateurDao().findOne(monExUtilisateur).toString());
		if (!this.daoFacto.getUtilisateurDao().findOne(monExUtilisateur).isPresent()) {
			return false;
		} else {
			return true;
		}
	}

	private boolean verifierExistenceUtilisateurParId(Integer idUtilisateur) {
		if (this.getDaoFacto().getUtilisateurDao().findById(idUtilisateur).get() == null) {
			return false;
		} else {
			return true;
		}
	}

	private String constructionRoleSpringSecurity(String role) {
		if (role.endsWith("]")) {
			role = role.replace("]", "");
		}
		return "ROLE_" + role;
	}

	private String encrytePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

}
