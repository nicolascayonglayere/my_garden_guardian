package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	// @Column(name = "occupation")
	// private boolean occupation;
	// @OneToMany(mappedBy = "parcelle")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "calendrier_cultural", joinColumns = @JoinColumn(name = "id_parcelle"), inverseJoinColumns = @JoinColumn(name = "id_culture"), schema = "garden_guardian")
	private List<Culture> calendrierCultural;

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

	public List<Culture> getCalendrierCultural() {
		return this.calendrierCultural;
	}

	public void setCalendrierCultural(List<Culture> calendrierCultural) {
		this.calendrierCultural = calendrierCultural;
	}

	public void addCulture(Culture culture) {
		if (this.calendrierCultural == null) {
			this.calendrierCultural = new ArrayList<Culture>();
		}
		this.calendrierCultural.add(culture);
	}

	@Override
	public String toString() {
		return "Parcelle [idParcelle=" + this.idParcelle + ", surface=" + this.surface + ", code=" + this.code
				+ ", calendrierCultural=" + this.calendrierCultural + "]";
	}

}
