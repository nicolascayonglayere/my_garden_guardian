package fr.ncg.mygardenguardian.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class AdhesionDTO {

	private Integer idAdhesion;
	private Date dateAdhesion;
	private ParcelleDTO parcelleDTO;
	private UtilisateurDTO utilisateurDTO;

	public AdhesionDTO() {
	}

	public AdhesionDTO(Date dateAdhesion, ParcelleDTO parcelleDTO, UtilisateurDTO utilisateurDTO) {
		this.dateAdhesion = dateAdhesion;
		this.parcelleDTO = parcelleDTO;
		this.utilisateurDTO = utilisateurDTO;
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

	@Override
	public String toString() {
		return "AdhesionDTO [idAdhesion=" + this.idAdhesion + ", dateAdhesion=" + this.dateAdhesion + "]";
	}

}
