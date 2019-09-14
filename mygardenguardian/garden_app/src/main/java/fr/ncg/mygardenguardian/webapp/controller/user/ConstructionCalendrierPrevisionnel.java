package fr.ncg.mygardenguardian.webapp.controller.user;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.impl.security.GardenGuardianAppUser;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.CultureInstanceDTO;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.culture.AjoutCultureFormulaire;
import fr.ncg.mygardenguardian.webapp.utils.DateHandler;

@Controller
public class ConstructionCalendrierPrevisionnel {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("user/ajouter_culture")
	public String goAjouterCulture(@ModelAttribute CultureDTO cultureDTO, BindingResult errors, Model model) {
		model.addAttribute("mesCultures", this.managerFactory.getCultureManager().obtenirToutesLesCultures());
		model.addAttribute("ajoutCultureFormulaire", new AjoutCultureFormulaire());
		return "user/ajouter_culture";
	}

	@PostMapping("user/ajouter_culture")
	public String ajoutCulture(@ModelAttribute("ajoutCultureFormulaire") AjoutCultureFormulaire ajoutCultureFormulaire,
			BindingResult errors, Model model, RedirectAttributes mesCulturesAjoutees) {

		final List<CultureDTO> calendrierPrev = new ArrayList<CultureDTO>();
		final List<CultureInstanceDTO> culturesEnTerre = new ArrayList<CultureInstanceDTO>();

		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();
		AdhesionDTO adhesionDto = this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(idUtilisateur);
		ParcelleDTO parcelleDto = this.managerFactory.getParcelleManager()
				.trouverParcelleParId(adhesionDto.getParcelleDTO().getIdParcelle());
		Date dateDuJour = Calendar.getInstance().getTime();

		IntStream.range(0, ajoutCultureFormulaire.getCulturesAjoutees().size()).forEachOrdered(i -> {
			calendrierPrev.add(this.managerFactory.getCultureManager()
					.trouverLaCulture(ajoutCultureFormulaire.getCulturesAjoutees().get(i)));

			if (this.managerFactory.getCultureInstanceManager()
					.trouverCultureEnTerre(parcelleDto.getIdParcelle(), dateDuJour).stream()
					.anyMatch(ci -> ci.getCulture().getIdCulture() == this.managerFactory.getCultureManager()
							.trouverLaCulture(ajoutCultureFormulaire.getCulturesAjoutees().get(i)).getIdCulture())) {

				culturesEnTerre.addAll(this.managerFactory.getCultureInstanceManager()
						.trouverCultureInstanceParCultureId(this.managerFactory.getCultureManager()
								.trouverLaCulture(ajoutCultureFormulaire.getCulturesAjoutees().get(i)).getIdCulture()));
			}
		});

		List<CultureInstanceDTO> culturesAjoutees = calendrierPrev.stream()
				.map(ci -> this.managerFactory.getCultureInstanceManager()
						.prevoirCulture(new CultureInstanceDTO(ci, parcelleDto, dateDuJour)))
				.collect(Collectors.toList());
		mesCulturesAjoutees.addFlashAttribute("culturesAjoutees", culturesAjoutees);
		mesCulturesAjoutees.addFlashAttribute("culturesEnTerre", culturesEnTerre);
		return ("redirect:/user/date_culture_instance");
	}

	@GetMapping("/user/date_culture_instance")
	public String goDaterCultureInstance(Model model, HttpServletRequest req) {

		if (req.getParameter("idCultureInstance") != null) {
			try {
				model.addAttribute("culturesAjoutees", Arrays.asList(this.managerFactory.getCultureInstanceManager()
						.trouverCultureInstance(Integer.valueOf(req.getParameter("idCultureInstance")))));
			} catch (RuntimeException e) {
				e.printStackTrace();
				model.addAttribute("errorMessage", e.getMessage());
			}
		} else {
			model.addAttribute("culturesAjoutees", model.asMap().get("culturesAjoutees"));
			model.addAttribute("culturesEnTerre", model.asMap().get("culturesEnTerre"));
		}

		return ("user/date_culture_instance");
	}

	@PostMapping("/user/date_culture_instance")
	public String datationCultureInstance(HttpServletRequest req, RedirectAttributes mesCulturesAjoutees) {
		List<CultureInstanceDTO> cultAdd = new ArrayList<CultureInstanceDTO>();
		IntStream.range(0, req.getParameterValues("idCultureInstance").length).forEachOrdered(i -> {
			CultureInstanceDTO cultDatee = this.managerFactory.getCultureInstanceManager()
					.trouverCultureInstance(Integer.valueOf(req.getParameterValues("idCultureInstance")[i]));
			try {
				cultDatee.setDate(DateHandler.conversionStringVersDate(req.getParameterValues("date")[i]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cultAdd.add(this.managerFactory.getCultureInstanceManager().daterCulture(cultDatee));
		});

		List<CultureInstanceDTO> culturesHorsRecom = cultAdd.stream()
				.filter(ci -> ci.getDate()
						.after(DateHandler.conversionNumSemaineVersDate(ci.getCulture().getRecommandationHaute())))
				.collect(Collectors.toList());
		culturesHorsRecom.addAll(cultAdd.stream()
				.filter(ci -> ci.getDate()
						.before(DateHandler.conversionNumSemaineVersDate(ci.getCulture().getRecommandationBasse())))
				.collect(Collectors.toList()));

		mesCulturesAjoutees.addFlashAttribute("culturesAjoutees", cultAdd);
		mesCulturesAjoutees.addFlashAttribute("culturesHorsRecom", culturesHorsRecom);
		return ("redirect:/user/calendrier_previsionnel");
	}

	public IBusinessManagerFactory getManagerFactory(BindingResult errors, Model model,
			RedirectAttributes mesCulturesAjoutees) {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
