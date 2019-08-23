package fr.ncg.mygardenguardian.webapp.controller.admin;

import javax.validation.Valid;

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
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.AdhesionModifJardinierFormulaire;

@Controller
public class AdhesionController {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("admin/modification_adhesion")
	public String goModifierParcelleJardinier(Model model) {
		model.addAttribute("adhesionModifForm", new AdhesionModifJardinierFormulaire());
		model.addAttribute("utilisateursListe", this.managerFactory.getUtilisateurManager().trouverJardiniers());
		model.addAttribute("parcelleVideListe", this.managerFactory.getParcelleManager().trouverToutesParcellesVides());

		return "admin/modification_adhesion";
	}

	@PostMapping("admin/modification_adhesion")
	public String modificationParcelleJardinier(
			@Valid @ModelAttribute("adhesionModifForm") @RequestBody AdhesionModifJardinierFormulaire adhesionModifForm,
			BindingResult errors, Model model, RedirectAttributes parcelleModif) {

		if (errors.hasErrors()) {
			System.out.println(errors.toString());
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("adhesionModifForm", adhesionModifForm);
			model.addAttribute("utilisateursListe", this.managerFactory.getUtilisateurManager().trouverJardiniers());
			model.addAttribute("parcelleVideListe",
					this.managerFactory.getParcelleManager().trouverToutesParcellesVides());
			return ("/admin/modification_adhesion");
		}

		AdhesionDTO adhesionModif = this.managerFactory.getAdhesionManager()
				.trouverAdhesionIdUtilisateur(adhesionModifForm.getIdUtilisateur());
		this.managerFactory.getAdhesionManager().annulerAdhesion(adhesionModif);

		AdhesionDTO nvelleAdhesion = new AdhesionDTO();
		nvelleAdhesion.setParcelleDTO(
				this.managerFactory.getParcelleManager().trouverParcelleParId(adhesionModifForm.getIdParcelle()));
		nvelleAdhesion.setUtilisateurDTO(adhesionModif.getUtilisateurDTO());
		nvelleAdhesion = this.managerFactory.getAdhesionManager().nouvelleInscription(nvelleAdhesion);

		parcelleModif.addFlashAttribute("monInscription", nvelleAdhesion);
		return "redirect:/admin/accueil";
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
