package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.UtilisateurDTO;

public interface IUtilisateurManager {

	public UtilisateurDTO inscriptionUtilisateur(UtilisateurDTO utilisateur);

	public List<UtilisateurDTO> trouverJardiniers();

}
