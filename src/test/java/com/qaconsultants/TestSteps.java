package com.qaconsultants;

import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSteps implements En {
    private WebDriver driver;
    private ProductsPage productsPage;
    private LoginPage loginPage;
    private CartPage cartPage;

    private CheckoutPage checkoutPage;

    private PaymentPage paymentPage;

    private HomePage homePage;

    public TestSteps() {

        // setting up the configuration browser before each given
        // selenide method: page - static method (provide URL and page object class)
        Before(() -> {
            //Configuration.browser = "firefox";
            //Configuration.browserBinary = "C:/Program Files/Mozilla Firefox/firefox.exe";
//            System.setProperty("webdriver.gecko.driver", "C:/Users/tegodawatte/Downloads/geckodriver-v0.32.2-win32/geckodriver.exe");

            //WebDriver driver = new FirefoxDriver();
            driver = new FirefoxDriver();

        });


        Given("^I open login page$", () -> {
            System.out.println("I am on the login page");

            driver.get("https://automationexercise.com/login");
            Thread.sleep(1000);

        });

        When("^I login as a registered user$", () -> {

            System.out.println("I am logging in as a registered user");


            this.loginPage = new LoginPage(this.driver);

            loginPage.enterEmail("thamodh@email.com");
            loginPage.enterPassword("Password");
            loginPage.clickLogin();

            Thread.sleep(1000);

        });

        When("^I switch to open products page$", () -> {

            System.out.println("I am switching to the products page");

            this.homePage = new HomePage(this.driver);

            homePage.clickProductsPage();

            Thread.sleep(1000);

        });

        When("^I search t shirts on the products page$", () -> {


            this.productsPage = new ProductsPage(this.driver);

            productsPage.enterSearch("tshirts");
            productsPage.clickSearch();

            Thread.sleep(1000);
        });


        When("^I select two shirts I want and add to cart$", () -> {

            productsPage.selectFirstShirt();
            productsPage.selectSecondShirt();

            Thread.sleep(1000);

        });

        When("^I remove one shirt I do not want from the cart$", () -> {


            this.cartPage = new CartPage(this.driver);

            Thread.sleep(1000);

            cartPage.clickRemoveItem();

        });

        When("^I proceed to checkout to place my order$", () -> {

            cartPage.clickCheckout();

            Thread.sleep(1000);

        });

        When("^I place my order in checkout$", () -> {

            this.checkoutPage = new CheckoutPage(this.driver);

            checkoutPage.clickPlaceOrder();

            Thread.sleep(1000);
        });

        When("^I add my payment info to confirm my order$", () -> {

            this.paymentPage = new PaymentPage(this.driver);

            paymentPage.enterNameOnCard("Thamodh Egodawatte");
            paymentPage.enterCardNumber("1111 2222 3333 4444");
            paymentPage.enterCVC("123");
            paymentPage.enterExpiryMonth("01");
            paymentPage.enterExpiryYear("2030");

            paymentPage.clickConfirmOrder();

            Thread.sleep(1000);
        });

        When("^I download the invoice for the order I placed$", () -> {

            paymentPage.clickDownloadInvoice();

            Thread.sleep(1000);
        });


    }

}
