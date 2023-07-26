package com.loop.runner;


import io.cucumber.junit.Cucumber;  //coming from pomxml cucumber junit
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;  //coming from junit

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber-reports.html",
                "json:target/json-reports/json-report",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/features",
        glue = "com/loop/step_definitions",
        dryRun = false,
        tags = "@smoke",
        monochrome = true,
        publish = false
)

public class CukesRunner {

}


//In Big project we can have more than one runner classes, instead of playing with tag each runner class run different tags
