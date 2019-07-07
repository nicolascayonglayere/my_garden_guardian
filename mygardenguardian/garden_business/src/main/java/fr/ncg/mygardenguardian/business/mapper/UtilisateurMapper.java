package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.entites.Utilisateur;

public class UtilisateurMapper {

	public static UtilisateurDTO fromUtilisateurToUtilisateurDTO(Utilisateur utilisateur) {
		UtilisateurDTO userDto = new UtilisateurDTO();
		if (utilisateur.getIdUtilisateur() != null) {
			userDto.setIdUtilisateur(utilisateur.getIdUtilisateur());
		}
		userDto.setNom(utilisateur.getNom());
		userDto.setPrenom(utilisateur.getPrenom());
		userDto.setMdp(utilisateur.getMdp());
		userDto.setRole(utilisateur.getRole());
		userDto.setCoordonneeUtilisateurDTO(
				CoordonneesUtilisateurMapper.fromCoordonneeToCoordonneeDTO(utilisateur.getCoordonneeUtilisateur()));
		if (utilisateur.getCulturesAjoutees() != null) {
			utilisateur.getCulturesAjoutees().stream().map(c -> CultureMapper.fromCultureToCultureDto(c))
					.forEach(c -> userDto.addCulture(c));
		}
		return userDto;
	}

	public static Utilisateur fromUtilisateurDTOToUtilisateur(UtilisateurDTO utilisateurDto) {
		Utilisateur user = new Utilisateur();
		if (utilisateurDto.getIdUtilisateur() != null) {
			user.setIdUtilisateur(utilisateurDto.getIdUtilisateur());
		}
		user.setNom(utilisateurDto.getNom());
		user.setPrenom(utilisateurDto.getPrenom());
		user.setMdp(utilisateurDto.getMdp());
		user.setRole(utilisateurDto.getRole());
		user.setCoordonneeUtilisateur(CoordonneesUtilisateurMapper
				.fromCoordonneeDTOToCoordonnee(utilisateurDto.getCoordonneeUtilisateurDTO()));
		if (utilisateurDto.getCultureAjoutees() != null) {
			utilisateurDto.getCultureAjoutees().stream().map(c -> CultureMapper.fromCultureDtoToCulture(c))
					.forEach(c -> user.addCulture(c));
		}
		return user;
	}
}
