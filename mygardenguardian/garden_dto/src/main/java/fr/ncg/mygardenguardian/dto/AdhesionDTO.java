package fr.ncg.mygardenguardian.dto;

import java.util.Date;

public class AdhesionDTO {

	private Integer idAdhesion;
	private Date dateAdhesion;
	private ParcelleDTO parcelleDTO;
	private UtilisateurDTO utilisateurDTO;
	private boolean archive;
	private Date dateAnnulation;

	public AdhesionDTO() {
	}

	public AdhesionDTO(Date dateAdhesion, boolean archive, Date dateAnnulation) {
		this.dateAdhesion = dateAdhesion;
		this.archive = archive;
		this.dateAnnulation = dateAnnulation;
	}

	public Integer getIdAdhesion() {
		return this.idAdhesion;
	}

	public void setIdAdhesion(Integer idAdhesion) {
		this.idAdhesion = idAdhesion;
	}

	public Date getDateAdhesion() {
		return this.dateAdhesion;
	}

	public void setDateAdhesion(Date dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public ParcelleDTO getParcelleDTO() {
		return this.parcelleDTO;
	}

	public void setParcelleDTO(ParcelleDTO parcelleDTO) {
		this.parcelleDTO = parcelleDTO;
	}

	public UtilisateurDTO getUtilisateurDTO() {
		return this.utilisateurDTO;
	}

	public void setUtilisateurDTO(UtilisateurDTO utilisateurDTO) {
		this.utilisateurDTO = utilisateurDTO;
	}

	public boolean isArchive() {
		return this.archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	public Date getDateAnnulation() {
		return this.dateAnnulation;
	}

	public void setDateAnnulation(Date dateAnnulation) {
		this.dateAnnulation = dateAnnulation;
	}

	@Override
	public String toString() {
		return "AdhesionDTO [idAdhesion=" + this.idAdhesion + ", dateAdhesion=" + this.dateAdhesion + ", parcelleDTO="
				+ this.parcelleDTO + ", utilisateurDTO=" + this.utilisateurDTO + ", archive=" + this.archive
				+ ", dateAnnulation=" + this.dateAnnulation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.archive ? 1231 : 1237);
		result = prime * result + ((this.dateAdhesion == null) ? 0 : this.dateAdhesion.hashCode());
		result = prime * result + ((this.dateAnnulation == null) ? 0 : this.dateAnnulation.hashCode());
		result = prime * result + ((this.idAdhesion == null) ? 0 : this.idAdhesion.hashCode());
		result = prime * result + ((this.parcelleDTO == null) ? 0 : this.parcelleDTO.hashCode());
		result = prime * result + ((this.utilisateurDTO == null) ? 0 : this.utilisateurDTO.hashCode());
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
		AdhesionDTO other = (AdhesionDTO) obj;
		if (this.archive != other.archive)
			return false;
		if (this.dateAdhesion == null) {
			if (other.dateAdhesion != null)
				return false;
		} else if (!this.dateAdhesion.equals(other.dateAdhesion))
			return false;
		if (this.dateAnnulation == null) {
			if (other.dateAnnulation != null)
				return false;
		} else if (!this.dateAnnulation.equals(other.dateAnnulation))
			return false;
		if (this.idAdhesion == null) {
			if (other.idAdhesion != null)
				return false;
		} else if (!this.idAdhesion.equals(other.idAdhesion))
			return false;
		if (this.parcelleDTO == null) {
			if (other.parcelleDTO != null)
				return false;
		} else if (!this.parcelleDTO.equals(other.parcelleDTO))
			return false;
		if (this.utilisateurDTO == null) {
			if (other.utilisateurDTO != null)
				return false;
		} else if (!this.utilisateurDTO.equals(other.utilisateurDTO))
			return false;
		return true;
	}

}
