package com.loop.step_definitions;

import com.loop.pages.DocuportBasePage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

public class ValidateButtonsStepDef {
    private static final Logger LOG = LogManager.getLogger();


    DocuportBasePage docuportBasePage = new DocuportBasePage();
    LoginPage loginPage = new LoginPage();

    private SoftAssertions softAssertions = new SoftAssertions();

    @When("user enters {string} and {string} credentials")
    public void user_enters_and_credentials(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
        BrowserUtils.justWait(5);
        if (username.equals("b1g1_client@gmail.com")) {
            docuportBasePage.continueB.click();
            BrowserUtils.justWait(7);
            LOG.info("User successfully entered credentials");
        }
    }
    @When("user clicks on {string} item")
    public void user_clicks_on_item(String button) {
        docuportBasePage.clickButton(button);
        BrowserUtils.justWait(7);
        LOG.info("User clicks " +button+ " successfully");
    }

    @When("user validates {string} is displayed")
    public void user_validates_is_displayed (String displayed) {
        docuportBasePage.displayedPages(displayed);
        BrowserUtils.justWait(7);
        LOG.info("Text is visible");
    }


}

