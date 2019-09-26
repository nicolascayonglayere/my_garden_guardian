package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.entites.Parcelle;

/**
 * Interface IParcelleManager qui gere les {@link Parcelle}
 * 
 * @author nicolas
 *
 */

public interface IParcelleManager {

	/**
	 * Methode pour obtenir la liste des {@link Parcelle} non cultivees
	 * 
	 * @return la liste des {@link ParcelleDTO}
	 */
	public List<ParcelleDTO> trouverToutesParcellesVides();

	/**
	 * Methode pour la liste des {@link Parcelle}
	 * 
	 * @return la liste des {@link ParcelleDTO}
	 */
	public List<ParcelleDTO> trouverToutesParcelles();

	/**
	 * Methode pour trouver la {@link Parcelle} a partir de son id
	 * 
	 * @param idParcelle
	 * @return {@link ParcelleDTO}
	 */
	public ParcelleDTO trouverParcelleParId(int idParcelle);

	/**
	 * Methode pour creer une nouvelle {@link Parcelle}
	 * 
	 * @param parcelle
	 * @return {@link ParcelleDTO}
	 */
	public ParcelleDTO enregistrerParcelle(ParcelleDTO parcelle);
}
