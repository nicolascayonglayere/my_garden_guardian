package fr.ncg.mygardenguardian.dto;

import java.util.ArrayList;
import java.util.List;

public class OperationCulturaleDTO {

	private Integer idOperationCulturale;
	private String nom;
	private Integer origIntervPossible;
	private Integer intervallePossible;
	private String description;
	private List<MaterielDTO> materiels;
	private String statut;

	public OperationCulturaleDTO() {
	}

	public OperationCulturaleDTO(Integer idOperationCulturale, String nom, Integer origIntervPossible,
			Integer intervallePossible, String description, String statut) {
		this.idOperationCulturale = idOperationCulturale;
		this.nom = nom;
		this.origIntervPossible = origIntervPossible;
		this.intervallePossible = intervallePossible;
		this.description = description;
		this.statut = statut;
	}

	public Integer getIdOperationCulturale() {
		return this.idOperationCulturale;
	}

	public void setIdOperationCulturale(Integer idOperationCulturale) {
		this.idOperationCulturale = idOperationCulturale;
	}

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

	public List<MaterielDTO> getMateriels() {
		return this.materiels;
	}

	public void setMateriels(List<MaterielDTO> materiels) {
		this.materiels = materiels;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void addMateriel(MaterielDTO mat) {
		if (this.materiels == null) {
			this.materiels = new ArrayList<MaterielDTO>();
		}
		this.materiels.add(mat);
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

	@Override
	public String toString() {
		return "OperationCulturaleDTO [idOperationCulturale=" + this.idOperationCulturale + ", nom=" + this.nom
				+ ", origIntervPossible=" + this.origIntervPossible + ", intervallePossible=" + this.intervallePossible
				+ ", description=" + this.description + ", materiels=" + this.materiels + ", statut=" + this.statut
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.idOperationCulturale == null) ? 0 : this.idOperationCulturale.hashCode());
		result = prime * result + ((this.intervallePossible == null) ? 0 : this.intervallePossible.hashCode());
		result = prime * result + ((this.materiels == null) ? 0 : this.materiels.hashCode());
		result = prime * result + ((this.nom == null) ? 0 : this.nom.hashCode());
		result = prime * result + ((this.origIntervPossible == null) ? 0 : this.origIntervPossible.hashCode());
		result = prime * result + ((this.statut == null) ? 0 : this.statut.hashCode());
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
		OperationCulturaleDTO other = (OperationCulturaleDTO) obj;
		if (this.description == null) {
			if (other.description != null)
				return false;
		} else if (!this.description.equals(other.description))
			return false;
		if (this.idOperationCulturale == null) {
			if (other.idOperationCulturale != null)
				return false;
		} else if (!this.idOperationCulturale.equals(other.idOperationCulturale))
			return false;
		if (this.intervallePossible == null) {
			if (other.intervallePossible != null)
				return false;
		} else if (!this.intervallePossible.equals(other.intervallePossible))
			return false;
		if (this.materiels == null) {
			if (other.materiels != null)
				return false;
		} else if (!this.materiels.equals(other.materiels))
			return false;
		if (this.nom == null) {
			if (other.nom != null)
				return false;
		} else if (!this.nom.equals(other.nom))
			return false;
		if (this.origIntervPossible == null) {
			if (other.origIntervPossible != null)
				return false;
		} else if (!this.origIntervPossible.equals(other.origIntervPossible))
			return false;
		if (this.statut == null) {
			if (other.statut != null)
				return false;
		} else if (!this.statut.equals(other.statut))
			return false;
		return true;
	}

}
