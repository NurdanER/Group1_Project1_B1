package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportUtils {
    /**
     * logins to the docuport application
     * @param driver, which initialized in test base
     * @param role, comes from docuport constants.
     * @author Nurdan
     */
    public static void loginDocuport (WebDriver driver,String role ) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@id='input-14']"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='input-15']"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));

        switch (role.toLowerCase()) {
            case "client":
                userName.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "supervisor":
                userName.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                userName.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                userName.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            default : throw new InputMismatchException("There is not such element ");

        }
        loginButton.click();
    }

    /**
     * logs out from the application
     * @param driver
     * @author Nurdan
     */


    public static void logOut(WebDriver driver){
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
    }


}
