package com.qaconsultants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    private WebDriver driver;

    // super constructor
    public PaymentPage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
        PageFactory.initElements(driver, this);
    }

    // ------------------- Locators for the Payment Page ------------------------------
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
    private WebElement downloadInvoiceButton;

    // --------------------- Methods for the Payment Page --------------------------------

    /**
     * Enters the name of the cardholder onto the corresponding
     * field in the Payment Page
     *
     * @param  uNameOnCard  the name of the cardholder
     * @return void
     */
    public void enterNameOnCard (String uNameOnCard) {
        nameOnCard.sendKeys(uNameOnCard);
    }

    /**
     * Enters the card number onto the corresponding
     * field in the Payment Page
     *
     * @param  uCardNumber  the name of the cardholder
     * @return void
     */
    public void enterCardNumber (String uCardNumber) {
        cardNumber.sendKeys(uCardNumber);
    }

    /**
     * Enters the card's CVC code onto the corresponding
     * field in the Payment Page
     *
     * @param  uCVC  the name of the cardholder
     * @return void
     */
    public void enterCVC (String uCVC) {
        cvc.sendKeys(uCVC);
    }

    /**
     * Enters the card's expiry month onto the corresponding
     * field in the Payment Page
     *
     * @param  uExpiryMonth  the name of the cardholder
     * @return void
     */
    public void enterExpiryMonth (String uExpiryMonth) {
        expiryMonth.sendKeys(uExpiryMonth);
    }

    /**
     * Enters the card's expiry year onto the corresponding
     * field in the Payment Page
     *
     * @param  uExpiryYear  the name of the cardholder
     * @return void
     */
    public void enterExpiryYear(String uExpiryYear) {
        expiryYear.sendKeys(uExpiryYear);
    }

    /**
     * Clicks the Pay and Confirm Order button to successfully
     * place the order
     *
     * @param  NONE
     * @return void
     */
    public void clickConfirmOrder () {
        confirmOrderButton.click();
    }

    /**
     * Clicks the Download Invoice button to download the
     * order's invoice
     *
     * @param  NONE
     * @return void
     */
    public void clickDownloadInvoice() {
        downloadInvoiceButton.click();
    }
}
