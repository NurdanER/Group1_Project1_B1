package com.loop.step_definitions;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        Driver.getDriver();
        BrowserUtils.myScenario = scenario;
    }


@Before
    public void setUp() {
    Driver.getDriver();
}

@After
    public void tearDown (Scenario scenario){
         if (scenario.isFailed()) {
             final byte[] screenshoot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
             scenario.attach(screenshoot, "image/png", scenario.getName());

            }
                Driver.closeDriver();


}

}
