package com.qa.testcases;

import com.qa.pages.AccountPage;
import com.qa.testData.DataHolder;
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
    @Test(description = "Latif --->A user should be able to edit account information ")
    public void editAccountInformationTest(){
        page.getInstance(AccountPage.class).clickChangeIconButton();
        page.getInstance(AccountPage.class).clickAccountLink();
        page.getInstance(AccountPage.class).clickEditLink();
        page.getInstance(AccountPage.class).inputFirstName();
        page.getInstance(AccountPage.class).inputLastName();
        page.getInstance(AccountPage.class).clickSaveBtn();
        Assert.assertTrue(page.getInstance(AccountPage.class).verifySuccessMessage());
        String new_name = page.getInstance(AccountPage.class).getNewName();
        System.out.println(new_name);
        Assert.assertEquals(new_name, DataHolder.getFirstName()+" "+DataHolder.getLastName());
    }
    @Test(description = "Latif --->A user should be able to view Account Information ")
    public void verifyAccountInfo(){
        page.getInstance(AccountPage.class).clickChangeIconButton();
        page.getInstance(AccountPage.class).clickAccountLink();
        Assert.assertTrue(page.getInstance(AccountPage.class).verifyAccountInfo());
    }
    @Test(description = "Latif --->A user should be able to see My product Reviews ")
    public void verifyMyProductReviews(){
        page.getInstance(AccountPage.class).clickChangeIconButton();
        page.getInstance(AccountPage.class).clickAccountLink();
        String title = page.getInstance(AccountPage.class).getProductReviewsPageTitle();
        System.out.println("The page title is " + title);
        Assert.assertEquals(title,"My Product Reviews");
        page.getInstance(AccountPage.class).clickMyProductReviewsLink();
        Assert.assertTrue(page.getInstance(AccountPage.class).verifyMyProductReviews());
    }
}