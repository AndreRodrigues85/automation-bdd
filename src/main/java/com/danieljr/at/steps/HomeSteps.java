package com.danieljr.at.steps;

import com.danieljr.at.pages.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Daniel Junior.
 */
@Component
public class HomeSteps extends AbstractSteps {

    @Autowired
    private HomePage homePage;

    @Given("I am on the website home page")
    public void navigateToHomePage() {
        homePage.navigateTo();
    }

    @When("I navigate to the login page")
    public void navigateToLoginPage() {
        homePage.navigateToLoginPage();
    }
}