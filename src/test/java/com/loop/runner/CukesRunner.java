package com.loop.runner;
//helps us to run feature file
//monochrome gives you right one

import io.cucumber.junit.Cucumber;  //coming from pomxml cucumber junit
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;  //coming from junit

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber-reports.html",
                "json:target/json-reports/json-report",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/features",    //copy/path right click from loginfeature
        glue = "com/loop/step_definitions",
        dryRun = false,            //generate snippet
        tags = "@soft",
        monochrome = true,
        publish = true
)

public class CukesRunner {

}
