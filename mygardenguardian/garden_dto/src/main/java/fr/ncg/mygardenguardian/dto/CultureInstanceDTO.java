package fr.ncg.mygardenguardian.dto;

import java.util.Date;

/**
 * Data Transfer Object CultureInstance
 * 
 * @author nicolas
 *
 */
public class CultureInstanceDTO {

	private Integer idCultureInstance;
	private CultureDTO culture;
	private ParcelleDTO parcelle;
	private Date date;

	public CultureInstanceDTO() {
	}

	public CultureInstanceDTO(Integer idCultureInstance, Date date) {
		this.idCultureInstance = idCultureInstance;
		this.date = date;
	}

	public CultureInstanceDTO(CultureDTO culture, ParcelleDTO parcelle, Date date) {
		this.culture = culture;
		this.parcelle = parcelle;
		this.date = date;
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

	public Integer getIdCultureInstance() {
		return this.idCultureInstance;
	}

	public void setIdCultureInstance(Integer idCultureInstance) {
		this.idCultureInstance = idCultureInstance;
	}

	@Override
	public String toString() {
		return "CultureInstanceDTO [idCultureInstance=" + this.idCultureInstance + ", culture=" + this.culture
				+ ", parcelle=" + this.parcelle + ", date=" + this.date + "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((this.culture == null) ? 0 : this.culture.hashCode());
//		result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
//		result = prime * result + ((this.idCultureInstance == null) ? 0 : this.idCultureInstance.hashCode());
//		result = prime * result + ((this.parcelle == null) ? 0 : this.parcelle.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		CultureInstanceDTO other = (CultureInstanceDTO) obj;
		if (this.culture == null) {
			if (other.culture != null)
				return false;
		} else if (!this.culture.equals(other.culture))
			return false;
		if (this.date == null) {
			if (other.date != null)
				return false;
		} else if (!this.date.equals(other.date))
			return false;
		if (this.idCultureInstance == null) {
			if (other.idCultureInstance != null)
				return false;
		} else if (!this.idCultureInstance.equals(other.idCultureInstance))
			return false;
		if (this.parcelle == null) {
			if (other.parcelle != null)
				return false;
		} else if (!this.parcelle.equals(other.parcelle))
			return false;
		return true;
	}

}
