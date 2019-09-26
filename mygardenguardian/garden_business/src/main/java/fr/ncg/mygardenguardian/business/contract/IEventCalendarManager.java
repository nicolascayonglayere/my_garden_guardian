package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.EventCalendarDTO;
import fr.ncg.mygardenguardian.entites.OperationCulturale;
import fr.ncg.mygardenguardian.entites.Utilisateur;

/**
 * Interface IEventCalendarManager qui gere la construction des evenements
 * affiches dans le calendrier previsionnel des {@link Utilisateur}
 * 
 * @author nicolas
 *
 */
public interface IEventCalendarManager {

	/**
	 * Methode pour construire la liste de {@link EventCalendarDTO} de l
	 * {@link Utilisateur}
	 * 
	 * @param idUtilisateur
	 * @return liste des {@link EventCalendarDTO}
	 */
	List<EventCalendarDTO> listeCulturesCalendrier(Integer idUtilisateur);

	/**
	 * Methode pour construire la liste de {@link EventCalendarDTO} de l
	 * {@link Utilisateur}
	 * 
	 * @param idUtilisateur
	 * @return liste des {@link EventCalendarDTO}
	 */
	List<EventCalendarDTO> listeCulturesCalendrier(String uuidUtilisateur);

	/**
	 * Methode pour construire la liste de {@link EventCalendarDTO} de l
	 * {@link Utilisateur} pour {@link OperationCulturale}
	 * 
	 * @param idUtilisateur
	 * @param nomOpeCult
	 * @return liste des {@link EventCalendarDTO}
	 */
	List<EventCalendarDTO> constructionEventOpeCultCalendar(Integer idUtilisateur, String nomOpeCult);

}
