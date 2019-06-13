package fr.ncg.mygardenguardian.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.IRoleManager;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.entites.Role;

@Transactional
@Service
public class RoleManagerImpl implements IRoleManager {

	private IDaoFactory daoFacto;

	@Override
	public Role trouverRole(String role) {
		return this.daoFacto.getRoleDao().findByRole(role);
	}

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

}
