package fr.ncg.mygardenguardian.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.ncg.mygardenguardian.business.contract.IAdhesionManager;
import fr.ncg.mygardenguardian.business.contract.IRoleManager;
import fr.ncg.mygardenguardian.business.contract.IUtilisateurManager;

@Component
public class BusinessManagerFactoryImpl implements IBusinessManagerFactory {

	private IAdhesionManager adhesionManager;
	private IUtilisateurManager utilisateurManager;
	private IRoleManager roleManager;

	@Override
	public IAdhesionManager getAdhesionManager() {
		return this.adhesionManager;
	}

	@Autowired
	@Override
	public void setAdhesionManager(IAdhesionManager adhesionManager) {
		this.adhesionManager = adhesionManager;
	}

	@Override
	public IUtilisateurManager getUtilisateurManager() {
		return this.utilisateurManager;
	}

	@Autowired
	@Override
	public void setUtilisateurManager(IUtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public IRoleManager getRoleManager() {
		return this.roleManager;
	}

	@Autowired
	@Override
	public void setRoleManager(IRoleManager roleManager) {
		this.roleManager = roleManager;
	}

}
