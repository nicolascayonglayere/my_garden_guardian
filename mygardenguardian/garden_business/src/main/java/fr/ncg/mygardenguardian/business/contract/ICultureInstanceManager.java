package fr.ncg.mygardenguardian.business.contract;

import java.util.Date;
import java.util.List;

import fr.ncg.mygardenguardian.dto.CultureInstanceDTO;

public interface ICultureInstanceManager {

	public CultureInstanceDTO prevoirCulture(CultureInstanceDTO cultureInstanceDTO);

	public CultureInstanceDTO daterCulture(CultureInstanceDTO cultureInstanceDTO);

	public CultureInstanceDTO trouverCultureInstance(Integer idCultureInstance);

	public List<CultureInstanceDTO> trouverCultureInstanceParCultureId(Integer idCulture);

	public List<CultureInstanceDTO> trouverCultureEnTerre(Integer idParcelle, Date date);

	public List<CultureInstanceDTO> trouverCultureHorsRecommandation(Integer idParcelle);

	public void supprimerCultureInstance(Integer idCulture);

}
