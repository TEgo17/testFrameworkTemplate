package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UsingCheckoutPage {

    public static void main (String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://automationexercise.com/checkout");

        CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);

        checkoutPage.clickPlaceOrder();

    }
}
