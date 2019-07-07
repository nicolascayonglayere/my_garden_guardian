package fr.ncg.mygardenguardian.webapp.formulaire.culture;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnregistrementPlanteBddFormulaire {

	@NotBlank(message = "Un nom est requis")
	private String nomPlante;
	@NotBlank(message = "Une variété est requise")
	private String variete;
	@NotBlank(message = "Un nom latin est requis")
	private String nomLatin;
	@NotNull(message = "Durée du cycle requise en mois")
	private Integer dureeCycle;
	@NotBlank(message = "Un produit est requis")
	private String produit;

	public String getNomPlante() {
		return this.nomPlante;
	}

	public void setNomPlante(String nomPlante) {
		this.nomPlante = nomPlante;
	}

	public String getNomLatin() {
		return this.nomLatin;
	}

	public void setNomLatin(String nomLatin) {
		this.nomLatin = nomLatin;
	}

	public Integer getDureeCycle() {
		return this.dureeCycle;
	}

	public void setDureeCycle(Integer dureeCycle) {
		this.dureeCycle = dureeCycle;
	}

	public String getProduit() {
		return this.produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getVariete() {
		return this.variete;
	}

	public void setVariete(String variete) {
		this.variete = variete;
	}

	@Override
	public String toString() {
		return "EnregistrementPlanteBddFormulaire [nomPlante=" + this.nomPlante + ", nomLatin=" + this.nomLatin
				+ ", dureeCycle=" + this.dureeCycle + ", produit=" + this.produit + ", variete=" + this.variete + "]";
	}

}
