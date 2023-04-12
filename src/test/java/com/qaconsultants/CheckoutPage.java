package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    // FireFox web driver
    private WebDriver driver;

    // super constructor
    public CheckoutPage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
        PageFactory.initElements(driver, this);

    }

    // ------------------- Locators for the Checkout Page -----------------------------
    @FindBy(how = How.XPATH, using = "//*[text()='Place Order']")
    private WebElement placeOrderButton;


    // --------------------- Methods for the Checkout Page --------------------------------

    /**
     * Clicks the place order button that is displayed on the bottom
     * of the checkout page for a user to advance to the Payment Page
     *
     * @param  NONE
     * @return void
     */
    public void clickPlaceOrder () {
        placeOrderButton.click();
    }

}
