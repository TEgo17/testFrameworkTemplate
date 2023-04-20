package com.qaconsultants;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
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

    public void blockAds() {
        SelenideElement frame = Selenide.$(
                By.xpath("//iframe[contains(@name,'aswift') and contains(@style,'visibility: visible')]"));
        if (frame.exists() && frame.isDisplayed()) {
            Selenide.switchTo().frame(frame);
            SelenideElement button = Selenide.$(By.id("dismiss-button"));
            // some Ads have that button in the first frame
            if (button.isDisplayed() && button.isEnabled()) {
                button.click();
            } else {
                // can check the second frame as well
                Selenide.switchTo().frame(Selenide.$(By.id("ad_iframe")));
                Selenide.$(By.id("dismiss-button")).click();
                Selenide.switchTo().defaultContent();
            }
        }
    }

}
