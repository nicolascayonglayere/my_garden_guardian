package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.entites.Adhesion;
import fr.ncg.mygardenguardian.entites.Parcelle;
import fr.ncg.mygardenguardian.entites.Utilisateur;

/**
 * Interface IAdhesionManger qui va gérer les adhésions des jardiniers
 * 
 * @author nicolas
 *
 */
public interface IAdhesionManager {

	/**
	 * Méthode pour renouveler une {@link Adhesion}
	 * 
	 * @param adhesionDTO
	 * @return {@link AdhesionDTO}
	 * @throws RuntimeException
	 */
	public AdhesionDTO renouvellementAdhesion(AdhesionDTO adhesionDTO) throws RuntimeException;

	/**
	 * Methode pour creer une {@link Adhesion}
	 * 
	 * @param adhesionDTO
	 * @return {@link AdhesionDTO}
	 * @throws RuntimeException
	 */
	public AdhesionDTO nouvelleInscription(AdhesionDTO adhesionDTO) throws RuntimeException;

	/**
	 * Methode pour annuler une {@link Adhesion}
	 * 
	 * @param adhesionDTO
	 * @throws RuntimeException
	 */
	public void annulerAdhesion(AdhesionDTO adhesionDTO) throws RuntimeException;

	/**
	 * Methode pour trouver une {@link Adhesion} d'un {@link Utilisateur}
	 * 
	 * @param utilisateurDTO
	 * @return {@link AdhesionDTO}
	 */
	public AdhesionDTO trouverAdhesionUtilisateur(UtilisateurDTO utilisateurDTO);

	/**
	 * Methode pour trouver une {@link Adhesion} a partir du nom d'un
	 * {@link Utilisateur}
	 * 
	 * @param nomUtilisateur
	 * @return {@link AdhesionDTO}
	 */
	public AdhesionDTO trouverAdhesionNomUtilisateur(String nomUtilisateur);

	/**
	 * Methode pour trouver une {@link Adhesion } a partir de l'id d'un
	 * {@link Utilisateur}
	 * 
	 * @param idUtilisateur
	 * @return {@link AdhesionDTO}
	 */
	public AdhesionDTO trouverAdhesionIdUtilisateur(Integer idUtilisateur);

	/**
	 * Methode pour trouver une {@link Adhesion} a partir de l'id d'une
	 * {@link Parcelle}
	 * 
	 * @param idParcelle
	 * @return {@link AdhesionDTO}
	 */
	public AdhesionDTO trouverAdhesionIdParcelle(Integer idParcelle);

	/**
	 * Methode pour trouver tous les jardiniers
	 * 
	 * @return liste de {@link AdhesionDTO}
	 */
	public List<AdhesionDTO> trouverJardiniers();

	/**
	 * Methode pour trouver une {@link Adhesion} a partir de son id
	 * 
	 * @param idAdhesion
	 * @return {@link AdhesionDTO}
	 */
	public AdhesionDTO trouverParId(Integer idAdhesion);

}
