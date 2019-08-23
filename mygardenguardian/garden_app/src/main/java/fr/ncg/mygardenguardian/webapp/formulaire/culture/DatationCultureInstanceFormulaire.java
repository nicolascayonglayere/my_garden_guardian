package fr.ncg.mygardenguardian.webapp.formulaire.culture;

import java.util.Date;
import java.util.Map;

public class DatationCultureInstanceFormulaire {

	Map<Integer, Date> culturesAjoutees;

	public Map<Integer, Date> getCulturesAjoutees() {
		return this.culturesAjoutees;
	}

	public void setCulturesAjoutees(Map<Integer, Date> culturesAjoutees) {
		this.culturesAjoutees = culturesAjoutees;
	}

//	public List<Integer> getCulturesAjoutees() {
//		return this.culturesAjoutees;
//	}
//
//	public void setCulturesAjoutees(List<Integer> culturesAjoutees) {
//		this.culturesAjoutees = culturesAjoutees;
//	}
}
