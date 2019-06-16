package fr.ncg.mygardenguardian.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.ncg.mygardenguardian.consumer.contract.AdhesionDao;
import fr.ncg.mygardenguardian.consumer.contract.CoordonneesUtilisateurDao;
import fr.ncg.mygardenguardian.consumer.contract.ParcelleDao;
import fr.ncg.mygardenguardian.consumer.contract.UtilisateurDao;

@Component
public class DaoFactoryImpl implements IDaoFactory {

	private AdhesionDao adhesionDao;
	private UtilisateurDao utilisateurDao;
	private CoordonneesUtilisateurDao coordonneesUtilisateurDao;
	// private RoleDao roleDao;
	private ParcelleDao parcelleDao;

	@Override
	public AdhesionDao getAdhesionDao() {
		return this.adhesionDao;
	}

	@Autowired
	@Override
	public void setAdhesionDao(AdhesionDao adhesionDao) {
		this.adhesionDao = adhesionDao;
	}

	@Override
	public UtilisateurDao getUtilisateurDao() {
		return this.utilisateurDao;
	}

	@Autowired
	@Override
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public CoordonneesUtilisateurDao getCoordonneesUtilisateurDao() {
		return this.coordonneesUtilisateurDao;
	}

	@Autowired
	@Override
	public void setCoordonneesUtilisateurDao(CoordonneesUtilisateurDao coordonneesUtilisateurDao) {
		this.coordonneesUtilisateurDao = coordonneesUtilisateurDao;
	}

	// @Override
	// public RoleDao getRoleDao() {
	// return this.roleDao;
	// }
	//
	// @Autowired
	// @Override
	// public void setRoleDao(RoleDao roleDao) {
	// this.roleDao = roleDao;
	// }
	//
	@Override
	public ParcelleDao getParcelleDao() {
		return this.parcelleDao;
	}

	@Autowired
	@Override
	public void setParcelleDao(ParcelleDao parcelleDao) {
		this.parcelleDao = parcelleDao;
	}

}
