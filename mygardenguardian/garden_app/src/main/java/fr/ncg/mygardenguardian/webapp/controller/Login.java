package fr.ncg.mygardenguardian.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {
	@GetMapping("/")
	public String home1() {
		return "/login";
	}

	@GetMapping("/home")
	public String home() {
		return "/login";
	}

	// @GetMapping("/admin")
	// public String admin() {
	// return "/admin";
	// }
	//
	// @GetMapping("/user")
	// public String user() {
	// return "/user";
	// }
	//
	// @GetMapping("/about")
	// public String about() {
	// return "/about";
	// }

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/403")
	public String error403() {
		return "/errors/403";
	}
}
