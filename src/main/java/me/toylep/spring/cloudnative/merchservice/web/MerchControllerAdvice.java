package me.toylep.spring.cloudnative.merchservice.web;

import me.toylep.spring.cloudnative.merchservice.domain.MerchAlreadyExistsException;
import me.toylep.spring.cloudnative.merchservice.domain.MerchNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MerchControllerAdvice {

    @ExceptionHandler(MerchNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String merchNotFoundHandler(MerchNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(MerchAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String merchAlreadyExistsHandler(MerchAlreadyExistsException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
