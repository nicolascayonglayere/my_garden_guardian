package fr.ncg.mygardenguardian.webapp.formulaire.culture;

import javax.validation.constraints.NotBlank;

public class EnregistrementIntrantBddFormulaire {

	@NotBlank(message = "Un nom est requis")
	private String nom;
	@NotBlank(message = "Une référence est requiss")
	private String reference;
	private Integer planteId;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "AjoutIntrantBddFormulaire [nom=" + this.nom + ", reference=" + this.reference + "]";
	}

	public Integer getPlanteId() {
		return this.planteId;
	}

	public void setPlanteId(Integer planteId) {
		this.planteId = planteId;
	}
}
