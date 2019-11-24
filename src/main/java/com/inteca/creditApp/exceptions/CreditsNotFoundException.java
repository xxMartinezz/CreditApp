package com.inteca.creditApp.exceptions;

public class CreditsNotFoundException extends RuntimeException
{
    public CreditsNotFoundException() { }

    public CreditsNotFoundException(String message) {
        super(message);
    }
}
