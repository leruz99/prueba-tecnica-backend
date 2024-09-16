package com.prueba.backeend.exeptions;

public class UserRegistrationException extends RuntimeException{
    public UserRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
