package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parcelle", schema = "garden_guardian")
public class Parcelle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_parcelle")
	private Integer idParcelle;
	@Column(name = "surface")
	private double surface;
	@Column(name = "code")
	private String code;

	@OneToMany(mappedBy = "parcelle")
	private List<CalendrierCultural> listeCultures;

	public Parcelle() {
	}

	public Parcelle(double surface, String code) {
		this.surface = surface;
		this.code = code;
		// this.occupation = occupation;
	}

	public Integer getIdParcelle() {
		return this.idParcelle;
	}

	public void setIdParcelle(Integer idParcelle) {
		this.idParcelle = idParcelle;
	}

	public double getSurface() {
		return this.surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void addCulture(Culture culture, Date date) {
		if (this.listeCultures == null) {
			this.listeCultures = new ArrayList<CalendrierCultural>();
		}
		CalendrierCultural cal = new CalendrierCultural();
		cal.setCulture(culture);
		cal.setDate(date);
		cal.setIdCulture(culture.getIdCulture());
		cal.setParcelle(this);
		cal.setIdParcelle(this.getIdParcelle());
		this.listeCultures.add(cal);
		culture.getListeParcelles().add(cal);
	}

	public List<CalendrierCultural> getListeCultures() {
		return this.listeCultures;
	}

	public void setListeCultures(List<CalendrierCultural> listeCultures) {
		this.listeCultures = listeCultures;
	}

	@Override
	public String toString() {
		return "Parcelle [idParcelle=" + this.idParcelle + ", surface=" + this.surface + ", code=" + this.code
				+ ", calendrierCultural=" + this.listeCultures + "]";
	}

}
