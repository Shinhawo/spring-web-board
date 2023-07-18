package kr.co.jhta.web.advice;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	   @ExceptionHandler(Exception.class)
	   public String handleException(Exception ex) {
	      return "error/unknown";
	   }
	   
	   @ExceptionHandler(RuntimeException.class)
	   public String handleRuntimeException(RuntimeException ex) {
	      return "error/server";
	   }

	   @ExceptionHandler(DataAccessException.class)
	   public String handleDataAccessException(DataAccessException ex) {
	      return "error/db";
	   }
	   
	   @ExceptionHandler(AccessDeniedException.class)
	   public String handleAccessDeniedException(AccessDeniedException ex) {
	      throw ex;
	   }
}
