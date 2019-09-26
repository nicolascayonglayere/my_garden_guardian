package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;
import fr.ncg.mygardenguardian.entites.OperationCulturale;

/**
 * Mapper de {@link OperationCulturale}
 * 
 * @author nicolas
 *
 */
public class OperationCulturaleMapper {

	/**
	 * Methode depuis {@link OperationCulturaleDTO} vers {@link OperationCulturale}
	 * 
	 * @param op
	 * @return {@link OperationCulturale}
	 */
	public static OperationCulturale fromOperationCulturaleDtoToOperationCulturale(OperationCulturaleDTO op) {
		OperationCulturale monOp = new OperationCulturale();

		if (op.getIdOperationCulturale() != null) {
			monOp.setIdOperationCulturale(op.getIdOperationCulturale());
		}
		monOp.setOrigIntervPossible(op.getOrigIntervPossible());
		monOp.setIntervallePossible(op.getIntervallePossible());
		monOp.setDescritpion(op.getDescription());
		monOp.setNom(op.getNom());
		monOp.setStatut(op.getStatut());
		// monOp.setCulture(CultureMapper.fromCultureDtoToCulture(op.getCulture()));
		if (op.getMateriels() != null) {
			op.getMateriels().stream().forEach(m -> {
				monOp.addMateriel(MaterielMapper.fromMaterielDtoToMateriel(m));
			});
		}
		return monOp;
	}

	/**
	 * Methode depuis {@link OperationCulturale} vers {@link OperationCulturaleDTO}
	 * 
	 * @param op
	 * @return {@link OperationCulturaleDTO}
	 */
	public static OperationCulturaleDTO fromOperationCulturaleToOperationCulturaleDTO(OperationCulturale op) {
		OperationCulturaleDTO monOp = new OperationCulturaleDTO();

		if (op.getIdOperationCulturale() != null) {
			monOp.setIdOperationCulturale(op.getIdOperationCulturale());
		}
		monOp.setOrigIntervPossible(op.getOrigIntervPossible());
		monOp.setIntervallePossible(op.getIntervallePossible());
		monOp.setDescription(op.getDescritpion());
		monOp.setNom(op.getNom());
		monOp.setStatut(op.getStatut());
		// monOp.setCulture(CultureMapper.fromCultureToCultureDto(op.getCulture()));
		if (op.getMateriels() != null) {
			op.getMateriels().stream().forEach(m -> {
				monOp.addMateriel(MaterielMapper.fromMaterielToMaterielDto(m));
			});
		}
		return monOp;
	}

}
