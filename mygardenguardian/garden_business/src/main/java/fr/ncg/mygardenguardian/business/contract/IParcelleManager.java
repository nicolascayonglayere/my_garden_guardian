package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.ParcelleDTO;

public interface IParcelleManager {

	public List<ParcelleDTO> trouverToutesParcellesVides();

	public ParcelleDTO trouverParcelleParId(int idParcelle);
}
