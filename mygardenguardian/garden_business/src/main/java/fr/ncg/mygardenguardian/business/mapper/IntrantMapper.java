package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.IntrantDTO;
import fr.ncg.mygardenguardian.entites.Intrant;

public class IntrantMapper {

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
