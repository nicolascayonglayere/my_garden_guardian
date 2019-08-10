package fr.ncg.mygardenguardian.webapp.formulaire.culture;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnregistrementOperationCulturaleBddFormulaire {

	@NotBlank(message = "Un nom est requis")
	private String nom;
	@NotNull(message = "Une date d'operation est requise : saisissez le numéro de la semaine.")
	// @DateTimeFormat(iso = ISO.DATE)
	private Integer date;
	@NotBlank(message = "Une description est requise")
	private String description;

	private Integer planteId;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getDate() {
		return this.date;
	}

	public void setDate(Integer date) {
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
