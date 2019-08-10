package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.EventCalendarDTO;

public interface IEventCalendarManager {

	List<EventCalendarDTO> listeCulturesCalendrier(Integer idUtilisateur);

	List<EventCalendarDTO> constructionEventOpeCultCalendar(Integer idUtilisateur, String nomOpeCult);

}
