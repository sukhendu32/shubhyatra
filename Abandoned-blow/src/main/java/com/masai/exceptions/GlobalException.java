package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> customerException(UserException ex, WebRequest wr)
	{
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTime(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
	
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
	
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(BookingException.class)
	public ResponseEntity<MyErrorDetails> bookingException(BookingException ex, WebRequest wr)
	{
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTime(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(FlightException.class)
	public ResponseEntity<MyErrorDetails> flightException(FlightException ex, WebRequest wr)
	{
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTime(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HotelException.class)
	public ResponseEntity<MyErrorDetails> hotelException(HotelException ex, WebRequest wr)
	{
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTime(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TourPackageException.class)
	public ResponseEntity<MyErrorDetails> tourPackageException(TourPackageException ex, WebRequest wr)
	{
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTime(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception ex, WebRequest wr)
	{
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTime(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	

}
