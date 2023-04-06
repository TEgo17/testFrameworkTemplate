package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UsingPaymentPage {

    public static void main (String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://automationexercise.com/payment");

        PaymentPage paymentPage = PageFactory.initElements(driver, PaymentPage.class);

        paymentPage.enterNameOnCard("Thamodh Egodawatte");
        paymentPage.enterCardNumber("1111 2222 3333 4444");
        paymentPage.enterCVC("123");
        paymentPage.enterExpiryMonth("01");
        paymentPage.enterExpiryYear("2030");

        paymentPage.clickConfirmOrder();
        paymentPage.clickDownloadInvoice();

    }
}
