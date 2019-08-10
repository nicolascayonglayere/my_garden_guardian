package fr.ncg.mygardenguardian.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.IIntrantManager;
import fr.ncg.mygardenguardian.business.mapper.CultureMapper;
import fr.ncg.mygardenguardian.business.mapper.IntrantMapper;
import fr.ncg.mygardenguardian.consumer.DaoFactoryImpl;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.IntrantDTO;
import fr.ncg.mygardenguardian.entites.Intrant;

@Service
@Transactional
public class IntrantManagerImpl implements IIntrantManager {

	private DaoFactoryImpl daoFacto;

	@Override
	public IntrantDTO creerIntrantBdd(CultureDTO culture) {
		// --TODO verif existance intrant
		Intrant monIntrant = IntrantMapper.fromIntrantDtoToIntrant(culture.getIntrants().get(0));
		monIntrant.setCulture(CultureMapper.fromCultureDtoToCulture(culture));
		return IntrantMapper.fromIntrantToIntrantDTO(this.daoFacto.getIntrantDao().saveAndFlush(monIntrant));
	}

	@Override
	public List<String> obtenirNomsIntrants() {
		List<String> nomsIntrants = new ArrayList<String>();
		this.daoFacto.getIntrantDao().findAll().stream().forEachOrdered(op -> {
			if (!nomsIntrants.contains(op.getNom().trim())) {
				nomsIntrants.add(op.getNom());
			}
		});
		Collections.sort(nomsIntrants);
		return nomsIntrants;
	}

	public DaoFactoryImpl getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(DaoFactoryImpl daoFacto) {
		this.daoFacto = daoFacto;
	}

}