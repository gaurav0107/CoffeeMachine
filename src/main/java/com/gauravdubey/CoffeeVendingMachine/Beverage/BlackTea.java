package com.gauravdubey.CoffeeVendingMachine.Beverage;
import com.gauravdubey.CoffeeVendingMachine.Beverage.contract.Beverage;
import com.gauravdubey.CoffeeVendingMachine.enums.Ingredients;

import java.util.Map;

public class BlackTea implements Beverage {

    Map<Ingredients, Integer> requiredIngredients;

    public BlackTea(Map<Ingredients, Integer> requiredIngredients) {
        this.requiredIngredients = requiredIngredients;
    }

    @Override
    public Map<Ingredients, Integer> getIngredients() {
        return this.requiredIngredients;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing :" + this.getClass().getSimpleName());
    }
}
