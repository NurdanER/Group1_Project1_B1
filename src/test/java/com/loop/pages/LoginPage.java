package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath= "//input[@id='input-14']")
    public WebElement loginInput;

    @FindBy(xpath= "//input[@id='input-15']")
    public WebElement passwordInput;

    @FindBy(className ="v-btn__content")
    public WebElement loginButton;

    @FindBy(xpath="//span[.='Home']")
    public WebElement homePage;




    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }












}
