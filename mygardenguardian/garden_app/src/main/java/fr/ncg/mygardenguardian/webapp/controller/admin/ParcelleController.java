package fr.ncg.mygardenguardian.webapp.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ncg.mygardenguardian.business.BusinessManagerFactoryImpl;
import fr.ncg.mygardenguardian.dto.AdhesionDTO;
import fr.ncg.mygardenguardian.dto.ParcelleDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.ParcelleFormulaire;

@Controller
public class ParcelleController {

	private BusinessManagerFactoryImpl managerFacto;

	@GetMapping("admin/modification_parcelle")
	public String goModifParcelle(Model model, HttpServletRequest req) {
		Map<ParcelleDTO, AdhesionDTO> parcellesListe = new HashMap<ParcelleDTO, AdhesionDTO>();
		List<ParcelleDTO> parcelles = this.managerFacto.getParcelleManager().trouverToutesParcelles();
		parcelles.stream().forEachOrdered(p -> {
			if (this.managerFacto.getAdhesionManager().trouverAdhesionIdParcelle(p.getIdParcelle()) != null) {
				parcellesListe.put(p,
						this.managerFacto.getAdhesionManager().trouverAdhesionIdParcelle(p.getIdParcelle()));
			} else {
				parcellesListe.put(p, null);
			}
		});
		model.addAttribute("parcelleForm", new ParcelleFormulaire());
		model.addAttribute("parcellesListe", parcellesListe);

		return "admin/gestion_parcelle";
	}

	@PostMapping("admin/modification_parcelle")
	public String modifierParcelle(@Valid @ModelAttribute("parcelleForm") @RequestBody ParcelleFormulaire parcelleForm,
			BindingResult errors, Model model, RedirectAttributes parcelleCree) {

		if (errors.hasErrors()) {
			System.out.println(errors.toString());
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("parcelleForm", parcelleForm);
			return ("admin/modification_parcelle");
		}

		ParcelleDTO maParcelle = new ParcelleDTO();
		maParcelle.setCode(parcelleForm.getCode());
		maParcelle.setSurface(parcelleForm.getSurface());
		maParcelle.setIdParcelle(parcelleForm.getIdParcelle());
		this.managerFacto.getParcelleManager().enregistrerParcelle(maParcelle);
		parcelleCree.addFlashAttribute("parcelleModif", maParcelle);
		return "redirect:/admin/accueil";
	}

	public BusinessManagerFactoryImpl getManagerFacto() {
		return this.managerFacto;
	}

	@Autowired
	public void setManagerFacto(BusinessManagerFactoryImpl managerFacto) {
		this.managerFacto = managerFacto;
	}

}
