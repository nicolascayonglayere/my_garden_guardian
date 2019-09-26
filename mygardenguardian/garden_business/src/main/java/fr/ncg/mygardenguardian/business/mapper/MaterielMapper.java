package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.MaterielDTO;
import fr.ncg.mygardenguardian.entites.Materiel;

/**
 * Mapper de {@link Materiel}
 * 
 * @author nicolas
 *
 */
public class MaterielMapper {

	/**
	 * Methode depuis {@link MaterielDTO} vers {@link Materiel}
	 * 
	 * @param materiel
	 * @return {@link Materiel}
	 */
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

	/**
	 * Methode depuis {@link Materiel} vers {@link MaterielDTO}
	 * 
	 * @param materiel
	 * @return {@link MaterielDTO}
	 */
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
