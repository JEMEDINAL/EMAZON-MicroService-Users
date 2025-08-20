package com.emazon.microservice_usuario.adapter.out.errorhandler;

import com.emazon.microservice_usuario.domain.exception.InvalidEmail;
import com.emazon.microservice_usuario.domain.exception.InvalidPhoneNumber;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandlerUser {
    private static final String MESSAGE = "Message";
    private static final String STATUS = "Status";
    private static final String TIMESTAMP = "TimeStamp";

    @ExceptionHandler(MismatchedInputException.class)
    public ResponseEntity<Map<String,String>> dataTypeError(MismatchedInputException ex){
        Map<String,String> errorDetails = new HashMap<>();
        String field = null;
        if (ex.getPath() != null && !ex.getPath().isEmpty()) {
            field = ex.getPath().get(0).getFieldName();
        }
        String message = "Invalid data type error in field: ";
        errorDetails.put(MESSAGE, message.concat(field));
        errorDetails.put(STATUS, HttpStatus.BAD_REQUEST.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validClassIn(MethodArgumentNotValidException ex){
        Map<String,String> errorDetails = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->
                errorDetails.put(error.getField(),error.getDefaultMessage()));
        errorDetails.put(STATUS, HttpStatus.BAD_REQUEST.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(InvalidEmail.class)
    public ResponseEntity<Map<String,String>> invalidEmail(InvalidEmail ex){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, ex.getMessage());
        errorDetails.put(STATUS, HttpStatus.BAD_REQUEST.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
    @ExceptionHandler(InvalidPhoneNumber.class)
    public ResponseEntity<Map<String,String>> invalidPhoneNumber(InvalidPhoneNumber ex){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, ex.getMessage());
        errorDetails.put(STATUS, HttpStatus.BAD_REQUEST.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
