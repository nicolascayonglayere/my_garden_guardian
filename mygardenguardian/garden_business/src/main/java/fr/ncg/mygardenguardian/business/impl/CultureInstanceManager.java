package fr.ncg.mygardenguardian.business.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.ICultureInstanceManager;
import fr.ncg.mygardenguardian.business.contract.ICultureManager;
import fr.ncg.mygardenguardian.business.mapper.CultureInstanceMapper;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.dto.CultureInstanceDTO;

@Service
@Transactional
public class CultureInstanceManager implements ICultureInstanceManager {

	// private DaoFactoryImpl daoFacto;
	private IDaoFactory daoFacto;
	// private CultureManager cultureManager;
	private ICultureManager cultureManager;

	@Override
	public CultureInstanceDTO prevoirCulture(CultureInstanceDTO cultureinstanceDTO) {
		System.out.println(this.daoFacto);
		return CultureInstanceMapper.fromCultureInstanceToCultureInstanceDTO(this.daoFacto.getCultureInstanceDao()
				.saveAndFlush(CultureInstanceMapper.fromCultureInstanceDtoToCultureInstance(cultureinstanceDTO)));
	}

	@Override
	public CultureInstanceDTO daterCulture(CultureInstanceDTO cultureInstanceDTO) {
		if (cultureInstanceDTO.getIdCultureInstance() != null) {
			if (this.checkExistence(cultureInstanceDTO.getIdCultureInstance())) {
				return CultureInstanceMapper
						.fromCultureInstanceToCultureInstanceDTO(this.daoFacto.getCultureInstanceDao().saveAndFlush(
								CultureInstanceMapper.fromCultureInstanceDtoToCultureInstance(cultureInstanceDTO)));
			} else {
				throw new RuntimeException("La culture n'existe pas dans le calendrier");
			}
		} else {
			throw new RuntimeException("La culture n'existe pas dans le calendrier");
		}
	}

	@Override
	public CultureInstanceDTO trouverCultureInstance(Integer idCultureInstance) {
		if (this.checkExistence(idCultureInstance)) {
			return CultureInstanceMapper.fromCultureInstanceToCultureInstanceDTO(
					this.daoFacto.getCultureInstanceDao().findById(idCultureInstance).get());
		} else {
			throw new RuntimeException("La culture n'existe pas dans le calendrier.");
		}
	}

	@Override
	public List<CultureInstanceDTO> trouverCultureEnTerre(Integer idParcelle, Date date) {
		return this.daoFacto.getCultureInstanceDao().findByParcelleIdParcelle(idParcelle).stream()
				.filter(ci -> this.anneeCulture(date) == this.anneeCulture(ci.getDate()))
				.map(ci -> CultureInstanceMapper.fromCultureInstanceToCultureInstanceDTO(ci))
				.collect(Collectors.toList());
	}

	@Override
	public List<CultureInstanceDTO> trouverCultureInstanceParCultureId(Integer idCulture) {
		if (this.cultureManager.trouverLaCulture(idCulture) != null) {
			return this.daoFacto.getCultureInstanceDao().findByCultureIdCulture(idCulture).stream()
					.map(ci -> CultureInstanceMapper.fromCultureInstanceToCultureInstanceDTO(ci))
					.collect(Collectors.toList());
		} else {
			throw new RuntimeException("La culture n'existe pas.");
		}
	}

	@Override
	public void supprimerCultureInstance(Integer idCulture) {
		if (this.checkExistence(idCulture)) {
			this.daoFacto.getCultureInstanceDao().deleteById(idCulture);
		} else {
			throw new RuntimeException("La culture n'existe pas dans le calendrier");
		}

	}

	@Override
	public List<CultureInstanceDTO> trouverCultureHorsRecommandation(Integer idParcelle) {
		List<CultureInstanceDTO> culturesHorsRecom = this.daoFacto.getCultureInstanceDao()
				.findByParcelleIdParcelle(idParcelle).stream()
				.filter(ci -> ci.getDate()
						.after(this.conversionNumSemaineVersDate(ci.getCulture().getRecommandationHaute())))
				.map(ci -> CultureInstanceMapper.fromCultureInstanceToCultureInstanceDTO(ci))
				.collect(Collectors.toList());
		culturesHorsRecom.addAll(this.daoFacto.getCultureInstanceDao().findByParcelleIdParcelle(idParcelle).stream()
				.filter(ci -> ci.getDate()
						.before(this.conversionNumSemaineVersDate(ci.getCulture().getRecommandationBasse())))
				.map(ci -> CultureInstanceMapper.fromCultureInstanceToCultureInstanceDTO(ci))
				.collect(Collectors.toList()));
		culturesHorsRecom.sort((d1, d2) -> d1.getDate().compareTo(d2.getDate()));
		return culturesHorsRecom;
	}

	private boolean checkExistence(Integer idCulture) {
		if (this.daoFacto.getCultureInstanceDao().findById(idCulture).isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	private Date conversionNumSemaineVersDate(Integer numSemaine) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, numSemaine);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}

	private int anneeCulture(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

	public ICultureManager getCultureManager() {
		return this.cultureManager;
	}

	@Autowired
	public void setCultureManager(ICultureManager cultureManager) {
		this.cultureManager = cultureManager;
	}

}
