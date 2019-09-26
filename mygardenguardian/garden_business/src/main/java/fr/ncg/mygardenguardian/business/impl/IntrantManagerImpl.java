package fr.ncg.mygardenguardian.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

		Intrant monIntrant = IntrantMapper.fromIntrantDtoToIntrant(culture.getIntrants().stream()
				.filter(i -> i.getIdIntrant() == null).collect(Collectors.toList()).get(0));
		monIntrant.setCulture(CultureMapper.fromCultureDtoToCulture(culture));
		return IntrantMapper.fromIntrantToIntrantDTO(this.daoFacto.getIntrantDao().saveAndFlush(monIntrant));
	}

	@Override
	public IntrantDTO modifierIntrantBdd(IntrantDTO intrant, CultureDTO culture) {
		// TODO verif existance intrant et de la culture

		Intrant monIntrant = IntrantMapper.fromIntrantDtoToIntrant(intrant);
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

	@Override
	public List<IntrantDTO> obtenirIntrantsCultureId(Integer idCulture) {
		// --TODO verfifier existence de culture
		return this.daoFacto.getIntrantDao().findByCultureIdCulture(idCulture).stream()
				.map(in -> IntrantMapper.fromIntrantToIntrantDTO(in)).collect(Collectors.toList());
	}

	@Override
	public IntrantDTO obtenirIntrant(Integer IdIntrant) {
		// TODO verifier existence de l'intrant
		return IntrantMapper.fromIntrantToIntrantDTO(this.daoFacto.getIntrantDao().findById(IdIntrant).get());
	}

	public DaoFactoryImpl getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(DaoFactoryImpl daoFacto) {
		this.daoFacto = daoFacto;
	}

}
