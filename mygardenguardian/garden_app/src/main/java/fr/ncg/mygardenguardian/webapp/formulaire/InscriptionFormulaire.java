package fr.ncg.mygardenguardian.webapp.formulaire;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class InscriptionFormulaire {

	@NotBlank(message = "Un nom est requis")
	private String nom;
	@NotBlank(message = "Un prenom est requis")
	private String prenom;
	@NotBlank(message = "Un mot de passe est requis")
	private String mdp;
	@NotBlank(message = "Saisissez un numéro de portbale : 01-23-45-67-89")
	@Pattern(regexp = "(\\d{2}-){4}\\d{2}", message = "Saisissez un numéro de portbale : 01-23-45-67-89")
	@Valid
	private String numPortable;
	@NotBlank(message = "Saisissez un email valide")
	@Valid
	private String email;
	@NotBlank(message = "Adresse requise")
	private String adresse;
	@NotBlank(message = "Saisissez un code postal : 12345")
	@Pattern(regexp = "\\d{5}", message = "Saisissez un code postal : 12345")
	@Valid
	private String codePostal;
	@NotBlank(message = "Ville requise")
	private String ville;
	private String role;
	private Integer idParcelle;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNumPortable() {
		return this.numPortable;
	}

	public void setNumPortable(String numPortable) {
		this.numPortable = numPortable;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getIdParcelle() {
		return this.idParcelle;
	}

	public void setIdParcelle(Integer idParcelle) {
		this.idParcelle = idParcelle;
	}

	@Override
	public String toString() {
		return "InscriptionFormulaire [nom=" + this.nom + ", prenom=" + this.prenom + ", mdp=" + this.mdp
				+ ", numPortable=" + this.numPortable + ", email=" + this.email + ", adresse=" + this.adresse
				+ ", codePostal=" + this.codePostal + ", ville=" + this.ville + ", role=" + this.role + ", idParcelle="
				+ this.idParcelle + "]";
	}

}
