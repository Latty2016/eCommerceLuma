package com.qa.pages;

import com.qa.utils.Enum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

public abstract class Page {
    WebDriver driver;
    WebDriverWait wait;

    // constructor
    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(Enum.IMPLICIT_WAIT));
    }

    // mostly used methods(abstract)
    public abstract String getTitle();
    public abstract WebElement getElement(By locator);

    public abstract void waitForElementPresent(By locator);
    public abstract void waitTilPresent(WebElement webElement);
    public abstract void sleep(int seconds);

    // Java Generic class to return page class instance
    public <Tpage extends BasePage> Tpage getInstance(Class<Tpage> tpageClass) {
        try {
            return tpageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
