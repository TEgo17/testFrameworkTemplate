package com.qaconsultants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductsPage {




    // Locators for the Login Page ------------

    @FindBy(how = How.XPATH, using = "//input[@id='search_product']")
    private WebElement searchBar;

    @FindBy(how = How.XPATH, using = "//button[@id='submit_search']")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//div[@class='product-image-wrapper']")
    private WebElement scroll;

    @FindBy(how = How.XPATH, using = "//*[@data-product-id='2']")
    private WebElement firstShirt;

    @FindBy(how = How.XPATH, using = "//*[@data-product-id='28']")
    private WebElement secondShirt;

    @FindBy(how = How.XPATH, using = "//*[@class='btn btn-success close-modal btn-block']")
    private WebElement continueShoppingButton;

    @FindBy(how = How.XPATH, using = "//*[text()='View Cart']")
    private WebElement viewCartButton;



    public void enterSearch (String uSearch) {
        searchBar.sendKeys(uSearch);
    }

    public void clickSearch () {
        searchButton.click();
    }

    public void selectFirstShirt() {

        //scroll.scrollTo().hover();
        //firstShirt.shouldBe(Condition.enabled, Duration.ofSeconds(3)).click();

        firstShirt.click();

        continueShoppingButton.click();
    }

    public void selectSecondShirt() {
        //scroll.scrollTo().hover();
        //secondShirt.shouldBe(Condition.enabled, Duration.ofSeconds(3)).click();

        secondShirt.click();
        continueShoppingButton.click();
    }

}
