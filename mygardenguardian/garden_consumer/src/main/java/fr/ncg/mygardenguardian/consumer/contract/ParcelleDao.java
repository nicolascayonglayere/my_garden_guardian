package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.ncg.mygardenguardian.entites.Parcelle;

public interface ParcelleDao extends JpaRepository<Parcelle, Integer> {

	// @Query("SELECT p FROM Parcelle p LEFT JOIN Adhesion a ON p.idParcelle =
	// a.parcelle.idParcelle WHERE a.archive=:archive OR a.parcelle.idParcelle IS
	// NULL")
	@Query("SELECT p FROM Parcelle p WHERE (SELECT COUNT(a) FROM Adhesion a WHERE a.parcelle.idParcelle = p.idParcelle AND a.archive IS FALSE) = 0 ")
	public List<Parcelle> trouverParcelleVide();

	// public List<Parcelle> findByOccupation(boolean occupation);

	@Override
	public Optional<Parcelle> findById(Integer idParcelle);
}
