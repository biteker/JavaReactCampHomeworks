package kodlamaio.hrms.core.utilities.validations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception){
		ValidationError validationError = new ValidationError
				(false, "Validation error.", exception.getBindingResult().getFieldError().getDefaultMessage());
		
		
		return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
		
		
	}
}