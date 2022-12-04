package net.hari.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomExp extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CustomExp(String message) {
		super(message);
	}
}