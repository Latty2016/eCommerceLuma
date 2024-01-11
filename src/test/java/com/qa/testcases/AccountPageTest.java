package com.qa.testcases;

import com.qa.pages.AccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest{
    @Test(description = "Kevser --->A user should be able to create an account ")
    public void verifyCreateAccountFunction(){
        page.getInstance(AccountPage.class).InputAccountInfo();
        Assert.assertTrue(page.getInstance(AccountPage.class).verifyAfterUrl());
        Assert.assertTrue(page.getInstance(AccountPage.class).verifyAfterPageTitle());
        Assert.assertTrue(page.getInstance(AccountPage.class).verifySuccessMessageDisplayed());
    }
}

