package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private By changeIcon = By.xpath("(//button[@type='button'])[1]");
    private By accountLink = By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[1]/a[1]");
    private By editLink = By.xpath("(//span[contains(text(),'Edit')])[1]");
    private By firstName = By.xpath("//input[@id='firstname']");
    private By lastName = By.xpath("//input[@id='lastname']");
    private By saveBtn = By.xpath("//button[@type='submit']//span[contains(text(),'Save')]");
    private By savedMessage = By.xpath("//div[contains(text(),'You saved the account information.')]");
    private By newName = By.xpath("//p[contains(text(),'Yusuf Altay')]");
    // methods
    public WebElement getChangeIconElement(){
        return getElement(changeIcon);
    }
    public void clickChangeIconButton(){
        waitForElementPresent(accountLink);
        getChangeIconElement().click();
    }
    public WebElement getAccountLinkElement(){
        return getElement(accountLink);
    }
    public void clickAccountLink(){
        wait.until(ExpectedConditions.presenceOfElementLocated(accountLink));
        Actions action = new Actions(driver);
        action.moveToElement(getAccountLinkElement()).build().perform();
       /* JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", accountLink);*/
        getAccountLinkElement().click();
    }
    public WebElement getEditLinkElement(){
        waitForElementPresent(editLink);
        return getElement(editLink);
    }
    public void clickEditLink(){
        getEditLinkElement().click();
    }
    public WebElement getFirstNameTextFieldElement(){
        return getElement(firstName);
    }
    public void inputFirstName(){
        getFirstNameTextFieldElement().clear();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getFirstNameTextFieldElement().sendKeys("Yusuf");
    }
    public WebElement getLastNameTextFieldElement(){
        return getElement(lastName);
    }
    public void inputLastName(){
        getLastNameTextFieldElement().clear();
        getLastNameTextFieldElement().sendKeys("Altay");
    }
    public WebElement getSaveBtnElement(){
        return getElement(saveBtn);
    }
    public void clickSaveBtn(){
        getSaveBtnElement().click();
    }
    public WebElement getSavedMessageElement(){
        return getElement(savedMessage);
    }
    public String getSavedMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(savedMessage));
        return getSavedMessageElement().getText();
    }
    public WebElement getNewNameElement(){
        return getElement(newName);
    }
    public String getNewName(){
        return getNewNameElement().getText();
    }
}
