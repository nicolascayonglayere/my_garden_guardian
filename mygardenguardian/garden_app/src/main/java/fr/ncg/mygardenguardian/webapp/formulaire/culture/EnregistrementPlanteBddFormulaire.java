package fr.ncg.mygardenguardian.webapp.formulaire.culture;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import fr.ncg.mygardenguardian.webapp.validator.RecomHauteSupRecomBasseConstraint;

@RecomHauteSupRecomBasseConstraint(message = "La recommandation haute doit être supérieure à la recommandation basse")
public class EnregistrementPlanteBddFormulaire {

	@NotBlank(message = "Un nom de culture est requis")
	private String nomCulture;
	@NotBlank(message = "Un nom de plante est requis")
	private String nomPlante;
	@NotBlank(message = "Une variété est requise")
	private String variete;
	@NotBlank(message = "Un nom latin est requis")
	private String nomLatin;
	@NotNull(message = "Durée du cycle requise en mois")
	private Integer dureeCycle;
	@NotNull(message = "Recommandation basse requise")
	private Integer recommandationBasse;
	@NotNull(message = "Recommandation haute requise")
	private Integer recommandationHaute;
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

	public String getNomCulture() {
		return this.nomCulture;
	}

	public void setNomCulture(String nomCulture) {
		this.nomCulture = nomCulture;
	}

	public Integer getRecommandationBasse() {
		return this.recommandationBasse;
	}

	public void setRecommandationBasse(Integer recommandationBasse) {
		this.recommandationBasse = recommandationBasse;
	}

	public Integer getRecommandationHaute() {
		return this.recommandationHaute;
	}

	public void setRecommandationHaute(Integer recommandationHaute) {
		this.recommandationHaute = recommandationHaute;
	}

	@Override
	public String toString() {
		return "EnregistrementPlanteBddFormulaire [nomCulture=" + this.nomCulture + ", nomPlante=" + this.nomPlante
				+ ", variete=" + this.variete + ", nomLatin=" + this.nomLatin + ", dureeCycle=" + this.dureeCycle
				+ ", recommandationBasse=" + this.recommandationBasse + ", recommandationHaute="
				+ this.recommandationHaute + ", produit=" + this.produit + "]";
	}

}
