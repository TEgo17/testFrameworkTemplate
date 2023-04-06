package com.qaconsultants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage {

    // Locators for the Login Page ------------

    @FindBy(how = How.XPATH, using = "//*[text()='Place Order']")
    private WebElement placeOrderButton;

    public void clickPlaceOrder () {
       placeOrderButton.click();
    }

}
