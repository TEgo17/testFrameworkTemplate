package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UsingProductsPage {

    public static void main (String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://automationexercise.com/products");

        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);

        productsPage.enterSearch("tshirts");
        productsPage.clickSearch();
        productsPage.selectFirstShirt();
        productsPage.selectSecondShirt();

    }
}
