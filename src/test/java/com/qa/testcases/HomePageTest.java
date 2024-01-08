package com.qa.testcases;

import com.qa.pages.HomePage;
import com.qa.testcases.BaseTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void verifyMyAccountChangeTest(){

        page.getInstance(HomePage.class).clickChangeIconButton();
        page.getInstance(HomePage.class).clickMyAccount();
    }
}
