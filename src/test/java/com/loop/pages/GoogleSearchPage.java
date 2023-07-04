package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.nio.file.WatchEvent;

public class GoogleSearchPage {


    @FindBy(name = "q")
    public WebElement searcBox;


    @FindBy(xpath="//input[@id='gbqfbb']/preceding-sibling::input")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@class='FLP8od']")
    public WebElement capital;



    public GoogleSearchPage () {
        PageFactory.initElements(Driver.getDriver(), this);

    }



}
