package fr.ncg.mygardenguardian.business;

import fr.ncg.mygardenguardian.business.contract.IAdhesionManager;
import fr.ncg.mygardenguardian.business.contract.IRoleManager;
import fr.ncg.mygardenguardian.business.contract.IUtilisateurManager;

public interface IBusinessManagerFactory {

	public IAdhesionManager getAdhesionManager();

	public void setAdhesionManager(IAdhesionManager adhesionManager);

	public IUtilisateurManager getUtilisateurManager();

	public void setUtilisateurManager(IUtilisateurManager utilisateurManager);

	public IRoleManager getRoleManager();

	public void setRoleManager(IRoleManager roleManager);

}
