package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Intrant;

@Repository
public interface IntrantDao extends JpaRepository<Intrant, Integer> {

	public List<Intrant> findByCultureIdCulture(Integer idCulture);

}
