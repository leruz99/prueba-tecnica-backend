package com.prueba.backeend.exeptions;

public class UserRetrievalException extends RuntimeException{
    public UserRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }
}
