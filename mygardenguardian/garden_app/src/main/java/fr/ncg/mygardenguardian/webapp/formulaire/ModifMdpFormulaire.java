package fr.ncg.mygardenguardian.webapp.formulaire;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import fr.ncg.mygardenguardian.webapp.validator.PasswordsEqualConstraint;

@PasswordsEqualConstraint(message = "passwords are not equal")
public class ModifMdpFormulaire {

	@NotBlank(message = "Un mot de passe est requis")
	private String mdp;
	@NotBlank(message = "Un mot de passe est requis")
	@Valid
	private String mdpConfirm;

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMdpConfirm() {
		return this.mdpConfirm;
	}

	public void setMdpConfirm(String mdpConfirm) {
		this.mdpConfirm = mdpConfirm;
	}

	@Override
	public String toString() {
		return "ModifMdpFormulaire [mdp=" + this.mdp + ", mdpConfirm=" + this.mdpConfirm + "]";
	}

}
