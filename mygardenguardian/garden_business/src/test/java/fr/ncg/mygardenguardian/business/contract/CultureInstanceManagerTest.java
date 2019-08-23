package fr.ncg.mygardenguardian.business.contract;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.ncg.mygardenguardian.business.impl.CultureInstanceManager;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.CultureInstanceDTO;
import fr.ncg.mygardenguardian.dto.IntrantDTO;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.dto.PlanteDTO;
import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.CultureInstance;
import fr.ncg.mygardenguardian.entites.Intrant;
import fr.ncg.mygardenguardian.entites.OperationCulturale;
import fr.ncg.mygardenguardian.entites.Parcelle;
import fr.ncg.mygardenguardian.entites.Plante;

public class CultureInstanceManagerTest {

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private IDaoFactory daoFacto;
	@Mock
	private ICultureManager cultureManager;
	@InjectMocks
	private CultureInstanceManager cultInstManager;

	private CultureInstanceDTO cultureInstanceTemoin;
	private CultureDTO cultureTemoin;
	private PlanteDTO planteTemoin;

	private CultureInstance cultureInstanceEntiteTemoin;
	private Culture cultureEntiteTemoin;
	private Plante planteEntiteTemoin;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		IntrantDTO intrant = new IntrantDTO("intrant", "ref");
		List<IntrantDTO> intrantsTemoin = Arrays.asList(intrant);

		Intrant intrantEntite = new Intrant("intrant", "ref");
		List<Intrant> intrantsEntiteTemoin = Arrays.asList(intrantEntite);

		OperationCulturaleDTO ope1 = new OperationCulturaleDTO(1, "op", 1, 2, "descr", "statut");
		OperationCulturaleDTO ope2 = new OperationCulturaleDTO(2, "oq", 4, 5, "descr 2", "statut");
		List<OperationCulturaleDTO> opeCultTemoin = Arrays.asList(ope1, ope2);

		OperationCulturale opeEntite1 = new OperationCulturale(1, "op", 1, 2, "descr", "statut");
		OperationCulturale opeEntite2 = new OperationCulturale(2, "oq", 4, 5, "descr 2", "statut");
		List<OperationCulturale> opeCultEntiteTemoin = Arrays.asList(opeEntite1, opeEntite2);

		this.planteTemoin = new PlanteDTO("nom", "nomLatin", 12, "produit", "variete");

		this.planteEntiteTemoin = new Plante("nom", "nomLatin", "variete", 12, "produit");

		this.cultureTemoin = new CultureDTO(false);
		this.cultureTemoin.setIdCulture(1);
		this.cultureTemoin.setNom("nom");
		this.cultureTemoin.setRecommandationBasse(01);
		this.cultureTemoin.setRecommandationHaute(02);
		this.cultureTemoin.setIntrants(intrantsTemoin);
		this.cultureTemoin.setOperationsCulturales(opeCultTemoin);
		this.cultureTemoin.setPlante(this.planteTemoin);

		this.cultureEntiteTemoin = new Culture("nom", false, 01, 02);
		this.cultureEntiteTemoin.setIdCulture(1);
		this.cultureEntiteTemoin.setIntrants(intrantsEntiteTemoin);
		this.cultureEntiteTemoin.setOperationsCulturales(opeCultEntiteTemoin);
		this.cultureEntiteTemoin.setPlante(this.planteEntiteTemoin);

		this.cultureInstanceTemoin = new CultureInstanceDTO(1, Calendar.getInstance().getTime());
		this.cultureInstanceTemoin.setCulture(this.cultureTemoin);
		this.cultureInstanceTemoin.setParcelle(new ParcelleDTO(100, "ZZ"));

		this.cultureInstanceEntiteTemoin = new CultureInstance(this.cultureInstanceTemoin.getDate());
		this.cultureInstanceEntiteTemoin.setCulture(this.cultureEntiteTemoin);
		this.cultureInstanceEntiteTemoin.setIdCultureInstance(1);
		this.cultureInstanceEntiteTemoin.setParcelle(new Parcelle(100, "ZZ"));
	}

	@Test
	public void whenGivenCultureInstanceDTO_thenReturnCultureInstanceDTOSave() {
		Mockito.when(this.daoFacto.getCultureInstanceDao().saveAndFlush(Mockito.any()))
				.thenReturn(this.cultureInstanceEntiteTemoin);
		System.out.println(this.daoFacto.getCultureInstanceDao());
		Assert.assertTrue(
				this.cultInstManager.prevoirCulture(this.cultureInstanceTemoin) instanceof CultureInstanceDTO);
		Assert.assertEquals(this.cultureInstanceTemoin,
				this.cultInstManager.prevoirCulture(this.cultureInstanceTemoin));
	}
}
