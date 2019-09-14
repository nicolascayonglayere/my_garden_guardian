package fr.ncg.mygardenguardian.webapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;

import fr.ncg.mygardenguardian.webapp.formulaire.culture.EnregistrementPlanteBddFormulaire;
import fr.ncg.mygardenguardian.webapp.formulaire.culture.ModifPlanteFormulaire;

public class RecomHauteSupRecomBasseConstraintValidator
		implements ConstraintValidator<RecomHauteSupRecomBasseConstraint, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value instanceof EnregistrementPlanteBddFormulaire) {
			EnregistrementPlanteBddFormulaire monFormSave = (EnregistrementPlanteBddFormulaire) value;
			return monFormSave.getRecommandationHaute() > monFormSave.getRecommandationBasse();
		} else if (value instanceof ModifPlanteFormulaire) {
			ModifPlanteFormulaire monFormModif = (ModifPlanteFormulaire) value;
			return monFormModif.getRecommandationHaute() > monFormModif.getRecommandationBasse();
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
