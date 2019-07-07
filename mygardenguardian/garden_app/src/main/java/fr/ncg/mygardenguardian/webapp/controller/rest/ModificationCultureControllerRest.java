package fr.ncg.mygardenguardian.webapp.controller.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.dto.CultureDTO;
import fr.ncg.mygardenguardian.dto.IntrantDTO;
import fr.ncg.mygardenguardian.dto.OperationCulturaleDTO;
import fr.ncg.mygardenguardian.dto.PlanteDTO;

@RestController
public class ModificationCultureControllerRest {

	private IBusinessManagerFactory managerFactory;

	@PostMapping(value = "/culture/modification_culture", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String modifierCulture(@RequestBody String culture) throws UnsupportedEncodingException, ParseException {
		System.out.println("CTRL CONTROLLER REST POST Modification culture ------------" + culture);
		// culture.replaceAll("%20", " ");
		culture = URLDecoder.decode(culture, "UTF-8");
		String[] cultureProcess = culture.split("&");
		Map<String, String> cultureField = new HashMap<String, String>();

		for (int i = 0; i < cultureProcess.length; i++) {
			System.out.println("CTR CONTROLLER REST POST Modif culture -----------" + cultureProcess[i].split("=")[0]
					+ " - " + cultureProcess[i].split("=")[1] + "\n");
			cultureField.put(cultureProcess[i].split("=")[0], cultureProcess[i].split("=")[1]);
		}
		CultureDTO maCultureModif = new CultureDTO();
		maCultureModif.setIdCulture(Integer.valueOf(cultureField.entrySet().stream()
				.filter(s -> s.getKey().equalsIgnoreCase("idCulture")).findFirst().get().getValue()));

		PlanteDTO maPlanteModif = new PlanteDTO();
		maPlanteModif.setIdPlante(Integer.valueOf(cultureField.entrySet().stream()
				.filter(s -> s.getKey().equalsIgnoreCase("plante.idPlante")).findFirst().get().getValue()));
		maPlanteModif.setNom(cultureField.entrySet().stream().filter(s -> s.getKey().equalsIgnoreCase("plante.nom"))
				.findFirst().get().getValue());
		maPlanteModif.setNomLatin(cultureField.entrySet().stream()
				.filter(s -> s.getKey().equalsIgnoreCase("plante.nomLatin")).findFirst().get().getValue());
		maPlanteModif.setVariete(cultureField.entrySet().stream()
				.filter(s -> s.getKey().equalsIgnoreCase("plante.variete")).findFirst().get().getValue());
		maPlanteModif.setDureeCycle(Integer.valueOf(cultureField.entrySet().stream()
				.filter(s -> s.getKey().equalsIgnoreCase("plante.dureeCycle")).findFirst().get().getValue()));
		maPlanteModif.setProduit(cultureField.entrySet().stream()
				.filter(s -> s.getKey().equalsIgnoreCase("plante.produit")).findFirst().get().getValue());

		maCultureModif.setPlante(maPlanteModif);

		Map<String, String> intrantField = new HashMap<String, String>();
		cultureField.entrySet().stream().filter(s -> s.getKey().startsWith("intrants")).forEachOrdered(s -> {
			intrantField.put(s.getKey(), s.getValue());
		});
		System.out.println("CTRL CONTROLLER REST POST Modif culture intrant---------------- " + intrantField.size()
				+ " - " + intrantField.toString());
		for (int i = 0; i < (intrantField.size()) / 3; i++) {
			IntrantDTO monIntrantModif = new IntrantDTO();
			monIntrantModif.setIdIntrant(Integer.valueOf(intrantField.get("intrants[" + i + "].idIntrant").toString()));
			monIntrantModif.setNom(intrantField.get("intrants[" + i + "].nom").toString());
			monIntrantModif.setReference(intrantField.get("intrants[" + i + "].reference").toString());
			maCultureModif.addIntrant(monIntrantModif);
		}

		Map<String, String> opeCultField = new HashMap<String, String>();
		cultureField.entrySet().stream().filter(s -> s.getKey().startsWith("operationsCulturales"))
				.forEachOrdered(s -> {
					opeCultField.put(s.getKey(), s.getValue());
				});

		System.out.println("CTRL CONTROLLER REST POST Modif culture ope cult---------------- " + opeCultField.size()
				+ " - " + opeCultField.toString());

		for (int i = 0; i < (opeCultField.size()) / 4; i++) {
			OperationCulturaleDTO monOpeModif = new OperationCulturaleDTO();
			monOpeModif.setIdOperationCulturale(Integer
					.valueOf(opeCultField.get("operationsCulturales[" + i + "].idOperationCulturale").toString()));
			monOpeModif.setNom(opeCultField.get("operationsCulturales[" + i + "].nom").toString());
			monOpeModif.setDescription(opeCultField.get("operationsCulturales[" + i + "].description").toString());
			monOpeModif.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S")
					.parse(opeCultField.get("operationsCulturales[" + i + "].date").toString()));
			monOpeModif.setStatut(String.valueOf(false));
			maCultureModif.addOperationCulturale(monOpeModif);
		}

		System.out.println(
				"CTRL CONTROLLER REST POST Modif culture intrant---------------- " + maCultureModif.toString());
		this.managerFactory.getCultureManager().modifierCultureBdd(maCultureModif);
		return "redirect:/accueil";
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
