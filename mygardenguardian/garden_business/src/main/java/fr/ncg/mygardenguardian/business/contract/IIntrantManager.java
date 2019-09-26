package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.IntrantDTO;
import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.Intrant;

/**
 * Interface IIntrantManager qui gere les {@link Intrant}
 * 
 * @author nicolas
 *
 */
public interface IIntrantManager {

	/**
	 * Methode pour creer un {@link Intrant}
	 * 
	 * @param culture
	 * @return {@link IntrantDTO}
	 */
	public IntrantDTO creerIntrantBdd(CultureDTO culture);

	/**
	 * Methode pour modifier une {@link Intrant}
	 * 
	 * @param intrant
	 * @param culture
	 * @return {@link IntrantDTO}
	 */
	public IntrantDTO modifierIntrantBdd(IntrantDTO intrant, CultureDTO culture);

	/**
	 * Methode pour trouver l {@link Intrant} a partir de l'id
	 * 
	 * @param IdIntrant
	 * @return {@link IntrantDTO}
	 */
	public IntrantDTO obtenirIntrant(Integer IdIntrant);

	/**
	 * Methode pour obtenir la liste des noms des {@link Intrant}
	 * 
	 * @return liste de String
	 */
	public List<String> obtenirNomsIntrants();

	/**
	 * Methode pour obtenir la liste des {@link Intrant} de la {@link Culture}
	 * 
	 * @param idCulture
	 * @return liste des {@link IntrantDTO}
	 */
	public List<IntrantDTO> obtenirIntrantsCultureId(Integer idCulture);
}
