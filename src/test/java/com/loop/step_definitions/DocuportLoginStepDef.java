package com.loop.step_definitions;

import com.loop.pages.DocuportBasePage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.Map;

public class DocuportLoginStepDef {

    LoginPage loginPage = new LoginPage();
    DocuportBasePage docuportBasePage = new DocuportBasePage();
    private static final Logger LOG = LogManager.getLogger();



    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }
    @When("user enters credentials for supervisor role")
    public void user_enters_credentials_for_supervisor_role() {
        loginPage.loginDocuport(ConfigurationReader.getProperty("supervisor"),ConfigurationReader.getProperty("password"));
        LOG.info("User successfully logged in as an Supervisor");

    }

    @Then("user should see the home page for supervisor")
    public void user_should_see_the_home_page_for_supervisor() {
        Assert.assertTrue("Login unsuccessful", docuportBasePage.homePage.isDisplayed());
        LOG.info("Home Page for supervisor is displayed");



    }

    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        Assert.assertTrue( docuportBasePage.homePage.isDisplayed());
        LOG.info("Home Page for advisor is displayed");

    }

    @When("user enters credentials for advisor role")
    public void user_enters_credentials_for_advisor_role() {
        loginPage.loginDocuport(ConfigurationReader.getProperty("advisor"),ConfigurationReader.getProperty("password"));

        LOG.info("User successfully logged in as an Advisor");

    }

    @When("user enters credentials for client role")
    public void user_enters_credentials_for_client_role() {
        loginPage.loginDocuport(ConfigurationReader.getProperty("client"), ConfigurationReader.getProperty("password"));
        LOG.info("User successfully logged in as an Client");

    }
    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
        Assert.assertTrue("Login unsuccessful", docuportBasePage.homePage.isDisplayed());
        LOG.info("Home Page for client is displayed");


    }
    @When("user enters credentials")
    public void user_enters_credentials(Map< String, String> credentials) {
        for(Map.Entry<String, String> entry : credentials.entrySet()){
            String key =entry.getKey();
            System.out.println("key = " +key);
            String value =entry.getValue();
            System.out.println("value = " + value);
        }
       loginPage.loginDocuport(credentials.get("username"), credentials.get("password"));
        LOG.info("Home Page with Map practice for client is displayed");




    }
    @When("user enters credentials for employee role")
    public void user_enters_credentials_for_employee_role() {
        loginPage.loginDocuport(ConfigurationReader.getProperty("employee"),ConfigurationReader.getProperty("password"));
        LOG.info("User successfully logged in as a employee ");
    }
    @Then("user should see the home page for employee")
    public void user_should_see_the_home_page_for_employee() {
        Assert.assertTrue("Login unsuccessful", docuportBasePage.homePage.isDisplayed());
        LOG.info("Home Page for employee is displayed");

    }


}
