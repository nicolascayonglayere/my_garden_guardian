package fr.ncg.mygardenguardian.business.mapper;

import fr.ncg.mygardenguardian.dto.CoordonneesUtilisateurDTO;
import fr.ncg.mygardenguardian.entites.CoordonneesUtilisateur;

/**
 * Mapper de {@link CoordonneesUtilisateur}
 * 
 * @author nicolas
 *
 */
public class CoordonneesUtilisateurMapper {

	/**
	 * Methode depuis {@link CoordonneesUtilisateur} vers
	 * {@link CoordonneesUtilisateurDTO}
	 * 
	 * @param coordonneeUtilisateur
	 * @return {@link CoordonneesUtilisateurDTO}
	 */
	public static CoordonneesUtilisateurDTO fromCoordonneeToCoordonneeDTO(
			CoordonneesUtilisateur coordonneeUtilisateur) {
		CoordonneesUtilisateurDTO cuDto = new CoordonneesUtilisateurDTO();
		if (coordonneeUtilisateur.getIdCoordonneesUtilisateur() != null) {
			cuDto.setIdCoordonneesUtilisateur(coordonneeUtilisateur.getIdCoordonneesUtilisateur());
		}
		cuDto.setAdresse(coordonneeUtilisateur.getAdresse());
		cuDto.setCodePostal(coordonneeUtilisateur.getCodePostal());
		cuDto.setEmail(coordonneeUtilisateur.getEmail());
		cuDto.setNumPortable(coordonneeUtilisateur.getNumPortable());
		cuDto.setVille(coordonneeUtilisateur.getVille());
		return cuDto;
	}

	/**
	 * Methode depuis {@link CoordonneesUtilisateurDTO} vers
	 * {@link CoordonneesUtilisateur}
	 * 
	 * @param coordonneeUtilisateur
	 * @return {@link CoordonneesUtilisateur}
	 */
	public static CoordonneesUtilisateur fromCoordonneeDTOToCoordonnee(
			CoordonneesUtilisateurDTO coordonneeUtilisateur) {
		CoordonneesUtilisateur cu = new CoordonneesUtilisateur();
		if (coordonneeUtilisateur.getIdCoordonneesUtilisateur() != null) {
			cu.setIdCoordonneesUtilisateur(coordonneeUtilisateur.getIdCoordonneesUtilisateur());
		}
		cu.setAdresse(coordonneeUtilisateur.getAdresse());
		cu.setCodePostal(coordonneeUtilisateur.getCodePostal());
		cu.setEmail(coordonneeUtilisateur.getEmail());
		cu.setNumPortable(coordonneeUtilisateur.getNumPortable());
		cu.setVille(coordonneeUtilisateur.getVille());
		return cu;
	}

}
