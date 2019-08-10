package fr.ncg.mygardenguardian.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.webapp.formulaire.culture.AjoutCultureFormulaire;

@Controller
public class AccueilAll {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/accueil")
	public String accueilAll(Model model) {
		System.out.println("CTRL CONTROLLER ACCUEIL GET-------------- "
				+ this.managerFactory.getCultureManager().obtenirCulturesEnConstruction().size());
		model.addAttribute("mesCulturesConstr",
				this.managerFactory.getCultureManager().obtenirCulturesEnConstruction());
		model.addAttribute("ajoutCultureForm", new AjoutCultureFormulaire());
		return "/accueil";
	}

	@PostMapping("/accueil")
	public String selectionCultureModif(
			@ModelAttribute("ajoutCultureForm") @RequestBody AjoutCultureFormulaire ajoutCultureForm,
			BindingResult errors, Model model, RedirectAttributes cultureCree) {
		System.out.println(
				"CTRL CONTROLLER ACCUEIL POST ------------------- " + ajoutCultureForm.getCulturesAjoutees().get(0));
		cultureCree.addFlashAttribute("cultureCreee", this.managerFactory.getCultureManager()
				.trouverLaCulture(ajoutCultureForm.getCulturesAjoutees().get(0)));
		return ("redirect:/culture/tableau_bord_enregistrement_culture?idCulture="
				+ ajoutCultureForm.getCulturesAjoutees().get(0));
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
