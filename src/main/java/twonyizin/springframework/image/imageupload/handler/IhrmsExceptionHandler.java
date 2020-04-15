package twonyizin.springframework.image.imageupload.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import twonyizin.springframework.image.imageupload.exception.ExceptionResponse;
import twonyizin.springframework.image.imageupload.exception.ResourceNotFoundException;


/**
 * @author TheinZaw
 */
@ControllerAdvice
@RestControllerAdvice
public class IhrmsExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex,
																				   WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(false, ex.getMessage(), new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

}
