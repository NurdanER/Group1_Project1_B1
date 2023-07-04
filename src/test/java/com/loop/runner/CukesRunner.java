package com.loop.runner;
//helps us to run feature file
//monochrome gives you right one

import io.cucumber.junit.Cucumber;  //coming from pomxml cucumber junit
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;  //coming from junit

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-report/cucumber-reports.html",
                  "json:target/json-reports/json-report/" },
        features = "src/test/resources/features",    //copy/path right click from loginfeature
        glue = "com/loop/step_definitions",
        dryRun = false,
        tags = "@nsuue",
        monochrome = true
)

public class CukesRunner {

}
