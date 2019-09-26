package fr.ncg.mygardenguardian.webapp.controller.culture;

import javax.validation.Valid;

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
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.PlanteDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.culture.EnregistrementPlanteBddFormulaire;

@Controller
public class EnregistrementCulture {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("culture/enregistrement_culture")
	public String goEnregistrerCulture(Model model) {
		model.addAttribute("planteFormulaire", new EnregistrementPlanteBddFormulaire());
		return "culture/enregistrement_culture";
	}

	@PostMapping("culture/enregistrement_culture")
	public String enregistrerCulture(
			@Valid @ModelAttribute("planteFormulaire") @RequestBody EnregistrementPlanteBddFormulaire planteFormulaire,
			BindingResult errors, Model model, RedirectAttributes cultureCreee) {

		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();

		if (errors.hasErrors()) {
			System.out.println(errors.toString());
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("planteFormulaire", planteFormulaire);
			return ("culture/enregistrement_culture");
		}

		PlanteDTO maPlante = new PlanteDTO();
		maPlante.setNom(planteFormulaire.getNomPlante());
		maPlante.setNomLatin(planteFormulaire.getNomLatin());
		maPlante.setDureeCycle(planteFormulaire.getDureeCycle());
		maPlante.setVariete(planteFormulaire.getNomLatin());
		maPlante.setProduit(planteFormulaire.getProduit());

		CultureDTO maCulture = new CultureDTO();
		maCulture.setNom(planteFormulaire.getNomCulture());
		maCulture.setRecommandationBasse(planteFormulaire.getRecommandationBasse());
		maCulture.setRecommandationHaute(planteFormulaire.getRecommandationHaute());
		maCulture.setPlante(maPlante);
		maCulture.setEnConstruction(true);
		maCulture = this.managerFactory.getCultureManager().creerCultureBdd(maCulture,
				this.managerFactory.getUtilisateurManager().trouverUtilisateurParId(idUtilisateur));
		cultureCreee.addFlashAttribute("cultureCreee", maCulture);

		return ("redirect:/culture/tableau_bord_enregistrement_culture?idCulture=" + maCulture.getIdCulture());
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
