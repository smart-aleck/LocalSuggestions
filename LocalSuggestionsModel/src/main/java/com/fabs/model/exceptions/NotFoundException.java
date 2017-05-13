package com.fabs.model.exceptions;

public class NotFoundException extends Exception {

    public NotFoundException(String text){
        super(text);
    }
    public NotFoundException(Object object, Throwable throwable){
        super(object.toString(), throwable);
    }
}
