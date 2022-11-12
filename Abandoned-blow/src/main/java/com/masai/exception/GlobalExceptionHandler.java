package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler extends Exception{

    
    @ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> OtherExceptionHandler(Exception exp, WebRequest req){
		ErrorDetails authExp = new ErrorDetails();
		authExp.setTimestamp(LocalDateTime.now());
		authExp.setMessage(exp.getMessage());
		authExp.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authExp,HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exp) {
		
		ErrorDetails authExp = new ErrorDetails();
		authExp.setTimestamp(LocalDateTime.now());
		authExp.setMessage("Validation Error");
		authExp.setDescription(exp.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(authExp,HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(TourPackageException.class)
	public ResponseEntity<ErrorDetails> TourPackageExceptionHandler(TourPackageException te, WebRequest req){
		ErrorDetails ted = new ErrorDetails();
		ted.setTimestamp(LocalDateTime.now());
		ted.setMessage(te.getMessage());
		ted.setDescription(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ted,HttpStatus.BAD_REQUEST);
	}
}