package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plante", schema = "garden_guardian")
public class Plante implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plante")
	private Integer idPlante;
	@Column(name = "nom", nullable = false)
	private String nom;
	@Column(name = "nom_latin", nullable = false)
	private String nomLatin;
	@Column(name = "variete", nullable = false)
	private String variete;
	@Column(name = "duree_cycle", nullable = false)
	private Integer dureeCycle;
	@Column(name = "produit", nullable = false)
	private String produit;

	public Plante() {
	}

	public Plante(String nom, String nomLatin, String variete, Integer dureeCycle, String produit) {
		this.nom = nom;
		this.nomLatin = nomLatin;
		this.variete = variete;
		this.dureeCycle = dureeCycle;
		this.produit = produit;
	}

	public Integer getIdPlante() {
		return this.idPlante;
	}

	public void setIdPlante(Integer idPlante) {
		this.idPlante = idPlante;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomLatin() {
		return this.nomLatin;
	}

	public void setNomLatin(String nomLatin) {
		this.nomLatin = nomLatin;
	}

	public Integer getDureeCycle() {
		return this.dureeCycle;
	}

	public void setDureeCycle(Integer dureeCycle) {
		this.dureeCycle = dureeCycle;
	}

	public String getProduit() {
		return this.produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getVariete() {
		return this.variete;
	}

	public void setVariete(String variete) {
		this.variete = variete;
	}

	@Override
	public String toString() {
		return "Plante [idPlante=" + this.idPlante + ", nom=" + this.nom + ", nomLatin=" + this.nomLatin + ", variete="
				+ this.variete + ", dureeCycle=" + this.dureeCycle + ", produit=" + this.produit + "]";
	}

}
