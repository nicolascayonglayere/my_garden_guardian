package fr.ncg.mygardenguardian.dto;

public class MaterielDTO {

	private Integer idMateriel;
	private String nom;
	private String reference;
	// private OperationCulturaleDTO operationCulturale;

	public MaterielDTO() {
	}

	public MaterielDTO(String nom, String reference) {
		this.nom = nom;
		this.reference = reference;
	}

	public Integer getIdMateriel() {
		return this.idMateriel;
	}

	public void setIdMateriel(Integer idMateriel) {
		this.idMateriel = idMateriel;
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

//	public OperationCulturaleDTO getOperationCulturale() {
//		return this.operationCulturale;
//	}
//
//	public void setOperationCulturale(OperationCulturaleDTO operationCulturale) {
//		this.operationCulturale = operationCulturale;
//	}

	@Override
	public String toString() {
		return "MaterielDTO [idMateriel=" + this.idMateriel + ", nom=" + this.nom + ", reference=" + this.reference
				+ "]";
//				+ ", operationCulturale=" + this.operationCulturale + "]";
	}

}
