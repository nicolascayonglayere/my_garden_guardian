package fr.ncg.mygardenguardian.dto;

public class ParcelleDTO {

	private Integer idParcelle;
	private double surface;
	private String code;
	// private boolean occupation;

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

	// public boolean isOccupation() {
	// return this.occupation;
	// }
	//
	// public void setOccupation(boolean occupation) {
	// this.occupation = occupation;
	// }

	@Override
	public String toString() {
		return "ParcelleDTO [idParcelle=" + this.idParcelle + ", surface=" + this.surface + ", code=" + this.code
				+ ", occupation=" + 00 + "]";
	}

}
