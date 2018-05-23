package com.danieljr.at.pages;

import com.danieljr.at.configuration.pageobjects.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Daniel Junior.
 */
@PageObject
public class LoginPage extends AbstractPage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    private WebElement messageLabel;

    @FindBy(className = "page-heading")
    private WebElement pageHeadingText;

    public LoginPage typeEmail(String email) {
        log.info("Email: " + email);

        emailInput.clear();
        emailInput.sendKeys(email);

        return this;
    }

    public LoginPage typePassword(String password) {
        log.info("Password: " + password);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
        log.info("Clicked on Login button.");
    }

    public String getMessageLabel() {
        String message = messageLabel.getText();
        log.info("Message found: " + message);
        return message;
    }

    public String getPageHeadingText() {
        String message = pageHeadingText.getText();
        log.info("Message found: " + message);
        return message;
    }
}