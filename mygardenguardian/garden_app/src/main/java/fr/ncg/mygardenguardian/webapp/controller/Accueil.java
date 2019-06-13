package fr.ncg.mygardenguardian.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Accueil {

	@GetMapping("/accueil")
	public String getAccueil() {
		return ("accueil");
	}
}
