package fr.ncg.mygardenguardian.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.IParcelleManager;
import fr.ncg.mygardenguardian.business.mapper.ParcelleMapper;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.entites.Parcelle;

@Transactional
@Service
public class ParcelleManagerImpl implements IParcelleManager {

	private IDaoFactory daoFacto;

	@Override
	public List<ParcelleDTO> trouverToutesParcellesVides() {
		List<ParcelleDTO> maListeParcellesVides = new ArrayList<ParcelleDTO>();
		for (Parcelle p : this.daoFacto.getParcelleDao().trouverParcelleVide()) {
			// .findByOccupation(false)) {
			maListeParcellesVides.add(ParcelleMapper.fromParcelleToParcelleDTO(p));
		}
		return maListeParcellesVides;
	}

	@Override
	public ParcelleDTO trouverParcelleParId(int idParcelle) {
		return ParcelleMapper.fromParcelleToParcelleDTO(this.getDaoFacto().getParcelleDao().findById(idParcelle).get());
	}

	public IDaoFactory getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(IDaoFactory daoFacto) {
		this.daoFacto = daoFacto;
	}

}
