package fr.ncg.mygardenguardian.webapp.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.impl.security.GardenGuardianAppUser;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;

@Controller
public class MonProfil {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("user/mon_profil")
	public String goMonProfil(@ModelAttribute AdhesionDTO adhesionDTO, BindingResult errors, Model model) {

		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();
		AdhesionDTO monAdhesion = this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(idUtilisateur);
		model.addAttribute("adhesionDTO", monAdhesion);

		return ("user/mon_profil");
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
