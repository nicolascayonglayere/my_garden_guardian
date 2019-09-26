package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.entites.Utilisateur;

/**
 * Interface IUtilisateurManager qui gere les {@link Utilisateur}
 * 
 * @author nicolas
 *
 */
public interface IUtilisateurManager {

	/**
	 * Methode pour creer un {@link Utilisateur}
	 * 
	 * @param utilisateur
	 * @return {@link UtilisateurDTO}
	 */
	public UtilisateurDTO inscriptionUtilisateur(UtilisateurDTO utilisateur);

	/**
	 * Methode pour trouver tous les {@link Utilisateur} de role jardinier
	 * 
	 * @return liste des {@link UtilisateurDTO}
	 */
	public List<UtilisateurDTO> trouverJardiniers();

	/**
	 * Methode pour supprimer un {@link Utilisateur}
	 * 
	 * @param utilisateur
	 */
	public void supprimerUtilisateur(UtilisateurDTO utilisateur);

	/**
	 * Methode pour trouver un {@link Utilisateur} a partir de son id
	 * 
	 * @param idUtilisateur
	 * @return{@link UtilisateurDTO}
	 */
	public UtilisateurDTO trouverUtilisateurParId(Integer idUtilisateur);

	/**
	 * Methode pour trouver un {@link Utilisateur} a partir de son uuid
	 * 
	 * @param uuidUtilisateur
	 * @return {@link UtilisateurDTO}
	 */
	public UtilisateurDTO trouverUtilisateurParUuid(String uuidUtilisateur);

	/**
	 * Methode pour verifier l'existence d'un {@link Utilisateur}
	 * 
	 * @param utilisateur
	 * @return true or false
	 */
	public boolean verifExistenceUtilisateur(UtilisateurDTO utilisateur);

	/**
	 * Methode pour trouver un {@link Utilisateur} a partir de son nom
	 * 
	 * @param nom
	 * @return {@link UtilisateurDTO}
	 */
	public UtilisateurDTO trouverUtilisateurParNom(String nom);

	/**
	 * methode pour modifier u{@link Utilisateur}
	 * 
	 * @param utilisateur
	 * @return {@link UtilisateurDTO}
	 */
	public UtilisateurDTO modifierProfil(UtilisateurDTO utilisateur);

}
