package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.CultureInstance;
import fr.ncg.mygardenguardian.entites.Parcelle;

/**
 * Interface JpaRepository requetant la table culture_instance
 * 
 * @author nicolas
 *
 */
@Repository
public interface CultureInstanceDao extends JpaRepository<CultureInstance, Integer> {

	/**
	 * Methode de selection de {@link CultureInstance} avec l'id de {@link Parcelle}
	 * 
	 * @param idParcelle
	 * @return liste de {@link CultureInstance}
	 */
	public List<CultureInstance> findByParcelleIdParcelle(Integer idParcelle);

	/**
	 * Methode de selection de {@link CultureInstance} avec l'id de {@link Culture}
	 * 
	 * @param idCulture
	 * @return liste de {@link CultureInstance}
	 */
	public List<CultureInstance> findByCultureIdCulture(Integer idCulture);

}
