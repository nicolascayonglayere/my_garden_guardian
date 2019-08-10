package fr.ncg.mygardenguardian.consumer.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Materiel;

@Repository
public interface MaterielDao extends JpaRepository<Materiel, Integer> {

}
