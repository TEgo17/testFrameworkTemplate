package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    public HomePage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
        PageFactory.initElements(driver, this);

    }

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
