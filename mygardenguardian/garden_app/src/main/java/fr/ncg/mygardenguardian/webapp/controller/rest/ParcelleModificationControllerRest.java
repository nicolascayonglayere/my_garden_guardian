package fr.ncg.mygardenguardian.webapp.controller.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;

@RestController
public class ParcelleModificationControllerRest {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/admin/get_parcelle_modif")
	@ResponseBody
	public ParcelleDTO obtenirParcelleModif(HttpServletRequest req) {
		ParcelleDTO maParcelle = this.managerFactory.getParcelleManager()
				.trouverParcelleParId(Integer.valueOf(req.getParameter("idParcelle")));
		return maParcelle;
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
