package fr.ncg.mygardenguardian.webapp.controller.culture;

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
import fr.ncg.mygardenguardian.webapp.formulaire.IdIntegerFormlaire;

@Controller
public class ModificationCultureSelect {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/culture/select_modification_culture")
	public String goSelectCulture(Model model) {
		model.addAttribute("mesCulturesConstr", this.managerFactory.getCultureManager().obtenirToutesLesCultures());
		model.addAttribute("idForm", new IdIntegerFormlaire());

		return "culture/select_modification_culture";
	}

	@PostMapping("/culture/select_modification_culture")
	public String selectCulture(@ModelAttribute("idForm") @RequestBody IdIntegerFormlaire idForm, BindingResult errors,
			Model model, RedirectAttributes cultureSelect) {

		cultureSelect.addFlashAttribute("cultureModif",
				this.managerFactory.getCultureManager().trouverLaCulture(idForm.getIdCulture()));

		return ("redirect:/culture/modification_culture");
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
