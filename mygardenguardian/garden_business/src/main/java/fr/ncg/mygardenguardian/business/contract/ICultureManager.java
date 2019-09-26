package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.OperationCulturale;
import fr.ncg.mygardenguardian.entites.Utilisateur;

/**
 * Interface ICultureManager qui gere les {@link Culture}
 * 
 * @author nicolas
 *
 */
public interface ICultureManager {

	/**
	 * Methode pour trouver toutes les {@link Culture}
	 * 
	 * @return liste des {@link CultureDTO}
	 */
	public List<CultureDTO> obtenirToutesLesCultures();

	/**
	 * Methode pour trouver la {@link Culture} a partir de son id
	 * 
	 * @param idCulture
	 * @return {@link CultureDTO}
	 */
	public CultureDTO trouverLaCulture(Integer idCulture);

	/**
	 * Methode pour creer une {@link Culture} avec un {@link Utilisateur} comme
	 * auteur
	 * 
	 * @param culture
	 * @param auteur
	 * @return {@link CultureDTO}
	 */
	public CultureDTO creerCultureBdd(CultureDTO culture, UtilisateurDTO auteur);

	/**
	 * Methode pour trouver les {@link Culture} en construction
	 * 
	 * @return liste des {@link CultureDTO}
	 */
	public List<CultureDTO> obtenirCulturesEnConstruction();

	/**
	 * MEthode pour trouver les {@link Culture} en construction de l'auteur
	 * {@link Utilisateur}
	 * 
	 * @param idUtilisateur
	 * @return liste des {@link CultureDTO}
	 */
	public List<CultureDTO> obtenirCulturesEnConstructionAuteur(Integer idUtilisateur);

	/**
	 * Methode pour creer {@link OperationCulturale} de la {@link Culture}
	 * 
	 * @param culture
	 * @return {@link CultureDTO}
	 */
	public CultureDTO creerOperationCulturaleBdd(CultureDTO culture);

	/**
	 * MEthode pour modifier la {@link Culture}
	 * 
	 * @param culture
	 * @return {@link CultureDTO}
	 */
	public CultureDTO modifierCultureBdd(CultureDTO culture);

}
