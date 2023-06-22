package com.loop.runner;
//helps us to run feature file


import io.cucumber.junit.Cucumber;  //coming from pomxml cucumber junit
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;  //coming from junit

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",    //copy/path right click from loginfeature
        glue = "com/loop/step_definitions"
)

public class CukesRunner {
}
