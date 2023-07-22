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
        features = "src/test/resources/features",    //copy/path right click from loginfeature   //busniess part of cucumber
        glue = "com/loop/step_definitions", //cucumber the location of our step definitions   //glue tells the code
        dryRun = false,            //generate snippet
        tags = "@nana",    //which tag we wanna run
        monochrome = true,    //extra log
        publish = false   //publishing run in somewhere
)

public class CukesRunner {

}


//In Big project we can have more than one runner classes, instead of playing with tag each runner class run different tags
