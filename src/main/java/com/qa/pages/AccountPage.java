package com.qa.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    private By signOutButton = By.linkText("Sign Out");
    
    //After Sign up
    //"Thank you for registering with Main Website Store."
    //Css = ".message-success.success.message>div"
    //xpath = "//div[contains(text(),"Thank you for registering with Main Website Store.")]"
    private By successfulMessage = By.cssSelector(".message-success.success.message>div");
    private String afterSignInPageTitle = "My Account";
    private String afterSignInPageUrl = "https://kams.studio/customer/account/";
    
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
    public WebElement getSignOutElement(){return getElement(signOutButton);}
    
    public void clickSignOutButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(signOutButton));
        getSignOutElement().click();
    }
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickChangeIconButton();
        clickSignOutButton();
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
