package fr.ncg.mygardenguardian.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.entites.Role;
import fr.ncg.mygardenguardian.entites.Utilisateur;
import fr.ncg.mygardenguardian.webapp.formulaire.InscriptionFormulaire;

@Controller
public class InscriptionUtilisateur {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/inscription")
	public String getInscription(@ModelAttribute Utilisateur utilisateur, BindingResult errors, Model model) {
		InscriptionFormulaire inscriptionForm = new InscriptionFormulaire();
		model.addAttribute(inscriptionForm);
		return ("inscription");
	}

	@PostMapping("/inscription")
	public String inscription(@ModelAttribute("utilisateur") InscriptionFormulaire utilisateur, BindingResult errors,
			Model model) {
		Role monRoleUtilisateur = this.managerFactory.getRoleManager().trouverRole("JARDINIERS");
		Utilisateur monUtilisateur = new Utilisateur(utilisateur.getPrenom(), utilisateur.getNom(),
				utilisateur.getPseudo(), utilisateur.getMdp(), monRoleUtilisateur);
		this.managerFactory.getUtilisateurManager().inscriptionUtilisateur(monUtilisateur);
		return ("accueil");
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
