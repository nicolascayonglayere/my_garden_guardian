package fr.ncg.mygardenguardian.dto;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurDTO {

	private Integer idUtilisateur;
	private String prenom;
	private String nom;
	private String mdp;
	private CoordonneesUtilisateurDTO coordonneeUtilisateurDTO;
	private String role;
	private List<CultureDTO> cultureAjoutees;

	public UtilisateurDTO() {
	}

	public UtilisateurDTO(String prenom, String nom, String mdp, String role) {
		this.prenom = prenom;
		this.nom = nom;
		this.mdp = mdp;
		this.role = role;
	}

	public Integer getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UtilisateurDTO [idUtilisateur=" + this.idUtilisateur + ", prenom=" + this.prenom + ", nom=" + this.nom
				+ ", mdp=" + this.mdp + ", role=" + this.role + "]";
	}

	public CoordonneesUtilisateurDTO getCoordonneeUtilisateurDTO() {
		return this.coordonneeUtilisateurDTO;
	}

	public void setCoordonneeUtilisateurDTO(CoordonneesUtilisateurDTO coordonneeUtilisateurDTO) {
		this.coordonneeUtilisateurDTO = coordonneeUtilisateurDTO;
	}

	public List<CultureDTO> getCultureAjoutees() {
		return this.cultureAjoutees;
	}

	public void setCultureAjoutees(List<CultureDTO> cultureAjoutees) {
		this.cultureAjoutees = cultureAjoutees;
	}

	public void addCulture(CultureDTO culture) {
		if (this.cultureAjoutees == null) {
			this.cultureAjoutees = new ArrayList<CultureDTO>();
		}
		this.cultureAjoutees.add(culture);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.coordonneeUtilisateurDTO == null) ? 0 : this.coordonneeUtilisateurDTO.hashCode());
		result = prime * result + ((this.cultureAjoutees == null) ? 0 : this.cultureAjoutees.hashCode());
		result = prime * result + ((this.idUtilisateur == null) ? 0 : this.idUtilisateur.hashCode());
		result = prime * result + ((this.mdp == null) ? 0 : this.mdp.hashCode());
		result = prime * result + ((this.nom == null) ? 0 : this.nom.hashCode());
		result = prime * result + ((this.prenom == null) ? 0 : this.prenom.hashCode());
		result = prime * result + ((this.role == null) ? 0 : this.role.hashCode());
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
		UtilisateurDTO other = (UtilisateurDTO) obj;
		if (this.coordonneeUtilisateurDTO == null) {
			if (other.coordonneeUtilisateurDTO != null)
				return false;
		} else if (!this.coordonneeUtilisateurDTO.equals(other.coordonneeUtilisateurDTO))
			return false;
		if (this.cultureAjoutees == null) {
			if (other.cultureAjoutees != null)
				return false;
		} else if (!this.cultureAjoutees.equals(other.cultureAjoutees))
			return false;
		if (this.idUtilisateur == null) {
			if (other.idUtilisateur != null)
				return false;
		} else if (!this.idUtilisateur.equals(other.idUtilisateur))
			return false;
		if (this.mdp == null) {
			if (other.mdp != null)
				return false;
		} else if (!this.mdp.equals(other.mdp))
			return false;
		if (this.nom == null) {
			if (other.nom != null)
				return false;
		} else if (!this.nom.equals(other.nom))
			return false;
		if (this.prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!this.prenom.equals(other.prenom))
			return false;
		if (this.role == null) {
			if (other.role != null)
				return false;
		} else if (!this.role.equals(other.role))
			return false;
		return true;
	}

}
