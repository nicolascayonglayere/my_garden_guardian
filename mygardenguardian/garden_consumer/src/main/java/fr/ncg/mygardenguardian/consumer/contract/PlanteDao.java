package fr.ncg.mygardenguardian.consumer.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Plante;

/**
 * Interface JpaRepository requetant la table plante
 * 
 * @author nicolas
 *
 */
@Repository
public interface PlanteDao extends JpaRepository<Plante, Integer> {

}
