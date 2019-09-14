package fr.ncg.mygardenguardian.webapp.controller.culture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

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
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.culture.EnregistrementOperationCulturaleBddFormulaire;
import fr.ncg.mygardenguardian.webapp.utils.OperationsCulturalesTypes;

@Controller
public class EnregistrementOperationCulturale {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/culture/enregistrement_opeCulturale")
	public String goAjouterOperationCulturale(Model model, @RequestParam Integer idCulture) {
		if (model.asMap().containsKey("cultureCreee")) {
			System.out.println("CTRL CONTROLLER OPE CULT GET -----------------" + model.asMap().get("cultureCreee"));
			model.addAttribute("cultureCreee", model.asMap().get("cultureCreee"));
		}
		if (idCulture != null) {
			model.addAttribute("cultureCreee", this.managerFactory.getCultureManager().trouverLaCulture(idCulture));
		}

		List<String> opeCultTypes = new ArrayList<String>();
		EnumSet.allOf(OperationsCulturalesTypes.class).stream()
				.forEach(op -> opeCultTypes.add(op.getOperationCulturaleType()));
		Collections.sort(opeCultTypes);

		model.addAttribute("nomOpeCult", opeCultTypes);
		// this.managerFactory.getOperationCulturaleManager().obtenirNomsOperationCulturale());
		model.addAttribute("operationCulturaleForm", new EnregistrementOperationCulturaleBddFormulaire());

		return "culture/enregistrement_opeCulturale";
	}

	@PostMapping("/culture/enregistrement_opeCulturale")
	public String enregistreOperationCulturale(
			@Valid @ModelAttribute("operationCulturaleForm") @RequestBody EnregistrementOperationCulturaleBddFormulaire operationCulturaleForm,
			BindingResult errors, Model model, RedirectAttributes opeCree) {

		if (errors.hasErrors()) {
			System.out.println(errors.toString());
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("operationCulturaleForm", operationCulturaleForm);
			model.addAttribute("cultureCreee",
					this.managerFactory.getCultureManager().trouverLaCulture(operationCulturaleForm.getPlanteId()));
			return ("culture/enregistrement_opeCulturale");
		}

		OperationCulturaleDTO monOpeCult = new OperationCulturaleDTO();
		monOpeCult.setNom(operationCulturaleForm.getNom());
		monOpeCult.setIntervallePossible(operationCulturaleForm.getIntervallePossible());
		monOpeCult.setOrigIntervPossible(operationCulturaleForm.getOrigIntervPossible());
		monOpeCult.setDescription(operationCulturaleForm.getDescription());

		System.out.println("CTRL CONTROLLER IDPLANTE --------------" + operationCulturaleForm.getPlanteId());
		CultureDTO maCulture = this.managerFactory.getCultureManager()
				.trouverLaCulture(operationCulturaleForm.getPlanteId());
		maCulture.addOperationCulturale(monOpeCult);
		System.out.println("CTRL CONTROLLER OPE CULT ---------------- " + maCulture.toString());
		CultureDTO monOpeCultCree = this.managerFactory.getCultureManager().creerOperationCulturaleBdd(maCulture);
		opeCree.addFlashAttribute("cultureCreee", monOpeCultCree);
		// opeCree.addFlashAttribute("operationCultCree", monOpeCultCree);

		return ("redirect:/culture/enregistrement_opeCulturale?idCulture=" + monOpeCultCree.getIdCulture());
	}

	@GetMapping("/culture/modif_ope_culturale")
	public String goModifierOperationCulturale(Model model, HttpServletRequest req) {
		model.addAttribute("listeOperationCulturale", this.managerFactory.getOperationCulturaleManager()
				.obtenirOperationsCulturalesParCulture(Integer.valueOf(req.getParameter("idCulture"))));
		model.addAttribute("opeCultForm", new EnregistrementOperationCulturaleBddFormulaire());
		return "culture/modification_opeCulturale";
	}

	@PostMapping("/culture/modif_ope_culturale")
	public String modifierOperationCulturale(
			@Valid @ModelAttribute("opeCultForm") @RequestBody EnregistrementOperationCulturaleBddFormulaire opeCultForm,
			BindingResult errors, Model model, RedirectAttributes opeCultCree) {
		if (errors.hasErrors()) {
			System.out.println(errors.toString());
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("opeCultForm", opeCultForm);
			model.addAttribute("cultureCreee",
					this.managerFactory.getCultureManager().trouverLaCulture(opeCultForm.getPlanteId()));
			return ("culture/modif_intrant");
		}
		System.out.println("CTRL CONTROLLER IDPLANTE --------------" + opeCultForm.getPlanteId());
		CultureDTO maCulture = this.managerFactory.getCultureManager().trouverLaCulture(opeCultForm.getPlanteId());

		OperationCulturaleDTO monOpeCult = new OperationCulturaleDTO();
		monOpeCult.setDescription(opeCultForm.getDescription());
		monOpeCult.setIntervallePossible(opeCultForm.getIntervallePossible());
		monOpeCult.setNom(opeCultForm.getNom());
		monOpeCult.setOrigIntervPossible(opeCultForm.getOrigIntervPossible());
		monOpeCult.setIdOperationCulturale(opeCultForm.getIdOperationCulturale());
		monOpeCult.setStatut("previsionnel");

		opeCultCree.addFlashAttribute("cultureCreee", maCulture);
		opeCultCree.addFlashAttribute("opeCultCreee", this.managerFactory.getOperationCulturaleManager()
				.modifierOperationCulturaleBdd(maCulture, monOpeCult));

		return "redirect:/culture/tableau_bord_enregistrement_culture?idCulture=" + maCulture.getIdCulture();
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
