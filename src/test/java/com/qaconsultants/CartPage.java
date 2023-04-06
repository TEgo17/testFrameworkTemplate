package com.qaconsultants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage {


    // Locators for the Login Page ------------

    @FindBy(how = How.XPATH, using = "//*[@class='cart_delete']")
    private WebElement removeItemButton;

    @FindBy(how = How.XPATH, using = "//*[@class='btn btn-default check_out']")
    private WebElement checkoutButton;

    public void clickRemoveItem () {
        removeItemButton.click();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

}
