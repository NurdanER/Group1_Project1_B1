package com.loop.step_definitions;

import com.loop.pages.DocuportAdvisorPage;
import com.loop.pages.DocuportBasePage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportUtils;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class DocuportNewClientStepDef {

    private static final Logger LOG = LogManager.getLogger();


String email = "christina_kachala_256@gmail.com";
String password = "Group1";

    LoginPage loginPage = new LoginPage();
    DocuportAdvisorPage docuportAdvisorPage = new DocuportAdvisorPage();
    DocuportBasePage docuportBasePage = new DocuportBasePage();
    @When("user enters credentials for advisor role")
    public void user_enters_credentials_for_advisor_role() {
    loginPage.loginDocuport(ConfigurationReader.getProperty("advisor"),ConfigurationReader.getProperty("password"));
    Assert.assertTrue("Login unsuccessful", docuportBasePage.homePage.isDisplayed());
    LOG.info("User successfully logged in as an Advisor");

    }
    @When("user clicks Client button and creates new client")
    public void user_clicks_client_button_and_creates_new_client() {
    docuportAdvisorPage.clients.click();
   docuportAdvisorPage.createNewClient.click();
    docuportAdvisorPage.personalDropdown.click();
    docuportAdvisorPage.locateInputNames("First name","Christiana");
    docuportAdvisorPage.locateInputNames("Last name","Kachala");
   docuportAdvisorPage.createNewUserCheckBox.click();
    docuportAdvisorPage.locateInputNames("Email address", email);
    docuportAdvisorPage.advisorDropdown.click();
    docuportAdvisorPage.batch1Group1Option.click();
    docuportAdvisorPage.locateInputNames("Phone number", "545156645");
    docuportAdvisorPage.locateInputNames("Password", password);
    docuportAdvisorPage.locateInputNames("Confirm password", password);
    docuportAdvisorPage.save.click();
    docuportAdvisorPage.locateInputNames("Social Security Number", "6578542155445");
    docuportAdvisorPage.advisor2Dropdown.click();
    docuportAdvisorPage.batch1Group1Option.click();
    BrowserUtils.justWait(5);
    docuportAdvisorPage.servicesDropdown.click();
    docuportAdvisorPage.bookkeepingDropdown.click();
    BrowserUtils.justWait(5);
    docuportAdvisorPage.save.click();
    BrowserUtils.justWait(5);

}

    @When("user validates that new client created")
    public void user_validates_that_new_client_created() {
    docuportBasePage.searchButton1.click();
    docuportAdvisorPage.locateInputNames("Email address", email);
    docuportBasePage.searchButton2.click();
    BrowserUtils.justWait(2);
    String expectedMessage = email;
    String actualMessage = docuportAdvisorPage.locateEmail(email);
    Assert.assertEquals("Expected doesnt match with Actual",expectedMessage, actualMessage);
    LOG.info("User successfully created a new client");


    }
    @When("user logs out as an advisor")
    public void user_logs_out_as_an_advisor() {
        DocuportUtils.logOut(Driver.getDriver());
        BrowserUtils.justWait(2);


    }
    @Then("user logs in as a new client")
    public void user_logs_in_as_a_new_client() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.usernameInput.clear();
        loginPage.usernameInput.click();
        loginPage.usernameInput.sendKeys(email);
       loginPage.passwordInput.click();
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
        Assert.assertTrue("Login unsuccessful",docuportBasePage.homePage.isDisplayed());
        LOG.info("User successfully logged in as a new client");


    }

}
