package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;

public interface ICultureManager {

	public List<CultureDTO> obtenirToutesLesCultures();

	public CultureDTO trouverLaCulture(Integer idCulture);

	public CultureDTO creerCultureBdd(CultureDTO culture, UtilisateurDTO auteur);

	public List<CultureDTO> obtenirCulturesEnConstruction();

	public List<CultureDTO> obtenirCulturesEnConstructionAuteur(Integer idUtilisateur);

	public CultureDTO creerOperationCulturaleBdd(CultureDTO culture);

	public CultureDTO modifierCultureBdd(CultureDTO culture);

}
