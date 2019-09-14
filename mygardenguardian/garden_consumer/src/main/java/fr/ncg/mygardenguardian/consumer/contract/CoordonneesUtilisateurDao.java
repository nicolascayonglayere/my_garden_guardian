package fr.ncg.mygardenguardian.consumer.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.CoordonneesUtilisateur;

/**
 * Interface JpaRepository requetant la table coordonnees_utilisateur
 * 
 * @author nicolas
 *
 */

@Repository
public interface CoordonneesUtilisateurDao extends JpaRepository<CoordonneesUtilisateur, Integer> {

}
