package fr.ncg.mygardenguardian.webapp.controller.user;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.business.impl.security.GardenGuardianAppUser;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;
import fr.ncg.mygardenguardian.webapp.formulaire.MotSecretFormulaire;
import fr.ncg.mygardenguardian.webapp.utils.SymetricCrypto;

@Controller
public class ExportCalendrierController {

	private static String URL_PREF = "127.0.0.1:8181/API/ical?idJardinier=";

	private IBusinessManagerFactory businessManager;

	private SymetricCrypto encryptor = new SymetricCrypto();

	@GetMapping("user/export_calendrier")
	public String goExporCalendrier(Model model) {
		model.addAttribute("motSecretForm", new MotSecretFormulaire());
		return "user/export_calendrier";
	}

	@PostMapping("user/export_calendrier")
	public String generationUrlExport(HttpServletRequest req, Model model, RedirectAttributes url)
			throws InvalidKeyException, UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException,
			BadPaddingException, IllegalBlockSizeException {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
		Integer idUtilisateur = monUser.getIdUtilisateur();
		UtilisateurDTO monUtilisateur = this.businessManager.getUtilisateurManager()
				.trouverUtilisateurParId(idUtilisateur);

		String monUrl = URL_PREF + Base64.getEncoder()
				.encodeToString(this.encryptor.encryptMessage(monUtilisateur.getUuid().getBytes()));
		System.out.println("CTRL creation url ------------------- " + monUrl);
		url.addFlashAttribute("url", monUrl);

		return "redirect:/user/export_calendrier";
	}

	public IBusinessManagerFactory getBusinessManager() {
		return this.businessManager;
	}

	@Autowired
	public void setBusinessManager(IBusinessManagerFactory businessManager) {
		this.businessManager = businessManager;
	}

}
