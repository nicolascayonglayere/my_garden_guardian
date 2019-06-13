package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.entites.Utilisateur;

public interface IUtilisateurManager {

	public Utilisateur inscriptionUtilisateur(Utilisateur utilisateur);

	public List<Utilisateur> trouverJardiniers();

}
