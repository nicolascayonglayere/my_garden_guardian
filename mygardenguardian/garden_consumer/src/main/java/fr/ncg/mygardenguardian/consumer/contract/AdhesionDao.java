package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Adhesion;

@Repository
public interface AdhesionDao extends JpaRepository<Adhesion, Integer> {

	@Query("Select a from Adhesion a where a.utilisateur.idUtilisateur = :idUtilisateur AND a.archive = :archive")
	public Adhesion findByIdUtilisateurAndArchive(@Param("idUtilisateur") Integer idUtilisateur,
			@Param("archive") boolean archive);

	public List<Adhesion> findByArchive(boolean archive);

}
