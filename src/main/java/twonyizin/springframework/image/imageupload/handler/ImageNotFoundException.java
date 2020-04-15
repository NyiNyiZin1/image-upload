package twonyizin.springframework.image.imageupload.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ImageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ImageNotFoundException(String message) {
		super(message);
	}

	public ImageNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}