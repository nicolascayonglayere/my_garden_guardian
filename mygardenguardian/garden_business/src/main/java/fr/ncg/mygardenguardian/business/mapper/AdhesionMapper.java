package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.entites.Adhesion;

public class AdhesionMapper {

	public static Adhesion fromAdhesionDTOToAdhesion(AdhesionDTO adhesion) {
		Adhesion adh = new Adhesion();
		if (adhesion.getIdAdhesion() != null) {
			adh.setIdAdhesion(adhesion.getIdAdhesion());
		}
		adh.setDateAdhesion(adhesion.getDateAdhesion());
		adh.setParcelle(ParcelleMapper.fromParcelleDTOToParcelle(adhesion.getParcelleDTO()));
		adh.setUtilisateur(UtilisateurMapper.fromUtilisateurDTOToUtilisateur(adhesion.getUtilisateurDTO()));
		adh.setArchive(adhesion.isArchive());
		if (adhesion.getDateAnnulation() != null) {
			adh.setDateAnnulation(adhesion.getDateAnnulation());
		}
		return adh;
	}

	public static AdhesionDTO fromAdhesionToAdhesionDTO(Adhesion monAdhesion) {
		AdhesionDTO adhDto = new AdhesionDTO();
		if (monAdhesion.getIdAdhesion() != null) {
			adhDto.setIdAdhesion(monAdhesion.getIdAdhesion());
		}
		adhDto.setDateAdhesion(monAdhesion.getDateAdhesion());
		adhDto.setParcelleDTO(ParcelleMapper.fromParcelleToParcelleDTO(monAdhesion.getParcelle()));
		adhDto.setUtilisateurDTO(UtilisateurMapper.fromUtilisateurToUtilisateurDTO(monAdhesion.getUtilisateur()));
		adhDto.setArchive(monAdhesion.isArchive());
		if (monAdhesion.getDateAnnulation() != null) {
			adhDto.setDateAnnulation(monAdhesion.getDateAnnulation());
		}
		return adhDto;
	}

}
