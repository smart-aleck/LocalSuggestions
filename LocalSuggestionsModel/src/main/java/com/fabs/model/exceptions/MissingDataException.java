package com.fabs.model.exceptions;

public class MissingDataException extends Exception {

    public MissingDataException(Object object, Throwable throwable){
        super(object.toString(), throwable);
    }
}
