package fr.ncg.mygardenguardian.webapp.controller.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.CoordonneesUtilisateurDTO;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.InscriptionFormulaire;
import fr.ncg.mygardenguardian.webapp.formulaire.ModificationFormulaire;

@Controller
public class Inscription {

	private IBusinessManagerFactory managerFactory;
	@Autowired
	private Validator validator;

	@GetMapping("/admin/inscription_jardinier")
	public String getInscriptionJardinier(@ModelAttribute AdhesionDTO adhesion, BindingResult errors, Model model) {
		InscriptionFormulaire inscriptionForm = new InscriptionFormulaire();
		model.addAttribute(inscriptionForm);
		model.addAttribute("roleListe", this.initRole());
		model.addAttribute("parcelleListe",
				this.getManagerFactory().getParcelleManager().trouverToutesParcellesVides());
		return ("admin/inscription_jardinier");
	}

	// @ExceptionHandler(PasswordsEqualConstraint.class)
	@PostMapping("/admin/inscription_jardinier")
	public String inscriptionJardinier(
			@Valid @ModelAttribute("inscriptionFormulaire") @RequestBody InscriptionFormulaire inscriptionFormulaire,
			BindingResult errors, Model model, RedirectAttributes monInscrit) {
		Set<ConstraintViolation<@Valid InscriptionFormulaire>> failures = this.validator
				.validate(inscriptionFormulaire);

		if (errors.hasErrors() || !failures.isEmpty()) {
			System.out.println(errors.toString());
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("roleListe", this.initRole());
			model.addAttribute("parcelleListe",
					this.getManagerFactory().getParcelleManager().trouverToutesParcellesVides());
			return ("admin/inscription_jardinier");
		}

//		System.out.println("CTRL controller --------- " + inscriptionFormulaire.toString());

		CoordonneesUtilisateurDTO cuDto = new CoordonneesUtilisateurDTO();
		cuDto.setAdresse(inscriptionFormulaire.getAdresse());
		cuDto.setCodePostal(inscriptionFormulaire.getCodePostal());
		cuDto.setEmail(inscriptionFormulaire.getEmail());
		cuDto.setNumPortable(inscriptionFormulaire.getNumPortable());
		cuDto.setVille(inscriptionFormulaire.getVille());

		UtilisateurDTO userDto = new UtilisateurDTO();
		userDto.setNom(inscriptionFormulaire.getNom());
		userDto.setPrenom(inscriptionFormulaire.getPrenom());
		userDto.setMdp(inscriptionFormulaire.getMdp());
		userDto.setRole(inscriptionFormulaire.getRole());
		userDto.setCoordonneeUtilisateurDTO(cuDto);

		ParcelleDTO parcelleDTO = this.managerFactory.getParcelleManager()
				.trouverParcelleParId(inscriptionFormulaire.getIdParcelle());

		AdhesionDTO adhesionDTO = new AdhesionDTO();
		adhesionDTO.setParcelleDTO(parcelleDTO);
		adhesionDTO.setUtilisateurDTO(userDto);
		adhesionDTO.setDateAdhesion(Calendar.getInstance().getTime());
		this.managerFactory.getAdhesionManager().nouvelleInscription(adhesionDTO);

		monInscrit.addFlashAttribute("monInscription", adhesionDTO);
		// model.addAttribute("message", );
		// session.setAttribute("jardinierInscrit", userDto);
		return ("redirect:/admin/accueil");
	}

	@GetMapping("/admin/lister_jardinier")
	public String goListerJardiniers(@ModelAttribute AdhesionDTO utilisateur, BindingResult errors, Model model) {
		model.addAttribute("jardiniersListe", this.getManagerFactory().getAdhesionManager().trouverJardiniers());
		return ("admin/lister_jardinier");
	}

	@GetMapping("/admin/supprimer_jardinier")
	public String goSupprimerJardinier(@ModelAttribute AdhesionDTO utilisateur, BindingResult errors, Model model) {
		model.addAttribute(new ModificationFormulaire());
		model.addAttribute("jardiniersListe", this.getManagerFactory().getAdhesionManager().trouverJardiniers());
		return ("admin/supprimer_jardinier");
	}

	@PostMapping("/admin/supprimer_jardinier")
	public String supprimerJardinier(
			@ModelAttribute("suppressionFormulaire") @RequestBody ModificationFormulaire utilisateur,
			BindingResult errors, Model model, RedirectAttributes jardiniersSupprimes) {
		System.out.println("CTRL controller ------------" + utilisateur.getJardinierSuppr().size() + " - "
				+ utilisateur.getJardinierSuppr().get(0));
		List<UtilisateurDTO> mesJardiniersSuppr = new ArrayList<UtilisateurDTO>();
		for (int i = 0; i < utilisateur.getJardinierSuppr().size(); i++) {

			AdhesionDTO monAdhesionAnnulee = this.getManagerFactory().getAdhesionManager()
					.trouverParId(utilisateur.getJardinierSuppr().get(i));

			UtilisateurDTO monJardinierSuppr = monAdhesionAnnulee.getUtilisateurDTO();
			// this.getManagerFactory().getUtilisateurManager().trouverUtilisateurParId(monAdhesionAnnulee.getUtilisateurDTO().getIdUtilisateur());
			mesJardiniersSuppr.add(monJardinierSuppr);
			this.managerFactory.getAdhesionManager().annulerAdhesion(monAdhesionAnnulee);
		}
		jardiniersSupprimes.addFlashAttribute("mesJardiniersSuppr", mesJardiniersSuppr);
		// session.setAttribute("mesJardinierSuppr", mesJardiniersSuppr);

		return ("redirect:/admin/accueil");
	}

	@GetMapping("/admin/renouvellement_adhesion")
	public String goRenouvellerAdhesion(@ModelAttribute AdhesionDTO adhesion, BindingResult errors, Model model) {
		ModificationFormulaire mf = new ModificationFormulaire();
		model.addAttribute("modificationFormulaire", mf);
		List<AdhesionDTO> mesJardiniers = this.getManagerFactory().getAdhesionManager().trouverJardiniers();
		model.addAttribute("jardiniersListe", mesJardiniers);
		return ("admin/renouvellement_adhesion");
	}

	@PostMapping("/admin/renouvellement_adhesion")
	public String renouvellementAdhesion(
			@ModelAttribute("suppressionFormulaire") @RequestBody ModificationFormulaire modificationFormulaire,
			BindingResult errors, Model model, RedirectAttributes jardiniersRenouveles) {
		for (int i = 0; i < modificationFormulaire.getJardinierSuppr().size(); i++) {
			AdhesionDTO monAdhesionRenouvellee = this.getManagerFactory().getAdhesionManager()
					.trouverParId(modificationFormulaire.getJardinierSuppr().get(i));
			AdhesionDTO adh = this.managerFactory.getAdhesionManager().renouvellementAdhesion(monAdhesionRenouvellee);
			jardiniersRenouveles.addFlashAttribute("jardiniersRenouveles", adh);
		}
		return ("redirect:/admin/accueil");
	}

	private List<String> initRole() {
		List<String> roleListe = new ArrayList<String>();
		roleListe.add("Administrateur");
		roleListe.add("Animateur");
		roleListe.add("Jardinier");
		return roleListe;
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
