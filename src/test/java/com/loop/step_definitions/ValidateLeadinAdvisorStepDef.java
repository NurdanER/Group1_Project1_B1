package com.loop.step_definitions;

import com.loop.pages.ClientPage;
import com.loop.pages.DocuportAdvisorPage;
import com.loop.pages.DocuportBasePage;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

public class ValidateLeadinAdvisorStepDef {
    private static final Logger LOG = LogManager.getLogger();

    ClientPage clientPage = new ClientPage();
    DocuportBasePage docuportBasePage = new DocuportBasePage();
    DocuportAdvisorPage docuportAdvisorPage = new DocuportAdvisorPage();

    @When("user validates that Rows Per Page shows by default {int} on a {string} page")
    public void user_validates_that_rows_per_page_shows_by_default_on_a_page(Integer numOfRowPage, String page) {

        Assert.assertEquals("Number of Row Page doesnt match with Actual",numOfRowPage,Integer.valueOf(docuportAdvisorPage.rowsPerPageNumber.getText()));
        LOG.info("Rows Per Page shows by default "+ numOfRowPage+ " on a " + page+ " page");

    }
    @When("user changes Rows Per Page to {int}")
    public void user_changes_rows_per_page_to(Integer int1) {
      docuportAdvisorPage.pageNumberDropdown.click();
      docuportAdvisorPage.changeRowsPerPageNumbers(int1);
      LOG.info("User changes number to " +int1);


    }
    @When("user validates that Rows per page shows {int} on a {string} page")
    public void user_validates_that_rows_per_page_shows_on_a_page(Integer numOfRowPage, String page) {
        Assert.assertEquals("Number of Row Page doesnt match with Actual",numOfRowPage,Integer.valueOf(docuportAdvisorPage.rowsPerPageNumber.getText()));
        LOG.info("Rows Per Page shows by default "+ numOfRowPage+ " on a " + page+ " page");

    }

    }
