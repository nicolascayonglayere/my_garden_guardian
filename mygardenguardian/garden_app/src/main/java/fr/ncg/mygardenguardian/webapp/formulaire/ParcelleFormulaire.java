package fr.ncg.mygardenguardian.webapp.formulaire;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ParcelleFormulaire {

	private Integer idParcelle;
	@NotBlank(message = "Un code est requis")
	private String code;
	@NotNull(message = "Surface requise en m2")
	private Integer surface;

	public Integer getIdParcelle() {
		return this.idParcelle;
	}

	public void setIdParcelle(Integer idParcelle) {
		this.idParcelle = idParcelle;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSurface() {
		return this.surface;
	}

	public void setSurface(Integer surface) {
		this.surface = surface;
	}

	@Override
	public String toString() {
		return "ParcelleFormulaire [idParcelle=" + this.idParcelle + ", code=" + this.code + ", surface=" + this.surface
				+ "]";
	}

}
