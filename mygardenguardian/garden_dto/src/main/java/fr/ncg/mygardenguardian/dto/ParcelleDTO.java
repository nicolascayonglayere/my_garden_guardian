package fr.ncg.mygardenguardian.dto;

import org.springframework.stereotype.Component;

@Component
public class ParcelleDTO {

	private Integer idParcelle;
	private double surface;
	private String code;

	public ParcelleDTO() {
	}

	public ParcelleDTO(double surface, String code) {
		this.surface = surface;
		this.code = code;
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

	@Override
	public String toString() {
		return "ParcelleDTO [idParcelle=" + this.idParcelle + ", surface=" + this.surface + ", code=" + this.code + "]";
	}

}
