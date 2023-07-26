package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportBasePage {
    public DocuportBasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//i[@class='v-icon notranslate mdi mdi-home theme--light']")
    public WebElement homePage;
    //<i aria-hidden="true" class="v-icon notranslate mdi mdi-home theme--light"></i>
    @FindBy(xpath = "//span[contains(text(),'Invitations')]")
    public WebElement invitationsButton;
    //span[contains(normalize-space(),'Continue')]           //this makes delete spaces
    @FindBy(xpath = "//span[.=' Continue ']")
    public WebElement continueB;

    public void clickButton (String button) {
        switch(button.toLowerCase()) {
            case "continue":
                BrowserUtils.waitForVisibility(continueB,7);
                continueB.click();
                BrowserUtils.waitForClickable(receivedDocsPage,7);
                break;
            case "invitations":
                invitationsButton.click();
                break;
            case "receiveddocs":
                receivedDocsPage.click();
                break;
            case "myuploads":
                myUploadsPage.click();
                break;
            case"leads":
                 leadsPage.click();
                 break;
            case"users":
                usersPage.click();
                break;

        }
    }


    @FindBy(xpath = "//span[.='Received docs']")
    public WebElement receivedDocsPage;

    @FindBy(xpath = "//span[.='My uploads']")
    public WebElement myUploadsPage;

    @FindBy(xpath = "//span[.='Leads']")
    public WebElement leadsPage;
    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersPage;



    public void displayedPages (String displayed){
        switch (displayed.toLowerCase()){
            case"receiveddocs":
                receivedDocsPage.isDisplayed();
                break;
            case"myuploads":
                myUploadsPage.isDisplayed();
                break;
            case"search":
                searchButton1.isDisplayed();
                break;
            case"download":
                downloadButton.isDisplayed();
                break;

        }
    }


    @FindBy(xpath = "//i[@class='v-icon notranslate v-icon--left mdi mdi-tune theme--light']")
    public WebElement searchButton1;
    @FindBy(xpath = "//span[contains(text(),'Download')]")
    public WebElement downloadButton;






    @FindBy(xpath = "//button[@class='text-none body-2 font-weight-medium v-btn v-btn--has-bg theme--light v-size--default primary']")
    public WebElement searchButton2;



    @FindBy(xpath = "//h2[contains(text(),'Received')]/..")
    public WebElement receivedDocuments;

   @FindBy(xpath = "//h2[contains(text(),'My')]/..")
    public WebElement myUploadsDoc;







}