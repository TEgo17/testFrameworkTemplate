package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    // FireFox web driver
    private WebDriver driver;

    // super constructor
    public LoginPage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
        PageFactory.initElements(driver, this);
    }

    // ------------------- Locators for the Login Page ------------------------------
    @FindBy(how = How.NAME, using = "email")
    private WebElement emailField;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement loginButton;


    // --------------------- Methods for the Login Page --------------------------------

    /**
     * Enters the email of the user into the username field
     * to log in to the site from the Login Page
     *
     * @param  uEmail  the email of the user
     * @return void
     */
    public void enterEmail (String uEmail) {
        emailField.sendKeys(uEmail);
    }

    /**
     * Enters the password of the user into the password field
     * to log in to the site from the Login Page
     *
     * @param  uPassword  the email of the user
     * @return void
     */
    public void enterPassword (String uPassword) {
        passwordField.sendKeys(uPassword);
    }

    /**
     * Clicks the login button to log into the site and
     * open the Home Page
     *
     * @param  NONE
     * @return void
     */
    public void clickLogin () {
        loginButton.click();
    }
}
