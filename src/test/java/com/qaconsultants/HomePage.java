package com.qaconsultants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    // Locators for the Home Page ------------

    @FindBy(how = How.XPATH, using = "//*[@href='/products']")
    private WebElement productsButton;

    @FindBy(how = How.XPATH, using = "//*[@href='/view_cart']")
    private WebElement cartButton;



    public void clickProductsPage () {
       productsButton.click();
    }

    public void clickCartPage () {
        cartButton.click();
    }


}
