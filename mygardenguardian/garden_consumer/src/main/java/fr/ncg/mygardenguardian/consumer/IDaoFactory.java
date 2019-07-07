package fr.ncg.mygardenguardian.consumer;

import fr.ncg.mygardenguardian.consumer.contract.AdhesionDao;
import fr.ncg.mygardenguardian.consumer.contract.CoordonneesUtilisateurDao;
import fr.ncg.mygardenguardian.consumer.contract.CultureDao;
import fr.ncg.mygardenguardian.consumer.contract.IntrantDao;
import fr.ncg.mygardenguardian.consumer.contract.MaterielDao;
import fr.ncg.mygardenguardian.consumer.contract.OperationCulturaleDao;
import fr.ncg.mygardenguardian.consumer.contract.ParcelleDao;
import fr.ncg.mygardenguardian.consumer.contract.PlanteDao;
import fr.ncg.mygardenguardian.consumer.contract.UtilisateurDao;

public interface IDaoFactory {

	public AdhesionDao getAdhesionDao();

	public void setAdhesionDao(AdhesionDao adhesionDao);

	public UtilisateurDao getUtilisateurDao();

	public void setUtilisateurDao(UtilisateurDao utilisateurDao);

	public CoordonneesUtilisateurDao getCoordonneesUtilisateurDao();

	public void setCoordonneesUtilisateurDao(CoordonneesUtilisateurDao coordonneesUtilisateurDao);

	public ParcelleDao getParcelleDao();

	public void setParcelleDao(ParcelleDao parcelleDao);

	public CultureDao getCultureDao();

	public void setCultureDao(CultureDao cultureDao);

	public IntrantDao getIntrantDao();

	public void setIntrantDao(IntrantDao intrantDao);

	public MaterielDao getMaterielDao();

	public void setMaterielDao(MaterielDao materielDao);

	public OperationCulturaleDao getOperationCulturaleDao();

	public void setOperationCulturaleDao(OperationCulturaleDao operationCulturaleDao);

	public PlanteDao getPlanteDao();

	public void setPlanteDao(PlanteDao planteDao);

}
