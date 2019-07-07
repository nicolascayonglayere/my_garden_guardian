package fr.ncg.mygardenguardian.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationCulturaleDTO {

	private Integer idOperationCulturale;
	private String nom;
	private Date date;
	private String description;
	// private CultureDTO culture;
	private List<MaterielDTO> materiels;
	private String statut;

	public OperationCulturaleDTO() {
	}

	public OperationCulturaleDTO(String nom, Date date, String description, String statut) {
		this.nom = nom;
		this.date = date;
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

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public CultureDTO getCulture() {
//		return this.culture;
//	}
//
//	public void setCulture(CultureDTO culture) {
//		this.culture = culture;
//	}

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

	@Override
	public String toString() {
		return "OperationCulturaleDTO [idOperationCulturale=" + this.idOperationCulturale + ", nom=" + this.nom
				+ ", date=" + this.date + ", description=" + this.description // + ", culture=" + this.culture
				+ ", materiels=" + this.materiels + ", statut=" + this.statut + "]";
	}

}
