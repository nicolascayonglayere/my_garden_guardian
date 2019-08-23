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
//		if (p.getListeCultures() != null) {
//			p.getListeCultures().stream().forEach(pa -> {
//				parcelleDTO.addCultureInstanceDTO(CultureInstanceMapper.fromCultureInstanceToCultureInstanceDTO(pa));
//			});
//		}
		return parcelleDTO;
	}

	public static Parcelle fromParcelleDTOToParcelle(ParcelleDTO p) {
		Parcelle maParcelle = new Parcelle();
		if (p.getIdParcelle() != null) {
			maParcelle.setIdParcelle(p.getIdParcelle());
		}
		maParcelle.setCode(p.getCode());
		maParcelle.setSurface(p.getSurface());
//		if (p.getlisteCultures() != null) {
//			p.getlisteCultures().stream().forEach(pa -> {
//				maParcelle.addCultureInstance(CultureInstanceMapper.fromCultureInstanceDtoToCultureInstance(pa));
//			});
//		}
		return maParcelle;
	}

}
