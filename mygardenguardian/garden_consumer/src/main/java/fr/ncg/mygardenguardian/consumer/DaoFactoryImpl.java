package fr.ncg.mygardenguardian.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.ncg.mygardenguardian.consumer.contract.AdhesionDao;
import fr.ncg.mygardenguardian.consumer.contract.CoordonneesUtilisateurDao;
import fr.ncg.mygardenguardian.consumer.contract.CultureDao;
import fr.ncg.mygardenguardian.consumer.contract.CultureInstanceDao;
import fr.ncg.mygardenguardian.consumer.contract.IntrantDao;
import fr.ncg.mygardenguardian.consumer.contract.MaterielDao;
import fr.ncg.mygardenguardian.consumer.contract.OperationCulturaleDao;
import fr.ncg.mygardenguardian.consumer.contract.ParcelleDao;
import fr.ncg.mygardenguardian.consumer.contract.PlanteDao;
import fr.ncg.mygardenguardian.consumer.contract.UtilisateurDao;

/**
 * Implementation de {@link IDaoFactory}
 * 
 * @author nicolas
 *
 */
@Component
public class DaoFactoryImpl implements IDaoFactory {

	private AdhesionDao adhesionDao;
	private UtilisateurDao utilisateurDao;
	private CoordonneesUtilisateurDao coordonneesUtilisateurDao;
	private ParcelleDao parcelleDao;
	private CultureDao cultureDao;
	private IntrantDao intrantDao;
	private MaterielDao materielDao;
	private OperationCulturaleDao operationCulturaleDao;
	private PlanteDao planteDao;
	private CultureInstanceDao cultureInstanceDao;

	@Override
	public AdhesionDao getAdhesionDao() {
		return this.adhesionDao;
	}

	@Autowired
	@Override
	public void setAdhesionDao(AdhesionDao adhesionDao) {
		this.adhesionDao = adhesionDao;
	}

	@Override
	public UtilisateurDao getUtilisateurDao() {
		return this.utilisateurDao;
	}

	@Autowired
	@Override
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public CoordonneesUtilisateurDao getCoordonneesUtilisateurDao() {
		return this.coordonneesUtilisateurDao;
	}

	@Autowired
	@Override
	public void setCoordonneesUtilisateurDao(CoordonneesUtilisateurDao coordonneesUtilisateurDao) {
		this.coordonneesUtilisateurDao = coordonneesUtilisateurDao;
	}

	@Override
	public ParcelleDao getParcelleDao() {
		return this.parcelleDao;
	}

	@Autowired
	@Override
	public void setParcelleDao(ParcelleDao parcelleDao) {
		this.parcelleDao = parcelleDao;
	}

	@Override
	public CultureDao getCultureDao() {
		return this.cultureDao;
	}

	@Autowired
	@Override
	public void setCultureDao(CultureDao cultureDao) {
		this.cultureDao = cultureDao;
	}

	@Override
	public IntrantDao getIntrantDao() {
		return this.intrantDao;
	}

	@Autowired
	@Override
	public void setIntrantDao(IntrantDao intrantDao) {
		this.intrantDao = intrantDao;
	}

	@Override
	public MaterielDao getMaterielDao() {
		return this.materielDao;
	}

	@Autowired
	@Override
	public void setMaterielDao(MaterielDao materielDao) {
		this.materielDao = materielDao;
	}

	@Override
	public OperationCulturaleDao getOperationCulturaleDao() {
		return this.operationCulturaleDao;
	}

	@Autowired
	@Override
	public void setOperationCulturaleDao(OperationCulturaleDao operationCulturaleDao) {
		this.operationCulturaleDao = operationCulturaleDao;
	}

	@Override
	public PlanteDao getPlanteDao() {
		return this.planteDao;
	}

	@Autowired
	@Override
	public void setPlanteDao(PlanteDao planteDao) {
		this.planteDao = planteDao;
	}

	@Override
	public CultureInstanceDao getCultureInstanceDao() {
		return this.cultureInstanceDao;
	}

	@Autowired
	@Override
	public void setCultureInstanceDao(CultureInstanceDao cultureInstanceDao) {
		this.cultureInstanceDao = cultureInstanceDao;
	}

}
