package com.prueba.backeend.exeptions;

public class InvalidPasswordFormatException extends RuntimeException{
    public InvalidPasswordFormatException(String message) {
        super(message);
    }
}
