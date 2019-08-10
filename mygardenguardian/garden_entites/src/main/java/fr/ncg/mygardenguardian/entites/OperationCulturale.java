package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "operation_culturale", schema = "garden_guardian")
public class OperationCulturale implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_operation_culturale")
	private Integer idOperationCulturale;
	@Column(name = "nom", nullable = false)
	private String nom;
	@Column(name = "date", nullable = false)
	private Integer date;
	@Column(name = "description", nullable = false)
	private String descritpion;
	@ManyToOne
	@JoinColumn(name = "id_culture")
	private Culture culture;
	@OneToMany(mappedBy = "operationCulturale")
	private List<Materiel> materiels;
	@Column(name = "statut", nullable = false)
	private String statut;

	public OperationCulturale() {
	}

	public OperationCulturale(String nom, Integer date, String descritpion, String statut) {
		this.nom = nom;
		this.date = date;
		this.descritpion = descritpion;
		this.statut = statut;
	}

	public Integer getIdOperationCulturale() {
		return this.idOperationCulturale;
	}

	public void setIdOperationCulturale(Integer idOperationCulturale) {
		this.idOperationCulturale = idOperationCulturale;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getDate() {
		return this.date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public String getDescritpion() {
		return this.descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public Culture getCulture() {
		return this.culture;
	}

	public void setCulture(Culture culture) {
		this.culture = culture;
	}

	public List<Materiel> getMateriels() {
		return this.materiels;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void addMateriel(Materiel mat) {
		if (this.materiels == null) {
			this.materiels = new ArrayList<Materiel>();
		}
		this.materiels.add(mat);
	}

	@Override
	public String toString() {
		return "OperationCulturale [idOperationCulturale=" + this.idOperationCulturale + ", nom=" + this.nom + ", date="
				+ this.date + ", descritpion=" + this.descritpion + ", culture=" + this.culture + ", materiels="
				+ this.materiels + ", statut=" + this.statut + "]";
	}

}
