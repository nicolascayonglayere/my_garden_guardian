package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.CultureInstanceDTO;
import fr.ncg.mygardenguardian.entites.CultureInstance;

/**
 * Mapper de {@link CultureInstance}
 * 
 * @author nicolas
 *
 */
public class CultureInstanceMapper {

	/**
	 * Methode depuis {@link CultureInstanceDTO} vers {@link CultureInstance}
	 * 
	 * @param cal
	 * @return {@link CultureInstance}
	 */
	public static CultureInstance fromCultureInstanceDtoToCultureInstance(CultureInstanceDTO cal) {
		CultureInstance monCal = new CultureInstance();
		if (cal.getIdCultureInstance() != null) {
			monCal.setIdCultureInstance(cal.getIdCultureInstance());
		}
		monCal.setParcelle(ParcelleMapper.fromParcelleDTOToParcelle(cal.getParcelle()));
		monCal.setDate(cal.getDate());
		monCal.setCulture(CultureMapper.fromCultureDtoToCulture(cal.getCulture()));
		return monCal;
	}

	/**
	 * Methode depuis {@link CultureInstance} vers {@link CultureInstanceDTO}
	 * 
	 * @param cal
	 * @return {@link CultureInstanceDTO}
	 */
	public static CultureInstanceDTO fromCultureInstanceToCultureInstanceDTO(CultureInstance cal) {
		CultureInstanceDTO monCal = new CultureInstanceDTO();
		if (cal.getIdCultureInstance() != null) {
			monCal.setIdCultureInstance(cal.getIdCultureInstance());
		}
		monCal.setParcelle(ParcelleMapper.fromParcelleToParcelleDTO(cal.getParcelle()));
		monCal.setDate(cal.getDate());
		monCal.setCulture(CultureMapper.fromCultureToCultureDto(cal.getCulture()));
		return monCal;
	}

}
