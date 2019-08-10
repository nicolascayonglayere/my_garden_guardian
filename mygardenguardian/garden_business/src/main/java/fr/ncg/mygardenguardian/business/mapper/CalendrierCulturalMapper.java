package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.CalendrierCulturalDTO;
import fr.ncg.mygardenguardian.entites.CalendrierCultural;

public class CalendrierCulturalMapper {

	public static CalendrierCultural fromCalendrierCulturalDtoToCalendrierCultural(CalendrierCulturalDTO cal) {
		// IBusinessManagerFactory managerFactory = new BusinessManagerFactoryImpl();
		CalendrierCultural monCal = new CalendrierCultural();
		monCal.setIdCulture(cal.getIdCulture());
		monCal.setIdParcelle(cal.getIdParcelle());
		monCal.setDate(cal.getDate());
		monCal.setCulture(CultureMapper.fromCultureDtoToCulture(cal.getCulture()));
//		monCal.setParcelle(ParcelleMapper.fromParcelleDTOToParcelle(
//				managerFactory.getParcelleManager().trouverParcelleParId(cal.getIdParcelle())));
		return monCal;
	}

	public static CalendrierCulturalDTO fromCalendrierCulturalToCalendrierCulturalDTO(CalendrierCultural cal) {
		CalendrierCulturalDTO monCal = new CalendrierCulturalDTO();
		monCal.setIdCulture(cal.getIdCulture());
		monCal.setIdParcelle(cal.getIdParcelle());
		monCal.setDate(cal.getDate());
		monCal.setCulture(CultureMapper.fromCultureToCultureDto(cal.getCulture()));// CalendrierCulturalMapper.managerFactory.trouverLaCulture(cal.getIdCulture()));
		// monCal.setParcelle(managerFactory.getParcelleManager().trouverParcelleParId(cal.getIdParcelle()));
		return monCal;
	}

}
