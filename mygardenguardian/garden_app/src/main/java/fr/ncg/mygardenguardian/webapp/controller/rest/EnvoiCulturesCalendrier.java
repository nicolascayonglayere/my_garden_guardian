package fr.ncg.mygardenguardian.webapp.controller.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.impl.security.GardenGuardianAppUser;
import fr.ncg.mygardenguardian.dto.EventCalendarDTO;

@RestController()
public class EnvoiCulturesCalendrier {

	private IBusinessManagerFactory managerFactory;
	private int compteur = 0;

	@GetMapping("/user/eventsCalendar")
	public List<EventCalendarDTO> envoiListeCultures() {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();
		Integer idParcelle = this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(idUtilisateur)
				.getParcelleDTO().getIdParcelle();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		sdf.setTimeZone(TimeZone.getTimeZone("CET"));
		List<EventCalendarDTO> monCalPrev = new ArrayList<EventCalendarDTO>();
		IntStream.range(0, this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle)
				.getCalendrierCultural().size()).forEachOrdered(i -> {
					String start = sdf.format(this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle)
							.getCalendrierCultural().get(i).getOperationsCulturales().get(0).getDate());
					String end = sdf
							.format(this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle)
									.getCalendrierCultural().get(i).getOperationsCulturales()
									.get(this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle)
											.getCalendrierCultural().get(i).getOperationsCulturales().size() - 1)
									.getDate());
					EventCalendarDTO maCultureAjoutee = new EventCalendarDTO();
					maCultureAjoutee.setId(i);
					maCultureAjoutee.setTitle(this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle)
							.getCalendrierCultural().get(i).getPlante().getNom());
					maCultureAjoutee.setStart(start);
					maCultureAjoutee.setEnd(end);
					maCultureAjoutee.setAllDay(false);
					System.out.println("CTRL ajax ---------- " + maCultureAjoutee.toString());
					monCalPrev.add(maCultureAjoutee);
				});
		System.out.println("CTRL ajax ---------- " + monCalPrev.size());
		return monCalPrev;
	}

	@GetMapping("/user/semisCalendar")
	public List<EventCalendarDTO> envoiListeSemis() {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();
		Integer idParcelle = this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(idUtilisateur)
				.getParcelleDTO().getIdParcelle();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		sdf.setTimeZone(TimeZone.getTimeZone("CET"));
		List<EventCalendarDTO> monSemisPrev = new ArrayList<EventCalendarDTO>();

		this.getManagerFactory().getParcelleManager().trouverParcelleParId(idParcelle).getCalendrierCultural().stream()
				.forEachOrdered(c -> {
					c.getOperationsCulturales().stream().filter(op -> op.getNom().equalsIgnoreCase("semis"))
							.forEachOrdered(op -> {
								EventCalendarDTO maCultureAjoutee = new EventCalendarDTO();
								maCultureAjoutee.setTitle("semis " + c.getPlante().getNom());
								maCultureAjoutee.setAllDay(false);
								maCultureAjoutee.setStart(sdf.format(op.getDate()));
								maCultureAjoutee.setEnd(sdf.format(op.getDate()));
								maCultureAjoutee.setId(this.compteur);
								this.compteur++;
								monSemisPrev.add(maCultureAjoutee);
							});

				});
		System.out.println("CTRL AJAX " + monSemisPrev.toString());
		return monSemisPrev;
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
