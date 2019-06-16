package fr.ncg.mygardenguardian.consumer;

import fr.ncg.mygardenguardian.consumer.contract.AdhesionDao;
import fr.ncg.mygardenguardian.consumer.contract.CoordonneesUtilisateurDao;
import fr.ncg.mygardenguardian.consumer.contract.ParcelleDao;
import fr.ncg.mygardenguardian.consumer.contract.UtilisateurDao;

public interface IDaoFactory {

	public AdhesionDao getAdhesionDao();

	public void setAdhesionDao(AdhesionDao adhesionDao);

	public UtilisateurDao getUtilisateurDao();

	public void setUtilisateurDao(UtilisateurDao utilisateurDao);

	public CoordonneesUtilisateurDao getCoordonneesUtilisateurDao();

	public void setCoordonneesUtilisateurDao(CoordonneesUtilisateurDao coordonneesUtilisateurDao);

	// public RoleDao getRoleDao();
	//
	// public void setRoleDao(RoleDao roleDao);

	public ParcelleDao getParcelleDao();

	public void setParcelleDao(ParcelleDao parcelleDao);
}
