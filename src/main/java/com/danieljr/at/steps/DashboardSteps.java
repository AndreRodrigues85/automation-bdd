package com.danieljr.at.steps;

import com.danieljr.at.pages.DashboardPage;
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
public class DashboardSteps extends AbstractSteps {

    @Autowired
    private DashboardPage dashboardPage;

    @When("I log out from the application")
    public void logoutFromApplication() {
        dashboardPage.logout();
    }

    @Then("I check to see the title $title at the dashboard page")
    public void checkToSeeThatDashboardPage(@Named("title") String title) {
        Assert.assertEquals(title, dashboardPage.getPageHeadingText());
    }
}