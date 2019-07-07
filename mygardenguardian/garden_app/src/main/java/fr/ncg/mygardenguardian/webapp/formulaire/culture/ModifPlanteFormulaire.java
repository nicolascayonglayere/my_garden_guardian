package fr.ncg.mygardenguardian.webapp.formulaire.culture;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ModifPlanteFormulaire {

	private Integer idCulture;
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
	public Integer getIdCulture() {
		return idCulture;
	}
	public void setIdCulture(Integer idCulture) {
		this.idCulture = idCulture;
	}
	public String getNomPlante() {
		return nomPlante;
	}
	public void setNomPlante(String nomPlante) {
		this.nomPlante = nomPlante;
	}
	public String getVariete() {
		return variete;
	}
	public void setVariete(String variete) {
		this.variete = variete;
	}
	public String getNomLatin() {
		return nomLatin;
	}
	public void setNomLatin(String nomLatin) {
		this.nomLatin = nomLatin;
	}
	public Integer getDureeCycle() {
		return dureeCycle;
	}
	public void setDureeCycle(Integer dureeCycle) {
		this.dureeCycle = dureeCycle;
	}
	public String getProduit() {
		return produit;
	}
	public void setProduit(String produit) {
		this.produit = produit;
	}
	
	
	
}
