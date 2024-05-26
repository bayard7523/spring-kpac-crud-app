package com.bayard7523.kpac.controller.advice;

import com.bayard7523.kpac.controller.response.BasicResponseErrorMessage;
import com.bayard7523.kpac.exception.KnowledgePackageAlreadyExistsException;
import com.bayard7523.kpac.exception.KnowledgePackageNotFoundException;
import com.bayard7523.kpac.exception.KnowledgePackageSetAlreadyExistsException;
import com.bayard7523.kpac.exception.KnowledgePackageSetNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({KnowledgePackageNotFoundException.class, KnowledgePackageSetNotFoundException.class})
	public ResponseEntity<BasicResponseErrorMessage> handleNotFound(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {
		return toBasicResponseErrorMessage(ex, HttpServletResponse.SC_NOT_FOUND);
	}

	@ExceptionHandler({KnowledgePackageAlreadyExistsException.class, KnowledgePackageSetAlreadyExistsException.class})
	public ResponseEntity<BasicResponseErrorMessage> handleAlreadyExists(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {
		return toBasicResponseErrorMessage(ex, HttpServletResponse.SC_SEE_OTHER);
	}

	private ResponseEntity<BasicResponseErrorMessage> toBasicResponseErrorMessage(Exception ex, int status) {
		final BasicResponseErrorMessage basicResponseErrorMessage = new BasicResponseErrorMessage();

		basicResponseErrorMessage.setTimestamp(LocalDateTime.now());
		basicResponseErrorMessage.setError(ex.getMessage());
		basicResponseErrorMessage.setStatus(status);

		return ResponseEntity.status(status).body(basicResponseErrorMessage);
	}
}
