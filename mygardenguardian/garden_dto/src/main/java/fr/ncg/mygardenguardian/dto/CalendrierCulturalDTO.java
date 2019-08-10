package fr.ncg.mygardenguardian.dto;

import java.util.Date;

public class CalendrierCulturalDTO {

	private Integer idParcelle;
	private Integer idCulture;
	private CultureDTO culture;
	private ParcelleDTO parcelle;
	private Date date;

	public CalendrierCulturalDTO() {
	}

	public CalendrierCulturalDTO(Integer idParcelle, Integer idCulture, Date date) {
		this.idParcelle = idParcelle;
		this.idCulture = idCulture;
		this.date = date;
	}

	public Integer getIdParcelle() {
		return this.idParcelle;
	}

	public void setIdParcelle(Integer idParcelle) {
		this.idParcelle = idParcelle;
	}

	public Integer getIdCulture() {
		return this.idCulture;
	}

	public void setIdCulture(Integer idCulture) {
		this.idCulture = idCulture;
	}

	public CultureDTO getCulture() {
		return this.culture;
	}

	public void setCulture(CultureDTO culture) {
		this.culture = culture;
	}

	public ParcelleDTO getParcelle() {
		return this.parcelle;
	}

	public void setParcelle(ParcelleDTO parcelle) {
		this.parcelle = parcelle;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CalendrierCulturalDTO [idParcelle=" + this.idParcelle + ", idCulture=" + this.idCulture + ", culture="
				+ this.culture + ", parcelle=" + this.parcelle + ", date=" + this.date + "]";
	}

}
