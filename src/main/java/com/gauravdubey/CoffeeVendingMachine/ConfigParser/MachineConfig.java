package com.gauravdubey.CoffeeVendingMachine.ConfigParser;

import com.gauravdubey.CoffeeVendingMachine.enums.Ingredients;
import lombok.Data;

import java.util.Map;

@Data
public class MachineConfig {
    Integer outlets;
    Map<Ingredients, Integer> ingredientsQuantity;
    public MachineConfig(Integer outlets, Map<Ingredients, Integer>ingredientsQuantity) {
        this.outlets = outlets;
        this.ingredientsQuantity = ingredientsQuantity;
    }
}
