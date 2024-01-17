package com.qa.pages;

import org.bouncycastle.tsp.TSPIOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class ShoppingCart extends BasePage{
    
    public ShoppingCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    String qtyInInfoPage;
    String qtyInShoppingCartIcon;
    
    @FindBy(id = "ui-id-21")
    WebElement gearTopMenu;
    @FindBy(id = "ui-id-22")
    WebElement bagsSecondMenu;
    @FindBy(id = "limiter")
    WebElement showXperPage;
    @FindAll(
            @FindBy(css = ".product-item-info") )
    List<WebElement> productGridList;
    @FindBy(id = "product-addtocart-button")
    WebElement addToCartButton;
    @FindBy(css = ".base")
    WebElement productNameInInfoPage;
    @FindBy(css = ".action.showcart")
    WebElement showProductCart;
    @FindBy(css = ".product-item-name > a[data-bind]")
    WebElement productNameInShoppingCartIcon;
    @FindBy(id = "qty")
    WebElement quantityInInfoPage;
    @FindBy(id = "cart-item-4-qty")
    WebElement quantityInShoppingCartIcon;
    @FindBy(css = "ui-id-21 > .ui-menu-icon.ui-icon.ui-icon-caret-1-e")
    WebElement arrowDropNextGearMenu;
    @FindBy(css = "a.action.viewcart")
    WebElement viewAndEditCartLink;
    @FindAll(
            @FindBy(css = ".col.item > .product-item-details > .product-item-name > a")
    )
    List<WebElement> ProductListInShoppingCart;
    @FindBy(css = ".message-success.success.message")
    WebElement successfullyAddedToShoppingCart;
    
    //By Locators
    private By gearTopMenuBy = By.id("ui-id-21");
    private By bagsSecondMenuBy = By.id("ui-id-22");
    private By showXperPageBy = By.id("limiter");
    private By productGridListBy = By.cssSelector(".product-item-info");
    private By addToCartButtonBy = By.id("product-addtocart-button");
    private By productNameInInfoPageBy = By.cssSelector(".base");
    private  By showProductCartBy = By.cssSelector(".action.showcart");
    private By productNameInShoppingCartIconBy = By.cssSelector(".product-item-name > a[data-bind]");
    private By quantityInInfoPageBy = By.id("qty");
    private By quantityInShoppingCartIconBy = By.id("cart-item-4-qty");
    private By arrowDropNextGearMenuBy = By.cssSelector("#ui-id-21 > .ui-menu-icon.ui-icon.ui-icon-caret-1-e");
    private By viewAndEditCartLinkBy = By.cssSelector("a.action.viewcart");
    
    public void clickGearMenu(){
        waitForElementPresent(gearTopMenuBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(gearTopMenu).perform();
        waitForElementPresent(bagsSecondMenuBy);
        bagsSecondMenu.click();
    }
    public void clickBagsMenu(){
        waitForElementPresent(arrowDropNextGearMenuBy);
        bagsSecondMenu.click();
    }
    public void changePerPage(){
        waitForElementPresent(showXperPageBy);
        Select select = new Select(showXperPage);
        select.selectByValue("36");
    }
    public void selectProduct(){
        waitForElementPresent(productGridListBy);
        Random random = new Random();
        int x = random.nextInt(productGridList.size());
        productGridList.get(x).click();
    }
    public void clickAddButton(){
        waitForElementPresent(addToCartButtonBy);
        addToCartButton.click();
    }
    public String getProductNameInInfoPage(){
        waitForElementPresent(productNameInInfoPageBy);
        return productNameInInfoPage.getText();
    }
    public void clickShoppingCartIcon(){
        waitForElementPresent(showProductCartBy);
        showProductCart.click();
    }
    public String getQtyValueFromInfoPage(){
        waitForElementPresent(quantityInInfoPageBy);
        return qtyInInfoPage = quantityInInfoPage.getText();
    }
    public String getProductNameInShoppingCartIcon(){
        waitForElementPresent(productNameInShoppingCartIconBy);
        return productNameInShoppingCartIcon.getText();
    }
    public String getQtyValueFromShoppingCartIcon(){
        waitForElementPresent(quantityInShoppingCartIconBy);
        return qtyInShoppingCartIcon = quantityInShoppingCartIcon.getText();
    }
    public boolean verifyProductName(){
        System.out.println("getProductNameInInfoPage() : " + getProductNameInInfoPage());
        System.out.println("getProductNameInShoppingCartIcon() : " + getProductNameInShoppingCartIcon());
        return getProductNameInInfoPage().equals(getProductNameInShoppingCartIcon());
    }
    public boolean verifySuccessMessage(){
        return successfullyAddedToShoppingCart.isDisplayed();
    }
    public boolean verifyQty(){
        System.out.println("getQtyValueFromInfoPage() : " + getQtyValueFromInfoPage());
        System.out.println("getQtyValueFromShoppingCartIcon() : " + getQtyValueFromShoppingCartIcon());
        return getQtyValueFromInfoPage().equals(getQtyValueFromShoppingCartIcon());
    }
    public void addProductToShoppingCartMainMethod(){
        clickGearMenu();
        selectProduct();
        clickAddButton();
        clickShoppingCartIcon();
        sleep(3);
    }

}
