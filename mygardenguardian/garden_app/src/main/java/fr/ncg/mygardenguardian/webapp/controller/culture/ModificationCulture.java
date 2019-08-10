package fr.ncg.mygardenguardian.webapp.controller.culture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.ncg.mygardenguardian.dto.CultureDTO;

@Controller
public class ModificationCulture {

	@GetMapping("/culture/modification_culture")
	public String goModifCulture(Model model) {
		CultureDTO maCultureModif = (CultureDTO) model.asMap().get("cultureModif");
		System.out.println("CTRL CONTROLLER GET MODIF CULTURE ------------" + maCultureModif.toString());
		model.addAttribute("cultureModif", maCultureModif);
//		model.addAttribute("modifPlanteForm", new ModifPlanteFormulaire());
//		IntStream.range(0, maCultureModif.getIntrants().size()).forEachOrdered(i -> {
//			model.addAttribute("modifIntrantForm", new EnregistrementIntrantBddFormulaire());
//		});
//		model.addAttribute("nbIntrantForm", maCultureModif.getIntrants().size() - 1);
//		IntStream.range(0, maCultureModif.getOperationsCulturales().size()).forEachOrdered(i -> {
//			model.addAttribute("modifOpCultForm" + i, new EnregistrementOperationCulturaleBddFormulaire());
//		});
//		model.addAttribute("nbOpForm", maCultureModif.getOperationsCulturales().size() - 1);
		return "culture/modification_culture";
	}

}
