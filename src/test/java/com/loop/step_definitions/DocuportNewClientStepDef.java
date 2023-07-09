package com.loop.step_definitions;

import com.loop.pages.DocuportBasePage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportUtils;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class DocuportNewClientStepDef {

    private static final Logger LOG = LogManager.getLogger();


String email = "christina_kachala_456@gmail.com";
String password = "Group1";

    LoginPage loginPage = new LoginPage();
    DocuportBasePage docuportBasePage = new DocuportBasePage();
    @When("user enters credentials for advisor role")
    public void user_enters_credentials_for_advisor_role() {
    loginPage.loginDocuport(ConfigurationReader.getProperty("advisor"),ConfigurationReader.getProperty("password"));
    Assert.assertTrue("Login unsuccessful", loginPage.homePage.isDisplayed());
    LOG.info("User successfully logged in as an Advisor");

    }
    @When("user clicks Client button and creates new client")
    public void user_clicks_client_button_and_creates_new_client() {
    docuportBasePage.clients.click();
   docuportBasePage.createNewClient.click();
    docuportBasePage.personalDropdown.click();
    docuportBasePage.locateInputNames("First name","Christiana");
    docuportBasePage.locateInputNames("Last name","Kachala");
   docuportBasePage.createNewUserCheckBox.click();
    docuportBasePage.locateInputNames("Email address", email);
    docuportBasePage.advisorDropdown.click();
    docuportBasePage.batch1Group1Option.click();
    docuportBasePage.locateInputNames("Phone number", "545156645");
    docuportBasePage.locateInputNames("Password", password);
    docuportBasePage.locateInputNames("Confirm password", password);
    docuportBasePage.save.click();
    docuportBasePage.locateInputNames("Social Security Number", "6578542155445");
    docuportBasePage.advisor2Dropdown.click();
    docuportBasePage.batch1Group1Option.click();
    BrowserUtils.justWait(5);
    docuportBasePage.servicesDropdown.click();
    docuportBasePage.bookkeepingDropdown.click();
    BrowserUtils.justWait(5);
    docuportBasePage.save.click();
    BrowserUtils.justWait(5);

}

    @When("user validates that new client created")
    public void user_validates_that_new_client_created() {
    docuportBasePage.searchButton1.click();
    docuportBasePage.locateInputNames("Email address", email);
    docuportBasePage.searchButton2.click();
    BrowserUtils.justWait(2);
    String expectedMessage = email;
    String actualMessage = docuportBasePage.locateEmail(email);
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
        Assert.assertTrue("Login unsuccessful",loginPage.homePage.isDisplayed());
        LOG.info("User successfully logged in as a new client");


    }

}
