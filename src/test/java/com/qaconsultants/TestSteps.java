package com.qaconsultants;

import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.log4j.Logger;

public class TestSteps implements En {

    // logger to document the test cases and conditions
    private static Logger logger = Logger.getLogger(RunPagesTest.class);

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

            driver = new FirefoxDriver();
            logger.info("setting up web driver");
        });

        // Given to: open the Automation Exercise website to the Login Page
        Given("^I open login page$", () -> {

            logger.info("opening the login page");
            driver.get("https://automationexercise.com/login");

            Thread.sleep(1000);
        });

        // Given to: add login credentials to log into the site as a registered user
        When("^I login as a registered user$", () -> {

            // LoginPage object
            this.loginPage = new LoginPage(this.driver);

            logger.info("entering login credentials and logging into site");
            loginPage.enterEmail("thamodh@email.com");
            loginPage.enterPassword("Password");
            loginPage.clickLogin();

            Thread.sleep(1000);
        });

        // Given to: switch from the Home Page to the Products Page
        When("^I switch to open products page$", () -> {

            // HomePage object
            this.homePage = new HomePage(this.driver);

            logger.info("switching from the home page to the products page");
            homePage.clickProductsPage();

            Thread.sleep(1000);
        });

        // Given to: search 'tshirts' in the search bar on the Products Page
        When("^I search t shirts on the products page$", () -> {

            // ProductsPage object
            this.productsPage = new ProductsPage(this.driver);

            logger.info("searching for t-shirts in the search bar");
            productsPage.enterSearch("tshirts");
            productsPage.clickSearch();

            Thread.sleep(1000);
        });

        // Given to: select two t-shirts from the Products Page
        When("^I select two shirts I want and add to cart$", () -> {

            logger.info("selecting two shirts and adding them to the cart");
            productsPage.selectShirt("2");
            productsPage.selectShirt("28");

            Thread.sleep(1000);
        });

        When("^I switch to open cart page$", () -> {

            logger.info("switching from products page to cart page");
            homePage.clickCartPage();

            Thread.sleep(1000);
        });

        // Given to: remove one t-shirt from the Cart Page
        When("^I remove one shirt I do not want from the cart$", () -> {

            // CartPage object
            this.cartPage = new CartPage(this.driver);

            logger.info("removing one t-shirt from the cart");
            cartPage.clickRemoveItem();

            Thread.sleep(1000);
        });

        // Given to: proceed to the Checkout Page from the Cart Page
        When("^I proceed to checkout to place my order$", () -> {

            logger.info("clicking button to proceed to checkout");
            cartPage.clickCheckout();

            Thread.sleep(1000);
        });

        // Given to: place the order in  the Checkout Page
        When("^I place my order in checkout$", () -> {

            // CheckoutPage object
            this.checkoutPage = new CheckoutPage(this.driver);

            logger.info("clicking button to place order");
            checkoutPage.clickPlaceOrder();

            Thread.sleep(1000);
        });

        // Given to: adding the payment info in the Payment Page to confirm the order
        When("^I add my payment info to confirm my order$", () -> {

            // PaymentPage object
            this.paymentPage = new PaymentPage(this.driver);

            logger.info("entering payment details to confirm order");
            paymentPage.enterNameOnCard("Thamodh Egodawatte");
            paymentPage.enterCardNumber("1111 2222 3333 4444");
            paymentPage.enterCVC("123");
            paymentPage.enterExpiryMonth("01");
            paymentPage.enterExpiryYear("2030");

            paymentPage.clickConfirmOrder();

            Thread.sleep(1000);
        });

        // Given to: downloading the invoice of the order in the Payment Page
        When("^I download the invoice for the order I placed$", () -> {

            logger.info("downloading the invoice after payment is secured");
            paymentPage.clickDownloadInvoice();

            Thread.sleep(1000);
        });

    }
}
