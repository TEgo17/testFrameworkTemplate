package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    // FireFox web driver
    private WebDriver driver;

    // super constructor
    public HomePage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
        PageFactory.initElements(driver, this);

    }

    // ------------------- Locators for the Home Page -----------------------------
    @FindBy(how = How.XPATH, using = "//*[@href='/products']")
    private WebElement productsButton;
    @FindBy(how = How.XPATH, using = "//*[@href='/view_cart']")
    private WebElement cartButton;


    // --------------------- Methods for the Home Page --------------------------------
    /**
     * Clicks the products icon in the Navigation bar at the top of the Home Page
     * to switch over to the Products Page
     *
     * @param  NONE
     * @return void
     */
    public void clickProductsPage () {
        productsButton.click();
    }

    /**
     * Clicks the cart icon in the Navigation bar at the top of the Home Page
     * to switch over to the Cart Page
     *
     * @param  NONE
     * @return void
     */
    public void clickCartPage () {
        cartButton.click();
    }


}
