package fr.ncg.mygardenguardian.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ncg.mygardenguardian.business.contract.ICultureManager;
import fr.ncg.mygardenguardian.business.mapper.CultureMapper;
import fr.ncg.mygardenguardian.business.mapper.IntrantMapper;
import fr.ncg.mygardenguardian.business.mapper.OperationCulturaleMapper;
import fr.ncg.mygardenguardian.business.mapper.ParcelleMapper;
import fr.ncg.mygardenguardian.business.mapper.PlanteMapper;
import fr.ncg.mygardenguardian.business.mapper.UtilisateurMapper;
import fr.ncg.mygardenguardian.consumer.DaoFactoryImpl;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.entites.Culture;

@Service
@Transactional
public class CultureManager implements ICultureManager {

	private DaoFactoryImpl daoFacto;

	@Override
	public List<CultureDTO> obtenirToutesLesCultures() {
		return this.daoFacto.getCultureDao().findAll().stream().map(c -> CultureMapper.fromCultureToCultureDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<CultureDTO> ajouterCulturesPrevisionnelles(List<CultureDTO> calendrierPrevisionnel,
			AdhesionDTO adhesion) {
		List<CultureDTO> monCalendrierRetour = new ArrayList<CultureDTO>();
		calendrierPrevisionnel.stream().map(c -> CultureMapper.fromCultureDtoToCulture(c)).forEachOrdered(c -> {
			if (this.verifExistenceCulture(c)) {
				Example<Culture> monExCulture = Example.of(c);
				c = this.daoFacto.getCultureDao().findOne(monExCulture).get();
				c.addParcelle(ParcelleMapper.fromParcelleDTOToParcelle(adhesion.getParcelleDTO()),
						Calendar.getInstance().getTime());
				monCalendrierRetour
						.add(CultureMapper.fromCultureToCultureDto(this.daoFacto.getCultureDao().saveAndFlush(c)));
			} else {
				throw new RuntimeException("La culture n'existe pas " + c.getPlante().getNom());
			}
		});
		return monCalendrierRetour;
	}

	@Override
	public CultureDTO creerCultureBdd(CultureDTO culture, UtilisateurDTO auteur) {
		Culture maCulture = CultureMapper.fromCultureDtoToCulture(culture);

		if (!this.verifExistenceCulture(maCulture)) {
			maCulture.setUtilisateur(UtilisateurMapper.fromUtilisateurDTOToUtilisateur(auteur));
			maCulture.setPlante(this.daoFacto.getPlanteDao().saveAndFlush(maCulture.getPlante()));
			return CultureMapper.fromCultureToCultureDto(this.daoFacto.getCultureDao().saveAndFlush(maCulture));
		} else {
			throw new RuntimeException("la culture existe deja " + culture.getPlante().getNom() + " - "
					+ culture.getPlante().getVariete());
		}
	}

	@Override
	public CultureDTO trouverLaCulture(Integer idCulture) {
		return CultureMapper.fromCultureToCultureDto(this.daoFacto.getCultureDao().findById(idCulture).get());
	}

	@Override
	public List<CultureDTO> obtenirCulturesEnConstruction() {
		return this.daoFacto.getCultureDao().findByEnConstruction(true).stream()
				.map(c -> CultureMapper.fromCultureToCultureDto(c)).collect(Collectors.toList());
	}

	@Override
	public CultureDTO creerOperationCulturaleBdd(CultureDTO culture) {
		List<OperationCulturaleDTO> mesOperationsCreees = new ArrayList<OperationCulturaleDTO>();
		// TODO verifier existence de operation culturale
		if (this.verifExistenceCulture(CultureMapper.fromCultureDtoToCulture(culture))) {
			culture.getOperationsCulturales().stream()
					.map(op -> OperationCulturaleMapper.fromOperationCulturaleDtoToOperationCulturale(op))
					.forEach(op -> {
						op.setCulture(CultureMapper.fromCultureDtoToCulture(culture));
						op.setStatut("previsionnel");
						mesOperationsCreees.add(OperationCulturaleMapper.fromOperationCulturaleToOperationCulturaleDTO(
								this.daoFacto.getOperationCulturaleDao().saveAndFlush(op)));
					});
			culture.setOperationsCulturales(mesOperationsCreees);

			return culture;
		} else {
			throw new RuntimeException("La culture n'existe pas " + culture.getPlante().getNom());
		}
	}

	@Override
	public CultureDTO modifierCultureBdd(CultureDTO culture) {
		if (this.getDaoFacto().getCultureDao().findById(culture.getIdCulture()).isPresent()) {
			Culture cultureInt = this.daoFacto.getCultureDao().findById(culture.getIdCulture()).get();
			cultureInt.setPlante(
					this.daoFacto.getPlanteDao().saveAndFlush(PlanteMapper.fromPlanteDtoToPlante(culture.getPlante())));
			culture.getIntrants().stream().map(i -> IntrantMapper.fromIntrantDtoToIntrant(i)).forEach(i -> {
				i.setCulture(cultureInt);
				cultureInt.addIntrant(this.daoFacto.getIntrantDao().saveAndFlush(i));
			});
			culture.getOperationsCulturales().stream()
					.map(op -> OperationCulturaleMapper.fromOperationCulturaleDtoToOperationCulturale(op))
					.forEach(op -> {
						op.setCulture(cultureInt);
						cultureInt.addOperationCulturale(this.daoFacto.getOperationCulturaleDao().save(op));
					});
			return CultureMapper.fromCultureToCultureDto(this.daoFacto.getCultureDao().saveAndFlush(cultureInt));
		} else {
			throw new RuntimeException("La culture n'existe pas " + culture.getPlante().getNom());
		}

	}

	private boolean verifExistenceCulture(Culture culture) {
		Example<Culture> monExCulture = Example.of(culture);
		if (!this.daoFacto.getCultureDao().findOne(monExCulture).isPresent()) {
			return false;
		} else {
			return true;
		}
	}

	public DaoFactoryImpl getDaoFacto() {
		return this.daoFacto;
	}

	@Autowired
	public void setDaoFacto(DaoFactoryImpl daoFacto) {
		this.daoFacto = daoFacto;
	}

}
