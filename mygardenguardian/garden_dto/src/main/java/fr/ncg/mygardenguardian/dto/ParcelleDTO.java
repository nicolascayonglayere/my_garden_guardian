package fr.ncg.mygardenguardian.dto;

import java.util.ArrayList;
import java.util.List;

public class ParcelleDTO {

	private Integer idParcelle;
	private double surface;
	private String code;
	// private boolean occupation;
	private List<CultureInstanceDTO> listeCultures;

	public ParcelleDTO() {
	}

	public ParcelleDTO(double surface, String code) {
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

	public void addCultureInstanceDTO(CultureInstanceDTO cal) {
		if (this.listeCultures == null) {
			this.listeCultures = new ArrayList<CultureInstanceDTO>();
		}
		this.listeCultures.add(cal);
	}

	public List<CultureInstanceDTO> getlisteCultures() {
		return this.listeCultures;
	}

	public void setlisteCultures(List<CultureInstanceDTO> listeCultures) {
		this.listeCultures = listeCultures;
	}

	@Override
	public String toString() {
		return "ParcelleDTO [idParcelle=" + this.idParcelle + ", surface=" + this.surface + ", code=" + this.code
				+ ", listeCultures=" + this.listeCultures + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
		result = prime * result + ((this.idParcelle == null) ? 0 : this.idParcelle.hashCode());
		result = prime * result + ((this.listeCultures == null) ? 0 : this.listeCultures.hashCode());
		long temp;
		temp = Double.doubleToLongBits(this.surface);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		ParcelleDTO other = (ParcelleDTO) obj;
		if (this.code == null) {
			if (other.code != null)
				return false;
		} else if (!this.code.equals(other.code))
			return false;
		if (this.idParcelle == null) {
			if (other.idParcelle != null)
				return false;
		} else if (!this.idParcelle.equals(other.idParcelle))
			return false;
		if (this.listeCultures == null) {
			if (other.listeCultures != null)
				return false;
		} else if (!this.listeCultures.equals(other.listeCultures))
			return false;
		if (Double.doubleToLongBits(this.surface) != Double.doubleToLongBits(other.surface))
			return false;
		return true;
	}

}
