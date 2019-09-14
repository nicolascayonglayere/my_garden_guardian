package fr.ncg.mygardenguardian.business.contract;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.impl.EventCalendarManagerImpl;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.CoordonneesUtilisateurDTO;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.CultureInstanceDTO;
import fr.ncg.mygardenguardian.dto.EventCalendarDTO;
import fr.ncg.mygardenguardian.dto.IntrantDTO;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.dto.PlanteDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.entites.Adhesion;
import fr.ncg.mygardenguardian.entites.CoordonneesUtilisateur;
import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.CultureInstance;
import fr.ncg.mygardenguardian.entites.Intrant;
import fr.ncg.mygardenguardian.entites.OperationCulturale;
import fr.ncg.mygardenguardian.entites.Parcelle;
import fr.ncg.mygardenguardian.entites.Plante;
import fr.ncg.mygardenguardian.entites.Utilisateur;

public class EventCalendarManagerTest {
	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private IBusinessManagerFactory managerFactory;
	@InjectMocks
	private EventCalendarManagerImpl eventCalManager;

	private AdhesionDTO adhTemoin;
	private ParcelleDTO parcelleTemoin;
	private UtilisateurDTO userTemoin;
	private CoordonneesUtilisateurDTO coordTemoin;

	private Utilisateur userEntityTemoin;
	private CoordonneesUtilisateur coordEntityTemoin;
	private Adhesion adhEntityTemoin;
	private Parcelle parcelleEntityTemoin;

	private CultureInstanceDTO cultureInstanceTemoin;
	private CultureDTO cultureTemoin;
	private PlanteDTO planteTemoin;

	private CultureInstance cultureInstanceEntiteTemoin;
	private Culture cultureEntiteTemoin;
	private Plante planteEntiteTemoin;

	private EventCalendarDTO calPrevCultureTemoin;
	private EventCalendarDTO calPrevOpeCultTemoin;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.parcelleTemoin = new ParcelleDTO();
		this.parcelleTemoin.setCode("ZZ");
		this.parcelleTemoin.setIdParcelle(1);
		this.parcelleTemoin.setSurface(100);

		this.parcelleEntityTemoin = new Parcelle(100, "ZZ");
		this.parcelleEntityTemoin.setIdParcelle(1);

		this.coordTemoin = new CoordonneesUtilisateurDTO("11-11-11-11-11", "emai@mail", "adresse", "ville",
				"codePostal");
		this.coordTemoin.setIdCoordonneesUtilisateur(1);

		this.coordEntityTemoin = new CoordonneesUtilisateur("11-11-11-11-11", "emai@mail", "adresse", "ville",
				"codePostal");
		this.coordEntityTemoin.setIdCoordonneesUtilisateur(1);

		this.userTemoin = new UtilisateurDTO();
		this.userTemoin.setIdUtilisateur(1);
		this.userTemoin.setMdp("XXXXXX");
		this.userTemoin.setNom("nom");
		this.userTemoin.setPrenom("prenom");
		this.userTemoin.setRole("JARDINIER");
		this.userTemoin.setCoordonneeUtilisateurDTO(this.coordTemoin);

		this.userEntityTemoin = new Utilisateur("prenom", "nom", "XXXXXX", "JARDINIER");
		this.userEntityTemoin.setIdUtilisateur(1);
		this.userEntityTemoin.setCoordonneeUtilisateur(this.coordEntityTemoin);

		this.adhTemoin = new AdhesionDTO();
		this.adhTemoin.setArchive(false);
		this.adhTemoin.setDateAdhesion(Calendar.getInstance().getTime());
		this.adhTemoin.setIdAdhesion(1);
		this.adhTemoin.setParcelleDTO(this.parcelleTemoin);
		this.adhTemoin.setUtilisateurDTO(this.userTemoin);

