package fr.ncg.mygardenguardian.business;

import fr.ncg.mygardenguardian.business.contract.IAdhesionManager;
import fr.ncg.mygardenguardian.business.contract.ICultureInstanceManager;
import fr.ncg.mygardenguardian.business.contract.ICultureManager;
import fr.ncg.mygardenguardian.business.contract.IEventCalendarManager;
import fr.ncg.mygardenguardian.business.contract.IExportCalendrier;
import fr.ncg.mygardenguardian.business.contract.IIntrantManager;
import fr.ncg.mygardenguardian.business.contract.IOperationCulturaleManager;
import fr.ncg.mygardenguardian.business.contract.IParcelleManager;
import fr.ncg.mygardenguardian.business.contract.IUtilisateurManager;

/**
 * Interface IBusinessManagerFactory qui permet l'accès aux différentes
 * interfaces de la couche business
 * 
 * @author nicolas
 *
 */
public interface IBusinessManagerFactory {

	/**
	 * Methode d'acces vers {@link IAdhesionManager}
	 * 
	 * @return {@link IAdhesionManager}
	 */
	public IAdhesionManager getAdhesionManager();

	/**
	 * Méthode pour définir la {@link IAdhesionManager}
	 * 
	 * @param adhesionManager
	 */
	public void setAdhesionManager(IAdhesionManager adhesionManager);

	/**
	 * Methode d'acces vers {@link IUtilisateurManager}
	 * 
	 * @return {@link IUtilisateurManager}
	 */
	public IUtilisateurManager getUtilisateurManager();

	/**
	 * Méthode pour définir la {@link IUtilisateurManager}
	 * 
	 * @param utilisateurManager
	 */
	public void setUtilisateurManager(IUtilisateurManager utilisateurManager);

	/**
	 * Methode d'acces vers {@link IParcelleManager}
	 * 
	 * @return {@link IParcelleManager}
	 */
	public IParcelleManager getParcelleManager();

	/**
	 * Méthode pour définir la {@link IParcelleManager}
	 * 
	 * @param parcelleManager
	 */
	public void setParcelleManager(IParcelleManager parcelleManager);

	/**
	 * Methode d'acces vers {@link ICultureManager}
	 * 
	 * @return {@link ICultureManager}
	 */
	public ICultureManager getCultureManager();

	/**
	 * Méthode pour définir la {@link ICultureManager}
	 * 
	 * @param cultureManager
	 */
	public void setCultureManager(ICultureManager cultureManager);

	/**
	 * Methode d'acces vers {@link IIntrantManager}
	 * 
	 * @return {@link IIntrantManager}
	 */
	public IIntrantManager getIntrantManager();

	/**
	 * Méthode pour définir la {@link IIntrantManager}
	 * 
	 * @param intrantManager
	 */
	public void setIntrantManager(IIntrantManager intrantManager);

	/**
	 * Methode d'acces vers {@link IOperationCulturaleManager}
	 * 
	 * @return {@link IOperationCulturaleManager}
	 */
	public IOperationCulturaleManager getOperationCulturaleManager();

	/**
	 * Méthode pour définir la {@link IOperationCulturaleManager}
	 * 
	 * @param opeCultManager
	 */
	public void setOperationCulturaleManager(IOperationCulturaleManager opeCultManager);

	/**
	 * Methode d'acces vers {@link IEventCalendarManager}
	 * 
	 * @return {@link IEventCalendarManager}
	 */
	public IEventCalendarManager getEventCalendarManager();

	/**
	 * Méthode pour définir la {@link IEventCalendarManager}
	 * 
	 * @param eventManager
	 */
	public void setEventCalendarManager(IEventCalendarManager eventManager);

	/**
	 * Methode d'acces vers {@link ICultureInstanceManager}
	 * 
	 * @return {@link ICultureInstanceManager}
	 */
	public ICultureInstanceManager getCultureInstanceManager();

	/**
	 * Méthode pour définir la {@link ICultureInstanceManager}
	 * 
	 * @param cultureInstanceManager
	 */
	public void setICultureInstanceManager(ICultureInstanceManager cultureInstanceManager);

	/**
	 * Methode d'acces vers {@link IExportCalendrier}
	 * 
	 * @return {@link IExportCalendrier}
	 */
	public IExportCalendrier getExportCalendrier();

	/**
	 * Méthode pour définir la {@link IExportCalendrier}
	 * 
	 * @param exportCalendrier
	 */
	public void setIExportCalendrier(IExportCalendrier exportCalendrier);
}
