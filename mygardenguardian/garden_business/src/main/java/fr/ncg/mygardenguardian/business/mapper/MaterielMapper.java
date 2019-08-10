package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.MaterielDTO;
import fr.ncg.mygardenguardian.entites.Materiel;

public class MaterielMapper {

	public static Materiel fromMaterielDtoToMateriel(MaterielDTO materiel) {
		Materiel monMateriel = new Materiel();
		if (materiel.getIdMateriel() != null) {
			monMateriel.setIdMateriel(materiel.getIdMateriel());
		}
		monMateriel.setNom(materiel.getNom());
		monMateriel.setReference(materiel.getReference());
//		monMateriel.setOperationCulturale(OperationCulturaleMapper
//				.fromOperationCulturaleDtoToOperationCulturale(materiel.getOperationCulturale()));
		return monMateriel;
	}

	public static MaterielDTO fromMaterielToMaterielDto(Materiel materiel) {
		MaterielDTO monMateriel = new MaterielDTO();
		if (materiel.getIdMateriel() != null) {
			monMateriel.setIdMateriel(materiel.getIdMateriel());
		}
		monMateriel.setNom(materiel.getNom());
		monMateriel.setReference(materiel.getReference());
//		monMateriel.setOperationCulturale(OperationCulturaleMapper
//				.fromOperationCulturaleToOperationCulturaleDTO(materiel.getOperationCulturale()));
		return monMateriel;
	}

}
