package com.ilyachuvaev.indoctrination.exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message){super(message); }
}
