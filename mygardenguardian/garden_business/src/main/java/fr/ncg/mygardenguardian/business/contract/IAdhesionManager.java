package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;

public interface IAdhesionManager {

	public AdhesionDTO renouvellementAdhesion(AdhesionDTO adhesionDTO) throws RuntimeException;

	public AdhesionDTO nouvelleInscription(AdhesionDTO adhesionDTO) throws RuntimeException;

	public void annulerAdhesion(AdhesionDTO adhesionDTO) throws RuntimeException;

	public AdhesionDTO trouverAdhesionUtilisateur(UtilisateurDTO utilisateurDTO);

	public List<AdhesionDTO> trouverJardiniers();

	public AdhesionDTO trouverParId(Integer idAdhesion);

}
