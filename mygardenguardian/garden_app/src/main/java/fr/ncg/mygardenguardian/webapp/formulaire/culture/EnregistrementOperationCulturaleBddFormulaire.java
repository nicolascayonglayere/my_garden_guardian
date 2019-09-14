package fr.ncg.mygardenguardian.webapp.formulaire.culture;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnregistrementOperationCulturaleBddFormulaire {

	private Integer idOperationCulturale;
	@NotBlank(message = "Un nom est requis")
	private String nom;
	@NotNull(message = "Saisissez le nombre de jours après le début de la culture")
	private Integer origIntervPossible;
	@NotNull(message = "Saisissez le nombre de jours durant lesquels il est possible de réaliser l'opération culturale.")
	private Integer intervallePossible;
	@NotBlank(message = "Une description est requise")
	private String description;

	private Integer planteId;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPlanteId() {
		return this.planteId;
	}

	public void setPlanteId(Integer planteId) {
		this.planteId = planteId;
	}

	public Integer getOrigIntervPossible() {
		return this.origIntervPossible;
	}

	public void setOrigIntervPossible(Integer origIntervPossible) {
		this.origIntervPossible = origIntervPossible;
	}

	public Integer getIntervallePossible() {
		return this.intervallePossible;
	}

	public void setIntervallePossible(Integer intervallePossible) {
		this.intervallePossible = intervallePossible;
	}

	public Integer getIdOperationCulturale() {
		return this.idOperationCulturale;
	}

	public void setIdOperationCulturale(Integer idOperationCulturale) {
		this.idOperationCulturale = idOperationCulturale;
	}

	@Override
	public String toString() {
		return "EnregistrementOperationCulturaleBddFormulaire [idOperationCulturale=" + this.idOperationCulturale
				+ ", nom=" + this.nom + ", origIntervPossible=" + this.origIntervPossible + ", intervallePossible="
				+ this.intervallePossible + ", description=" + this.description + ", planteId=" + this.planteId + "]";
	}

}
