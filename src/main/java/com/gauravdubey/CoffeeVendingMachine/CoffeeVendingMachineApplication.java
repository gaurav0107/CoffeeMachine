package com.gauravdubey.CoffeeVendingMachine;

import com.gauravdubey.CoffeeVendingMachine.Beverage.contract.BeverageFactory;
import com.gauravdubey.CoffeeVendingMachine.Beverage.factory.BeverageFactoryImpl;
import com.gauravdubey.CoffeeVendingMachine.ConfigParser.ConfigParser;
import com.gauravdubey.CoffeeVendingMachine.Machine.CoffeeMachine;
import com.gauravdubey.CoffeeVendingMachine.Machine.CoffeeMachineImpl;
import com.gauravdubey.CoffeeVendingMachine.enums.BeverageType;
import com.gauravdubey.CoffeeVendingMachine.enums.Ingredients;
import com.gauravdubey.CoffeeVendingMachine.ConfigParser.MachineConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class CoffeeVendingMachineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeVendingMachineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting Application");
		String fileName = "input.json";
		if(args.length > 0){
			fileName = args[0];
		}
		ConfigParser configParser =  new ConfigParser();
		MachineConfig machineConfig = configParser.getMachineConfig(fileName);
		Map<BeverageType, Map<Ingredients, Integer>> orderList = configParser.getOrderList(fileName);
		CoffeeMachine coffeeMachine = new CoffeeMachineImpl(machineConfig);
		coffeeMachine.startMachine();
		BeverageFactory beverageFactory = new BeverageFactoryImpl();

		orderList.forEach((beverageType, ingredientsIntegerMap) -> {
			try {
				coffeeMachine.prepareBeverage(beverageFactory.createBeverage(beverageType, ingredientsIntegerMap));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		coffeeMachine.stopMachine();
	}
}
