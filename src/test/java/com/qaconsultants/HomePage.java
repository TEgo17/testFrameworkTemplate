package com.qaconsultants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

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

    /**
     * Blocks incoming ads in Chrome and Firefox browsers by locating the dismiss ad
     * button and clicking it
     *
     * @param  NONE
     * @return void
     */
    public void adBlocker() {

        WebElement frame = driver.findElement(By.xpath("//iframe[contains(@name,'aswift') and contains(@style,'visibility: visible')]"));

        if (frame.isDisplayed()) {

            driver.switchTo().frame(frame);

            List <WebElement> button = driver.findElements(By.xpath("//div[@id='dismiss-button']"));

            // some ads the dismiss ad button in the first frame
            if (!button.isEmpty()) {
                button.get(0).click();
            }
            else {
                // check the second frame if the dismiss ad button is NOT in the first frame
                driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
                driver.findElement(By.id("dismiss-button")).click();
                driver.switchTo().defaultContent();
            }
        }
    }

}
