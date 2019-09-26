package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;
import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.OperationCulturale;

/**
 * Interface IOperationCulturaleManager qui gere les {@link OperationCulturale}
 * 
 * @author nicolas
 *
 */
public interface IOperationCulturaleManager {

	/**
	 * Methode pour modifier une {@link OperationCulturale}
	 * 
	 * @param culture
	 * @param operationCulturale
	 * @return {@link OperationCulturaleDTO}
	 */
	public OperationCulturaleDTO modifierOperationCulturaleBdd(CultureDTO culture,
			OperationCulturaleDTO operationCulturale);

	/**
	 * Methode pour obtenir la {@link OperationCulturale} a partir de son id
	 * 
	 * @param idOperationCulturale
	 * @return {@link OperationCulturaleDTO}
	 */
	public OperationCulturaleDTO obtenirOperationCulturaleParId(Integer idOperationCulturale);

	/**
	 * Methode pour obtenir la liste des {@link OperationCulturale} de la
	 * {@link Culture}
	 * 
	 * @param idCulture
	 * @return liste de {@link OperationCulturaleDTO}
	 */
	public List<OperationCulturaleDTO> obtenirOperationsCulturalesParCulture(Integer idCulture);

	/**
	 * Methode pour obtenir la liste des noms des {@link OperationCulturale}
	 * 
	 * @return la liste des noms des {@link OperationCulturaleDTO}
	 */
	public List<String> obtenirNomsOperationCulturale();
}
