package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Culture;

@Repository
public interface CultureDao extends JpaRepository<Culture, Integer> {

	public List<Culture> findByEnConstruction(boolean enConstruction);

	public List<Culture> findByEnConstructionAndUtilisateurIdUtilisateur(boolean enConstruction, Integer idUtilisateur);
}
