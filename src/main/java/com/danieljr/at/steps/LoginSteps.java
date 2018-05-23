package com.danieljr.at.steps;

import com.danieljr.at.pages.LoginPage;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Daniel Junior.
 */
@Component
public class LoginSteps extends AbstractSteps {

    @Autowired
    private LoginPage loginPage;

    @When("I login as $email with password $password")
    public void loginAs(@Named("email") String email,
                        @Named("password") String password) {
        loginPage.typeEmail(email)
                .typePassword(password)
                .clickLoginButton();
    }

    @When("I try to login with email $email and without password")
    public void loginWithPasswordRequired(@Named("email") String email) {
        loginPage.typeEmail(email)
                .clickLoginButton();
    }

    @When("I try to login with password $password and without email")
    public void loginWithEmailRequired(@Named("password") String password) {
        loginPage.typePassword(password)
                .clickLoginButton();
    }

    @Then("I should see the validation message: $message")
    public void assertValidationMessage(@Named("message") String message) {
        Assert.assertEquals(message, loginPage.getMessageLabel());
    }

    @Then("I check to see the title $title at the signin page")
    public void checkToSeeSignInPageDisplayed(@Named("title") String title) {
        Assert.assertEquals(title, loginPage.getPageHeadingText());
    }
}