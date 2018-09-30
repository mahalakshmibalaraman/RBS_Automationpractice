package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import wrappers.DriverFactory;

public class Hooks {
	
	@Before
    public void beforeScenario(Scenario scenario){
        System.out.println("Execution Started for scenario "+scenario.getName());
    }
 
	@After
    public static void afterScenario(Scenario scenario){
        
		DriverFactory.driver.quit();
		System.out.println("Execution completed for scenario "+scenario.getName());
    }
}
