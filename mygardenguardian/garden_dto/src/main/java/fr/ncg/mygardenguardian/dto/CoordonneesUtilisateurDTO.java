package fr.ncg.mygardenguardian.dto;

import org.springframework.stereotype.Component;

@Component
public class CoordonneesUtilisateurDTO {

	private Integer idCoordonneesUtilisateur;
	private Integer numPortable;
	private String email;
	private String adresse;
	private String ville;
	private Integer codePostal;

	public CoordonneesUtilisateurDTO() {
	}

	public CoordonneesUtilisateurDTO(Integer numPortable, String email, String adresse, String ville,
			Integer codePostal) {
		this.numPortable = numPortable;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Integer getIdCoordonneesUtilisateur() {
		return this.idCoordonneesUtilisateur;
	}

	public void setIdCoordonneesUtilisateur(Integer idCoordonneesUtilisateur) {
		this.idCoordonneesUtilisateur = idCoordonneesUtilisateur;
	}

	public Integer getNumPortable() {
		return this.numPortable;
	}

	public void setNumPortable(Integer numPortable) {
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

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "CoordonneesUtilisateurDTO [idCoordonneesUtilisateur=" + this.idCoordonneesUtilisateur + ", numPortable="
				+ this.numPortable + ", email=" + this.email + ", adresse=" + this.adresse + ", ville=" + this.ville
				+ ", codePostal=" + this.codePostal + "]";
	}

}
