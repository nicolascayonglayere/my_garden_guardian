package fr.ncg.mygardenguardian.webapp.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.impl.security.GardenGuardianAppUser;
import fr.ncg.mygardenguardian.dto.EventCalendarDTO;
import fr.ncg.mygardenguardian.webapp.utils.OperationsCulturalesTypes;

@RestController()
public class EnvoiCulturesCalendrier {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/user/eventsCalendar")
	public List<EventCalendarDTO> envoiListeCultures() {
		Integer idUtilisateur = this.recuperationIdUtilisateur();
		return this.getManagerFactory().getEventCalendarManager().listeCulturesCalendrier(idUtilisateur);
	}

	@GetMapping("/user/semisCalendar")
	public List<EventCalendarDTO> envoiListeSemis() {
		Integer idUtilisateur = this.recuperationIdUtilisateur();
		return this.managerFactory.getEventCalendarManager().constructionEventOpeCultCalendar(idUtilisateur,
				OperationsCulturalesTypes.Semis.getOperationCulturaleType());
	}

	@GetMapping("/user/prepSolCalendar")
	public List<EventCalendarDTO> envoiListePrepSol() {
		Integer idUtilisateur = this.recuperationIdUtilisateur();
		return this.managerFactory.getEventCalendarManager().constructionEventOpeCultCalendar(idUtilisateur,
				OperationsCulturalesTypes.PreparationSol.getOperationCulturaleType());

	}

	@GetMapping("/user/recolteCalendar")
	public List<EventCalendarDTO> envoiListeRecolte() {
		Integer idUtilisateur = this.recuperationIdUtilisateur();
		return this.managerFactory.getEventCalendarManager().constructionEventOpeCultCalendar(idUtilisateur,
				OperationsCulturalesTypes.Recolte.getOperationCulturaleType());
	}

	private Integer recuperationIdUtilisateur() {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		return monUser.getIdUtilisateur();
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
