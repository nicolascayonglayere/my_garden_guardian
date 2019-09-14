package fr.ncg.mygardenguardian.webapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;

import fr.ncg.mygardenguardian.webapp.formulaire.InscriptionFormulaire;
import fr.ncg.mygardenguardian.webapp.formulaire.ModifMdpFormulaire;

public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		if (value.getClass().isInstance(new InscriptionFormulaire())) {
			InscriptionFormulaire user = (InscriptionFormulaire) value;
			return user.getMdp().equals(user.getMdpConfirm());
		} else if (value.getClass().isInstance(new ModifMdpFormulaire())) {
			ModifMdpFormulaire user = (ModifMdpFormulaire) value;
			return user.getMdp().equals(user.getMdpConfirm());
		} else {
			return false;
		}
	}

	public static <T> String getValidationMessage(ConstraintViolation<T> violation) {
		String className = violation.getRootBeanClass().getSimpleName();
		String property = violation.getPropertyPath().toString();
		String message = violation.getMessage();
		return String.format("%s.%s %s", className, property, message);
	}

}
