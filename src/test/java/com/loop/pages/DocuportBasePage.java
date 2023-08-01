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

    @FindBy(xpath = "//span[contains(text(),'Invitations')]")
    public WebElement invitationsButton;

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
                BrowserUtils.waitForVisibility(receivedDocsPage,7);
                receivedDocsPage.click();
                break;
            case "myuploads":
                BrowserUtils.waitForVisibility(myUploadsPage,7);
                myUploadsPage.click();
                break;
            case"leads":
                 leadsPage.click();
                 break;
            case"users":
                BrowserUtils.waitForVisibility(usersPage,7);
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

////

    public void clickOption(String option) {
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'" + option + "')]")).click();
    }

    public void rowNumber(Integer num) {
        Driver.getDriver().findElement(By.xpath("//div[contains(text(),'" + num + "')]")).click();
    }

    @FindBy(xpath = "//div[@class='v-input__append-inner']")
    public WebElement rowPageDropdown;

    @FindBy(xpath = "//div[contains(text(),'10')]")
    public WebElement rowPageByDefault;

    @FindBy(xpath = "//div[contains(text(),'5')]")
    public WebElement rowPageFive;

    public void displayOption(String option) {
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'" + option + "')]"));
    }

    public void titleValidate(String title) {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[contains(text(),'" + title + "')]")).isDisplayed());
    }


    @FindBy(xpath = "//span[.='Clients']")
    public WebElement clients;

    @FindBy(xpath = "//span[.='Create new client']")
    public WebElement createNewClient;

    @FindBy(xpath = "//span[.='Personal']")
    public WebElement personalDropdown;


    public void locateInput(String input, String input2) {
        Driver.getDriver().findElement(By.xpath("//label[.='" + input + "']/following-sibling::input")).sendKeys(input2);
        BrowserUtils.justWait(3);
    }

    @FindBy(xpath = "//div[@class='v-input--selection-controls__ripple']")
    public WebElement createNewUserCheckBox;

    @FindBy(xpath = "//label[.='Advisor']/../div/div")
    public WebElement advisorDropdown;

    @FindBy(xpath = "//div[contains(text(),'Batch1 Group1')]")
    public WebElement Batch1group1Option;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[.='Advisor']/../div/following-sibling::div")
    public WebElement secondAdvisor;

    @FindBy(xpath = "//label[.= 'Services']/following-sibling::div/div")
    public WebElement services;

    @FindBy(xpath = "//div[contains(text(),'Payroll')]/../../div/div/div")
    public WebElement payroll;

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    public WebElement logout;

    @FindBy(xpath = "//span[contains(text(),'Search')]")
    public WebElement search;

    @FindBy(xpath = "//span[@class='subtitle-2 text-none pl-2 pr-3 gray--text text--darken-3']")
    public WebElement profile;






}