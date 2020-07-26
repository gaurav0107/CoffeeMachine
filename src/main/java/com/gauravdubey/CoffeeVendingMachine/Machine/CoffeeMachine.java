package com.gauravdubey.CoffeeVendingMachine.Machine;

import com.gauravdubey.CoffeeVendingMachine.Beverage.contract.Beverage;
import com.gauravdubey.CoffeeVendingMachine.Exceptions.IngredientsNotAvailableException;
import com.gauravdubey.CoffeeVendingMachine.Exceptions.InsufficientIngredientsException;
import com.gauravdubey.CoffeeVendingMachine.enums.Ingredients;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public abstract class CoffeeMachine {

    ExecutorService executorService;

    public abstract Integer getOutlets();

    public abstract Map<Ingredients, Integer> getIngredients();

    public void prepareBeverage(Beverage beverage) throws Exception {
        if(executorService == null){
            throw new Exception("Machine is Not Started Yet");
        }
        executorService.execute(new Runnable() {
            public void run() {
                String resultMessage;
                try {
                    preparingBeverage(beverage);
                    resultMessage =  beverage.getClass().getSimpleName() + " is prepared";
                }catch (IngredientsNotAvailableException| InsufficientIngredientsException ex){
                    resultMessage = ex.getMessage();
                }
                System.out.println(resultMessage);
            }
        });
    }

    public Beverage preparingBeverage(Beverage beverage) throws IngredientsNotAvailableException, InsufficientIngredientsException{
        updateIngredients(beverage);
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return beverage;
    }

    @Synchronized
    public void updateIngredients(Beverage beverage) throws IngredientsNotAvailableException, InsufficientIngredientsException{
        Map<Ingredients, Integer> requiredIngredients = beverage.getIngredients();
        requiredIngredients.forEach((ingredients, value) -> {
            if(!getIngredients().containsKey(ingredients)){
                throw new IngredientsNotAvailableException(ingredients.getName());
            }
            if(getIngredients().get(ingredients) < value){
                throw new InsufficientIngredientsException(ingredients.getName());
            }
        });
        requiredIngredients.forEach((ingredients, value) -> {
            getIngredients().put(ingredients, getIngredients().get(ingredients) - value);
        });

    }

    public void startMachine(){
        executorService = Executors.newFixedThreadPool(getOutlets());
        System.out.println("Coffee Machine Started");
    }

    public void stopMachine(){
        executorService.shutdown();
    }

    public void getIngredientsStatus(){
        System.out.println(getIngredients());
    }

    public void refillIngredients(Map<Ingredients, Integer> ingredientsMap){
        System.out.println(getIngredients());
    }
}
