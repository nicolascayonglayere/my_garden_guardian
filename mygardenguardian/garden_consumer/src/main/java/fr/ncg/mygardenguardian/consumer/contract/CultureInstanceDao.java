package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.CultureInstance;

@Repository
public interface CultureInstanceDao extends JpaRepository<CultureInstance, Integer> {

	public List<CultureInstance> findByParcelleIdParcelle(Integer idParcelle);

	public List<CultureInstance> findByCultureIdCulture(Integer idCulture);

}
