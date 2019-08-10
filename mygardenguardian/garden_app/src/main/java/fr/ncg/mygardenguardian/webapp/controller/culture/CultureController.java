package fr.ncg.mygardenguardian.webapp.controller.culture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;

@Controller
public class CultureController {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/culture/culture")
	public String goPageCulture(Model model, @RequestParam("idCulture") Integer idCulture) {
		model.addAttribute("maCulture", this.managerFactory.getCultureManager().trouverLaCulture(idCulture));
		return "/culture/culture";
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
