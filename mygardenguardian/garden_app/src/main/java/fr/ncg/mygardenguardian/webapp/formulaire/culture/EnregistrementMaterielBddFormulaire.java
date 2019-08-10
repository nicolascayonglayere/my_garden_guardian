package fr.ncg.mygardenguardian.webapp.formulaire.culture;

import javax.validation.constraints.NotBlank;

public class EnregistrementMaterielBddFormulaire {

	@NotBlank(message = "Un nom est requis")
	private String nom;
	@NotBlank(message = "Un nom est requis")
	private String reference;

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
		return "EnregistrementMaterielBddFormulaire [nom=" + this.nom + ", reference=" + this.reference + "]";
	}
}
