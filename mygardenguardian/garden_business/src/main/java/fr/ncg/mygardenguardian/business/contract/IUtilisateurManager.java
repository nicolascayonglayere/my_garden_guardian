package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.UtilisateurDTO;

public interface IUtilisateurManager {

	public UtilisateurDTO inscriptionUtilisateur(UtilisateurDTO utilisateur);

	public List<UtilisateurDTO> trouverJardiniers();

	public void supprimerUtilisateur(UtilisateurDTO utilisateur);

	public UtilisateurDTO trouverUtilisateurParId(Integer idUtilisateur);

	public UtilisateurDTO trouverUtilisateurParUuid(String uuidUtilisateur);

	public boolean verifExistenceUtilisateur(UtilisateurDTO utilisateur);

	public UtilisateurDTO trouverUtilisateurParNom(String nom);

	public UtilisateurDTO modifierProfil(UtilisateurDTO utilisateur);

}
