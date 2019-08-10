package fr.ncg.mygardenguardian.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.IOperationCulturaleManager;
import fr.ncg.mygardenguardian.consumer.DaoFactoryImpl;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;

@Service
@Transactional
public class OperationCulturaleManager implements IOperationCulturaleManager {

	private DaoFactoryImpl daoFacto;

	@Override
	public OperationCulturaleDTO creerOperationCulturaleBdd(CultureDTO culture) {
//		List<OperationCulturaleDTO> mesOperationsCreees = new ArrayList<OperationCulturaleDTO>();
//		// TODO verifier existence de operation culturale et de la culture
//		culture.getOperationsCulturales().stream()
//				.map(op -> OperationCulturaleMapper.fromOperationCulturaleDtoToOperationCulturale(op)).forEach(op -> {
//					op.setCulture(CultureMapper.fromCultureDtoToCulture(culture));
//					op.setStatut("previsionnel");
//					System.out.println("CTRL BUSINESS OPE CULT --------------" + op.toString());
//					mesOperationsCreees.add(OperationCulturaleMapper.fromOperationCulturaleToOperationCulturaleDTO(
//							this.daoFacto.getOperationCulturaleDao().saveAndFlush(op)));
//				});
//		culture.setOperationsCulturales(mesOperationsCreees);
//
//		return OperationCulturaleMapper.fromOperationCulturaleToOperationCulturaleDTO(
//				this.daoFacto.getOperationCulturaleDao().saveAndFlush(monOpeCult));
		return null;
	}

	public DaoFactoryImpl getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(DaoFactoryImpl daoFacto) {
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

}
