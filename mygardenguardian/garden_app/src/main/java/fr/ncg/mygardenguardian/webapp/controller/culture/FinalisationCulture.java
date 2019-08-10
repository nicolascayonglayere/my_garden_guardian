package fr.ncg.mygardenguardian.webapp.controller.culture;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.impl.security.GardenGuardianAppUser;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.IdIntegerFormlaire;

@Controller
public class FinalisationCulture {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("culture/finalisation_culture")
	public String goFinaliserCulture(Model model, @RequestParam Integer idCulture) {
		if (model.asMap().containsKey("cultureCreee")) {
			System.out.println(
					"CTRL CONTROLLER FINALISATION CULT GET -----------------" + model.asMap().get("cultureCreee"));
			model.addAttribute("cultureCreee", model.asMap().get("cultureCreee"));
		}
		if (idCulture != null) {
			model.addAttribute("cultureCreee", this.managerFactory.getCultureManager().trouverLaCulture(idCulture));
		}

		model.addAttribute("idIntegerForm", new IdIntegerFormlaire());
		return ("culture/finalisation_culture");
	}

	@PostMapping("culture/finalisation_culture")
	public String finaliserCulture(@ModelAttribute("idIntegerForm") @RequestBody IdIntegerFormlaire idIntegerForm,
			BindingResult errors, Model model, RedirectAttributes cultureCreee) throws IOException {

		System.out.println("CTRL CONTROLLER POST ------------ " + idIntegerForm.getIdCulture());

		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();
		UtilisateurDTO monUtilisateur = this.managerFactory.getUtilisateurManager()
				.trouverUtilisateurParId(idUtilisateur);
		CultureDTO maCulture = this.managerFactory.getCultureManager().trouverLaCulture(idIntegerForm.getIdCulture());
		maCulture.setEnConstruction(false);
		cultureCreee
				.addFlashAttribute(this.managerFactory.getCultureManager().creerCultureBdd(maCulture, monUtilisateur));

		return ("redirect:/accueil");
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
