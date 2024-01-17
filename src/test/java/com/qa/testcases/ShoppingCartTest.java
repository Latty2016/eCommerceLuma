package com.qa.testcases;

import com.qa.pages.BasePage;
import com.qa.pages.ShoppingCart;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {
    @Test(description = "Kevser ---> SRT-4-A user should be able to add products to shopping cart")
    public void addProductToShoppingCartTest(){
        page.getInstance(ShoppingCart.class).addProductToShoppingCartMainMethod();
        Assert.assertTrue(page.getInstance(ShoppingCart.class).verifySuccessMessage());
    }
    
}
