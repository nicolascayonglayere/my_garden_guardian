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

}
