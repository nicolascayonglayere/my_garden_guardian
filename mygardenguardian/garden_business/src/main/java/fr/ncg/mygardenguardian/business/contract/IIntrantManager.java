package fr.ncg.mygardenguardian.business.contract;

import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.IntrantDTO;

public interface IIntrantManager {

	public IntrantDTO creerIntrantBdd(CultureDTO culture);
}
