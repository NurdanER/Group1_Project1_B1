package com.loop.step_definitions;

import com.loop.pages.GoogleSearchPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class GoogleSearchStepDefs {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));

    }
    @When("user types Loop Academy in the google search box and clicks enter")
    public void user_types_loop_academy_in_the_google_search_box_and_clicks_enter() {
        googleSearchPage.searcBox.sendKeys("Loop Academy" + Keys.ENTER);

    }
    @Then("user should see Loop Academy - Google Search in the google title")
    public void user_should_see_loop_academy_google_search_in_the_google_title() {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("expected does Not match the actual", "Loop Academy - Google Search", actualTitle);

    }
    @When("user types {string} in the google search box and click enter")
    public void user_types_in_the_google_search_box_and_click_enter(String input) {
  googleSearchPage.searcBox.sendKeys(input + Keys.ENTER);
    }
    @Then("User should see {string} is in the google title")
    public void user_should_see_search_is_in_the_google_title(String title) {
        Assert.assertEquals("Expected does Not match actual",title, Driver.getDriver().getTitle());

    }
    @Then("user searches the following item")
    public void user_searches_the_following_item(List<Map<String, String>>items) {     //run several steps in one scenario   //we stored data in List
      /*  items.forEach(p -> {
            googleSearchPage.searcBox.clear();           //it will clear after writes one word then it will  write other text
            googleSearchPage.searcBox.sendKeys(p + Keys.ENTER);
            Assert.assertEquals(p + " - Google Search", Driver.getDriver().getTitle());
        });

       */

     /*   for (String s : items) {
            googleSearchPage.searcBox.clear();
            googleSearchPage.searcBox.sendKeys(s + Keys.ENTER);
            Assert.assertEquals(s + " - Google Search", Driver.getDriver().getTitle());
        }

      */
        for (Map <String, String> item : items) {
            System.out.println(item.get("items"));
            googleSearchPage.searcBox.clear();
            googleSearchPage.searcBox.sendKeys(item.get("items") + Keys.ENTER);
        }


        }
    @When("user searches for the {string}")
    public void user_searches_for_the(String country) {
        googleSearchPage.searcBox.sendKeys("What is the capital of " + country + Keys.ENTER);


    }
    @Then("user should see the {string} in the result")
    public void user_should_see_the_in_the_result(String capital) {
        Assert.assertEquals(googleSearchPage.capital.getText(), capital);



    }

}






