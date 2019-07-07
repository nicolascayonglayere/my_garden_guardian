package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur", schema = "garden_guardian")
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private Integer idUtilisateur;
	@Column(name = "prenom", nullable = false)
	private String prenom;
	@Column(name = "nom", nullable = false)
	private String nom;
	@Column(name = "mot_de_passe", nullable = false)
	private String mdp;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_coordonnee")
	private CoordonneesUtilisateur coordonneeUtilisateur;
	@Column(name = "role", nullable = false)
	private String role;
	@OneToMany(mappedBy = "utilisateur")
	private List<Culture> culturesAjoutees;

	public Utilisateur() {
	}

	public Utilisateur(String prenom, String nom, String mdp, String role) {
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

	public CoordonneesUtilisateur getCoordonneeUtilisateur() {
		return this.coordonneeUtilisateur;
	}

	public void setCoordonneeUtilisateur(CoordonneesUtilisateur coordonneeUtilisateur) {
		this.coordonneeUtilisateur = coordonneeUtilisateur;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Culture> getCulturesAjoutees() {
		return this.culturesAjoutees;
	}

	public void setCulturesAjoutees(List<Culture> culturesAjoutees) {
		this.culturesAjoutees = culturesAjoutees;
	}

	public void addCulture(Culture culture) {
		if (this.culturesAjoutees == null) {
			this.culturesAjoutees = new ArrayList<Culture>();
		}
		this.culturesAjoutees.add(culture);
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + this.idUtilisateur + ", prenom=" + this.prenom + ", nom=" + this.nom
				+ ", mdp=" + this.mdp + ", coordonneeUtilisateur=" + this.coordonneeUtilisateur + ", role=" + this.role
				+ "]";
	}

}
