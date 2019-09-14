package fr.ncg.mygardenguardian.webapp.controller;

import java.util.Calendar;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.impl.security.GardenGuardianAppUser;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.culture.AjoutCultureFormulaire;

@Controller
public class AccueilAll {

	private IBusinessManagerFactory managerFactory;

	// --TODO Attention au else. Pour l'instant seulement 2 roles
	@GetMapping("/accueil")
	public String accueilAll(Model model) {
		System.out.println("CTRL CONTROLLER ACCUEIL GET-------------- "
				+ this.managerFactory.getCultureManager().obtenirCulturesEnConstruction().size());
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		monUser.getAuthorities().stream().forEach(ga -> System.out.println(ga.getAuthority()));
		if (monUser.getAuthorities().stream().filter(ga -> ga.getAuthority().equalsIgnoreCase("ROLE_Administrateur"))
				.count() > 0) {
			model.addAttribute("mesCulturesConstr",
					this.managerFactory.getCultureManager().obtenirCulturesEnConstruction());
		} else {
			AdhesionDTO adhesionDto = this.managerFactory.getAdhesionManager()
					.trouverAdhesionIdUtilisateur(monUser.getIdUtilisateur());
			ParcelleDTO parcelleDto = this.managerFactory.getParcelleManager()
					.trouverParcelleParId(adhesionDto.getParcelleDTO().getIdParcelle());
			Calendar.getInstance().getTime();
			model.addAttribute("mesCulturesConstr", this.managerFactory.getCultureManager()
					.obtenirCulturesEnConstructionAuteur(monUser.getIdUtilisateur()));
			model.addAttribute("culturesInstances", this.managerFactory.getCultureInstanceManager()
					.trouverCultureHorsRecommandation(parcelleDto.getIdParcelle()));
		}

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
