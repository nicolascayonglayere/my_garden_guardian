package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.OperationCulturale;

@Repository
public interface OperationCulturaleDao extends JpaRepository<OperationCulturale, Integer> {

	public List<OperationCulturale> findByCultureIdCulture(Integer idCulture);

}
