package fr.ncg.mygardenguardian.business.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.contract.IEventCalendarManager;
import fr.ncg.mygardenguardian.dto.EventCalendarDTO;

@Service
@Transactional
public class EventCalendarManagerImpl implements IEventCalendarManager {

	private IBusinessManagerFactory managerFactory;
	private int compteur;

	@Override
	public List<EventCalendarDTO> listeCulturesCalendrier(Integer idUtilisateur) {
		Integer idParcelle = this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(idUtilisateur)
				.getParcelleDTO().getIdParcelle();

		List<EventCalendarDTO> monCalPrev = new ArrayList<EventCalendarDTO>();
		IntStream.range(0, this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle)
				.getCalendrierCultural().size()).forEachOrdered(i -> {
					String start = this.conversionNumSemaineVersStringDate(this.managerFactory.getParcelleManager()
							.trouverParcelleParId(idParcelle).getCalendrierCultural().get(i).getCulture()
							.getOperationsCulturales().get(0).getDate());
					String end = this.conversionNumSemaineVersStringDate(this.managerFactory.getParcelleManager()
							.trouverParcelleParId(idParcelle).getCalendrierCultural().get(i).getCulture()
							.getOperationsCulturales()
							.get(this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle)
									.getCalendrierCultural().get(i).getCulture().getOperationsCulturales().size() - 1)
							.getDate());
					EventCalendarDTO maCultureAjoutee = new EventCalendarDTO();
					maCultureAjoutee.setId(i);
					maCultureAjoutee.setTitle(this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle)
							.getCalendrierCultural().get(i).getCulture().getPlante().getNom());
					maCultureAjoutee.setStart(start);
					maCultureAjoutee.setEnd(end);
					maCultureAjoutee.setAllDay(true);
					maCultureAjoutee.setUrl("/culture/culture?idCulture="
							+ this.managerFactory.getParcelleManager().trouverParcelleParId(idParcelle)
									.getCalendrierCultural().get(i).getCulture().getIdCulture());
					monCalPrev.add(maCultureAjoutee);
				});
		return monCalPrev;
	}

	@Override
	public List<EventCalendarDTO> constructionEventOpeCultCalendar(Integer idUtilisateur, String nomOpeCult) {
		int idParcelle = this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(idUtilisateur)
				.getParcelleDTO().getIdParcelle();
		this.compteur = 0;
		List<EventCalendarDTO> monSemisPrev = new ArrayList<EventCalendarDTO>();
		this.getManagerFactory().getParcelleManager().trouverParcelleParId(idParcelle).getCalendrierCultural().stream()
				.forEachOrdered(c -> {
					c.getCulture().getOperationsCulturales().stream()
							.filter(op -> op.getNom().equalsIgnoreCase(nomOpeCult)).forEachOrdered(op -> {
								EventCalendarDTO maCultureAjoutee = new EventCalendarDTO();
								maCultureAjoutee.setTitle(nomOpeCult + " - " + c.getCulture().getPlante().getNom());
								maCultureAjoutee.setAllDay(true);
								maCultureAjoutee.setStart(this.conversionNumSemaineVersStringDate(op.getDate()));
								maCultureAjoutee.setEnd(this.conversionNumSemaineVersStringDate(op.getDate() + 1));
								maCultureAjoutee.setId(this.compteur);
								this.compteur++;
								monSemisPrev.add(maCultureAjoutee);
							});

				});
		return monSemisPrev;
	}

	private String conversionNumSemaineVersStringDate(Integer numSemaine) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		sdf.setTimeZone(TimeZone.getTimeZone("CET"));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, numSemaine);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return sdf.format(cal.getTime());

	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
