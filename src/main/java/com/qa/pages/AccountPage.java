package com.qa.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    
    Faker faker = new Faker();
    //Page Locator For Sign Up
    private By createAnAccountButton = By.linkText("Create an Account");
   
    //Verify Page is Correct
    private String pageInnerHeader = "Create New Customer Account";
    private By createAnAccountPageHeader = By.cssSelector(".base");
    private String urlOfSignUpPage = "https://kams.studio/customer/account/create/";
    private String pageTitle= "Create New Customer Account";
    
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By signUpForNewsLetter = By.id("is_subscribed");
    private By allowRemoteShoppingAssistance = By.id("assistance_allowed_checkbox");
    private By emailAddress = By.id("email_address");
    private By password = By.cssSelector("input#password");
    private By passwordConfirm = By.id("password-confirmation");
    private By createAnAccountSubmitButton = By.cssSelector(".action.submit.primary");
    
    //After Sign up
    //"Thank you for registering with Main Website Store."
    //Css = ".message-success.success.message>div"
    //xpath = "//div[contains(text(),"Thank you for registering with Main Website Store.")]"
    private By successfulMessage = By.cssSelector(".message-success.success.message>div");
    private String afterSignInPageTitle = "My Account";
    private String afterSignInPageUrl = "https://kams.studio/customer/account/";
    
    public WebElement getCreateAnAccountButton(){return getElement(createAnAccountButton);}
    public WebElement getFirstNameField(){return getElement(firstNameField);}
    public WebElement getLastNameField(){return getElement(lastNameField);}
    public WebElement getSignUpForNewsLetter(){return getElement(signUpForNewsLetter);}
    public WebElement getAllowRemoteShoppingAssistance(){return getElement(allowRemoteShoppingAssistance);}
    public WebElement getEmailAddress(){return getElement(emailAddress);}
    public WebElement getPassword(){return getElement(password);}
    public WebElement getPasswordConfirm(){return getElement(passwordConfirm);}
    public WebElement getCreateAnAccountSubmitButton(){return getElement(createAnAccountSubmitButton);}
    public WebElement getCreateAnAccountPageHeader(){return getElement(createAnAccountPageHeader);}
    public WebElement getSuccessfulMessage(){return getElement(successfulMessage);}
    public boolean verifyUrl(String Url){
        return Url.equals(urlOfSignUpPage);
    }
    public boolean verifyPageHeader()
    {
        return pageInnerHeader.equals(getCreateAnAccountPageHeader());
    }
    public boolean verifyPageTitle(String PageTitle){return PageTitle.equals(pageTitle);}
    
    //After Sign In Verify
    public boolean verifyAfterUrl(){return driver.getCurrentUrl().equals(afterSignInPageUrl);}
    public boolean verifyAfterPageTitle(){return driver.getTitle().equals(afterSignInPageTitle);}
    public boolean verifySuccessMessageDisplayed(){return getSuccessfulMessage().isDisplayed();}
    
    public void InputAccountInfo(){
        getCreateAnAccountButton().click(); //Click Button
        //Verify the Page
        verifyPageHeader();
        verifyPageTitle(driver.getTitle());
        verifyUrl(driver.getCurrentUrl());
        getFirstNameField().sendKeys(faker.name().firstName());
        getLastNameField().sendKeys(faker.name().lastName());
        getSignUpForNewsLetter().click();
        getAllowRemoteShoppingAssistance().click();
        getEmailAddress().sendKeys(faker.internet().emailAddress());
        String password = faker.internet().password(8,12,true,true,true);
        System.out.println(password);
        getPassword().sendKeys(password);
        getPasswordConfirm().sendKeys(password);
        getCreateAnAccountSubmitButton().click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
