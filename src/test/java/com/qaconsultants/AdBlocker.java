package com.qaconsultants;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class AdBlocker {

    /**
     * Blocks ads and pop-ups from displaying on the site using
     * Selenide frames
     *
     * @param  NONE
     * @return void
     */
    public void blockAds() {
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
    }

}
