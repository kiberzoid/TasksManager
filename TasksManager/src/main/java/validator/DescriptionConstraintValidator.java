package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DescriptionConstraintValidator implements ConstraintValidator<DescriptionConstraint,String>{
	
	@Override
	public void initialize(DescriptionConstraint constraintAnnotation) {}
	
	@Override
	public boolean isValid(String description, ConstraintValidatorContext context) {
		if(description!=null && description.length()>=4 && description.length()<=20)
			return true;
		return false;
	}
}
