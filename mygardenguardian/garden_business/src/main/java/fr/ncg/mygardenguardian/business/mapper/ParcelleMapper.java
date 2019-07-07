package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.entites.Parcelle;

public class ParcelleMapper {

	public static ParcelleDTO fromParcelleToParcelleDTO(Parcelle p) {
		ParcelleDTO parcelleDTO = new ParcelleDTO();
		if (p.getIdParcelle() != null) {
			parcelleDTO.setIdParcelle(p.getIdParcelle());
		}
		parcelleDTO.setCode(p.getCode());
		parcelleDTO.setSurface(p.getSurface());
		if (p.getCalendrierCultural() != null) {
			p.getCalendrierCultural().stream().forEach(pa -> {
				parcelleDTO.addCultureDto(CultureMapper.fromCultureToCultureDto(pa));
			});
		}
		// parcelleDTO.setOccupation(p.isOccupation());
		return parcelleDTO;
	}

	public static Parcelle fromParcelleDTOToParcelle(ParcelleDTO p) {
		Parcelle maParcelle = new Parcelle();
		if (p.getIdParcelle() != null) {
			maParcelle.setIdParcelle(p.getIdParcelle());
		}
		maParcelle.setCode(p.getCode());
		maParcelle.setSurface(p.getSurface());
		if (p.getCalendrierCultural() != null) {
			p.getCalendrierCultural().stream().forEach(pa -> {
				maParcelle.addCulture(CultureMapper.fromCultureDtoToCulture(pa));
			});
		}
		// maParcelle.setOccupation(p.isOccupation());
		return maParcelle;
	}

}
