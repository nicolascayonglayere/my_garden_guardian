package fr.ncg.mygardenguardian.webapp.controller.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.dto.IntrantDTO;

@RestController
public class ModificationIntrantControllerRest {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/culture/get_intrant_modif")
	@ResponseBody
	public IntrantDTO obtenirIntrantModif(HttpServletRequest req) {
		System.out.println("CTRL CONTROLLER JQUERY " + req.getParameter("idIntrant"));
		IntrantDTO monIntrant = this.managerFactory.getIntrantManager()
				.obtenirIntrant(Integer.valueOf(req.getParameter("idIntrant")));
		return monIntrant;
	}

	@PostMapping("/culture/intrant_suppr")
	@ResponseBody
	public void suppressionIntrant(HttpServletRequest req) {
		System.out.println(req.getParameter("idIntrant") + " - " + req.getAttribute("idIntrant"));
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
