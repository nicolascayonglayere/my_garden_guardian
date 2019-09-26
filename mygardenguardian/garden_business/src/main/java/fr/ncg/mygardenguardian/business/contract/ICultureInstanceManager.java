package fr.ncg.mygardenguardian.business.contract;

import java.util.Date;
import java.util.List;

import fr.ncg.mygardenguardian.dto.CultureInstanceDTO;
import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.CultureInstance;
import fr.ncg.mygardenguardian.entites.Parcelle;

/**
 * Interface ICultureInstanceManager qui gere les {@link CultureInstance}
 * 
 * @author nicolas
 *
 */
public interface ICultureInstanceManager {

	/**
	 * Methode pour creer une {@link CultureInstance} a partir d'une
	 * {@link CultureInstanceDTO}
	 * 
	 * @param cultureInstanceDTO
	 * @return {@link CultureInstanceDTO}
	 */
	public CultureInstanceDTO prevoirCulture(CultureInstanceDTO cultureInstanceDTO);

	/**
	 * Methode pour modifier une {@link CultureInstance}
	 * 
	 * @param cultureInstanceDTO
	 * @return {@link CultureInstanceDTO}
	 */
	public CultureInstanceDTO daterCulture(CultureInstanceDTO cultureInstanceDTO);

	/**
	 * Methode pour trouve la {@link CultureInstance} a partir de son id
	 * 
	 * @param idCultureInstance
	 * @return {@link CultureInstanceDTO}
	 */
	public CultureInstanceDTO trouverCultureInstance(Integer idCultureInstance);

	/**
	 * Methode pour trouver la liste des {@link CultureInstance} à partir de l'id de
	 * la {@link Culture}
	 * 
	 * @param idCulture
	 * @return liste de {@link CultureInstanceDTO}
	 */
	public List<CultureInstanceDTO> trouverCultureInstanceParCultureId(Integer idCulture);

	/**
	 * Methode pour trouver la liste des {@link CultureInstance} sur une
	 * {@link Parcelle} a la date
	 * 
	 * @param idParcelle
	 * @param date
	 * @return liste des {@link CultureInstanceDTO}
	 */
	public List<CultureInstanceDTO> trouverCultureEnTerre(Integer idParcelle, Date date);

	/**
	 * Methode pour trouver la liste des {@link CultureInstance} hors recommandation
	 * sur une parcelle
	 * 
	 * @param idParcelle
	 * @return la liste des {@link CultureInstanceDTO}
	 */
	public List<CultureInstanceDTO> trouverCultureHorsRecommandation(Integer idParcelle);

	/**
	 * Methode pour supprimer la {@link CultureInstance}
	 * 
	 * @param idCulture
	 */
	public void supprimerCultureInstance(Integer idCulture);

}
