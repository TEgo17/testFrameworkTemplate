package com.qaconsultants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage {

    // -------------- [Locators for the Login Page] --------------------

    @FindBy(how = How.NAME, using = "email")
    private WebElement emailField;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement loginButton;


    // -------------- [Methods for the Login Page] --------------------

    public void enterEmail (String uEmail) {
        emailField.sendKeys(uEmail);
    }

    public void enterPassword (String uPassword) {
        passwordField.sendKeys(uPassword);
    }

    public void clickLogin () {
        loginButton.click();
    }


}
