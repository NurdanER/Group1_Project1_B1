package com.loop.step_definitions;

import io.cucumber.java.en.*;
import com.loop.utilities.DB_Util;
import org.junit.Assert;

import java.sql.ResultSet;
import java.util.List;

import static org.bouncycastle.cms.RecipientId.password;

public class UserInfoStepDefs {

    List<String> actualResult;
    List<String> actualResult2;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        // DB_Util.createConnection(ip, userName, password);
        System.out.println("******************************");
        System.out.println("CONNECTION IS HANDLED INN HOOKS");
        System.out.println("******************************");
    }

        @When("Execute query to get all column for {string}")
    public void execute_query_to_get_all_column_for(String string) {

        // select * from identity.departments
        DB_Util.runQuery("select * from identity." + string);
        actualResult = DB_Util.getColumnDataAsList("name");

    }

    @Then("Verify the below column sare listed in result for")
    public void verify_the_below_column_sare_listed_in_result_for(List<String> expectedResult) {
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("Actual: " + actualResult);
        System.out.println("Expected: " + expectedResult);
    }

    @When("I execute the query to get all columns for the {string} where first name {string}")
    public void iExecuteTheQueryToGetAllColumnsForTheWhereFirstName(String documentUsers , String batch1) {
        DB_Util.runQuery("SELECT * FROM " + documentUsers + " WHERE first_name = '" + batch1 + "' ORDER BY id;");
        actualResult2 = DB_Util.getColumnDataAsList("id");
    }
    @Then("Verify the below columns are listed in result for id")
    public void verify_the_below_column_sare_listed_in_result_for_id(List<String> expectedID) {
        Assert.assertEquals(expectedID, actualResult2);
        System.out.println("Actual: " + actualResult2);
        System.out.println("Expected: " + expectedID);
    }

}
