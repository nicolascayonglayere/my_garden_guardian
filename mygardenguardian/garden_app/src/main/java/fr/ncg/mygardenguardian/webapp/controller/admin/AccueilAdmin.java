package fr.ncg.mygardenguardian.webapp.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;

@Controller
public class AccueilAdmin {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/admin/accueil")
	public String getAccueil(@ModelAttribute ParcelleDTO parcelleDTO, BindingResult errors, Model model) {
		System.out.println("CTRL ACCUEIL ----------" + model.asMap().size() + " - " + model.toString());
		if (model.containsAttribute("mesJardiniersSuppr")) {
			model.addAttribute("mesJardiniersSuppr", model.asMap().get("mesJardiniersSuppr"));
		} else if (model.containsAttribute("monInscription")) {
			model.addAttribute("jardinierInscrit", model.asMap().get("monInscription"));
		}
		List<ParcelleDTO> parcellesListe = this.managerFactory.getParcelleManager().trouverToutesParcellesVides();
		model.addAttribute("parcellesListe", parcellesListe);
		return ("admin/accueil");
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
