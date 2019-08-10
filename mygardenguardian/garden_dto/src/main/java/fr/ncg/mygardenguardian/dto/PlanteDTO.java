package fr.ncg.mygardenguardian.dto;

public class PlanteDTO {

	private Integer idPlante;
	private String nom;
	private String nomLatin;
	private Integer dureeCycle;
	private String produit;
	private String variete;

	public PlanteDTO() {
	}

	public PlanteDTO(String nom, String nomLatin, Integer dureeCycle, String produit, String variete) {
		this.nom = nom;
		this.nomLatin = nomLatin;
		this.dureeCycle = dureeCycle;
		this.produit = produit;
		this.variete = variete;
	}

	public Integer getIdPlante() {
		return this.idPlante;
	}

	public void setIdPlante(Integer idPlante) {
		this.idPlante = idPlante;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		return "PlanteDTO [idPlante=" + this.idPlante + ", nom=" + this.nom + ", nomLatin=" + this.nomLatin
				+ ", dureeCycle=" + this.dureeCycle + ", produit=" + this.produit + ", variete=" + this.variete + "]";
	}

}
