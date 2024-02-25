package com.example.geektrust.exception;

public class ProcessingException extends RuntimeException {
  public ProcessingException() {
    super();
  }
  
  public ProcessingException(String exceptionMessage) {
    super(exceptionMessage);
  }
}