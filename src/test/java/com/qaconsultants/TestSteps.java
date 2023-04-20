package com.qaconsultants;

import io.cucumber.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * This TestSteps class uses the Cucumber and Selenium external libraries to automate a
 * scenario of a registered user logging into a site called AutomationExercise. The user
 * will log in, search for t-shirts, pick 2 t-shirts, remove one t-shirt later in the cart,
 * proceed to checkout, add payment info to place the order and then finally download the invoice
 *
 * @author Thamodh Egodawatte
 * @version 1.0
 * @since 03-20-2023
 */

public class TestSteps implements En {

    // logger to document the test cases and conditions
    private static Logger logger = LogManager.getLogger("MyLogger");


    // web driver to access website
    private WebDriver driver;

    // ----- Page Object Model classes -------------
    private ProductsPage productsPage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;
    private HomePage homePage;

    public TestSteps() {

        // setting up the configuration browser  before each given statement
        Before(() -> {
            logger.debug("setting up Firefox web driver");
            driver = new FirefoxDriver();
            logger.info("Firefox web driver set up");
        });

        // Given to: open the Automation Exercise website to the Login Page
        Given("^I open login page$", () -> {

            logger.debug("opening the login page");
            driver.get("https://automationexercise.com/login");
            logger.info("opened the login page");

            Thread.sleep(1000);
        });

        // Given to: add login credentials to log into the site as a registered user
        When("^I login as a registered user$", () -> {

            // LoginPage object
            this.loginPage = new LoginPage(this.driver);

            logger.debug("entering login credentials and logging into site");
            loginPage.enterEmail("thamodh@email.com");
            loginPage.enterPassword("Password");
            loginPage.clickLogin();
            logger.info("added login credentials and logged in");

            Thread.sleep(1000);
        });

        // Given to: switch from the Home Page to the Products Page
        When("^I switch to open products page$", () -> {

            // HomePage object
            this.homePage = new HomePage(this.driver);

           // Thread.sleep(2000);

           // homePage.blockAds();

            logger.debug("switching from the home page to the products page");
            homePage.clickProductsPage();
            logger.info("switched to product page from home page");

            Thread.sleep(1000);
        });

        // Given to: search 'tshirts' in the search bar on the Products Page
        When("^I search t shirts on the products page$", () -> {

            // ProductsPage object
            this.productsPage = new ProductsPage(this.driver);

            logger.debug("searching for t-shirts in the search bar");
            productsPage.enterSearch("tshirts");
            productsPage.clickSearch();
            logger.info("searched for t-shirts");

            Thread.sleep(1000);
        });

        // Given to: select two t-shirts from the Products Page
        When("^I select two shirts I want and add to cart$", () -> {

            logger.debug("selecting two shirts and adding them to the cart");
            productsPage.selectShirt("2");
            productsPage.selectShirt("28");
            logger.info("selected two t-shirts and added them to the cart");

            Thread.sleep(1000);
        });

        When("^I switch to open cart page$", () -> {

            logger.debug("switching from products page to cart page");
            homePage.clickCartPage();
            logger.info("switched to cart page from the products pages");

            Thread.sleep(1000);
        });

        // Given to: remove one t-shirt from the Cart Page
        When("^I remove one shirt I do not want from the cart$", () -> {

            // CartPage object
            this.cartPage = new CartPage(this.driver);

            logger.debug("removing one t-shirt from the cart");
            cartPage.clickRemoveItem();
            logger.info("removed a t-shirt from the cart");

            Thread.sleep(1000);
        });

        // Given to: proceed to the Checkout Page from the Cart Page
        When("^I proceed to checkout to place my order$", () -> {

            logger.debug("clicking button to proceed to checkout");
            cartPage.clickCheckout();
            logger.info("clicked the button to enter the checkout");

            Thread.sleep(1000);
        });

        // Given to: place the order in  the Checkout Page
        When("^I place my order in checkout$", () -> {

            // CheckoutPage object
            this.checkoutPage = new CheckoutPage(this.driver);

            logger.debug("clicking button to place order");
            checkoutPage.clickPlaceOrder();
            logger.info("clicked button to place order");

            Thread.sleep(1000);
        });

        // Given to: adding the payment info in the Payment Page to confirm the order
        When("^I add my payment info to confirm my order$", () -> {

            // PaymentPage object
            this.paymentPage = new PaymentPage(this.driver);

            logger.debug("entering payment details to confirm order");
            paymentPage.enterNameOnCard("Thamodh Egodawatte");
            paymentPage.enterCardNumber("1111 2222 3333 4444");
            paymentPage.enterCVC("123");
            paymentPage.enterExpiryMonth("01");
            paymentPage.enterExpiryYear("2030");
            logger.info("entered payment details");

            logger.debug("clicking button to confirm order");
            paymentPage.clickConfirmOrder();
            logger.info("clicked button to confirm order");

            Thread.sleep(1000);
        });

        // Given to: downloading the invoice of the order in the Payment Page
        When("^I download the invoice for the order I placed$", () -> {

            logger.debug("downloading the invoice after payment is secured");
            paymentPage.clickDownloadInvoice();
            logger.info("downloaded the invoice");

            Thread.sleep(1000);
        });
    }
}
