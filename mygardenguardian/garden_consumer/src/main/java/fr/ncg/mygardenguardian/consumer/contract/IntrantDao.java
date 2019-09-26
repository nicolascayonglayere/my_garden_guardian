package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.Intrant;

/**
 * Interface JpaRepository requetant la table intrant
 * 
 * @author nicolas
 *
 */
@Repository
public interface IntrantDao extends JpaRepository<Intrant, Integer> {

	/**
	 * Methode de selection de {@link Intrant} avec l'id de {@link Culture}
	 * 
	 * @param idCulture
	 * @return liste de {@link Culture}
	 */
	public List<Intrant> findByCultureIdCulture(Integer idCulture);

}
