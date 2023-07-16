package com.loop.step_definitions;

import com.loop.pages.ClientPage;
import com.loop.pages.DocuportBasePage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class ClientStepDefs {
    private static final Logger LOG = LogManager.getLogger();

    ClientPage clientPage = new ClientPage();
    DocuportBasePage docuportBasePage = new DocuportBasePage();

    private SoftAssertions softAssertions = new SoftAssertions ();

    @When("user validates choose account pop up is visible")
    public void user_validates_choose_account_pop_up_is_visible() {
        BrowserUtils.waitForVisibility(clientPage.chooseAccountText,5);
        //assertTrue(clientPage.chooseAccountText.isDisplayed());
       // assertTrue(clientPage.chooseAccountText.getText().equals("Choose account"));
       // assert (clientPage.chooseAccountText.getText().equals("Choose account"));            //this assert comes from java
        softAssertions.assertThat(clientPage.chooseAccountText.getText()).isEqualTo("Loop Academy");
        LOG.info("Account text is visible");

    }


    @When("user chooses account from drop down")
    public void user_chooses_account_from_drop_down() {
       // BrowserUtils.waitForVisibility(clientPage.continueButton,5);
       // assertTrue(clientPage.continueButton.isDisplayed());
        softAssertions.assertThat(docuportBasePage.continueB.isDisplayed()).isTrue();
        softAssertions.assertThat(docuportBasePage.continueB.getText()).isEqualTo("Loop Academy");
        softAssertions.assertAll();      //shows which one is failed



    }
    @When("user clicks {string} button")
    public void user_clicks_button(String button) {
        docuportBasePage.clickButton(button);
        BrowserUtils.justWait(3);





    }



}
