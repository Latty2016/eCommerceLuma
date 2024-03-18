package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // page locator or Object repository
    private By defaultLoginMessage = By.xpath("//li/span[contains(text(),'Default welcome msg!')]");
    private By signInLink = By.linkText("Sign In");
    private By emailId = By.id("email");
    private By passwordId = By.id("pass");
    private By signInBtn = By.id("send2");
    private By signInErrorMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");

    private By forgotPasswordLink = By.xpath("//div/a[@class='action remind']/span");
    // getters

    public String getDefaultLoginMessage() {
        // waitElementPresent
        waitForElementPresent(defaultLoginMessage);
        return getElement(defaultLoginMessage).getText();
    }
    public WebElement getSignInLink() {
        return getElement(signInLink);
    }
    public WebElement getEmailId() {
        return getElement(emailId);
    }
    public WebElement getPasswordId() {
        return getElement(passwordId);
    }
    public WebElement getSignInBtn() {
        return getElement(signInBtn);
    }
    public WebElement getSignInErrorMessageText(){
        return  getElement(signInErrorMessage);
    }
    public WebElement getForgetPasswordLink(){
        return getElement(forgotPasswordLink);
    }
    public String getPageTitle() {
        return getTitle();
    }
    public HomePage doLogin(String userName, String userPass) {
        getSignInLink().click();
        getEmailId().sendKeys(userName);
        getPasswordId().sendKeys(userPass);
        getSignInBtn().click();
        return getInstance(HomePage.class);
    }
}
