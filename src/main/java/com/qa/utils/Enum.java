package com.qa.utils;

import com.qa.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class Enum extends BasePage {
    public Enum(WebDriver driver) {
        super(driver);
    }
    /*
    * Implicit wait, waits for an element to appear on the page,
    * while explicit wait, waits for a specific condition, such as the presence of an element or the element to be clickable.
    * Scope: Implicit wait applies globally, while explicit wait applies locally to a specific element.
    * */
  public static long IMPLICIT_WAIT = 10;
}
