package StepDefinitions;

import io.cucumber.java.After;
import utilities.DriverManager;

public class Hook {
    @After
    public void afterScenario(){
        DriverManager.getDriver().driver.close();
    }
}
