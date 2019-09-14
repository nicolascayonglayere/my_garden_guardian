package fr.ncg.mygardenguardian.webapp.utils;

public enum OperationsCulturalesTypes {

	Semis("semis"), Plantation("plantation"), Irrigation("irrigation"), Fertilisation("fertilisation"),
	Desherbage("desherbage"), SanteCulture("santé des cultures"), Recolte("recolte"), Taille("taille"),
	Palissage("palissage"), Eclaircissage("eclaircissage"), Paillage("paillage"), Bouturage("bouturage"),
	Greffage("greffage"), Conditionnement("conditionnement"), PreparationSol("preparation du sol"), Binage("binage");

	private String operationCulturaleType;

	OperationsCulturalesTypes(String op) {
		this.operationCulturaleType = op;
	}

	public String getOperationCulturaleType() {
		return this.operationCulturaleType;
	}
}