		this.adhEntityTemoin = new Adhesion(this.adhTemoin.getDateAdhesion(), false, null);
		this.adhEntityTemoin.setIdAdhesion(1);
		this.adhEntityTemoin.setUtilisateur(this.userEntityTemoin);
		this.adhEntityTemoin.setParcelle(this.parcelleEntityTemoin);

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

		this.planteTemoin = new PlanteDTO("nom", "nomLatin", 1, "produit", "variete");
		this.planteTemoin.setIdPlante(1);

		this.planteEntiteTemoin = new Plante("nom", "nomLatin", "variete", 1, "produit");
		this.planteEntiteTemoin.setIdPlante(1);

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

		this.cultureInstanceTemoin = new CultureInstanceDTO();
		this.cultureInstanceTemoin.setCulture(this.cultureTemoin);
		this.cultureInstanceTemoin.setIdCultureInstance(1);
		this.cultureInstanceTemoin.setDate(Calendar.getInstance().getTime());
		this.cultureInstanceTemoin.setParcelle(this.parcelleTemoin);

		this.cultureInstanceEntiteTemoin = new CultureInstance(this.cultureInstanceTemoin.getDate());
		this.cultureInstanceEntiteTemoin.setCulture(this.cultureEntiteTemoin);
		this.cultureInstanceEntiteTemoin.setIdCultureInstance(1);
		this.cultureInstanceEntiteTemoin.setParcelle(this.parcelleEntityTemoin);

		this.parcelleTemoin.setlisteCultures(Arrays.asList(this.cultureInstanceTemoin));

		this.parcelleEntityTemoin.setListeCultures(Arrays.asList(this.cultureInstanceEntiteTemoin));

		this.calPrevCultureTemoin = new EventCalendarDTO(1, "nom", true, "2019-09-22", "2019-10-22",
				"/user/culture?idCulture=1");
		this.calPrevOpeCultTemoin = new EventCalendarDTO(2, "op - nom", true, "2019-09-23", "2019-09-23",
				"/user/culture?idCulture=1");

	}

	@Test
	public void whenGivenIdUtilisateur_thenReturnListCultureCalendrierPrevisionnel() {
		List<EventCalendarDTO> listeTemoin = Arrays.asList(this.calPrevCultureTemoin);
		Mockito.when(this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(Mockito.anyInt()))
				.thenReturn(this.adhTemoin);
		Mockito.when(this.managerFactory.getParcelleManager().trouverParcelleParId(Mockito.anyInt()))
				.thenReturn(this.parcelleTemoin);

		Assert.assertTrue(this.eventCalManager.listeCulturesCalendrier(1).size() > 0);
		IntStream.range(0, listeTemoin.size()).forEachOrdered(i -> {
			Assert.assertEquals(listeTemoin.get(i), this.eventCalManager.listeCulturesCalendrier(1).get(i));
		});
	}

	@Test
	public void whenGivenIdUtilisateurAndNomOperationCulturale_thenReturnListOperationCulturaleCalendrierPrevisionnel() {
		List<EventCalendarDTO> listeTemoin = Arrays.asList(this.calPrevOpeCultTemoin);
		Mockito.when(this.managerFactory.getAdhesionManager().trouverAdhesionIdUtilisateur(Mockito.anyInt()))
				.thenReturn(this.adhTemoin);
		Mockito.when(this.managerFactory.getParcelleManager().trouverParcelleParId(Mockito.anyInt()))
				.thenReturn(this.parcelleTemoin);

		Assert.assertTrue(this.eventCalManager.constructionEventOpeCultCalendar(1, "op").size() > 0);
		IntStream.range(0, listeTemoin.size()).forEachOrdered(i -> {
			System.out.println(listeTemoin.get(i).toString());
			// System.out.println(this.eventCalManager.constructionEventOpeCultCalendar(1,
			// "op").get(i).toString());
			Assert.assertEquals(listeTemoin.get(i),
					this.eventCalManager.constructionEventOpeCultCalendar(1, "op").get(i));
		});
	}

}
