package com.danieljr.at.pages;

import com.danieljr.at.configuration.pageobjects.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Daniel Junior.
 */
@PageObject
public class HomePage extends AbstractPage {

    @Value("${base.url}")
    private String APP_URL;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement loginMenuOption;

    public void navigateTo() {
        log.info("Navigating to the page: " + APP_URL);
        webDriverProvider.get().get(APP_URL);
    }

    public void navigateToLoginPage() {
        loginMenuOption.click();
        log.info("Clicked on Login menu option.");
    }
}