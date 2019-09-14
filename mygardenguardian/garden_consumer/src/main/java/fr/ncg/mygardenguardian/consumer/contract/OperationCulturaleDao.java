package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.OperationCulturale;

/**
 * Interface JpaRepository requetant la table operation_culturale
 * 
 * @author nicolas
 *
 */
@Repository
public interface OperationCulturaleDao extends JpaRepository<OperationCulturale, Integer> {

	/**
	 * Methode de selection de {@link OperationCulturale} avec l'id de
	 * {@link Culture}
	 * 
	 * @param idCulture
	 * @return liste de {@link OperationCulturale}
	 */
	public List<OperationCulturale> findByCultureIdCulture(Integer idCulture);

}
