package com.danieljr.at.steps.lifecycle;

import com.danieljr.at.configuration.pageobjects.PageObjectBeanPostProcessor;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Daniel Junior.
 */
@Component
public class ExecutionLifecycle {

    @Autowired
    private PageObjectBeanPostProcessor pageObjectPostProcessor;

    @Autowired
    private WebDriverProvider driverProvider;

    @BeforeStory
    public void beforeStory() throws Exception {
        driverProvider.initialize();

        for (Object page : pageObjectPostProcessor.getPageObjects()) {
            PageFactory.initElements(driverProvider.get(), page);
        }
    }

    @AfterStory
    public void afterStory() throws Exception {
        driverProvider.end();
    }
}