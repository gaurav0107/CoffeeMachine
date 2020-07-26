package com.gauravdubey.CoffeeVendingMachine.enums;

public enum BeverageType {
    ginger_tea("ginger_tea"), elaichi_tea("elaichi_tea"),
    coffee("hot_coffee"), black_tea("black_tea"),
    green_tea("green_tea"),
    hot_milk("hot_milk"), hot_water("hot_water");
    private String name;

    BeverageType(String value) {
        name = value;
    }

    public String getName() {
        return name;
    }
}
