package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calendrier_cultural", schema = "garden_guardian")
@IdClass(CalendrierCulturalPk.class)
public class CalendrierCultural implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_parcelle")
	private Integer idParcelle;
	@Id
	@Column(name = "id_culture")
	private Integer idCulture;

	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "id_parcelle", referencedColumnName = "id_parcelle", updatable = false, insertable = false) }) // ,
	// @JoinColumn(name = "id_culture", referencedColumnName = "id_culture") })
	// @JoinColumn(name = "id_parcelle") // , referencedColumnName = "id_parcelle")
	private Parcelle parcelle;

	@ManyToOne
	@JoinColumns(value = {
			// @JoinColumn(name = "id_parcelle", referencedColumnName = "id_parcelle",
			// updatable = false, insertable = false),
			@JoinColumn(name = "id_culture", referencedColumnName = "id_culture", updatable = false, insertable = false) })
	private Culture culture;
	@Column(name = "date")
	private Date date;

	public CalendrierCultural() {
	}

	public CalendrierCultural(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIdParcelle() {
		return this.idParcelle;
	}

	public void setIdParcelle(Integer idParcelle) {
		this.idParcelle = idParcelle;
	}

	public Parcelle getParcelle() {
		return this.parcelle;
	}

	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}

	public Integer getIdCulture() {
		return this.idCulture;
	}

	public void setIdCulture(Integer idCulture) {
		this.idCulture = idCulture;
	}

	public Culture getCulture() {
		return this.culture;
	}

	public void setCulture(Culture culture) {
		this.culture = culture;
	}

	@Override
	public String toString() {
		return "CalendrierCultural [idParcelle=" + this.idParcelle + ", idCulture=" + this.idCulture + ", date="
				+ this.date + "]";
	}

}
