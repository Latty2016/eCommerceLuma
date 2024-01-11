package com.qa.testcases;

import com.qa.pages.AccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest{
    @Test
    public void editAccountInformationTest(){
        page.getInstance(AccountPage.class).clickChangeIconButton();
        page.getInstance(AccountPage.class).clickAccountLink();
        page.getInstance(AccountPage.class).clickEditLink();
        page.getInstance(AccountPage.class).inputFirstName();
        page.getInstance(AccountPage.class).inputLastName();
        page.getInstance(AccountPage.class).clickSaveBtn();

        String successMessage = page.getInstance(AccountPage.class).getSavedMessage();
        System.out.println(successMessage);
        String new_name = page.getInstance(AccountPage.class).getNewName();
        System.out.println(new_name);
    }
}
