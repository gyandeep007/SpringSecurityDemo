package com.gyan.customerservice.customerservice.exception;


import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandling {
    @Value(value = "${data.exception.message1}")
    private String message1;


    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity customerNotFound(CustomerNotFound customerNotFound){
        return new ResponseEntity(customerNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(SQLException.class)
//    public ResponseEntity sqlException(SQLException sqlException){
//        return new ResponseEntity(sqlException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity jdbcException(JDBCConnectionException jdbcConnectionException){
        return new ResponseEntity(jdbcConnectionException.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
