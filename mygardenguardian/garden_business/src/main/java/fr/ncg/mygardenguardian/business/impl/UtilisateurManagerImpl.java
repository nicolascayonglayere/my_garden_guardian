package fr.ncg.mygardenguardian.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		CoordonneesUtilisateur mesCoordonnees = this.daoFacto.getCoordonneesUtilisateurDao()
				.saveAndFlush(monUtilisateur.getCoordonneeUtilisateur());
		monUtilisateur.setCoordonneeUtilisateur(mesCoordonnees);
		return UtilisateurMapper
				.fromUtilisateurToUtilisateurDTO(this.daoFacto.getUtilisateurDao().saveAndFlush(monUtilisateur));
	}

	@Override
	public List<UtilisateurDTO> trouverJardiniers() {
		List<UtilisateurDTO> maListeJardiniers = new ArrayList<UtilisateurDTO>();
		for (Utilisateur u : this.daoFacto.getUtilisateurDao().findAll()) {
			maListeJardiniers.add(UtilisateurMapper.fromUtilisateurToUtilisateurDTO(u));
		}
		return maListeJardiniers;
	}

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

}
