package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage {

    public ClientPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h3[.='Choose account']")
    public WebElement chooseAccountText;

    @FindBy(xpath = "//span[.=' Continue ']")
    //span[contains(normalize-space(),'Continue')]           //this makes delete spaces
    public WebElement continueButton;


}
