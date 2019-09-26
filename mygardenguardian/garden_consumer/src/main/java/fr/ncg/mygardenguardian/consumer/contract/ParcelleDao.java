package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.ncg.mygardenguardian.entites.Parcelle;

/**
 * Interface JpaRepository requetant la table parcelle
 * 
 * @author nicolas
 *
 */
public interface ParcelleDao extends JpaRepository<Parcelle, Integer> {

	/**
	 * Methode de selection de {@link Parcelle} vides
	 * 
	 * @return liste de {@link Parcelle}
	 */
	@Query("SELECT p FROM Parcelle p WHERE (SELECT COUNT(a) FROM Adhesion a WHERE a.parcelle.idParcelle = p.idParcelle AND a.archive IS FALSE) = 0 ")
	public List<Parcelle> trouverParcelleVide();

	/**
	 * Methode de selection de {@link Parcelle} avec l'id de {@link Parcelle} return
	 * {@link Parcelle}
	 */
	@Override
	public Optional<Parcelle> findById(Integer idParcelle);
}
