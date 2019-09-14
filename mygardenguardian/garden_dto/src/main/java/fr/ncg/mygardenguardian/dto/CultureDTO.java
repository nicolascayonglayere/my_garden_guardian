package fr.ncg.mygardenguardian.dto;

import java.util.ArrayList;
import java.util.List;

public class CultureDTO {

	private Integer idCulture;
	private String nom;
	private PlanteDTO plante;
	private List<OperationCulturaleDTO> operationsCulturales;
	private List<IntrantDTO> intrants;
	private boolean enConstruction;
	private List<CultureInstanceDTO> listeInstances;
	// private UtilisateurDTO utilisateur;
	private Integer recommandationBasse;
	private Integer recommandationHaute;

	public CultureDTO() {
	}

	public CultureDTO(boolean enConstruction) {
		this.enConstruction = enConstruction;
	}

	public Integer getIdCulture() {
		return this.idCulture;
	}

	public void setIdCulture(Integer idCulture) {
		this.idCulture = idCulture;
	}

	public PlanteDTO getPlante() {
		return this.plante;
	}

	public void setPlante(PlanteDTO plante) {
		this.plante = plante;
	}

	public List<OperationCulturaleDTO> getOperationsCulturales() {
		return this.operationsCulturales;
	}

	public void setOperationsCulturales(List<OperationCulturaleDTO> operationsCulturales) {
		this.operationsCulturales = operationsCulturales;
	}

	public List<IntrantDTO> getIntrants() {
		return this.intrants;
	}

	public void setIntrants(List<IntrantDTO> intrants) {
		this.intrants = intrants;
	}

	public void addIntrant(IntrantDTO i) {
		if (this.intrants == null) {
			this.intrants = new ArrayList<IntrantDTO>();
		}
		this.intrants.add(i);
	}

	public void addOperationCulturale(OperationCulturaleDTO op) {
		if (this.operationsCulturales == null) {
			this.operationsCulturales = new ArrayList<OperationCulturaleDTO>();
		}
		this.operationsCulturales.add(op);
	}

	public boolean isEnConstruction() {
		return this.enConstruction;
	}

	public void setEnConstruction(boolean enConstruction) {
		this.enConstruction = enConstruction;
	}

	public void addCultureInstanceDTO(CultureInstanceDTO cal) {
		if (this.listeInstances == null) {
			this.listeInstances = new ArrayList<CultureInstanceDTO>();
		}
		this.listeInstances.add(cal);
	}

	public List<CultureInstanceDTO> getlisteInstances() {
		return this.listeInstances;
	}

	public void setlisteInstances(List<CultureInstanceDTO> listeInstances) {
		this.listeInstances = listeInstances;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		return "CultureDTO [idCulture=" + this.idCulture + ", nom=" + this.nom + ", plante=" + this.plante
				+ ", operationsCulturales=" + this.operationsCulturales + ", intrants=" + this.intrants
				+ ", enConstruction=" + this.enConstruction + ", listeInstances=" + this.listeInstances
				+ ", recommandationBasse=" + this.recommandationBasse + ", recommandationHaute="
				+ this.recommandationHaute + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.enConstruction ? 1231 : 1237);
		result = prime * result + ((this.idCulture == null) ? 0 : this.idCulture.hashCode());
		result = prime * result + ((this.intrants == null) ? 0 : this.intrants.hashCode());
		result = prime * result + ((this.listeInstances == null) ? 0 : this.listeInstances.hashCode());
		result = prime * result + ((this.nom == null) ? 0 : this.nom.hashCode());
		result = prime * result + ((this.operationsCulturales == null) ? 0 : this.operationsCulturales.hashCode());
		result = prime * result + ((this.plante == null) ? 0 : this.plante.hashCode());
		result = prime * result + ((this.recommandationBasse == null) ? 0 : this.recommandationBasse.hashCode());
		result = prime * result + ((this.recommandationHaute == null) ? 0 : this.recommandationHaute.hashCode());
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
		CultureDTO other = (CultureDTO) obj;
		if (this.enConstruction != other.enConstruction)
			return false;
		if (this.idCulture == null) {
			if (other.idCulture != null)
				return false;
		} else if (!this.idCulture.equals(other.idCulture))
			return false;
		if (this.intrants == null) {
			if (other.intrants != null)
				return false;
		} else if (!this.intrants.equals(other.intrants))
			return false;
		if (this.listeInstances == null) {
			if (other.listeInstances != null)
				return false;
		} else if (!this.listeInstances.equals(other.listeInstances))
			return false;
		if (this.nom == null) {
			if (other.nom != null)
				return false;
		} else if (!this.nom.equals(other.nom))
			return false;
		if (this.operationsCulturales == null) {
			if (other.operationsCulturales != null)
				return false;
		} else if (!this.operationsCulturales.equals(other.operationsCulturales))
			return false;
		if (this.plante == null) {
			if (other.plante != null)
				return false;
		} else if (!this.plante.equals(other.plante))
			return false;
		if (this.recommandationBasse == null) {
			if (other.recommandationBasse != null)
				return false;
		} else if (!this.recommandationBasse.equals(other.recommandationBasse))
			return false;
		if (this.recommandationHaute == null) {
			if (other.recommandationHaute != null)
				return false;
		} else if (!this.recommandationHaute.equals(other.recommandationHaute))
			return false;
		return true;
	}

}
