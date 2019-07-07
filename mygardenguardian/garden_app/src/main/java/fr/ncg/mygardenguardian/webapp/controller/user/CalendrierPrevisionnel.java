package fr.ncg.mygardenguardian.webapp.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.dto.CultureDTO;

@Controller
public class CalendrierPrevisionnel {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("user/calendrier_previsionnel")
	public String goCalendrierPrevisionnel(@ModelAttribute CultureDTO cultureDTO, BindingResult errors, Model model) {
		// model.addAttribute("mesCultures",
		// this.managerFactory.getCultureManager().obtenirToutesLesCultures();
		return "user/calendrier_previsionnel";
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
