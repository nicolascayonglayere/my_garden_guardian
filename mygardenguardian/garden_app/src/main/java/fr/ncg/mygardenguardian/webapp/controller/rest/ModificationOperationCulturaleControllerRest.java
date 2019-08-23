package fr.ncg.mygardenguardian.webapp.controller.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;

@RestController
public class ModificationOperationCulturaleControllerRest {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/culture/get_opeCult_modif")
	@ResponseBody
	public OperationCulturaleDTO obtenirOperationCulturaleModif(HttpServletRequest req) {
		OperationCulturaleDTO monOpeCult = this.managerFactory.getOperationCulturaleManager()
				.obtenirOperationCulturaleParId(Integer.valueOf(req.getParameter("idOperationCulturale")));
		return monOpeCult;
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
