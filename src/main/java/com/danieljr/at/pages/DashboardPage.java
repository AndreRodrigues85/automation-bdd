package com.danieljr.at.pages;

import com.danieljr.at.configuration.pageobjects.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Daniel Junior.
 */
@PageObject
public class DashboardPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOutMenuLink;

    @FindBy(className = "page-heading")
    private WebElement pageHeadingText;

    public void logout() {
        signOutMenuLink.click();
        log.info("Clicked to log out.");
    }

    public String getPageHeadingText() {
        String message = pageHeadingText.getText();
        log.info("Message found: " + message);
        return message;
    }
}