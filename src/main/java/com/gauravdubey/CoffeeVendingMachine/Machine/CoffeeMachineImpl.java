package com.gauravdubey.CoffeeVendingMachine.Machine;

import com.gauravdubey.CoffeeVendingMachine.enums.Ingredients;
import com.gauravdubey.CoffeeVendingMachine.ConfigParser.MachineConfig;

import java.util.Map;

public class CoffeeMachineImpl extends CoffeeMachine {

    MachineConfig machineConfig;

    @Override
    public Integer getOutlets() {
        return this.machineConfig.getOutlets();
    }

    @Override
    public Map<Ingredients, Integer> getIngredients() {
        return this.machineConfig.getIngredientsQuantity();
    }

    public CoffeeMachineImpl(MachineConfig machineConfig) {
        this.machineConfig = machineConfig;
    }
}
