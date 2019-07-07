package fr.ncg.mygardenguardian.webapp.formulaire.culture;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class EnregistrementOperationCulturaleBddFormulaire {

	@NotBlank(message = "Un nom est requis")
	private String nom;
	@NotNull(message = "Une date de début est requise")
	@DateTimeFormat(iso = ISO.DATE)
	private Date date;
	@NotBlank(message = "Une description est requise")
	private String description;

	private Integer planteId;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "EnregistrementOperationCulturaleBddFormulaire [nom=" + this.nom + ", date=" + this.date
				+ ", description=" + this.description + "]";
	}

	public Integer getPlanteId() {
		return this.planteId;
	}

	public void setPlanteId(Integer planteId) {
		this.planteId = planteId;
	}

}
