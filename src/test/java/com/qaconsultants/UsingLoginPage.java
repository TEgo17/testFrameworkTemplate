package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UsingLoginPage {

    public static void main (String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://automationexercise.com/login");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.enterEmail("thamodh@email.com");
        loginPage.enterPassword("Password");
        loginPage.clickLogin();

    }
}
