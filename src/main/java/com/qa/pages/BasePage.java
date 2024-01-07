package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
           element = driver.findElement(locator);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some error occurred while trying to find element " + locator.toString());
        }


    }
}
