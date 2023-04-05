package com.revature.Exceptions;

public class InvalidInputException extends Exception {

    public InvalidInputException(){
        super("Invalid username or password");
    }

}
