package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import entity.Task;

@Service
public class TaskValidator implements org.springframework.validation.Validator{
	
	@Autowired
	private LocalValidatorFactoryBean factory;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Task.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty", "Invalid id");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.empty", "Invalid description");
		if(!errors.hasErrors()) {
			factory.validate(target, errors);
			Task task = (Task) target;
			if(task.getId() <= 0)
				errors.rejectValue("id", "id.min", "Invalid id");
		}
	}
}
