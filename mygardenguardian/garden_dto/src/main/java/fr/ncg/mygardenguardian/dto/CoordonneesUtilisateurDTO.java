package fr.ncg.mygardenguardian.dto;

public class CoordonneesUtilisateurDTO {

	private Integer idCoordonneesUtilisateur;
	private String numPortable;
	private String email;
	private String adresse;
	private String ville;
	private String codePostal;

	public CoordonneesUtilisateurDTO() {
	}

	public CoordonneesUtilisateurDTO(String numPortable, String email, String adresse, String ville,
			String codePostal) {
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

	public String getNumPortable() {
		return this.numPortable;
	}

	public void setNumPortable(String numPortable) {
		this.numPortable = numPortable;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "CoordonneesUtilisateurDTO [idCoordonneesUtilisateur=" + this.idCoordonneesUtilisateur + ", numPortable="
				+ this.numPortable + ", email=" + this.email + ", adresse=" + this.adresse + ", ville=" + this.ville
				+ ", codePostal=" + this.codePostal + "]";
	}

}
