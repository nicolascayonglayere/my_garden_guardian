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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.PlanteDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.culture.ModifPlanteFormulaire;

@Controller
public class ModificationCulture {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/culture/modification_culture")
	public String goModifCulture(Model model, HttpServletRequest req) {
		CultureDTO maCultureModif = new CultureDTO();
		if (req.getParameter("idCulture") != null) {
			maCultureModif = this.managerFactory.getCultureManager()
					.trouverLaCulture(Integer.valueOf(req.getParameter("idCulture")));
			maCultureModif.setEnConstruction(true);
			this.managerFactory.getCultureManager().modifierCultureBdd(maCultureModif);
		} else {
			maCultureModif = (CultureDTO) model.asMap().get("cultureModif");
		}

		System.out.println("CTRL CONTROLLER GET MODIF CULTURE ------------" + maCultureModif.toString());
		model.addAttribute("cultureCreee", maCultureModif);
		return "culture/tableau_bord_enregistrement_culture";
	}

	@GetMapping("/culture/modif_plante")
	public String goModifPlanteCulture(Model model, HttpServletRequest req) {
		System.out.println("CTRL CONTROLLER modif culture " + req.getParameter("idCulture"));
		ModifPlanteFormulaire cultureModif = new ModifPlanteFormulaire();
		cultureModif.setIdCulture(Integer.valueOf(req.getParameter("idCulture")));
		cultureModif.setDureeCycle(this.managerFactory.getCultureManager()
				.trouverLaCulture(Integer.valueOf(req.getParameter("idCulture"))).getPlante().getDureeCycle());
		cultureModif.setNomCulture(this.managerFactory.getCultureManager()
				.trouverLaCulture(Integer.valueOf(req.getParameter("idCulture"))).getNom());
		cultureModif.setNomLatin(this.managerFactory.getCultureManager()
				.trouverLaCulture(Integer.valueOf(req.getParameter("idCulture"))).getPlante().getNomLatin());
		cultureModif.setNomPlante(this.managerFactory.getCultureManager()
				.trouverLaCulture(Integer.valueOf(req.getParameter("idCulture"))).getPlante().getNom());
		cultureModif.setProduit(this.managerFactory.getCultureManager()
				.trouverLaCulture(Integer.valueOf(req.getParameter("idCulture"))).getPlante().getProduit());
		cultureModif.setRecommandationBasse(this.managerFactory.getCultureManager()
				.trouverLaCulture(Integer.valueOf(req.getParameter("idCulture"))).getRecommandationBasse());
		cultureModif.setRecommandationHaute(this.managerFactory.getCultureManager()
				.trouverLaCulture(Integer.valueOf(req.getParameter("idCulture"))).getRecommandationHaute());
		cultureModif.setVariete(this.managerFactory.getCultureManager()
				.trouverLaCulture(Integer.valueOf(req.getParameter("idCulture"))).getPlante().getVariete());
		model.addAttribute("planteFormulaire", cultureModif);
		model.addAttribute("cultureCreee", this.managerFactory.getCultureManager()
				.trouverLaCulture(Integer.valueOf(req.getParameter("idCulture"))));
		return "/culture/modification_culture";
	}

	@PostMapping("/culture/modif_plante")
	public String modifierCulture(
			@Valid @ModelAttribute("planteFormulaire") @RequestBody ModifPlanteFormulaire modifPlanteFormulaire,
			BindingResult errors, Model model, RedirectAttributes maCultureRedir) {

		if (errors.hasErrors()) {
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("planteFormulaire", modifPlanteFormulaire);
			return ("/culture/modification_culture");
		}

		System.out.println("CTRL CONTROLLER POST Modif culture -------" + modifPlanteFormulaire.getIdCulture());
		CultureDTO maCultureModif = new CultureDTO();
		maCultureModif.setIdCulture(modifPlanteFormulaire.getIdCulture());
		maCultureModif.setEnConstruction(true);
		maCultureModif.setNom(modifPlanteFormulaire.getNomCulture());
		maCultureModif.setRecommandationBasse(modifPlanteFormulaire.getRecommandationBasse());
		maCultureModif.setRecommandationHaute(modifPlanteFormulaire.getRecommandationHaute());

		PlanteDTO maPlanteModif = new PlanteDTO();
		maPlanteModif.setIdPlante(this.managerFactory.getCultureManager()
				.trouverLaCulture(modifPlanteFormulaire.getIdCulture()).getPlante().getIdPlante());
		maPlanteModif.setNom(modifPlanteFormulaire.getNomPlante());
		maPlanteModif.setNomLatin(modifPlanteFormulaire.getNomLatin());
		maPlanteModif.setVariete(modifPlanteFormulaire.getVariete());
		maPlanteModif.setProduit(modifPlanteFormulaire.getProduit());
		maPlanteModif.setDureeCycle(modifPlanteFormulaire.getDureeCycle());
		maCultureModif.setPlante(maPlanteModif);
		maCultureModif.setIntrants(this.managerFactory.getCultureManager()
				.trouverLaCulture(modifPlanteFormulaire.getIdCulture()).getIntrants());
		maCultureModif.setOperationsCulturales(this.managerFactory.getCultureManager()
				.trouverLaCulture(modifPlanteFormulaire.getIdCulture()).getOperationsCulturales());
		maCultureModif.setlisteInstances(this.managerFactory.getCultureManager()
				.trouverLaCulture(modifPlanteFormulaire.getIdCulture()).getlisteInstances());
		this.managerFactory.getCultureManager().modifierCultureBdd(maCultureModif);

		maCultureRedir.addFlashAttribute("cultureCreee",
				this.managerFactory.getCultureManager().modifierCultureBdd(maCultureModif));

		return "redirect:/culture/tableau_bord_enregistrement_culture?idCulture=" + maCultureModif.getIdCulture();
	}

	@PostMapping("/culture/culture_suppr")
	@ResponseBody
	public void supprimerCulture(HttpServletRequest req) {
		System.out.println(req.getParameter("idCulture") + " - " + req.getAttribute("idCulture"));
		// --TODO faire un champs d'archive dans les cultures et mettre ce champs a true

		// par cette methode
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
