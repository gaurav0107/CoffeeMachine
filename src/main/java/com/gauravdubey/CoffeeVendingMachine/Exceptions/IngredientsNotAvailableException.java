package com.gauravdubey.CoffeeVendingMachine.Exceptions;

public class IngredientsNotAvailableException extends RuntimeException {
    public IngredientsNotAvailableException(String message) {
        super(message +  " is not available");
    }

}


