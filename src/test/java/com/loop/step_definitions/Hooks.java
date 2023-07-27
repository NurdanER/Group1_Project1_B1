package com.loop.step_definitions;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DB_Util;
import com.loop.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    private static final Logger LOG = LogManager.getLogger();


    @Before
    public void setUp(Scenario scenario){
        Driver.getDriver();
        BrowserUtils.myScenario = scenario;
        LOG.info("...........START AUTOMATION.......LOOP ACADEMY......");
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
         LOG.info(".............END AUTOMATION........LOOP ACADEMY.....");


}
    @Before ("@smoke")
    public void setUpDB(){
        String ip = ConfigurationReader.getProperty("docuportUrl");
        String un = ConfigurationReader.getProperty("dbUserName");
        String pw = ConfigurationReader.getProperty("dbPassword");

        DB_Util.createConnection(ip, un, pw);
    }


    @After("@smoke")
    public void destroyDB () {
        DB_Util.destroy();
    }



}
