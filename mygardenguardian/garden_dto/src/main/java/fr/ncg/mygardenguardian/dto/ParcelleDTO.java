package fr.ncg.mygardenguardian.dto;

import java.util.ArrayList;
import java.util.List;

public class ParcelleDTO {

	private Integer idParcelle;
	private double surface;
	private String code;
	// private boolean occupation;
	private List<CalendrierCulturalDTO> calendrierCultural;

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

	public void addCultureDTO(CalendrierCulturalDTO cal) {
		if (this.calendrierCultural == null) {
			this.calendrierCultural = new ArrayList<CalendrierCulturalDTO>();
		}
		this.calendrierCultural.add(cal);
	}

	public List<CalendrierCulturalDTO> getCalendrierCultural() {
		return this.calendrierCultural;
	}

	public void setCalendrierCultural(List<CalendrierCulturalDTO> calendrierCultural) {
		this.calendrierCultural = calendrierCultural;
	}

	@Override
	public String toString() {
		return "ParcelleDTO [idParcelle=" + this.idParcelle + ", surface=" + this.surface + ", code=" + this.code
				+ ", calendrierCultural=" + this.calendrierCultural + "]";
	}

}
