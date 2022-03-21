package com.bci.BCIProject.exception;

import com.bci.BCIProject.model.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Adviser {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<ErrorResponse> handleDuplcatedItem(DataIntegrityViolationException e){
        return new ResponseEntity(new ErrorResponse("500", "Item duplicado, ya existe el correo "), HttpStatus.ALREADY_REPORTED);

    }

    @ExceptionHandler(TransactionSystemException.class)
    public final ResponseEntity<ErrorResponse> handleTransactionSystemException(TransactionSystemException e){
        return new ResponseEntity(new ErrorResponse("500", "Email inválido o password inseguro"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleItemNotFoundException(ItemNotFoundException e){
        return  new ResponseEntity(new ErrorResponse("404", "Item no encontrado"), HttpStatus.NOT_FOUND);
    }

}
