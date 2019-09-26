package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.IntrantDTO;
import fr.ncg.mygardenguardian.entites.Intrant;

/**
 * Mapper de {@link Intrant}
 * 
 * @author nicolas
 *
 */
public class IntrantMapper {

	/**
	 * Methode depuis {@link Intrant} vers {@link IntrantDTO}
	 * 
	 * @param intrant
	 * @return {@link IntrantDTO}
	 */
	public static Intrant fromIntrantDtoToIntrant(IntrantDTO intrant) {
		Intrant monIntrant = new Intrant();
		if (intrant.getIdIntrant() != null) {
			monIntrant.setIdIntrant(intrant.getIdIntrant());
		}
		monIntrant.setNom(intrant.getNom());
		monIntrant.setReference(intrant.getReference());
		// monIntrant.setCulture(CultureMapper.fromCultureDtoToCulture(intrant.getCulture()));
		return monIntrant;
	}

	/**
	 * Methode depuis {@link IntrantDTO} vers {@link Intrant}
	 * 
	 * @param intrant
	 * @return {@link Intrant}
	 */
	public static IntrantDTO fromIntrantToIntrantDTO(Intrant intrant) {
		IntrantDTO monIntrant = new IntrantDTO();
		if (intrant.getIdIntrant() != null) {
			monIntrant.setIdIntrant(intrant.getIdIntrant());
		}
		monIntrant.setNom(intrant.getNom());
		monIntrant.setReference(intrant.getReference());
		// monIntrant.setCulture(CultureMapper.fromCultureToCultureDto(intrant.getCulture()));
		return monIntrant;
	}

}
