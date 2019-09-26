package fr.ncg.mygardenguardian.business.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.contract.IEventCalendarManager;
import fr.ncg.mygardenguardian.business.contract.IExportCalendrier;
import fr.ncg.mygardenguardian.dto.EventCalendarDTO;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.RandomUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;

@Service
@Transactional
public class ExportCalendrier implements IExportCalendrier {

	private IEventCalendarManager evenementManager;
	private IBusinessManagerFactory manager;

	private String chemin;

	@Override
	public Path exportCalendrier(String uuidUtilisateur) throws FileNotFoundException, IOException {
		Path chemExport = Paths.get(this.chemin + File.separator + uuidUtilisateur + ".ics");
		try (FileOutputStream fout = new FileOutputStream(chemExport.toString())) {
			CalendarOutputter outputter = new CalendarOutputter();
			outputter.output(this.generationCalendar(this.evenementManager.listeCulturesCalendrier(uuidUtilisateur)),
					fout);
		}

		return chemExport;
	}

	private Calendar generationCalendar(List<EventCalendarDTO> calendrier) {
		Calendar calendar = new Calendar();
		calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(CalScale.GREGORIAN);
		calendrier.stream().forEachOrdered(e -> {
			try {
				calendar.getComponents().add(this.generationEvenement(e));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		});
		return calendar;
	}

	private VEvent generationEvenement(EventCalendarDTO evenement) throws ParseException {
		DateTime start = new DateTime(evenement.getStart().replaceAll("-", "") + "T000000");
		DateTime end = new DateTime(evenement.getEnd().replaceAll("-", "") + "T000000");
		VEvent monEvent = new VEvent(start, end, evenement.getTitle());
		UidGenerator ug = new RandomUidGenerator();
		Uid uid = ug.generateUid();
		monEvent.getProperties().add(uid);
		return monEvent;
	}

	public IEventCalendarManager getEvenementManager() {
		return this.evenementManager;
	}

	@Autowired
	public void setEvenementManager(IEventCalendarManager evenementManager) {
		this.evenementManager = evenementManager;
	}

	public IBusinessManagerFactory getManager() {
		return this.manager;
	}

	@Autowired
	public void setManager(IBusinessManagerFactory manager) {
		this.manager = manager;
	}

	public String getChemin() {
		return this.chemin;
	}

	@Value(value = "${chemin.temp}")
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

}
