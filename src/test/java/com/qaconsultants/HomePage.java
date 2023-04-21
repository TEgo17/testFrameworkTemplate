package com.qaconsultants;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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


    private boolean clickDismissButton() {
        if (driver.findElements(By.xpath("//*[@id='dismiss-button']"))
                .size() == 1) {
            WebElement dismissButton = driver.findElement(By.xpath("//*[@id='dismiss-button']"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", dismissButton);
            return true;
        }
        return false;
    }

    public void blockAds() throws InterruptedException {
        try {
            System.out.println("testing to close pop-up ads");

            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

            for (int i = 0; i < iframes.size(); i++) {
                driver.switchTo().frame(i);
                System.out.println("frame: " + i);

                int adCounter = driver.findElements(By.xpath("//div[@id='ad_position_box']")).size();

                if (adCounter == 1) {
                    if (clickDismissButton()) {
                        break;
                    }
                    else {
                        driver.switchTo().frame("ad_iframe");
                        if (clickDismissButton()) {
                            break;
                        }
                    }
                }
                driver.switchTo().parentFrame();
            }
        } catch (Exception e) {
            System.out.println("no ads found");
        }

        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }

}
