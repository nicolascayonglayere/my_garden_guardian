package fr.ncg.mygardenguardian.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.IUtilisateurManager;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.entites.Utilisateur;

@Transactional
@Service
public class UtilisateurManagerImpl implements IUtilisateurManager {

	private IDaoFactory daoFacto;

	@Override
	public Utilisateur inscriptionUtilisateur(Utilisateur utilisateur) {
		return this.daoFacto.getUtilisateurDao().saveAndFlush(utilisateur);
	}

	@Override
	public List<Utilisateur> trouverJardiniers() {
		return this.daoFacto.getUtilisateurDao().findAll();
	}

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

}
