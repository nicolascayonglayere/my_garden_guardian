package fr.ncg.mygardenguardian.dto;

public class IntrantDTO {

	private Integer idIntrant;
	private String nom;
	private String reference;
	// private CultureDTO culture;

	public IntrantDTO() {
	}

	public IntrantDTO(String nom, String reference) {
		this.nom = nom;
		this.reference = reference;
	}

	public Integer getIdIntrant() {
		return this.idIntrant;
	}

	public void setIdIntrant(Integer idIntrant) {
		this.idIntrant = idIntrant;
	}

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

//	public CultureDTO getCulture() {
//		return this.culture;
//	}
//
//	public void setCulture(CultureDTO culture) {
//		this.culture = culture;
//	}

	@Override
	public String toString() {
		return "IntrantDTO [idIntrant=" + this.idIntrant + ", nom=" + this.nom + ", reference=" + this.reference + "]";
		// + ", culture=" + this.culture + "]";
	}

}
