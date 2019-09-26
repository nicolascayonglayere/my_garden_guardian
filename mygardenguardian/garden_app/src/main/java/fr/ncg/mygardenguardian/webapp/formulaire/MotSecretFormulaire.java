package fr.ncg.mygardenguardian.webapp.formulaire;

import javax.validation.constraints.NotBlank;

public class MotSecretFormulaire {

	@NotBlank
	private String motSecret;

	public String getMotSecret() {
		return this.motSecret;
	}

	public void setMotSecret(String motSecret) {
		this.motSecret = motSecret;
	}

}
