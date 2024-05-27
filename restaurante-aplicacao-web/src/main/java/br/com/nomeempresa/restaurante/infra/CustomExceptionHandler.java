package br.com.nomeempresa.restaurante.infra;

import br.com.nomeempresa.restaurante.adapters.inbound.response.ApiErrorMessage;
import br.com.nomeempresa.restaurante.core.exception.CoreExceptionNegocial;
import br.com.nomeempresa.restaurante.exception.CustomerAlreadyExistsException;
import br.com.nomeempresa.restaurante.exception.ResourceNotFound;
import jakarta.validation.ValidationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value
        = { IllegalArgumentException.class, IllegalStateException.class, ValidationException.class, CoreExceptionNegocial.class})
    protected ResponseEntity<Object> handleConflict(
        Exception ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<String> errors = Collections.singletonList(ex.getMessage());


        if (ex instanceof MethodArgumentNotValidException bindException) {
            errors = bindException.getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        }

        return handleExceptionInternal(ex, new ApiErrorMessage(status, errors),
            new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {
        RuntimeException.class
    })
    protected ResponseEntity<Object> handleInternal(
        Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return createResponseEntity( new ApiErrorMessage(status, List.of(ex.getMessage())),
            new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {
        NoSuchElementException.class,
        ResourceNotFound.class
    })
    protected ResponseEntity<Object> handleNotFound(
        Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return createResponseEntity( new ApiErrorMessage(status, List.of(ex.getMessage())),
            new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    protected ResponseEntity<Object> handleCustomerAlreadyExists(CustomerAlreadyExistsException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());

        return ResponseEntity.status(status).body(response);
    }


}