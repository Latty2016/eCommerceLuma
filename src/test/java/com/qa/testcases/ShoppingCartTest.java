package com.qa.testcases;

import com.qa.pages.BasePage;
import com.qa.pages.ShoppingCart;
import com.qa.testData.DataHolder;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

public class ShoppingCartTest extends BaseTest {
    @Test(description = "Kevser ---> SRT-4-A user should be able to add products to shopping cart")
    public void addProductToShoppingCartTest(){
        page.getInstance(ShoppingCart.class).addProductToShoppingCartMainMethod();
        Assert.assertTrue(page.getInstance(ShoppingCart.class).verifySuccessMessage());
    }
    @Test(dependsOnMethods = "addProductToShoppingCartTest", description = "Kevser ---> SRT-5 - - - A user should be able to check out the order")
    public void updateShoppingCartTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://kams.studio/checkout/cart/");
        Thread.sleep(3000);
//        page.getInstance(ShoppingCart.class).clickViewAndEditCartLink();
        
        DataHolder.setBeforeQtyUpdate(page.getInstance(ShoppingCart.class).getQtyFromShoppingCartPage());
        System.out.println(DataHolder.getBeforeQtyUpdate());
        
        Thread.sleep(3000);
        page.getInstance(ShoppingCart.class).sendNewQtyToField();
        page.getInstance(ShoppingCart.class).clickUpdateShoppingCartButton();
        System.out.println(page.getInstance(ShoppingCart.class).getQtyFromShoppingCartPage());
        Assert.assertTrue(page.getInstance(ShoppingCart.class).verifyShoppingCartUpdated());
    }
}