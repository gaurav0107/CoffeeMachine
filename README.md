# CoffeeMachine


Project is Creating Using Spring Boot.

## Supported Beverage Type
ginger_tea, elaichi_tea, coffee, black_tea, green_tea, hot_milk, hot_water;

## Supported Ingredients 
hot_water, hot_milk, ginger_syrup, sugar_syrup, tea_leaves_syrup, green_mixture, coffee_syrup, elaichi_syrup



### Install

```mvn package```

### Run 
``` ./run.sh input.json```


## Sample Input.json
```
{
  "machine": {
    "outlets": {
      "count_n": 3
    },
    "total_items_quantity": {
      "hot_water": 500,
      "hot_milk": 500,
      "ginger_syrup": 100,
      "sugar_syrup": 100,
      "tea_leaves_syrup": 100
    },
    "beverages": {
      "ginger_tea": {
        "hot_water": 200,
        "hot_milk": 100,
        "ginger_syrup": 10,
        "sugar_syrup": 10,
        "tea_leaves_syrup": 30
      },
      "coffee": {
        "hot_water": 100,
        "hot_milk": 400,
        "sugar_syrup": 50,
        "coffee_syrup": 30
      },
      "black_tea": {
        "hot_water": 300,
        "tea_leaves_syrup": 30
      },
      "green_tea": {
        "hot_water": 100,
        "green_mixture": 30
      },
    }
  }
}

```
