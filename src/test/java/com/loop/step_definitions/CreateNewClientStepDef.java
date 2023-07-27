package com.loop.step_definitions;

import com.github.javafaker.Faker;
import com.loop.pages.DocuportBasePage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CreateNewClientStepDef {

    DocuportBasePage docuportBasePage = new DocuportBasePage();
    LoginPage loginPage = new LoginPage();
    private static final Logger LOG = LogManager.getLogger();
    Faker emailFaker = new Faker();
    String email = emailFaker.internet().emailAddress();
    String password = "Group1";
    @When("user clicks Client button and creates new client")
    public void user_clicks_client_button_and_creates_new_client() {
        docuportBasePage.clients.click();
        BrowserUtils.justWait(3);
        docuportBasePage.createNewClient.click();
        docuportBasePage.personalDropdown.click();
        docuportBasePage.locateInput("First name","Group2");
        docuportBasePage.locateInput("Last name", "ACADEMY");
        docuportBasePage.createNewUserCheckBox.click();
        docuportBasePage.locateInput("Email address",email);
        docuportBasePage.advisorDropdown.click();
        docuportBasePage.Batch1group1Option.click();
        docuportBasePage.locateInput("Phone number","9999111");
        docuportBasePage.locateInput("Password",password);
        docuportBasePage.locateInput("Confirm password","Group1");
        docuportBasePage.saveButton.click();

        docuportBasePage.secondAdvisor.click();
        docuportBasePage.Batch1group1Option.click();
        docuportBasePage.services.click();
        docuportBasePage.payroll.click();
        BrowserUtils.justWait(5);
        docuportBasePage.saveButton.click();
    }
    @When("user validates that new client created")
    public void user_validates_that_new_client_created() {
        docuportBasePage.search.click();
        BrowserUtils.justWait(5);
        Driver.getDriver().findElement(By.xpath("//label[.='Email address']/following-sibling::input")).sendKeys(email);
        BrowserUtils.justWait(3);
        docuportBasePage.saveButton.click();
        BrowserUtils.justWait(5);
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//td[contains(text(),'" + email + "')]")).getText(),email);
    }
    @When("user logs out as an advisor")
    public void user_logs_out_as_an_advisor() {
        docuportBasePage.profile.click();

        docuportBasePage.logout.click();
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
