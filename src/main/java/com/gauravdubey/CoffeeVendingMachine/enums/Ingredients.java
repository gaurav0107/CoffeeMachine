package com.gauravdubey.CoffeeVendingMachine.enums;

public enum Ingredients {
    hot_water("hot_water"), hot_milk("hot_milk"), ginger_syrup("ginger_syrup"),
    sugar_syrup("sugar_syrup"), tea_leaves_syrup("tea_leaves_syrup"),
    green_mixture("green_mixture"),
    coffee_syrup("coffee_syrup"), elaichi_syrup("elaichi_syrup");
    private String name;

    Ingredients(String value) {
        name = value;
    }

    public String getName() {
        return name;
    }
}
