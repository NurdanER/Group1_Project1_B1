package com.loop.step_definitions;

import com.loop.pages.DocuportBasePage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocuportNewClientStepDef {
    LoginPage loginPage = new LoginPage();
    DocuportBasePage docuportBasePage = new DocuportBasePage();
    @When("user enters credentials for advisor role")
    public void user_enters_credentials_for_advisor_role() {
    loginPage.loginDocuport(ConfigurationReader.getProperty("advisor"),ConfigurationReader.getProperty("password"));
    }
    @When("user clicks Client button and creates new client")
    public void user_clicks_client_button_and_creates_new_client() {
    docuportBasePage.clients.click();
    docuportBasePage.createNewClient.click();
    docuportBasePage.personalDropdown.click();
    docuportBasePage.locateInputNames("First name","Christie");
    docuportBasePage.locateInputNames("Last name","Bled");
    docuportBasePage.createNewUserCheckBox.click();
    docuportBasePage.locateInputNames("Email address", "christie6@gmail.com");
    docuportBasePage.advisorDropdown.click();
    docuportBasePage.batch1Group1Option.click();
    docuportBasePage.locateInputNames("Phone number", "785465854");
    docuportBasePage.locateInputNames("Password", "Group1");
    docuportBasePage.locateInputNames("Confirm password", "Group1");
    docuportBasePage.save.click();
    docuportBasePage.advisorDropdown.click();
    docuportBasePage.batch1Group1Option.click();
    docuportBasePage.servicesDropdown.click();
    docuportBasePage.bookkeepingDropdown.click();
    docuportBasePage.save.click();



    }
    @When("user validates that new client created")
    public void user_validates_that_new_client_created() {




    }
    @When("user logs out as an advisor")
    public void user_logs_out_as_an_advisor() {

    }
    @Then("user logs in as a new client")
    public void user_logs_in_as_a_new_client() {

    }

}
