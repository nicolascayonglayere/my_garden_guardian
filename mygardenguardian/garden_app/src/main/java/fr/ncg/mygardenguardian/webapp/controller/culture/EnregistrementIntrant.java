package fr.ncg.mygardenguardian.webapp.controller.culture;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.IntrantDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.culture.EnregistrementIntrantBddFormulaire;

@Controller
public class EnregistrementIntrant {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/culture/enregistrement_intrant")
	public String goEnregistrerIntrant(Model model, @RequestParam Integer idCulture) {
		if (model.asMap().containsKey("cultureCreee")) {
			model.addAttribute("cultureCreee", model.asMap().get("cultureCreee"));
		}
		if (idCulture != null) {
			model.addAttribute("cultureCreee", this.managerFactory.getCultureManager().trouverLaCulture(idCulture));
		}
		model.addAttribute("nomsIntrants", this.managerFactory.getIntrantManager().obtenirNomsIntrants());
		model.addAttribute("intrantForm", new EnregistrementIntrantBddFormulaire());

		return ("culture/enregistrement_intrant");
	}

	@PostMapping("/culture/enregistrement_intrant")
	public String enregistrerIntrant(
			@Valid @ModelAttribute("intrantForm") @RequestBody EnregistrementIntrantBddFormulaire intrantForm,
			BindingResult errors, Model model, RedirectAttributes intrantCree) {

		if (errors.hasErrors()) {
			System.out.println(errors.toString());
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("planteFormulaire", intrantForm);
			model.addAttribute("cultureCreee",
					this.managerFactory.getCultureManager().trouverLaCulture(intrantForm.getPlanteId()));
			return ("culture/enregistrement_intrant");
		}

		IntrantDTO monIntrant = new IntrantDTO();
		monIntrant.setNom(intrantForm.getNom());
		monIntrant.setReference(intrantForm.getReference());

		CultureDTO maCulture = this.managerFactory.getCultureManager().trouverLaCulture(intrantForm.getPlanteId());
		maCulture.addIntrant(monIntrant);
		IntrantDTO monIntrantCree = this.managerFactory.getIntrantManager().creerIntrantBdd(maCulture);
		intrantCree.addFlashAttribute("cultureCreee", maCulture);
		intrantCree.addFlashAttribute("intrantCree", monIntrantCree);

		return ("redirect:/culture/tableau_bord_enregistrement_culture?idCulture=" + maCulture.getIdCulture());
	}

	@GetMapping("/culture/modif_intrant")
	public String goModifIntrant(Model model, HttpServletRequest req) {
		model.addAttribute("listeIntrants", this.managerFactory.getIntrantManager()
				.obtenirIntrantsCultureId(Integer.valueOf(req.getParameter("idCulture"))));
		model.addAttribute("intrantForm", new EnregistrementIntrantBddFormulaire());
		return ("culture/modification_intrant");
	}

	@PostMapping("/culture/modif_intrant")
	public String modifIntrant(
			@Valid @ModelAttribute("intrantForm") @RequestBody EnregistrementIntrantBddFormulaire intrantForm,
			BindingResult errors, Model model, RedirectAttributes intrantCree) {

		if (errors.hasErrors()) {
			System.out.println(errors.toString());
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("intrantForm", intrantForm);
			model.addAttribute("cultureCreee",
					this.managerFactory.getCultureManager().trouverLaCulture(intrantForm.getPlanteId()));
			return ("culture/modif_intrant");
		}
		IntrantDTO monIntrantCree;
		System.out.println("CTRL CONTROLLER IDPLANTE --------------" + intrantForm.getPlanteId());
		CultureDTO maCulture = this.managerFactory.getCultureManager().trouverLaCulture(intrantForm.getPlanteId());
		IntrantDTO monIntrant = new IntrantDTO();
		monIntrant.setNom(intrantForm.getNom());
		monIntrant.setReference(intrantForm.getReference());
		if (intrantForm.getIdIntrant() != null) {
			monIntrant.setIdIntrant(intrantForm.getIdIntrant());
			monIntrantCree = this.managerFactory.getIntrantManager().modifierIntrantBdd(monIntrant, maCulture);
		} else {
			maCulture.addIntrant(monIntrant);
			monIntrantCree = this.managerFactory.getIntrantManager().creerIntrantBdd(maCulture);
		}

		intrantCree.addFlashAttribute("cultureCreee", maCulture);
		intrantCree.addFlashAttribute("intrantCree", monIntrantCree);

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
