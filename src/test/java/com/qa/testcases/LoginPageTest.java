package com.qa.testcases;

import com.qa.configFileManager.ConfigFileManager;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    String FrontEnd_UserName= ConfigFileManager.readValue("config.properties","FrontEndUserName");
    String FrontEnd_Password= ConfigFileManager.readValue("config.properties","FrontEndUserPassWord");

    @Test(priority = 2,  enabled = true,description = "latif----> User should be able to get default message before sign in")
    public void verifySignInMessageTest()
    {
        String signInMessage = page.getInstance(LoginPage.class).getDefaultLoginMessage();
        System.out.println(signInMessage);
        Assert.assertEquals(signInMessage,"Default welcome msg!");
    }
    @Test(priority = 1,enabled = true, description = "latif----> User should be able to get the right page title before sign in")
    public void VerifyPageTitleTest()
    {
        String pageTitle = page.getInstance(LoginPage.class).getPageTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle,"Home Page");
    }
    @Test(priority = 3, description = "latif----> User should be able to login and see the welcome message after logged in successfully")
    public void verifyLogInTest()
    {
        page.getInstance(LoginPage.class).doLogin(FrontEnd_UserName,FrontEnd_Password);
        String welcomeMessage = page.getInstance(HomePage.class).getWelcomeMessage();
        System.out.println("The welcome message is "+welcomeMessage);
        boolean verifyMessage = welcomeMessage.contains("New Luma Yoga Collection");
        Assert.assertTrue(verifyMessage);

    }
}
