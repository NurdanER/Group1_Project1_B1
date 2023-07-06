package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportBasePage {
    public DocuportBasePage () {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//span[.='Clients']")
    public WebElement clients;

    @FindBy(xpath = "//span[.='Create new client']")
    public WebElement createNewClient;


    @FindBy(xpath = "//span[contains(text(),'Personal')]")
    public WebElement personalDropdown;

    public void locateInputNames(String input, String input2) {
        Driver.getDriver().findElement(By.xpath("//label[.='"+input +"']/following-sibling::input")).sendKeys(input2);
        BrowserUtils.justWait(2);

    }

    @FindBy(xpath = "//div[@class='v-input--selection-controls__ripple']")
    public WebElement createNewUserCheckBox;

    @FindBy(xpath = "//label[.='Advisor']/../div/div")
    public WebElement advisorDropdown;

    @FindBy(xpath = "//div[contains(text(),'Batch1 Group1')]")
    public WebElement batch1Group1Option;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement save;

    @FindBy(xpath = "//label[.='Services']/../div/div")
    public WebElement servicesDropdown;

    @FindBy(xpath = "//div[contains(text(),'Bookkeeping')]/../../div/div/div")
    public WebElement bookkeepingDropdown;







    }

