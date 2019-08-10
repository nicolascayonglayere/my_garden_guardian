package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "intrant", schema = "garden_guardian")
public class Intrant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_intrant")
	private Integer idIntrant;
	@Column(name = "nom", nullable = false)
	private String nom;
	@Column(name = "reference", nullable = false)
	private String reference;
	@ManyToOne
	@JoinColumn(name = "id_culture")
	private Culture culture;

	public Intrant() {
	}

	public Intrant(String nom, String reference) {
		this.nom = nom;
		this.reference = reference;
	}

	public Integer getIdIntrant() {
		return this.idIntrant;
	}

	public void setIdIntrant(Integer idIntrant) {
		this.idIntrant = idIntrant;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Culture getCulture() {
		return this.culture;
	}

	public void setCulture(Culture culture) {
		this.culture = culture;
	}

//	@Override
//	public String toString() {
//		return "Intrant [idIntrant=" + this.idIntrant + ", nom=" + this.nom + ", reference=" + this.reference
//				+ ", culture=" + this.culture + "]";
//	}

}
