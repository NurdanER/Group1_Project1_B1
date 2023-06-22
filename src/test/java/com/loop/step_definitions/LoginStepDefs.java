package com.loop.step_definitions;

import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage =  new LoginPage();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }
    @When("user enters username for client")
    public void user_enters_username_for_client() {
        BrowserUtils.waitForClickable(loginPage.loginButton,10);
        loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_CLIENT);


    }
    @When("user enters password for client")
    public void user_enters_password_for_client() {
        BrowserUtils.waitForClickable(loginPage.loginButton,10);
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);

    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();


    }
    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
        loginPage.homePage.isDisplayed();

    }

    @When("user enters username for employee")
    public void user_enters_username_for_employee() {
        BrowserUtils.waitForClickable(loginPage.loginButton,10);
        loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);


    }
    @When("user enters password for employee")
    public void user_enters_password_for_employee() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);

    }

    @Then("user should see the home page for employee")
    public void user_should_see_the_home_page_for_employee() {
        loginPage.homePage.isDisplayed();

    }
    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
        loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);

    }
    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {
        BrowserUtils.waitForClickable(loginPage.loginButton,10);
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);

    }
    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        loginPage.homePage.isDisplayed();

    }
    @When("user enters username for admin")
    public void user_enters_username_for_admin() {


    }
    @When("user enters password for admin")
    public void user_enters_password_for_admin() {

    }
    @Then("user should see the home page for admin")
    public void user_should_see_the_home_page_for_admin() {

    }




}






