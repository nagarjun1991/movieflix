package io.nagarjun.movieflix.Exception;

import org.springframework.http.HttpStatus;
 import org.springframework.web.bind.annotation.ResponseStatus;
 
 @ResponseStatus(code=HttpStatus.BAD_REQUEST)
 public class EntityAlreadyExistsException extends RuntimeException {
 
 	private static final long serialVersionUID = 405802649322364762L;
 
 	public EntityAlreadyExistsException(String message) {
 		super(message);
 	}
 
 	public EntityAlreadyExistsException(String message, Throwable cause) {
 		super(message, cause);
 	}
 }
