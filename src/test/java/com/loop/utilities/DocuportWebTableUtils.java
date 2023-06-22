package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocuportWebTableUtils {

    public static String returnAnyfield (WebDriver driver, String emailAddress, String field ) {
        WebElement element = null;
        String xpath = "";
        switch (field.toLowerCase()){
            case "full name":
                xpath = "//td[2][contains(text(),'" + emailAddress + "')]/preceding-sibling::td//span[2]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "username":
                xpath = "//td[2][contains(text(),'" + emailAddress + "')]/following-sibling::td[1]";
                element = driver.findElement(By.xpath(xpath));
                break;
        }
        return element.getText();
    }







}
