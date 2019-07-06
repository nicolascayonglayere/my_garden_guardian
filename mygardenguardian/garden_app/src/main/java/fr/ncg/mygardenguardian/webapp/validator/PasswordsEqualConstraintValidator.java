package fr.ncg.mygardenguardian.webapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;

import fr.ncg.mygardenguardian.webapp.formulaire.InscriptionFormulaire;

public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		InscriptionFormulaire user = (InscriptionFormulaire) value;
		return user.getMdp().equals(user.getMdpConfirm());
	}

	public static <T> String getValidationMessage(ConstraintViolation<T> violation) {
		String className = violation.getRootBeanClass().getSimpleName();
		String property = violation.getPropertyPath().toString();
		// Object invalidValue = violation.getInvalidValue();
		String message = violation.getMessage();
		return String.format("%s.%s %s", className, property, message);
	}

}
