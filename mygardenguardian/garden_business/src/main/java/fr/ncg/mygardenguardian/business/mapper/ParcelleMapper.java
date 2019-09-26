package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.entites.Parcelle;

/**
 * Mapper de {@link Parcelle}
 * 
 * @author nicolas
 *
 */
public class ParcelleMapper {

	/**
	 * Methode depuis {@link Parcelle} vers {@link ParcelleDTO}
	 * 
	 * @param p
	 * @return {@link ParcelleDTO}
	 */
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

	/**
	 * Methode depuis {@link ParcelleDTO} vers {@link Parcelle}
	 * 
	 * @param p
	 * @return {@link Parcelle}
	 */
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
