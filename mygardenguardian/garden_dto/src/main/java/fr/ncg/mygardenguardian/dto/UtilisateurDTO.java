package fr.ncg.mygardenguardian.dto;

import org.springframework.stereotype.Component;

@Component
public class UtilisateurDTO {

	private Integer idUtilisateur;
	private String prenom;
	private String nom;
	private String mdp;
	private CoordonneesUtilisateurDTO coordonneeUtilisateurDTO;
	private String role;

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

}
