package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.IntrantDTO;

public interface IIntrantManager {

	public IntrantDTO creerIntrantBdd(CultureDTO culture);

	public IntrantDTO modifierIntrantBdd(IntrantDTO intrant, CultureDTO culture);

	public IntrantDTO obtenirIntrant(Integer IdIntrant);

	public List<String> obtenirNomsIntrants();

	public List<IntrantDTO> obtenirIntrantsCultureId(Integer idCulture);
}
