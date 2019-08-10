package fr.ncg.mygardenguardian.business.contract;

import java.util.List;

import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;

public interface IOperationCulturaleManager {

	public OperationCulturaleDTO creerOperationCulturaleBdd(CultureDTO culture);

	public List<String> obtenirNomsOperationCulturale();
}
