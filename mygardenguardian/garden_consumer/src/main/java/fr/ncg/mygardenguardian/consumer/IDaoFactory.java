package fr.ncg.mygardenguardian.consumer;

import fr.ncg.mygardenguardian.consumer.contract.AdhesionDao;
import fr.ncg.mygardenguardian.consumer.contract.CoordonneesUtilisateurDao;
import fr.ncg.mygardenguardian.consumer.contract.CultureDao;
import fr.ncg.mygardenguardian.consumer.contract.CultureInstanceDao;
import fr.ncg.mygardenguardian.consumer.contract.IntrantDao;
import fr.ncg.mygardenguardian.consumer.contract.MaterielDao;
import fr.ncg.mygardenguardian.consumer.contract.OperationCulturaleDao;
import fr.ncg.mygardenguardian.consumer.contract.ParcelleDao;
import fr.ncg.mygardenguardian.consumer.contract.PlanteDao;
import fr.ncg.mygardenguardian.consumer.contract.UtilisateurDao;

/**
 * Interface DaoFactory qui permet l'accès aux différentes interfaces de la
 * couche consumer
 * 
 * @author nicolas
 *
 */
public interface IDaoFactory {

	/**
	 * Methode d'acces vers {@link AdhesionDao}
	 * 
	 * @return {@link AdhesionDao}
	 */
	public AdhesionDao getAdhesionDao();

	/**
	 * Méthode pour définir la {@link AdhesionDao}
	 * 
	 * @param adhesionDao
	 */
	public void setAdhesionDao(AdhesionDao adhesionDao);

	/**
	 * Methode d'acces vers {@link UtilisateurDao}
	 * 
	 * @return {@link UtilisateurDao}
	 */
	public UtilisateurDao getUtilisateurDao();

	/**
	 * Méthode pour définir la {@link UtilisateurDao}
	 * 
	 * @param utilisateurDao
	 */
	public void setUtilisateurDao(UtilisateurDao utilisateurDao);

	/**
	 * Methode d'acces vers {@link CoordonneesUtilisateurDao}
	 * 
	 * @return {@link CoordonneesUtilisateurDao}
	 */
	public CoordonneesUtilisateurDao getCoordonneesUtilisateurDao();

	/**
	 * Méthode pour définir la {@link CoordonneesUtilisateurDao}
	 * 
	 * @param coordonneesUtilisateurDao
	 */
	public void setCoordonneesUtilisateurDao(CoordonneesUtilisateurDao coordonneesUtilisateurDao);

	/**
	 * Methode d'acces vers {@link ParcelleDao}
	 * 
	 * @return {@link ParcelleDao}
	 */
	public ParcelleDao getParcelleDao();

	/**
	 * Méthode pour définir la {@link ParcelleDao}
	 * 
	 * @param parcelleDao
	 */
	public void setParcelleDao(ParcelleDao parcelleDao);

	/**
	 * Methode d'acces vers {@link CultureDao}
	 * 
	 * @return {@link CultureDao}
	 */
	public CultureDao getCultureDao();

	/**
	 * Méthode pour définir la {@link CultureDao}
	 * 
	 * @param cultureDao
	 */
	public void setCultureDao(CultureDao cultureDao);

	/**
	 * Methode d'acces vers {@link IntrantDao}
	 * 
	 * @return {@link IntrantDao}
	 */
	public IntrantDao getIntrantDao();

	/**
	 * Méthode pour définir la {@link IntrantDao}
	 * 
	 * @param intrantDao
	 */
	public void setIntrantDao(IntrantDao intrantDao);

	/**
	 * Methode d'acces vers {@link MaterielDao}
	 * 
	 * @return {@link MaterielDao}
	 */
	public MaterielDao getMaterielDao();

	/**
	 * Méthode pour définir la {@link MaterielDao}
	 * 
	 * @param materielDao
	 */
	public void setMaterielDao(MaterielDao materielDao);

	/**
	 * Methode d'acces vers {@link OperationCulturaleDao}
	 * 
	 * @return {@link OperationCulturaleDao}
	 */
	public OperationCulturaleDao getOperationCulturaleDao();

	/**
	 * Méthode pour définir la {@link OperationCulturaleDao}
	 * 
	 * @param operationCulturaleDao
	 */
	public void setOperationCulturaleDao(OperationCulturaleDao operationCulturaleDao);

	/**
	 * Methode d'acces vers {@link PlanteDao}
	 * 
	 * @return {@link PlanteDao}
	 */
	public PlanteDao getPlanteDao();

	/**
	 * Méthode pour définir la {@link PlanteDao}
	 * 
	 * @param planteDao
	 */
	public void setPlanteDao(PlanteDao planteDao);

	/**
	 * Methode d'acces vers {@link CultureInstanceDao}
	 * 
	 * @return {@link CultureInstanceDao}
	 */
	public CultureInstanceDao getCultureInstanceDao();

	/**
	 * Méthode pour définir la {@link CultureInstanceDao}
	 * 
	 * @param cultureInstanceDao
	 */
	public void setCultureInstanceDao(CultureInstanceDao cultureInstanceDao);

}
