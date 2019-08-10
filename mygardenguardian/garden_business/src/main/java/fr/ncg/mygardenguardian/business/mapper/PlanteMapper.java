package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.PlanteDTO;
import fr.ncg.mygardenguardian.entites.Plante;

public class PlanteMapper {

	public static Plante fromPlanteDtoToPlante(PlanteDTO plante) {
		Plante maPlante = new Plante();
		if (plante.getIdPlante() != null) {
			maPlante.setIdPlante(plante.getIdPlante());
		}
		maPlante.setNom(plante.getNom());
		maPlante.setNomLatin(plante.getNomLatin());
		maPlante.setVariete(plante.getVariete());
		maPlante.setDureeCycle(plante.getDureeCycle());
		maPlante.setProduit(plante.getProduit());
		return maPlante;
	}

	public static PlanteDTO fromPlanteToPlanteDTO(Plante plante) {
		PlanteDTO maPlante = new PlanteDTO();
		maPlante.setIdPlante(plante.getIdPlante());
		maPlante.setNom(plante.getNom());
		maPlante.setNomLatin(plante.getNomLatin());
		maPlante.setVariete(plante.getVariete());
		maPlante.setDureeCycle(plante.getDureeCycle());
		maPlante.setProduit(plante.getProduit());
		return maPlante;
	}

}
