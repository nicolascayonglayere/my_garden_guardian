package fr.ncg.mygardenguardian.webapp.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.CoordonneesUtilisateurDTO;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.InscriptionFormulaire;

@Controller
public class Inscription {

	private IBusinessManagerFactory managerFactory;
	private CoordonneesUtilisateurDTO cuDto;
	private UtilisateurDTO userDto;
	private ParcelleDTO parcelleDTO;
	private AdhesionDTO adhesionDTO;

	@GetMapping("/inscription_jardinier")
	public String getInscriptionJardinier(@ModelAttribute AdhesionDTO adhesion, BindingResult errors, Model model) {
		InscriptionFormulaire inscriptionForm = new InscriptionFormulaire();
		model.addAttribute(inscriptionForm);
		model.addAttribute("roleListe", this.initRole());
		model.addAttribute("parcelleListe",
				this.getManagerFactory().getParcelleManager().trouverToutesParcellesVides());
		return ("inscription_jardinier");
	}

	@PostMapping("/inscription_jardinier")
	public String inscriptionJardinier(
			@Valid @ModelAttribute("inscriptionFormulaire") @RequestBody InscriptionFormulaire inscriptionFormulaire,
			BindingResult errors, Model model) {

		if (errors.hasErrors()) {
			this.initRole();
			return ("inscription_jardinier");
		}

		this.cuDto.setAdresse(inscriptionFormulaire.getAdresse());
		this.cuDto.setCodePostal(inscriptionFormulaire.getCodePostal());
		this.cuDto.setEmail(inscriptionFormulaire.getEmail());
		this.cuDto.setNumPortable(inscriptionFormulaire.getNumPortable());
		this.cuDto.setVille(inscriptionFormulaire.getVille());

		this.userDto.setNom(inscriptionFormulaire.getNom());
		this.userDto.setPrenom(inscriptionFormulaire.getPrenom());
		this.userDto.setMdp(inscriptionFormulaire.getMdp());
		this.userDto.setRole(inscriptionFormulaire.getRole());
		this.userDto.setCoordonneeUtilisateurDTO(this.cuDto);

		this.parcelleDTO = this.managerFactory.getParcelleManager()
				.trouverParcelleParId(inscriptionFormulaire.getIdParcelle());

		this.adhesionDTO.setParcelleDTO(this.parcelleDTO);
		this.adhesionDTO.setUtilisateurDTO(this.userDto);
		this.adhesionDTO.setDateAdhesion(Calendar.getInstance().getTime());

		this.managerFactory.getAdhesionManager().saveAdhesion(this.adhesionDTO);
		return ("accueil");
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

	public CoordonneesUtilisateurDTO getCuDto() {
		return this.cuDto;
	}

	@Autowired
	public void setCuDto(CoordonneesUtilisateurDTO cuDto) {
		this.cuDto = cuDto;
	}

	public UtilisateurDTO getUserDto() {
		return this.userDto;
	}

	@Autowired
	public void setUserDto(UtilisateurDTO userDto) {
		this.userDto = userDto;
	}

	public ParcelleDTO getParcelleDTO() {
		return this.parcelleDTO;
	}

	@Autowired
	public void setParcelleDTO(ParcelleDTO parcelleDTO) {
		this.parcelleDTO = parcelleDTO;
	}

	public AdhesionDTO getAdhesionDTO() {
		return this.adhesionDTO;
	}

	@Autowired
	public void setAdhesionDTO(AdhesionDTO adhesionDTO) {
		this.adhesionDTO = adhesionDTO;
	}
}
