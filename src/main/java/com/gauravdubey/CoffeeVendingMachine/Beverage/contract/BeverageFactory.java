package com.gauravdubey.CoffeeVendingMachine.Beverage.contract;

import com.gauravdubey.CoffeeVendingMachine.enums.BeverageType;
import com.gauravdubey.CoffeeVendingMachine.enums.Ingredients;

import java.util.Map;

public interface BeverageFactory {
    Beverage createBeverage(BeverageType beverageType, Map<Ingredients, Integer> ingredientsMap) throws Exception;
}
