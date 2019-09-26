package fr.ncg.mygardenguardian.business.contract;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import fr.ncg.mygardenguardian.business.impl.EventCalendarManagerImpl;
import fr.ncg.mygardenguardian.business.impl.ExportCalendrier;
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

public class ExportCalendrierTest {

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private EventCalendarManagerImpl eventManager;

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

	private Path chemExportTemoin = Paths.get("I:\\temp", "myGardenGuardian.ics");

	@InjectMocks
	private ExportCalendrier export;

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

		this.calPrevCultureTemoin = new EventCalendarDTO(1, "nom", true, "2019-09-15", "2019-10-15",
				"/user/culture?idCulture=1");
	}

	@Test
	public void whenGivenIdUtilisateur_thenReturnPathOfFileCalendrierExport()
			throws FileNotFoundException, IOException {
		Mockito.when(this.eventManager.listeCulturesCalendrier(Mockito.anyString()))
				.thenReturn(Arrays.asList(this.calPrevCultureTemoin));

		Assert.assertTrue(this.export.exportCalendrier("1") instanceof Path);
		Assert.assertTrue(this.chemExportTemoin.toFile().exists());
		Assert.assertTrue(this.chemExportTemoin.toFile().length() > 0);

	}
}
