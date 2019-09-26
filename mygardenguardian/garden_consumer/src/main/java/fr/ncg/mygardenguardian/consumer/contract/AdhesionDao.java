package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Adhesion;
import fr.ncg.mygardenguardian.entites.Parcelle;
import fr.ncg.mygardenguardian.entites.Utilisateur;

/**
 * Interface JpaRepository requetant la table Adhesion
 * 
 * @author nicolas
 *
 */

@Repository
public interface AdhesionDao extends JpaRepository<Adhesion, Integer> {

	/**
	 * Methode de selection de {@link Adhesion} avec l'id de {@link Utilisateur} et
	 * l'archivage
	 * 
	 * @param idUtilisateur
	 * @param archive
	 * @return {@link Adhesion}
	 */
	@Query("Select a from Adhesion a where a.utilisateur.idUtilisateur = :idUtilisateur AND a.archive = :archive")
	public Adhesion findByIdUtilisateurAndArchive(@Param("idUtilisateur") Integer idUtilisateur,
			@Param("archive") boolean archive);

	/**
	 * Methode de selection de {@link Adhesion} avec le nom de {@link Utilisateur}
	 * 
	 * @param nomUtilisateur
	 * @return {@link Adhesion}
	 */
	@Query("Select a from Adhesion a where a.utilisateur.nom = :nomUtilisateur ")
	public Adhesion findByNomUser(@Param("nomUtilisateur") String nomUtilisateur);

	/**
	 * Methode de selection de {@link Adhesion} avec l'archivage
	 * 
	 * @param archive
	 * @return liste de {@link Adhesion}
	 */
	public List<Adhesion> findByArchive(boolean archive);

	/**
	 * Methode de selection de {@link Adhesion} avec l'id de {@link Parcelle} et
	 * l'archivage
	 * 
	 * @param idParcelle
	 * @param archive
	 * @return {@link Adhesion}
	 */
	public Optional<Adhesion> findByParcelleIdParcelleAndArchive(Integer idParcelle, boolean archive);

}
