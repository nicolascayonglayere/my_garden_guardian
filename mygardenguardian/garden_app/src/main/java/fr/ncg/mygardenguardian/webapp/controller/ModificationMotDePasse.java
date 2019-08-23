package fr.ncg.mygardenguardian.webapp.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.ModifMdpFormulaire;

@Controller("/modif_mdp")
public class ModificationMotDePasse {

	private IBusinessManagerFactory businessManager;
	@Autowired
	private Validator validator;

	@GetMapping("/modif_mdp")
	public String goModifMdp(Model model) {
		ModifMdpFormulaire formMdp = new ModifMdpFormulaire();
		model.addAttribute("modifMdpFormulaire", formMdp);
		return "modif_mdp";
	}

	@PostMapping("/modif_mdp")
	public String modificationMdp(
			@Valid @ModelAttribute("modifMdpFormulaire") @RequestBody ModifMdpFormulaire modifMdpFormulaire,
			BindingResult errors, Model model, RedirectAttributes monMdpModif) {

		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();
		UtilisateurDTO userDto = this.businessManager.getUtilisateurManager().trouverUtilisateurParId(idUtilisateur);

		Set<ConstraintViolation<@Valid ModifMdpFormulaire>> failures = this.validator.validate(modifMdpFormulaire);

		if (errors.hasErrors() || !failures.isEmpty()) {
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("modifMdpFormulaire", modifMdpFormulaire);
			model.addAttribute("utilisateurDTO", userDto);
			return ("modif_mdp");
		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(modifMdpFormulaire.getMdpConfirm());
		userDto.setMdp(hashedPassword);
		userDto = this.businessManager.getUtilisateurManager().modifierProfil(userDto);
		monMdpModif.addFlashAttribute("messageMdp", userDto);
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
