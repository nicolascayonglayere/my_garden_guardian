package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.Utilisateur;

/**
 * Interface JpaRepository requetant la table culture
 * 
 * @author nicolas
 *
 */
@Repository
public interface CultureDao extends JpaRepository<Culture, Integer> {

	/**
	 * Methode de selection des {@link Culture} en construction
	 * 
	 * @param enConstruction
	 * @return liste de {@link Culture}
	 */
	public List<Culture> findByEnConstruction(boolean enConstruction);

	/**
	 * Methode de selection de {@link Culture} en construction avec l'id de
	 * {@link Utilisateur}
	 * 
	 * @param enConstruction
	 * @param idUtilisateur
	 * @return liste de {@link Culture}
	 */
	public List<Culture> findByEnConstructionAndUtilisateurIdUtilisateur(boolean enConstruction, Integer idUtilisateur);
}
