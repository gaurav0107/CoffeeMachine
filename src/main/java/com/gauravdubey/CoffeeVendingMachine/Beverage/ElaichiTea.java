package com.gauravdubey.CoffeeVendingMachine.Beverage;

import com.gauravdubey.CoffeeVendingMachine.Beverage.contract.Beverage;
import com.gauravdubey.CoffeeVendingMachine.enums.Ingredients;

import java.util.Map;

public class ElaichiTea implements Beverage {

    Map<Ingredients, Integer> requiredIngredients;

    public ElaichiTea(Map<Ingredients, Integer> requiredIngredients) {
        this.requiredIngredients = requiredIngredients;
    }

    @Override
    public Map<Ingredients, Integer> getIngredients() {
        return requiredIngredients;
    }
}
