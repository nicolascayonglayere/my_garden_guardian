package fr.ncg.mygardenguardian.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.IOperationCulturaleManager;
import fr.ncg.mygardenguardian.business.mapper.CultureMapper;
import fr.ncg.mygardenguardian.business.mapper.OperationCulturaleMapper;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;
import fr.ncg.mygardenguardian.entites.OperationCulturale;

@Service
@Transactional
public class OperationCulturaleManager implements IOperationCulturaleManager {

	private IDaoFactory daoFacto;

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

	@Override
	public List<String> obtenirNomsOperationCulturale() {
		List<String> nomOpeCult = new ArrayList<String>();
		this.daoFacto.getOperationCulturaleDao().findAll().stream().forEachOrdered(op -> {
			if (!nomOpeCult.contains(op.getNom().trim())) {
				nomOpeCult.add(op.getNom());
			}
		});
		Collections.sort(nomOpeCult);
		return nomOpeCult;
	}

	@Override
	public List<OperationCulturaleDTO> obtenirOperationsCulturalesParCulture(Integer idCulture) {
		// TODO verifier l'existence de la culture
		return this.daoFacto.getOperationCulturaleDao().findByCultureIdCulture(idCulture).stream()
				.map(oc -> OperationCulturaleMapper.fromOperationCulturaleToOperationCulturaleDTO(oc))
				.collect(Collectors.toList());
	}

	@Override
	public OperationCulturaleDTO modifierOperationCulturaleBdd(CultureDTO culture,
			OperationCulturaleDTO operationCulturale) {
		// TODO verifier l'existence de la culture et de l'operationCulturale
		OperationCulturale monOpeCult = OperationCulturaleMapper
				.fromOperationCulturaleDtoToOperationCulturale(operationCulturale);
		monOpeCult.setCulture(CultureMapper.fromCultureDtoToCulture(culture));
		return OperationCulturaleMapper.fromOperationCulturaleToOperationCulturaleDTO(
				this.daoFacto.getOperationCulturaleDao().saveAndFlush(monOpeCult));
	}

	@Override
	public OperationCulturaleDTO obtenirOperationCulturaleParId(Integer idOperationCulturale) {
		// TODO verifier l'existence de l'operationCulturale
		return OperationCulturaleMapper.fromOperationCulturaleToOperationCulturaleDTO(
				this.daoFacto.getOperationCulturaleDao().findById(idOperationCulturale).get());
	}

}
