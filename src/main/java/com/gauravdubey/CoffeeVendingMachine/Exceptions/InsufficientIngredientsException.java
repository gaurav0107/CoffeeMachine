package com.gauravdubey.CoffeeVendingMachine.Exceptions;

public class InsufficientIngredientsException extends RuntimeException{
    public InsufficientIngredientsException(String message){
        super(message  + " is not sufficient");
    }

}
