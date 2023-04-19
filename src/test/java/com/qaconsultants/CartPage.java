package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    // FireFox web driver
    private WebDriver driver;

    // super constructor
    public CartPage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
        PageFactory.initElements(driver, this);
    }


    // ------------------- Locators for the Cart Page -----------------------------

    @FindBy(how = How.XPATH, using = "//*[@class='cart_delete']")
    private WebElement removeItemButton;

    @FindBy(how = How.XPATH, using = "//*[@class='btn btn-default check_out']")
    private WebElement checkoutButton;


    // --------------------- Methods for the Cart Page --------------------------------

    /**
     * Clicks the remove button that is displayed on the cart page beside a product
     * or item
     *
     * @param  NONE
     * @return void
     */
    public void clickRemoveItem () {
        removeItemButton.click();
    }

    /**
     * Clicks the checkout button that is displayed  at the bottom
     * of the cart page
     *
     * @param  NONE
     * @return void
     */
    public void clickCheckout() {
        checkoutButton.click();
    }

}
