package fr.ncg.mygardenguardian.dto;

import java.util.ArrayList;
import java.util.List;

public class CultureDTO {

	private Integer idCulture;
	private PlanteDTO plante;
	private List<OperationCulturaleDTO> operationsCulturales;
	private List<IntrantDTO> intrants;
	private boolean enConstruction;
	private List<CalendrierCulturalDTO> listeParcelles;
	// private UtilisateurDTO utilisateur;

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

	public void addParcelleDTO(CalendrierCulturalDTO cal) {
		if (this.listeParcelles == null) {
			this.listeParcelles = new ArrayList<CalendrierCulturalDTO>();
		}
		this.listeParcelles.add(cal);
	}

	public List<CalendrierCulturalDTO> getListeParcelles() {
		return this.listeParcelles;
	}

	public void setListeParcelles(List<CalendrierCulturalDTO> listeParcelles) {
		this.listeParcelles = listeParcelles;
	}

	@Override
	public String toString() {
		return "CultureDTO [idCulture=" + this.idCulture + ", plante=" + this.plante + ", operationsCulturales="
				+ this.operationsCulturales + ", intrants=" + this.intrants + ", enConstruction=" + this.enConstruction
				+ ", listeParcelles=" + this.listeParcelles + "]";
	}

}
