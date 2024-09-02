package com.matheusz.Carrers_Manager.exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException(){
        super("User already exist");
    }
}
