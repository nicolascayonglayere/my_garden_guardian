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
@Table(name = "culture_instance", schema = "garden_guardian")
public class CultureInstance implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_culture_instance")
	private Integer idCultureInstance;
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "id_parcelle")
	private Parcelle parcelle;
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "id_culture")
	private Culture culture;

	@Column(name = "date")
	private Date date;

	public CultureInstance() {
	}

	public CultureInstance(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Parcelle getParcelle() {
		return this.parcelle;
	}

	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}

	public Culture getCulture() {
		return this.culture;
	}

	public void setCulture(Culture culture) {
		this.culture = culture;
	}

	public Integer getIdCultureInstance() {
		return this.idCultureInstance;
	}

	public void setIdCultureInstance(Integer idCultureInstance) {
		this.idCultureInstance = idCultureInstance;
	}

	@Override
	public String toString() {
		return "CultureInstance [idCultureInstance=" + this.idCultureInstance + " culture=" + this.culture + ", date="
				+ this.date + "]";
	}

}
