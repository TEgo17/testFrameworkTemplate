package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;
    public CheckoutPage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
        PageFactory.initElements(driver, this);

    }

    // Locators for the Login Page ------------

    @FindBy(how = How.XPATH, using = "//*[text()='Place Order']")
    private WebElement placeOrderButton;

    public void clickPlaceOrder () {
       placeOrderButton.click();
    }

}
