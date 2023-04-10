package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    private WebDriver driver;
    public PaymentPage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
        PageFactory.initElements(driver, this);

    }

    // Locators for the Payment Page ------------

    @FindBy(how = How.NAME, using = "name_on_card")
    private WebElement nameOnCard;

    @FindBy(how = How.NAME, using = "card_number")
    private WebElement cardNumber;

    @FindBy(how = How.NAME, using = "cvc")
    private WebElement cvc;

    @FindBy(how = How.NAME, using = "expiry_month")
    private WebElement expiryMonth;

    @FindBy(how = How.NAME, using = "expiry_year")
    private WebElement expiryYear;

    @FindBy(how = How.XPATH, using = "//*[@class='form-control btn btn-primary submit-button']")
    private WebElement confirmOrderButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Download Invoice']")
    private WebElement downloadInvoice;

    public void enterNameOnCard (String uNameOnCard) {
        nameOnCard.sendKeys(uNameOnCard);
    }
    public void enterCardNumber (String uCardNumber) {
        cardNumber.sendKeys(uCardNumber);
    }

    public void enterCVC (String uCVC) {
        cvc.sendKeys(uCVC);
    }

    public void enterExpiryMonth (String uExpiryMonth) {
        expiryMonth.sendKeys(uExpiryMonth);
    }

    public void enterExpiryYear(String uExpiryYear) {
        expiryYear.sendKeys(uExpiryYear);
    }

    public void clickConfirmOrder () {
        confirmOrderButton.click();
    }

    public void clickDownloadInvoice() {
        downloadInvoice.click();
    }
}
