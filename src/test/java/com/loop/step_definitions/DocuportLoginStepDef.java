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


    }





}
