package com.gauravdubey.CoffeeVendingMachine.Beverage.factory;
import com.gauravdubey.CoffeeVendingMachine.Beverage.*;
import com.gauravdubey.CoffeeVendingMachine.Beverage.contract.Beverage;
import com.gauravdubey.CoffeeVendingMachine.Beverage.contract.BeverageFactory;
import com.gauravdubey.CoffeeVendingMachine.enums.BeverageType;
import com.gauravdubey.CoffeeVendingMachine.enums.Ingredients;

import java.util.Map;

public class BeverageFactoryImpl implements BeverageFactory {

    public Beverage createBeverage(BeverageType beverageType, Map<Ingredients, Integer> ingredientsMap) throws Exception {
        switch (beverageType){
            case ginger_tea:
                return new GingerTea(ingredientsMap);
            case coffee:
                return new Coffee(ingredientsMap);
            case hot_milk:
                return new HotMilk(ingredientsMap);
            case hot_water:
                return new HotWater(ingredientsMap);
            case elaichi_tea:
                return new ElaichiTea(ingredientsMap);
            case black_tea:
                return new BlackTea(ingredientsMap);
            case green_tea:
                return new GreenTea(ingredientsMap);
            default:
                throw new Exception("Beverage Not Available");
        }
    }
}
