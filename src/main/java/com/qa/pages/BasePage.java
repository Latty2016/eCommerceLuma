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
    
    @Override
    public void waitTilPresent(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some error occurred while trying to find element " + webElement.toString());
        }
    }
    @Override
    public void sleep(int seconds){     //Sometimes in debugging stage, u should wait for some reason, so just make a sleep method, just call this method when u want to use the Thread.sleep function
        try {
            Thread.sleep(1000*seconds);             //Because Thread.sleep() 's param is calculated by milliSeconds, and we want to just give second by default param to this method, so, u have to convert the millisecond to second in here
        } catch (InterruptedException e) {
            throw new RuntimeException(e);              //try-catch
        }
    }
    
    
    
}
