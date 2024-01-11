package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    // locators or object repository
    private By welcomeMessage = By.xpath("//span[contains(text(),'New Luma Yoga Collection')]");
    private By changeIcon = By.xpath("//button[@class='action switch']/span");
    private By myAccount = By.xpath("//li/a[@id='idyPTluTYO']");
    private By editLink = By.xpath("");
    // public getters

    public WebElement checkWelcomeMessage() {
        return getElement(welcomeMessage);
    }
    public String getWelcomeMessage()
    {
        waitForElementPresent(welcomeMessage);
        return checkWelcomeMessage().getText();
    }
    public WebElement changeMyAccount(){
        return getElement(changeIcon);
    }
    public void clickChangeIconButton(){
        changeMyAccount().click();
    }
    public WebElement selectMyAccount(){
        return getElement(myAccount);
    }
    public void clickMyAccount(){
        selectMyAccount().click();
    }
    
}
