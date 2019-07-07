package fr.ncg.mygardenguardian.webapp.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.impl.security.GardenGuardianAppUser;
import fr.ncg.mygardenguardian.dto.CoordonneesUtilisateurDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.ModifUserFormulaire;

@Controller
public class ModifProfil {

	private IBusinessManagerFactory businessManager;

	@GetMapping("user/modifier_profil")
	public String goModifProfil(@ModelAttribute ModifUserFormulaire formPreRempli, BindingResult errors, Model model) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();
		UtilisateurDTO monUtilisateur = this.businessManager.getUtilisateurManager()
				.trouverUtilisateurParId(idUtilisateur);
		formPreRempli.setNom(monUtilisateur.getNom());
		formPreRempli.setPrenom(monUtilisateur.getPrenom());
		formPreRempli.setAdresse(monUtilisateur.getCoordonneeUtilisateurDTO().getAdresse());
		formPreRempli.setCodePostal(monUtilisateur.getCoordonneeUtilisateurDTO().getCodePostal());
		formPreRempli.setEmail(monUtilisateur.getCoordonneeUtilisateurDTO().getEmail());
		formPreRempli.setNumPortable(monUtilisateur.getCoordonneeUtilisateurDTO().getNumPortable());
		formPreRempli.setVille(monUtilisateur.getCoordonneeUtilisateurDTO().getVille());
		model.addAttribute("modifUserFormulaire", formPreRempli);
		// model.addAttribute("utilisateurDTO", monUtilisateur);
		return ("user/modifier_profil");
	}

	@PostMapping("user/modifier_profil")
	public String modificationProfil(
			@Valid @ModelAttribute("modifUserFormulaire") @RequestBody ModifUserFormulaire modifUserFormulaire,
			BindingResult errors, Model model, RedirectAttributes monProfilModif) {
		// System.out.println("CTRL controller ---------------------" +
		// modifUserFormulaire.toString());

		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();
		UtilisateurDTO userDto = this.businessManager.getUtilisateurManager().trouverUtilisateurParId(idUtilisateur);

		if (errors.hasErrors()) {
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("modifUserFormulaire", modifUserFormulaire);
			model.addAttribute("utilisateurDTO", userDto);
			// System.out.println("CTRL ERRORS");
			return ("user/modifier_profil");
		}

		CoordonneesUtilisateurDTO cuDto = userDto.getCoordonneeUtilisateurDTO();
		cuDto.setAdresse(modifUserFormulaire.getAdresse());
		cuDto.setCodePostal(modifUserFormulaire.getCodePostal());
		cuDto.setEmail(modifUserFormulaire.getEmail());
		cuDto.setNumPortable(modifUserFormulaire.getNumPortable());
		cuDto.setVille(modifUserFormulaire.getVille());
		// System.out.println("CTRL controller " + cuDto.toString());

		userDto.setIdUtilisateur(idUtilisateur);
		userDto.setNom(modifUserFormulaire.getNom());
		userDto.setPrenom(modifUserFormulaire.getPrenom());
		userDto.setRole(loggedInUser.getAuthorities().toString());
		userDto.setCoordonneeUtilisateurDTO(cuDto);

		this.businessManager.getUtilisateurManager().modifierProfil(userDto);

		return ("redirect:/user/mon_profil");
	}

	public IBusinessManagerFactory getBusinessManager() {
		return this.businessManager;
	}

	@Autowired
	public void setBusinessManager(IBusinessManagerFactory businessManager) {
		this.businessManager = businessManager;
	}
}
