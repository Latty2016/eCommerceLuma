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
    // public getters

    public WebElement checkWelcomeMessage() {
        return getElement(welcomeMessage);
    }
    public String getWelcomeMessage()
    {
        waitForElementPresent(welcomeMessage);
        return checkWelcomeMessage().getText();
    }
}
