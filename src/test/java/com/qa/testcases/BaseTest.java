package com.qa.testcases;

import com.qa.configFileManager.ConfigFileManager;
import com.qa.pages.BasePage;
import com.qa.pages.LoginPage;
import com.qa.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
   public Page page;
    String URL= ConfigFileManager.readValue("config.properties","url");
    String FrontEnd_UserName= ConfigFileManager.readValue("config.properties","FrontEndUserName");
    String FrontEnd_Password= ConfigFileManager.readValue("config.properties","FrontEndUserPassWord");
    @BeforeMethod
    public void setUp()
    {
     driver = new ChromeDriver();
     driver.get(URL);
        // not to get null pointer because of driver we should create constructor of Page class
        // we cannot create constructor of Page class as it is abstract class, so we can get the constructor of BasePage class
        // by creating instance of BasePage class as it extends Page class and includes the constructor of Page class as super
        page = new BasePage(driver);
        page.getInstance(LoginPage.class).doLogin(FrontEnd_UserName,FrontEnd_Password);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
