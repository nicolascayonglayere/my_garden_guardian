package fr.ncg.mygardenguardian.webapp.controller.culture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;

@Controller
public class TableauBordEnregistrementCultureBdd {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("culture/tableau_bord_enregistrement_culture")
	public String goTableauBord(@RequestParam Integer idCulture, Model model) {
		if (model.asMap().containsKey("cultureCreee")) {
			model.addAttribute("cultureCreee", model.asMap().get("cultureCreee"));
		}
		if (idCulture != null) {
			model.addAttribute("cultureCreee", this.managerFactory.getCultureManager().trouverLaCulture(idCulture));
		}
		return ("culture/tableau_bord_enregistrement_culture");
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
