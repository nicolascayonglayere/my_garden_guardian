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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.dureeCycle == null) ? 0 : this.dureeCycle.hashCode());
		result = prime * result + ((this.idPlante == null) ? 0 : this.idPlante.hashCode());
		result = prime * result + ((this.nom == null) ? 0 : this.nom.hashCode());
		result = prime * result + ((this.nomLatin == null) ? 0 : this.nomLatin.hashCode());
		result = prime * result + ((this.produit == null) ? 0 : this.produit.hashCode());
		result = prime * result + ((this.variete == null) ? 0 : this.variete.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		PlanteDTO other = (PlanteDTO) obj;
		if (this.dureeCycle == null) {
			if (other.dureeCycle != null)
				return false;
		} else if (!this.dureeCycle.equals(other.dureeCycle))
			return false;
		if (this.idPlante == null) {
			if (other.idPlante != null)
				return false;
		} else if (!this.idPlante.equals(other.idPlante))
			return false;
		if (this.nom == null) {
			if (other.nom != null)
				return false;
		} else if (!this.nom.equals(other.nom))
			return false;
		if (this.nomLatin == null) {
			if (other.nomLatin != null)
				return false;
		} else if (!this.nomLatin.equals(other.nomLatin))
			return false;
		if (this.produit == null) {
			if (other.produit != null)
				return false;
		} else if (!this.produit.equals(other.produit))
			return false;
		if (this.variete == null) {
			if (other.variete != null)
				return false;
		} else if (!this.variete.equals(other.variete))
			return false;
		return true;
	}

}
