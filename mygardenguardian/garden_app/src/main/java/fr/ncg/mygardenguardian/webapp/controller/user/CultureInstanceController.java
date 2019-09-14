package fr.ncg.mygardenguardian.webapp.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;

@Controller
public class CultureInstanceController {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/user/culture")
	public String goPageCulture(Model model, @RequestParam("idCulture") Integer idCulture) {
		try {
			model.addAttribute("maCulture",
					this.managerFactory.getCultureInstanceManager().trouverCultureInstance(idCulture));
		} catch (RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());
		}
		return "/user/culture";
	}

	@PostMapping("/user/culture_instance_suppr")
	@ResponseBody
	public void suppressionCultureInstance(HttpServletRequest req) {
		try {
			this.managerFactory.getCultureInstanceManager()
					.supprimerCultureInstance(Integer.valueOf(req.getParameter("idCulture")));
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
