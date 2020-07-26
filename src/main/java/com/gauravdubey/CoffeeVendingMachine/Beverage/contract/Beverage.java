package com.gauravdubey.CoffeeVendingMachine.Beverage.contract;
import com.gauravdubey.CoffeeVendingMachine.enums.Ingredients;

import java.util.Map;

public interface Beverage {
    Map<Ingredients, Integer> getIngredients();
}
