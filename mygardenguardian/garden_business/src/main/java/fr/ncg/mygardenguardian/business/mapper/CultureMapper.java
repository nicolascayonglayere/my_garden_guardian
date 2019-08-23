package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.entites.Culture;

public class CultureMapper {

	public static Culture fromCultureDtoToCulture(CultureDTO cultureDTO) {
		Culture maCulture = new Culture();
		if (cultureDTO.getIdCulture() != null) {
			maCulture.setIdCulture(cultureDTO.getIdCulture());
		}
		maCulture.setPlante(PlanteMapper.fromPlanteDtoToPlante(cultureDTO.getPlante()));
		if (cultureDTO.getIntrants() != null) {
			cultureDTO.getIntrants().stream().forEach(i -> {
				maCulture.addIntrant(IntrantMapper.fromIntrantDtoToIntrant(i));
			});
		}
		if (cultureDTO.getOperationsCulturales() != null) {
			cultureDTO.getOperationsCulturales().stream().forEach(op -> {
				maCulture.addOperationCulturale(
						OperationCulturaleMapper.fromOperationCulturaleDtoToOperationCulturale(op));
			});
		}
		maCulture.setEnConstruction(cultureDTO.isEnConstruction());
		maCulture.setNom(cultureDTO.getNom());
		maCulture.setRecommandationBasse(cultureDTO.getRecommandationBasse());
		maCulture.setRecommandationHaute(cultureDTO.getRecommandationHaute());

//		if (cultureDTO.getUtilisateur() != null) {
//			maCulture.setUtilisateur(UtilisateurMapper.fromUtilisateurDTOToUtilisateur(cultureDTO.getUtilisateur()));
//		}
//		if (cultureDTO.getlisteInstances() != null) {
//			cultureDTO.getlisteInstances().stream().forEachOrdered(cal -> maCulture
//					.addCultureInstance(CultureInstanceMapper.fromCultureInstanceDtoToCultureInstance(cal)));
//		}
		return maCulture;
	}

	public static CultureDTO fromCultureToCultureDto(Culture culture) {
		CultureDTO maCultureDTO = new CultureDTO();
		maCultureDTO.setIdCulture(culture.getIdCulture());
		maCultureDTO.setPlante(PlanteMapper.fromPlanteToPlanteDTO(culture.getPlante()));
		if (culture.getIntrants() != null) {
			culture.getIntrants().stream().forEach(i -> {
				maCultureDTO.addIntrant(IntrantMapper.fromIntrantToIntrantDTO(i));
			});
		}
		if (culture.getOperationsCulturales() != null) {
			culture.getOperationsCulturales().stream().forEach(op -> {
				maCultureDTO.addOperationCulturale(
						OperationCulturaleMapper.fromOperationCulturaleToOperationCulturaleDTO(op));
			});
		}

		maCultureDTO.setEnConstruction(culture.isEnConstruction());
		maCultureDTO.setNom(culture.getNom());
		maCultureDTO.setRecommandationBasse(culture.getRecommandationBasse());
		maCultureDTO.setRecommandationHaute(culture.getRecommandationHaute());
//		if (culture.getUtilisateur() != null) {
//			maCultureDTO.setUtilisateur(UtilisateurMapper.fromUtilisateurToUtilisateurDTO(culture.getUtilisateur()));
//		}

//		if (culture.getlisteCulturesInstances() != null) {
//			culture.getlisteCulturesInstances().stream().forEachOrdered(ci -> maCultureDTO
//					.addCultureInstanceDTO(CultureInstanceMapper.fromCultureInstanceToCultureInstanceDTO(ci)));
//		}
		return maCultureDTO;
	}

}
