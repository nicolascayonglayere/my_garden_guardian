package fr.ncg.mygardenguardian.business;

import fr.ncg.mygardenguardian.business.contract.IAdhesionManager;
import fr.ncg.mygardenguardian.business.contract.ICultureInstanceManager;
import fr.ncg.mygardenguardian.business.contract.ICultureManager;
import fr.ncg.mygardenguardian.business.contract.IEventCalendarManager;
import fr.ncg.mygardenguardian.business.contract.IIntrantManager;
import fr.ncg.mygardenguardian.business.contract.IOperationCulturaleManager;
import fr.ncg.mygardenguardian.business.contract.IParcelleManager;
import fr.ncg.mygardenguardian.business.contract.IRoleManager;
import fr.ncg.mygardenguardian.business.contract.IUtilisateurManager;

public interface IBusinessManagerFactory {

	public IAdhesionManager getAdhesionManager();

	public void setAdhesionManager(IAdhesionManager adhesionManager);

	public IUtilisateurManager getUtilisateurManager();

	public void setUtilisateurManager(IUtilisateurManager utilisateurManager);

	public IRoleManager getRoleManager();

	public void setRoleManager(IRoleManager roleManager);

	public IParcelleManager getParcelleManager();

	public void setParcelleManager(IParcelleManager parcelleManager);

	public ICultureManager getCultureManager();

	public void setCultureManager(ICultureManager cultureManager);

	public IIntrantManager getIntrantManager();

	public void setIntrantManager(IIntrantManager intrantManager);

	public IOperationCulturaleManager getOperationCulturaleManager();

	public void setOperationCulturaleManager(IOperationCulturaleManager opeCultManager);

	public IEventCalendarManager getEventCalendarManager();

	public void setEventCalendarManager(IEventCalendarManager eventManager);

	public ICultureInstanceManager getCultureInstanceManager();

	public void setICultureInstanceManager(ICultureInstanceManager cultureInstanceManager);
}
