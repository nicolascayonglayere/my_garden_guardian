package fr.ncg.mygardenguardian.webapp.controller.rest;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@PostMapping(value = "/culture/modification_culture")
	public ResponseEntity<String> modifierCulture(@RequestBody String culture, HttpServletRequest request)
			throws UnsupportedEncodingException, ParseException {

		System.out.println("CTRL CONTROLLER REST POST Modif culture -------" + request.getParameter("idCulture"));
		CultureDTO maCultureModif = new CultureDTO();
		maCultureModif.setIdCulture(Integer.valueOf(request.getParameter("idCulture")));

		PlanteDTO maPlanteModif = new PlanteDTO();
		maPlanteModif.setIdPlante(Integer.valueOf(request.getParameter("plante.idPlante")));
		maPlanteModif.setNom(request.getParameter("plante.nom"));
		maPlanteModif.setNomLatin(request.getParameter("plante.nomLatin"));
		maPlanteModif.setVariete(request.getParameter("plante.variete"));
		maPlanteModif.setProduit(request.getParameter("plante.produit"));
		maPlanteModif.setDureeCycle(Integer.valueOf(request.getParameter("plante.dureeCycle")));
		maCultureModif.setPlante(maPlanteModif);

		int nbIntrant = (int) ((request.getParameterMap().entrySet().stream()
				.filter(s -> s.getKey().startsWith("intrants")).count()) / 3);
		IntStream.range(0, nbIntrant).forEachOrdered(i -> {
			IntrantDTO monIntrantModif = new IntrantDTO();
			monIntrantModif.setIdIntrant(Integer.valueOf(request.getParameter("intrants[" + i + "].idIntrant")));
			monIntrantModif.setNom(request.getParameter("intrants[" + i + "].nom"));
			monIntrantModif.setReference(request.getParameter("intrants[" + i + "].reference"));
			maCultureModif.addIntrant(monIntrantModif);
		});

		int nbOpeCult = (int) ((request.getParameterMap().entrySet().stream()
				.filter(s -> s.getKey().startsWith("operationsCulturales")).count()) / 4);
		IntStream.range(0, nbOpeCult).forEachOrdered(i -> {
			OperationCulturaleDTO monOpeModif = new OperationCulturaleDTO();
			monOpeModif.setIdOperationCulturale(
					Integer.valueOf(request.getParameter("operationsCulturales[" + i + "].idOperationCulturale")));
			monOpeModif.setNom(request.getParameter("operationsCulturales[" + i + "].nom"));
			monOpeModif.setDescription(request.getParameter("operationsCulturales[" + i + "].description"));
			monOpeModif.setDate(Integer.valueOf(request.getParameter("operationsCulturales[" + i + "].date")));
			monOpeModif.setStatut(String.valueOf(false));
			maCultureModif.addOperationCulturale(monOpeModif);
		});

		System.out.println(
				"CTRL CONTROLLER REST POST Modif culture intrant---------------- " + maCultureModif.toString());
		this.managerFactory.getCultureManager().modifierCultureBdd(maCultureModif);

		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
