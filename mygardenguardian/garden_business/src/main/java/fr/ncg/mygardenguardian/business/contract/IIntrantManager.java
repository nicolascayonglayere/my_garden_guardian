package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.IntrantDTO;

public interface IIntrantManager {

	public IntrantDTO creerIntrantBdd(CultureDTO culture);

	public List<String> obtenirNomsIntrants();
}