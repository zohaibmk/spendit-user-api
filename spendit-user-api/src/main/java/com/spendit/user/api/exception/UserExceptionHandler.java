package com.spendit.user.api.exception;

import com.spendit.user.api.exception.model.Problem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler({InvalidValueException.class})
    public ResponseEntity<Problem> handleBadRequestException(RuntimeException runtimeException) {
        LOGGER.error("Exception handled in UserExceptionHandler: ", runtimeException);

        Problem problem = new Problem();
        problem.setStatus(HttpStatus.BAD_REQUEST.value());
        problem.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
        problem.setMessage(runtimeException.getMessage());

        return new ResponseEntity<>(problem, HttpStatus.BAD_REQUEST);
    }
}
