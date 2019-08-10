package fr.ncg.mygardenguardian.webapp.utils;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.dto.UtilisateurDTO;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	private HttpSession session;
	private IBusinessManagerFactory businessManager;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		UtilisateurDTO monUtilisateur;
		if (authentication.getPrincipal() instanceof Principal) {
			monUtilisateur = this.businessManager.getUtilisateurManager()
					.trouverUtilisateurParNom(((Principal) authentication.getPrincipal()).getName());

		} else {
			monUtilisateur = this.businessManager.getUtilisateurManager()
					.trouverUtilisateurParNom((((User) authentication.getPrincipal()).getUsername()));
		}
		System.out.println("id utilisateur : " + monUtilisateur.getIdUtilisateur());
		// HttpSession session = request.getSession();
		this.session.setAttribute("idUtilisateur", monUtilisateur.getIdUtilisateur());
		response.sendRedirect("/accueil");

	}

	public HttpSession getSession() {
		return this.session;
	}

	@Autowired
	public void setSession(HttpSession session) {
		this.session = session;
	}

	public IBusinessManagerFactory getBusinessManager() {
		return this.businessManager;
	}

	@Autowired
	public void setBusinessManager(IBusinessManagerFactory businessManager) {
		this.businessManager = businessManager;
	}

}
