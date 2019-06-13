package fr.ncg.mygardenguardian.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.IAdhesionManager;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.entites.Adhesion;

@Transactional
@Service
public class AdhesionManagerImpl implements IAdhesionManager {

	private IDaoFactory daoFacto;

	@Override
	public void saveAdhesion(Adhesion adhesion) {
		this.daoFacto.getAdhesionDao().saveAndFlush(adhesion);
	}

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

}
