package com.qaconsultants;

import com.codeborne.selenide.Configuration;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class TestSteps implements En {
    public TestSteps() {

        // setting up the configuration browser before each given
        // selenide method: page - static method (provide URL and page object class)
        Before(() -> {
            Configuration.browser = "firefox";
            Configuration.browserBinary = "C:/Program Files/Mozilla Firefox/firefox.exe";
            System.setProperty("webdriver.gecko.driver", "C:/Users/tegodawatte/Downloads/geckodriver-v0.32.2-win32/geckodriver.exe");

            WebDriver driver = new FirefoxDriver();


        });

        WebDriver driver = new FirefoxDriver();

        Given("^I open login page$", () -> {
            System.out.println("I am on the login page");


            driver.get("https://automationexercise.com/login");

        });

        And("^I login as a registered user$", () -> {

            System.out.println("I am logging in as a registered user");


            driver.get("https://automationexercise.com/login");

            LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

            loginPage.enterEmail("thamodh@email.com");
            loginPage.enterPassword("Password");
            loginPage.clickLogin();

        });

        When("^I switch to open products page$", () -> {

            System.out.println("I am switching to the products page");


            driver.get("https://automationexercise.com/products");

        });

        And("^I search \"([^\"]*)\" on the products page$", (String tshirtSearch) -> {


            driver.get("https://automationexercise.com/products");

            ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);

            productsPage.enterSearch(tshirtSearch);
            productsPage.clickSearch();
        });

        And("^I select two shirts I want and add to cart$", () -> {


            driver.get("https://automationexercise.com/products");

            ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);

            productsPage.selectFirstShirt();
            productsPage.selectSecondShirt();

        });

        When("^I remove one shirt I do not want from the cart$", () -> {


            driver.get("https://automationexercise.com/view_cart");

            CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

            cartPage.clickRemoveItem();

        });

        And("^I proceed to checkout to place my order$", () -> {


            driver.get("https://automationexercise.com/view_cart");

            CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

            cartPage.clickCheckout();

        });

        And("^I place my order in checkout$", () -> {


            driver.get("https://automationexercise.com/checkout");

            CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);

            checkoutPage.clickPlaceOrder();
        });

        When("^I add my payment info to confirm my order$", () -> {

            driver.get("https://automationexercise.com/payment");

            PaymentPage paymentPage = PageFactory.initElements(driver, PaymentPage.class);

            paymentPage.enterNameOnCard("Thamodh Egodawatte");
            paymentPage.enterCardNumber("1111 2222 3333 4444");
            paymentPage.enterCVC("123");
            paymentPage.enterExpiryMonth("01");
            paymentPage.enterExpiryYear("2030");

            paymentPage.clickConfirmOrder();
        });

        When("^I download the invoice for the order I placed$", () -> {

            driver.get("https://automationexercise.com/payment_done/1000");

            PaymentPage paymentPage = PageFactory.initElements(driver, PaymentPage.class);

            paymentPage.clickDownloadInvoice();
        });


    }

     /*
           SelenideElement frame = Selenide.$(
                   By.xpath("//iframe[contains(@name,'aswift') and contains(@style,'visibility: visible')]"));
           if (frame.exists() && frame.isDisplayed()) {
               Selenide.switchTo().frame(frame);
               SelenideElement button = Selenide.$(By.id("dismiss-button"));
               // some Ads have that button in the first frame
               if (button.isDisplayed() && button.isEnabled()) {
                   button.click();
               } else {
                   // can check the second frame as well
                   Selenide.switchTo().frame(Selenide.$(By.id("ad_iframe")));
                   Selenide.$(By.id("dismiss-button")).click();
                   Selenide.switchTo().defaultContent();
               }
           }

            */

}
