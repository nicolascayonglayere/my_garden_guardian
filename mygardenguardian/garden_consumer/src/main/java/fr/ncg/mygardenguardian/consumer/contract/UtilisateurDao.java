package fr.ncg.mygardenguardian.consumer.contract;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Utilisateur;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

	public Optional<Utilisateur> findByNomAndPrenom(String nom, String prenom);

	@Query("SELECT u FROM Utilisateur u JOIN Adhesion a ON u.idUtilisateur = a.utilisateur.idUtilisateur WHERE u.role=:role AND a.archive=:archive")
	public List<Utilisateur> findGardeners(@Param(value = "role") String role,
			@Param(value = "archive") boolean archive);

	public Optional<Utilisateur> findByNomAndMdp(String nom, String mdp);

	public Optional<Utilisateur> findByNom(String nom);

	@Query("SELECT u FROM Utilisateur u JOIN CoordonneesUtilisateur cu ON u.coordonneeUtilisateur.idCoordonneesUtilisateur = cu.idCoordonneesUtilisateur "
			+ "WHERE u.coordonneeUtilisateur.email = :email")
	public Optional<Utilisateur> findByEmail(@Param(value = "email") String email);
}
