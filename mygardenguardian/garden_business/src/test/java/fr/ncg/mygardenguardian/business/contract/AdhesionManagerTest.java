package fr.ncg.mygardenguardian.business.contract;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.ncg.mygardenguardian.business.impl.AdhesionManagerImpl;
import fr.ncg.mygardenguardian.consumer.IDaoFactory;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.CoordonneesUtilisateurDTO;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.entites.Adhesion;
import fr.ncg.mygardenguardian.entites.CoordonneesUtilisateur;
import fr.ncg.mygardenguardian.entites.Parcelle;
import fr.ncg.mygardenguardian.entites.Utilisateur;

public class AdhesionManagerTest {

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private IDaoFactory daoFacto;
	@Mock
	private IUtilisateurManager userManager;

	@InjectMocks
	private AdhesionManagerImpl adhManager;

	private AdhesionDTO adhTemoin;
	private ParcelleDTO parcelleTemoin;
	private UtilisateurDTO userTemoin;
	private CoordonneesUtilisateurDTO coordTemoin;

	private Utilisateur userEntityTemoin;
	private CoordonneesUtilisateur coordEntityTemoin;
	private Adhesion adhEntityTemoin;
	private Parcelle parcelleEntityTemoin;

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

	}

	@Test
	public void whenGivenAdhesionDTO_thenReturnAdhesionRenouvelee() {
		Mockito.when(this.userManager.verifExistenceUtilisateur(Mockito.any())).thenReturn(true);
		Mockito.when(this.daoFacto.getUtilisateurDao().findOne(Mockito.any()))
				.thenReturn(Optional.of(this.userEntityTemoin));
		Mockito.when(
				this.daoFacto.getAdhesionDao().findByIdUtilisateurAndArchive(Mockito.anyInt(), Mockito.anyBoolean()))
				.thenReturn(new Adhesion());
		Mockito.when(this.daoFacto.getAdhesionDao().saveAndFlush(Mockito.any())).thenReturn(this.adhEntityTemoin);

		Assert.assertTrue(this.adhManager.renouvellementAdhesion(this.adhTemoin) instanceof AdhesionDTO);
		Assert.assertEquals(this.adhTemoin, this.adhManager.renouvellementAdhesion(this.adhTemoin));

	}

	@Test
	public void whenGivenAdhesionDTO_thenReturnNouvelleAdhesion() {
		Mockito.when(this.userManager.verifExistenceUtilisateur(Mockito.any())).thenReturn(false);
		Mockito.when(this.daoFacto.getUtilisateurDao().findOne(Mockito.any()))
				.thenReturn(Optional.of(this.userEntityTemoin));
		Mockito.when(
				this.daoFacto.getAdhesionDao().findByIdUtilisateurAndArchive(Mockito.anyInt(), Mockito.anyBoolean()))
				.thenReturn(new Adhesion());
		Mockito.when(this.userManager.inscriptionUtilisateur(Mockito.any())).thenReturn(this.userTemoin);
		Mockito.when(this.daoFacto.getAdhesionDao().saveAndFlush(Mockito.any())).thenReturn(this.adhEntityTemoin);

		Assert.assertTrue(this.adhManager.nouvelleInscription(this.adhTemoin) instanceof AdhesionDTO);
		Assert.assertEquals(this.adhTemoin, this.adhManager.nouvelleInscription(this.adhTemoin));
	}

	@Test(expected = RuntimeException.class)
	public void whenGivenFakeAdhesionDTO_thenThrowRuntimeException() {
		Mockito.when(this.userManager.verifExistenceUtilisateur(Mockito.any())).thenReturn(true);
		this.adhManager.nouvelleInscription(this.adhTemoin);
	}

	@Test
	public void whenGivenUtilisateurDTO_thenReturnAdhesionDTO() {
		Mockito.when(
				this.daoFacto.getAdhesionDao().findByIdUtilisateurAndArchive(Mockito.anyInt(), Mockito.anyBoolean()))
				.thenReturn(this.adhEntityTemoin);

		Assert.assertTrue(this.adhManager.trouverAdhesionUtilisateur(this.userTemoin) instanceof AdhesionDTO);
		Assert.assertEquals(this.adhTemoin, this.adhManager.trouverAdhesionUtilisateur(this.userTemoin));
	}

	@Test
	public void whenGivenIdUtilisateurDTO_thenReturnAdhesionDTO() {
		Mockito.when(
				this.daoFacto.getAdhesionDao().findByIdUtilisateurAndArchive(Mockito.anyInt(), Mockito.anyBoolean()))
				.thenReturn(this.adhEntityTemoin);

		Assert.assertTrue(this.adhManager
				.trouverAdhesionIdUtilisateur(this.userTemoin.getIdUtilisateur()) instanceof AdhesionDTO);
		Assert.assertEquals(this.adhTemoin,
				this.adhManager.trouverAdhesionIdUtilisateur(this.userTemoin.getIdUtilisateur()));
	}

	@Test
	public void whenGivenNomUtilisateur_thenReturnAdhesionDTO() {
		Mockito.when(this.daoFacto.getAdhesionDao().findByNomUser(Mockito.anyString()))
				.thenReturn(this.adhEntityTemoin);

		Assert.assertTrue(
				this.adhManager.trouverAdhesionNomUtilisateur(this.userTemoin.getNom()) instanceof AdhesionDTO);
		Assert.assertEquals(this.adhTemoin, this.adhManager.trouverAdhesionNomUtilisateur(this.userTemoin.getNom()));
	}

	@Test
	public void whenGivenNothing_thenReturnJardiniers() {
		List<AdhesionDTO> listeTemoin = Arrays.asList(this.adhTemoin);
		Mockito.when(this.daoFacto.getAdhesionDao().findByArchive(false))
				.thenReturn(Arrays.asList(this.adhEntityTemoin));

		Assert.assertTrue(this.adhManager.trouverJardiniers().size() > 0);
		IntStream.range(0, listeTemoin.size()).forEachOrdered(i -> {
			Assert.assertEquals(listeTemoin.get(i), this.adhManager.trouverJardiniers().get(i));
		});
	}

	@Test
	public void whenGivenIdAdhesionDTO_thenReturnAdhesionDTO() {
		Mockito.when(this.daoFacto.getAdhesionDao().findById(Mockito.anyInt()))
				.thenReturn(Optional.of(this.adhEntityTemoin));

		Assert.assertTrue(this.adhManager.trouverParId(this.adhTemoin.getIdAdhesion()) instanceof AdhesionDTO);
		Assert.assertEquals(this.adhTemoin, this.adhManager.trouverParId(this.adhTemoin.getIdAdhesion()));
	}

	@Test
	public void whenGivenIdParcelleDTO_thenReturnAdhesionDTO() {
		Mockito.when(this.daoFacto.getAdhesionDao().findByParcelleIdParcelleAndArchive(Mockito.anyInt(),
				Mockito.anyBoolean())).thenReturn(Optional.of(this.adhEntityTemoin));

		Assert.assertTrue(
				this.adhManager.trouverAdhesionIdParcelle(this.parcelleTemoin.getIdParcelle()) instanceof AdhesionDTO);
		Assert.assertEquals(this.adhTemoin,
				this.adhManager.trouverAdhesionIdParcelle(this.parcelleTemoin.getIdParcelle()));
	}
}
