package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adhesion", schema = "garden_guardian")
public class Adhesion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adhesion")
	private Integer idAdhesion;
	@Column(name = "date_adhesion", nullable = false)
	private Date dateAdhesion;
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "id_parcelle")
	private Parcelle parcelle;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;

	public Adhesion() {
	}

	public Adhesion(Date dateAdhesion, Parcelle parcelle, Utilisateur utilisateur) {
		this.dateAdhesion = dateAdhesion;
		this.parcelle = parcelle;
		this.utilisateur = utilisateur;
	}

	public Integer getIdAdhesion() {
		return this.idAdhesion;
	}

	public void setIdAdhesion(Integer idAdhesion) {
		this.idAdhesion = idAdhesion;
	}

	public Date getDateAdhesion() {
		return this.dateAdhesion;
	}

	public void setDateAdhesion(Date dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public Parcelle getParcelle() {
		return this.parcelle;
	}

	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Adhesion [idAdhesion=" + this.idAdhesion + ", dateAdhesion=" + this.dateAdhesion + ", parcelle="
				+ this.parcelle + ", utilisateur=" + this.utilisateur + "]";
	}

}
