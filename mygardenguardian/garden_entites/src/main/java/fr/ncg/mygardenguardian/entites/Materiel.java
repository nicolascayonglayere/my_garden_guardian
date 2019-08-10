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
@Table(name = "materiel", schema = "garden_guardian")
public class Materiel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_materiel")
	private Integer idMateriel;
	@Column(name = "nom", nullable = false)
	private String nom;
	@Column(name = "reference", nullable = false)
	private String reference;
	@ManyToOne()
	@JoinColumn(name = "id_operation_culturale")
	private OperationCulturale operationCulturale;

	public Materiel() {
	}

	public Materiel(String nom, String reference) {
		this.nom = nom;
		this.reference = reference;
	}

	public Integer getIdMateriel() {
		return this.idMateriel;
	}

	public void setIdMateriel(Integer idMateriel) {
		this.idMateriel = idMateriel;
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

	public OperationCulturale getOperationCulturale() {
		return this.operationCulturale;
	}

	public void setOperationCulturale(OperationCulturale operationCulturale) {
		this.operationCulturale = operationCulturale;
	}

	@Override
	public String toString() {
		return "Materiel [idMateriel=" + this.idMateriel + ", nom=" + this.nom + ", reference=" + this.reference
				+ ", operationCulturale=" + this.operationCulturale + "]";
	}

}
