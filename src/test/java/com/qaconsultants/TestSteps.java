package com.qaconsultants;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java8.En;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class TestSteps implements En {
    public TestSteps() {

       // setting up the configuration browser before each given
        // selenide method: page - static method (provide URL and page object class)
       Before(() -> {
           Configuration.browser = "firefox";
           Configuration.browserBinary = "C:/Program Files/Mozilla Firefox/firefox.exe";
           System.setProperty("webdriver.gecko.driver", "C:/Users/tegodawatte/Downloads/geckodriver-v0.32.2-win32/geckodriver.exe");
       });

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


        // Given to: open the login page
        Given("^I open login page$", () -> {
            System.out.println("I am on the login page");

            open("https://www.automationexercise.com/login");
        });

        // Given to: log into the website with valid credentials
        Given("^I login as a registered user$", () -> {
            System.out.println("I input my username and password on the login page");

            open("https://www.automationexercise.com/login");

            $(By.name("email")).sendKeys("thamodh@email.com");
            $(By.name("password")).sendKeys("Password");
            $x("//button[@type='submit']").click();
        });

        // Given to: switch from the home page to the products page
        Given("^I switch to open products page$", () -> {
            System.out.println("I am now on the products page");

            //open("https://www.automationexercise.com/products");
            $x("//*[@href='/products']").click();
        });

        // Given to: search for 'tshirts' in the search bar of the products page
        Given("^I search t shirts on the products page$", () -> {
            System.out.println("I have now searched for t shirts on the products page");

            $x("//input[@id='search_product']").sendKeys("tshirts");
            $x("//button[@id='submit_search']").click();
        });

        // Given to: select two tshirts from the products page and them to the cart
        Given("^I select two shirts I want and add to cart$", () -> {
            System.out.println("I am now selecting two shirts and adding to the cart");

            //$x("//div[@class='product-overlay']/descendant::p[text()='Men Tshirt']/following-sibling::a[@class='btn btn-default add-to-cart']").shouldBe(Condition.enabled, Duration.ofSeconds(3)).click();


            // add first shirt
            $x("//div[@class='product-image-wrapper']").scrollTo().hover();
          //  $x("//div[@class='single-products']/*/*[@data-product-id='2']").shouldBe(Condition.enabled, Duration.ofSeconds(3)).click();
            $x("//*[@data-product-id='2']").shouldBe(Condition.enabled, Duration.ofSeconds(3)).click();


            // press 'Continue Shopping' button
            $x("//*[@class='btn btn-success close-modal btn-block']").click();

            // add secord shirt
            $x("//div[@class='product-image-wrapper']").scrollTo().hover();
           // $x("//div[@class='single-products']/*/*[@data-product-id='28']").shouldBe(Condition.enabled, Duration.ofSeconds(3)).click();
            $x("//*[@data-product-id='28']").shouldBe(Condition.enabled, Duration.ofSeconds(3)).click();

            // press 'View Cart' button
            $x("//*[text()='View Cart']").click();

        });

        // Given to: remove a shirt from the cart
        Given("^I remove one shirt I do not want from the cart$", () -> {
            System.out.println("I am now removing one shirts from the cart");

            $x("//*[@class='cart_delete']").click();
        });

        // Given to: proceed to checkout and place the order
        Given("^I proceed to checkout to place my order$", () -> {
            System.out.println("I have now proceeded to checkout and I am placing my order");

            // Proceed to checkout button
            $x("//*[@class='btn btn-default check_out']").click();

            // Place order button
            $x("//*[text()='Place Order']").scrollTo().click();
        });

        // Given to: add the payment info to confirm the purchase of the order
        Given("^I add my payment info to confirm my order$", () -> {
            System.out.println("I am now adding my payment info to confirm my order");

            $(By.name("name_on_card")).sendKeys("Thamodh Egodawatte");
            $(By.name("card_number")).sendKeys("1234 1234 1234 1234");
            $(By.name("cvc")).sendKeys("999");
            $(By.name("expiry_month")).sendKeys("01");
            $(By.name("expiry_year")).sendKeys("2030");

            $x("//*[@class='form-control btn btn-primary submit-button']").click();
        });

        // Given to: download the invoice of the order that was placed
        Given("^I download the invoice for the order I placed$", () -> {
            System.out.println("I am now downloading my invoice for the order I placed");

            $x("//*[text()='Download Invoice']").click();
        });
        Given("^I search \"([^\"]*)\" on the products page$", (String tshirtSearch) -> {
            
        });

    }


}
