package com.qaconsultants;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    // FireFox web driver
    private WebDriver driver;

    // super constructor
    public ProductsPage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
        PageFactory.initElements(driver, this);
    }


    // ------------------- Locators for the Products Page ------------------------------

    @FindBy(how = How.XPATH, using = "//input[@id='search_product']")
    private WebElement searchBar;
    @FindBy(how = How.XPATH, using = "//button[@id='submit_search']")
    private WebElement searchButton;
    @FindBy(xpath= "//div[@class='product-image-wrapper']")
    private WebElement scroll;
    private WebElement shirt;
    private WebElement continueShoppingButton;



    // --------------------- Methods for the Products Page --------------------------------

    /**
     * Enters the user's search prompt into the search bar
     *
     * @param  uSearch  the user's search prompt
     * @return void
     */
    public void enterSearch (String uSearch) {
        searchBar.sendKeys(uSearch);
    }

    /**
     * Clicks on the search icon to search for the search
     * prompt that the user inputted in the search bar
     *
     * @param  NONE
     * @return void
     */
    public void clickSearch () {
        searchButton.click();
    }

    /**
     * Selects a shirt based on product ID from the Products page
     * after searching for 'tshirts' and adds it to the cart
     *
     * @param  productID   The number that represents the product ID of a shirt
     * @return void
     */
    public void selectShirt(String productID)  {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
        shirt = new WebDriverWait(this.driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-product-id='" + productID + "']")));
        shirt.click();

        continueShoppingButton = new WebDriverWait(this.driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-success close-modal btn-block']")));
        continueShoppingButton.click();
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
