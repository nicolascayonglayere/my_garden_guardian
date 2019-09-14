package fr.ncg.mygardenguardian.business.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.contract.IEventCalendarManager;
import fr.ncg.mygardenguardian.dto.CultureInstanceDTO;
import fr.ncg.mygardenguardian.dto.EventCalendarDTO;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;

@Service
@Transactional
public class EventCalendarManagerImpl implements IEventCalendarManager {

	private IBusinessManagerFactory managerFactory;
	private int compteur;

	@Override
	public List<EventCalendarDTO> listeCulturesCalendrier(Integer idUtilisateur) {
		Integer idParcelle = this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(idUtilisateur)
				.getParcelleDTO().getIdParcelle();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		List<EventCalendarDTO> monCalPrev = new ArrayList<EventCalendarDTO>();

		this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle).getlisteCultures().stream()
				.forEachOrdered(ci -> {
					String start = dateFormat.format(ci.getDate());
					Calendar monCal = Calendar.getInstance();
					monCal.setTime(ci.getDate());
					monCal.add(Calendar.MONTH, ci.getCulture().getPlante().getDureeCycle());
					Date dateFin = monCal.getTime();
					String end = dateFormat.format(dateFin);

					EventCalendarDTO maCultureAjoutee = new EventCalendarDTO();
					maCultureAjoutee.setId(this.compteur);
					maCultureAjoutee.setTitle(ci.getCulture().getNom());
					maCultureAjoutee.setStart(start);
					maCultureAjoutee.setEnd(end);
					maCultureAjoutee.setAllDay(true);
					maCultureAjoutee.setUrl("/user/culture?idCulture=" + ci.getIdCultureInstance());
					monCalPrev.add(maCultureAjoutee);
					this.compteur++;
				});
		return monCalPrev;
	}

	@Override
	public List<EventCalendarDTO> constructionEventOpeCultCalendar(Integer idUtilisateur, String nomOpeCult) {
		System.out.println("CTRL user --------------- " + idUtilisateur);
		Integer idParcelle = this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(idUtilisateur)
				.getParcelleDTO().getIdParcelle();
		System.out.println("CTRL parcelle--------------- " + idParcelle);
		List<EventCalendarDTO> monSemisPrev = new ArrayList<EventCalendarDTO>();
		this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle).getlisteCultures().stream()
				.forEachOrdered(c -> {
					c.getCulture().getOperationsCulturales().stream()
							.filter(op -> op.getNom().equalsIgnoreCase(nomOpeCult)).forEachOrdered(op -> {
								EventCalendarDTO maCultureAjoutee = new EventCalendarDTO();
								maCultureAjoutee.setTitle(nomOpeCult + " - " + c.getCulture().getPlante().getNom());
								maCultureAjoutee.setAllDay(true);
								maCultureAjoutee.setStart(this.debutOperationCulturale(c, op));
								maCultureAjoutee.setEnd(this.debutOperationCulturale(c, op));
								maCultureAjoutee.setId(this.compteur);
								this.compteur++;
								monSemisPrev.add(maCultureAjoutee);
							});

				});
		return monSemisPrev;
	}

	private String debutOperationCulturale(CultureInstanceDTO culture, OperationCulturaleDTO opeCult) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(culture.getDate());
		cal.add(Calendar.DAY_OF_YEAR, opeCult.getOrigIntervPossible());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFin = cal.getTime();
		String end = dateFormat.format(dateFin);

		return end;
	}

//	private String conversionNumSemaineVersStringDate(Integer numSemaine) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//		sdf.setTimeZone(TimeZone.getTimeZone("CET"));
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.WEEK_OF_YEAR, numSemaine);
//		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//		return sdf.format(cal.getTime());
//	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
