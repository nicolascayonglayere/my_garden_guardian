package fr.ncg.mygardenguardian.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
 * Implementation de {@link IBusinessManagerFactory}
 * 
 * @author nicolas
 *
 */
@Component
public class BusinessManagerFactoryImpl implements IBusinessManagerFactory {

	private IAdhesionManager adhesionManager;
	private IUtilisateurManager utilisateurManager;
	private IParcelleManager parcelleManager;
	private ICultureManager cultureManager;
	private IIntrantManager intrantManager;
	private IOperationCulturaleManager opeCultManager;
	private IEventCalendarManager eventManager;
	private ICultureInstanceManager cultureInstanceManager;
	private IExportCalendrier exportCalendrier;

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
	public IParcelleManager getParcelleManager() {
		return this.parcelleManager;
	}

	@Autowired
	@Override
	public void setParcelleManager(IParcelleManager parcelleManager) {
		this.parcelleManager = parcelleManager;
	}

	@Override
	public ICultureManager getCultureManager() {
		return this.cultureManager;
	}

	@Autowired
	@Override
	public void setCultureManager(ICultureManager cultureManager) {
		this.cultureManager = cultureManager;
	}

	@Override
	public IIntrantManager getIntrantManager() {
		return this.intrantManager;
	}

	@Autowired
	@Override
	public void setIntrantManager(IIntrantManager intrantManager) {
		this.intrantManager = intrantManager;
	}

	@Override
	public IOperationCulturaleManager getOperationCulturaleManager() {
		return this.opeCultManager;
	}

	@Autowired
	@Override
	public void setOperationCulturaleManager(IOperationCulturaleManager opeCultManager) {
		this.opeCultManager = opeCultManager;
	}

	@Override
	public IEventCalendarManager getEventCalendarManager() {
		return this.eventManager;
	}

	@Autowired
	@Override
	public void setEventCalendarManager(IEventCalendarManager eventManager) {
		this.eventManager = eventManager;
	}

	@Override
	public ICultureInstanceManager getCultureInstanceManager() {
		return this.cultureInstanceManager;
	}

	@Autowired
	@Override
	public void setICultureInstanceManager(ICultureInstanceManager cultureInstanceManager) {
		this.cultureInstanceManager = cultureInstanceManager;
	}

	@Override
	public IExportCalendrier getExportCalendrier() {
		return this.exportCalendrier;
	}

	@Autowired
	@Override
	public void setIExportCalendrier(IExportCalendrier exportCalendrier) {
		this.exportCalendrier = exportCalendrier;
	}

}
