package com.gauravdubey.CoffeeVendingMachine.ConfigParser;

import com.gauravdubey.CoffeeVendingMachine.enums.BeverageType;
import com.gauravdubey.CoffeeVendingMachine.enums.Ingredients;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ConfigParser {

    public Map<BeverageType, Map<Ingredients, Integer>> getOrderList(String fileName) throws Exception{
        JSONObject inputObject = new JSONObject(readFile(fileName));
        JSONObject machine = (JSONObject) inputObject.get("machine");
        JSONObject beverages = (JSONObject) machine.get("beverages");
        Map<BeverageType, Map<Ingredients, Integer>> orderList = new LinkedHashMap<>();
        Iterator<String> keys = beverages.keys();
        while (keys.hasNext()){
            String key = keys.next();
            BeverageType beverageType = BeverageType.valueOf(key);
            Map<Ingredients, Integer> ingredientsIntegerMap = new HashMap<>();
            JSONObject beverage = (JSONObject) beverages.get(key);
            Iterator<String> ingredients = beverage.keys();
            while (ingredients.hasNext()){
                String ing = ingredients.next();
                ingredientsIntegerMap.put(Ingredients.valueOf(ing), beverage.getInt(ing));
            }
            orderList.put(beverageType, ingredientsIntegerMap);
        }
        return orderList;
    }

    public MachineConfig getMachineConfig(String fileName) throws Exception {
        JSONObject inputObject = new JSONObject(readFile(fileName));
        JSONObject machine = (JSONObject) inputObject.get("machine");
        JSONObject outlets = (JSONObject) machine.get("outlets");
        JSONObject ingredientsQuantity = (JSONObject) machine.get("total_items_quantity");
        Iterator<String> keys = ingredientsQuantity.keys();
        Map<Ingredients, Integer> ingredientsIntegerMap = new HashMap<>();
        while(keys.hasNext()) {
            String key = keys.next();
            ingredientsIntegerMap.put(Ingredients.valueOf(key), ingredientsQuantity.getInt(key));
        }
        return new MachineConfig(outlets.getInt("count_n"), ingredientsIntegerMap);
    }

    private String readFile(String fileName) throws Exception {
        String inputJson = "";
        try {
            inputJson = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Input file Not Found");
        }
        return inputJson;
    }

}
