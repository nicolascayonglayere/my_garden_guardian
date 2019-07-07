package fr.ncg.mygardenguardian.webapp.controller.culture;

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
		model.addAttribute("operationCulturaleForm", new EnregistrementOperationCulturaleBddFormulaire());

		return "/culture/enregistrement_opeCulturale";
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
			return ("/culture/enregistrement_opeCulturale");
		}

		OperationCulturaleDTO monOpeCult = new OperationCulturaleDTO();
		monOpeCult.setNom(operationCulturaleForm.getNom());
		monOpeCult.setDate(operationCulturaleForm.getDate());
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

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
