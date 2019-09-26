package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Adhesion;
import fr.ncg.mygardenguardian.entites.Utilisateur;

/**
 * Interface JpaRepository requetant la table utilisateur
 * 
 * @author nicolas
 *
 */
@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

	/**
	 * Methode de selection de {@link Utilisateur} avec son nom et son prenom
	 * 
	 * @param nom
	 * @param prenom
	 * @return {@link Utilisateur}
	 */
	public Optional<Utilisateur> findByNomAndPrenom(String nom, String prenom);

	/**
	 * Methode de selection de {@link Utilisateur} avec le role et l'archivage de l
	 * {@link Adhesion}
	 * 
	 * @param role
	 * @param archive
	 * @return liste {@link Utilisateur}
	 */
	@Query("SELECT u FROM Utilisateur u JOIN Adhesion a ON u.idUtilisateur = a.utilisateur.idUtilisateur WHERE u.role=:role AND a.archive=:archive")
	public List<Utilisateur> findGardeners(@Param(value = "role") String role,
			@Param(value = "archive") boolean archive);

	/**
	 * Methode de selection de {@link Utilisateur} avec son nom et son mot de passe
	 * 
	 * @param nom
	 * @param mdp
	 * @return {@link Utilisateur}
	 */
	public Optional<Utilisateur> findByNomAndMdp(String nom, String mdp);

	/**
	 * Methode de selection de {@link Utilisateur} avec son nom
	 * 
	 * @param nom
	 * @return {@link Utilisateur}
	 */
	public Optional<Utilisateur> findByNom(String nom);

	/**
	 * Methode de selection de {@link Utilisateur} avec son email
	 * 
	 * @param email
	 * @return {@link Utilisateur}
	 */
	@Query("SELECT u FROM Utilisateur u JOIN CoordonneesUtilisateur cu ON u.coordonneeUtilisateur.idCoordonneesUtilisateur = cu.idCoordonneesUtilisateur "
			+ "WHERE u.coordonneeUtilisateur.email = :email")
	public Optional<Utilisateur> findByEmail(@Param(value = "email") String email);

	/**
	 * Methode de selection de {@link Utilisateur} avec son uuid
	 * 
	 * @param uuid
	 * @return {@link Utilisateur}
	 */
	public Optional<Utilisateur> findByUuid(String uuid);
}
