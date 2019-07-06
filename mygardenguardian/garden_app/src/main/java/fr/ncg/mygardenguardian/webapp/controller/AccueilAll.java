package fr.ncg.mygardenguardian.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilAll {

	@GetMapping("/accueil")
	public String accueilAll() {
		return "/accueil";
	}
}
