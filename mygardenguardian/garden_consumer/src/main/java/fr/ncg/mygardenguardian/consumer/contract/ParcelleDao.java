package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.ncg.mygardenguardian.entites.Parcelle;

public interface ParcelleDao extends JpaRepository<Parcelle, Integer> {

	@Query("SELECT p FROM Parcelle p LEFT JOIN Adhesion a ON p.idParcelle = a.parcelle.idParcelle WHERE a.parcelle.idParcelle IS NULL")
	public List<Parcelle> trouverParcelleVide();

	@Override
	public Optional<Parcelle> findById(Integer idParcelle);
}
