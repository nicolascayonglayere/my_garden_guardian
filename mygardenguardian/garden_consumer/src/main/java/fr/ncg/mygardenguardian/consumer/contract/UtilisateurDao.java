package fr.ncg.mygardenguardian.consumer.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ncg.mygardenguardian.entites.Utilisateur;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

	public Utilisateur findByNomAndPrenom(String nom, String prenom);
}
