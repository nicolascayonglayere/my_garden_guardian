package fr.ncg.mygardenguardian.dto;

/**
 * Data Transfer Object CoordonneesUtilisateur
 * 
 * @author nicolas
 *
 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.adresse == null) ? 0 : this.adresse.hashCode());
		result = prime * result + ((this.codePostal == null) ? 0 : this.codePostal.hashCode());
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result
				+ ((this.idCoordonneesUtilisateur == null) ? 0 : this.idCoordonneesUtilisateur.hashCode());
		result = prime * result + ((this.numPortable == null) ? 0 : this.numPortable.hashCode());
		result = prime * result + ((this.ville == null) ? 0 : this.ville.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		CoordonneesUtilisateurDTO other = (CoordonneesUtilisateurDTO) obj;
		if (this.adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!this.adresse.equals(other.adresse))
			return false;
		if (this.codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!this.codePostal.equals(other.codePostal))
			return false;
		if (this.email == null) {
			if (other.email != null)
				return false;
		} else if (!this.email.equals(other.email))
			return false;
		if (this.idCoordonneesUtilisateur == null) {
			if (other.idCoordonneesUtilisateur != null)
				return false;
		} else if (!this.idCoordonneesUtilisateur.equals(other.idCoordonneesUtilisateur))
			return false;
		if (this.numPortable == null) {
			if (other.numPortable != null)
				return false;
		} else if (!this.numPortable.equals(other.numPortable))
			return false;
		if (this.ville == null) {
			if (other.ville != null)
				return false;
		} else if (!this.ville.equals(other.ville))
			return false;
		return true;
	}

}
