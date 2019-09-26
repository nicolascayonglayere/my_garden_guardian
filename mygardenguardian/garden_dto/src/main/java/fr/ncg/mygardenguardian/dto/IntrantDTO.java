package fr.ncg.mygardenguardian.dto;

/**
 * Data Transfer Object Intrant
 * 
 * @author nicolas
 *
 */
public class IntrantDTO {

	private Integer idIntrant;
	private String nom;
	private String reference;
	private CultureDTO culture;

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

	public CultureDTO getCulture() {
		return this.culture;
	}

	public void setCulture(CultureDTO culture) {
		this.culture = culture;
	}

	@Override
	public String toString() {
		return "IntrantDTO [idIntrant=" + this.idIntrant + ", nom=" + this.nom + ", reference=" + this.reference + "]"
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.idIntrant == null) ? 0 : this.idIntrant.hashCode());
		result = prime * result + ((this.nom == null) ? 0 : this.nom.hashCode());
		result = prime * result + ((this.reference == null) ? 0 : this.reference.hashCode());
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
		IntrantDTO other = (IntrantDTO) obj;
		if (this.idIntrant == null) {
			if (other.idIntrant != null)
				return false;
		} else if (!this.idIntrant.equals(other.idIntrant))
			return false;
		if (this.nom == null) {
			if (other.nom != null)
				return false;
		} else if (!this.nom.equals(other.nom))
			return false;
		if (this.reference == null) {
			if (other.reference != null)
				return false;
		} else if (!this.reference.equals(other.reference))
			return false;
		return true;
	}

}
