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

public class ProductsPage {


    private WebDriver driver;
    public ProductsPage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
        PageFactory.initElements(driver, this);

    }


    // Locators for the Login Page ------------

    @FindBy(how = How.XPATH, using = "//input[@id='search_product']")
    private WebElement searchBar;

    @FindBy(how = How.XPATH, using = "//button[@id='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath= "//div[@class='product-image-wrapper']")
    private WebElement scroll;


    private WebElement firstShirt;

    private WebElement secondShirt;

    private WebElement continueShoppingButton;

    private WebElement viewCartButton;



    public void enterSearch (String uSearch) {
        searchBar.sendKeys(uSearch);
    }

    public void clickSearch () {
        searchButton.click();
    }

    public void selectFirstShirt()  {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
        firstShirt = new WebDriverWait(this.driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-product-id='2']")));
        firstShirt.click();

        continueShoppingButton = new WebDriverWait(this.driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-success close-modal btn-block']")));
        continueShoppingButton.click();
    }

    public void selectSecondShirt()  {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
        secondShirt = new WebDriverWait(this.driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-product-id='28']")));
        secondShirt.click();

        viewCartButton = new WebDriverWait(this.driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='View Cart']")));
        viewCartButton.click();
    }

}
