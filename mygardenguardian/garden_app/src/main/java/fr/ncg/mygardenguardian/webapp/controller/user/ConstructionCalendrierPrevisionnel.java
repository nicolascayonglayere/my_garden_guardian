package fr.ncg.mygardenguardian.webapp.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
import fr.ncg.mygardenguardian.webapp.formulaire.culture.AjoutCultureFormulaire;

@Controller
public class ConstructionCalendrierPrevisionnel {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("user/ajouter_culture")
	public String goAjouterCulture(@ModelAttribute CultureDTO cultureDTO, BindingResult errors, Model model) {
		// --TODO filtrer les cultures deja presentes dans le calendrier
		model.addAttribute("mesCultures", this.managerFactory.getCultureManager().obtenirToutesLesCultures());
		model.addAttribute("ajoutCultureFormulaire", new AjoutCultureFormulaire());
		return "user/ajouter_culture";
	}

	@PostMapping("user/ajouter_culture")
	public String ajoutCulture(@ModelAttribute("ajoutCultureFormulaire") AjoutCultureFormulaire ajoutCultureFormulaire,
			BindingResult errors, Model model, RedirectAttributes mesCulturesAjoutees) {
		System.out.println("CONTROLLER POST AJOUT CULTURE ----------------- "
				+ ajoutCultureFormulaire.getCulturesAjoutees().toString());
		final List<CultureDTO> calendrierPrev = new ArrayList<CultureDTO>();
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();
		AdhesionDTO adhesionDto = this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(idUtilisateur);

		IntStream.range(0, ajoutCultureFormulaire.getCulturesAjoutees().size()).forEachOrdered(i -> {
			calendrierPrev.add(this.managerFactory.getCultureManager()
					.trouverLaCulture(ajoutCultureFormulaire.getCulturesAjoutees().get(i)));
		});
		mesCulturesAjoutees.addFlashAttribute("culturesAjoutees",
				this.managerFactory.getCultureManager().ajouterCulturesPrevisionnelles(calendrierPrev, adhesionDto));
		return ("redirect:/user/calendrier_previsionnel");
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
