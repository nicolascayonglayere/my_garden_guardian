package fr.ncg.mygardenguardian.business.contract;

import java.util.ArrayList;
import java.util.Arrays;
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

import fr.ncg.mygardenguardian.business.impl.IntrantManagerImpl;
import fr.ncg.mygardenguardian.consumer.DaoFactoryImpl;
import fr.ncg.mygardenguardian.dto.CoordonneesUtilisateurDTO;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.IntrantDTO;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;
import fr.ncg.mygardenguardian.dto.PlanteDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.entites.CoordonneesUtilisateur;
import fr.ncg.mygardenguardian.entites.Culture;
import fr.ncg.mygardenguardian.entites.Intrant;
import fr.ncg.mygardenguardian.entites.OperationCulturale;
import fr.ncg.mygardenguardian.entites.Plante;
import fr.ncg.mygardenguardian.entites.Utilisateur;

public class IntrantManagerTest {

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private DaoFactoryImpl daoFacto;

	@InjectMocks
	private IntrantManagerImpl intrantManager;

	private CultureDTO cultureTemoin;
	private PlanteDTO planteTemoin;
	private UtilisateurDTO userTemoin;
	private CoordonneesUtilisateurDTO coordTemoin;
	private OperationCulturaleDTO ope1;
	private OperationCulturaleDTO ope2;
	private IntrantDTO intrant;

	private Culture cultureEntiteTemoin;
	private Plante planteEntiteTemoin;
	private Utilisateur userEntityTemoin;
	private CoordonneesUtilisateur coordEntityTemoin;
	private OperationCulturale opeEntite1;
	private OperationCulturale opeEntite2;
	private Intrant intrantEntite;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		this.intrant = new IntrantDTO("intrant", "ref");
		List<IntrantDTO> intrantsTemoin = new ArrayList<IntrantDTO>();
		intrantsTemoin.add(this.intrant);

		this.intrantEntite = new Intrant("intrant", "ref");
		List<Intrant> intrantsEntiteTemoin = new ArrayList<Intrant>();
		intrantsEntiteTemoin.add(this.intrantEntite);

		this.ope1 = new OperationCulturaleDTO(1, "op", 1, 2, "descr", "statut");
		this.ope2 = new OperationCulturaleDTO(2, "oq", 4, 5, "descr 2", "statut");
		List<OperationCulturaleDTO> opeCultTemoin = Arrays.asList(this.ope1, this.ope2);

		this.opeEntite1 = new OperationCulturale(1, "op", 1, 2, "descr", "statut");
		this.opeEntite2 = new OperationCulturale(2, "oq", 4, 5, "descr 2", "statut");
		List<OperationCulturale> opeCultEntiteTemoin = Arrays.asList(this.opeEntite1, this.opeEntite2);

		this.planteTemoin = new PlanteDTO("nom", "nomLatin", 12, "produit", "variete");
		this.planteTemoin.setIdPlante(1);

		this.planteEntiteTemoin = new Plante("nom", "nomLatin", "variete", 12, "produit");
		this.planteEntiteTemoin.setIdPlante(1);

		this.cultureTemoin = new CultureDTO(true);
		this.cultureTemoin.setIdCulture(1);
		this.cultureTemoin.setNom("nom");
		this.cultureTemoin.setRecommandationBasse(01);
		this.cultureTemoin.setRecommandationHaute(02);
		this.cultureTemoin.setIntrants(intrantsTemoin);
		this.cultureTemoin.setOperationsCulturales(opeCultTemoin);
		this.cultureTemoin.setPlante(this.planteTemoin);

		this.cultureEntiteTemoin = new Culture("nom", true, 01, 02);
		this.cultureEntiteTemoin.setIdCulture(1);
		this.cultureEntiteTemoin.setIntrants(intrantsEntiteTemoin);
		this.cultureEntiteTemoin.setOperationsCulturales(opeCultEntiteTemoin);
		this.cultureEntiteTemoin.setPlante(this.planteEntiteTemoin);

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
	}

	@Test
	public void whenGivenCultureDTO_thenReturnIntrantSave() {
		Mockito.when(this.daoFacto.getIntrantDao().saveAndFlush(Mockito.any())).thenReturn(this.intrantEntite);

		Assert.assertTrue(this.intrantManager.creerIntrantBdd(this.cultureTemoin) instanceof IntrantDTO);
		Assert.assertEquals(this.intrant, this.intrantManager.creerIntrantBdd(this.cultureTemoin));
	}

	@Test
	public void whenGivenCultureDTOAndIntrantDTO_thenReturnIntrantModify() {
		Mockito.when(this.daoFacto.getIntrantDao().saveAndFlush(Mockito.any())).thenReturn(this.intrantEntite);

		Assert.assertTrue(
				this.intrantManager.modifierIntrantBdd(this.intrant, this.cultureTemoin) instanceof IntrantDTO);
		Assert.assertEquals(this.intrant, this.intrantManager.modifierIntrantBdd(this.intrant, this.cultureTemoin));
	}

	@Test
	public void whenGivenNothing_thenReturnListNomsIntrants() {
		List<IntrantDTO> listeTemoin = Arrays.asList(this.intrant);
		Mockito.when(this.daoFacto.getIntrantDao().findAll()).thenReturn(Arrays.asList(this.intrantEntite));

		Assert.assertTrue(this.intrantManager.obtenirNomsIntrants().size() > 0);
		IntStream.range(0, listeTemoin.size()).forEachOrdered(i -> {
			Assert.assertEquals(listeTemoin.get(i).getNom(), this.intrantManager.obtenirNomsIntrants().get(i));
		});
	}

	@Test
	public void whenGivenIdCulture_thenReturnListIntrantCulture() {
		List<IntrantDTO> listeTemoin = Arrays.asList(this.intrant);
		Mockito.when(this.daoFacto.getIntrantDao().findByCultureIdCulture(Mockito.anyInt()))
				.thenReturn(Arrays.asList(this.intrantEntite));

		Assert.assertTrue(this.intrantManager.obtenirIntrantsCultureId(1).size() > 0);
		IntStream.range(0, listeTemoin.size()).forEachOrdered(i -> {
			Assert.assertEquals(listeTemoin.get(i), this.intrantManager.obtenirIntrantsCultureId(1).get(i));
		});
	}
}
