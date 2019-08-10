package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;

public class CalendrierCulturalPk implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idParcelle;
	private Integer idCulture;

	public Integer getIdParcelle() {
		return this.idParcelle;
	}

	public Integer getIdCulture() {
		return this.idCulture;
	}

	@Override
	public int hashCode() {
		return this.idParcelle + this.idCulture;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CalendrierCulturalPk) {
			CalendrierCulturalPk otherId = (CalendrierCulturalPk) obj;
			return (otherId.idParcelle == this.idParcelle) && (otherId.idCulture == this.idCulture);
		}
		return false;
	}

}
