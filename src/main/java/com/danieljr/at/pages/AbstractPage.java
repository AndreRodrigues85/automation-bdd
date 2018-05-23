package com.danieljr.at.pages;

import org.apache.log4j.Logger;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Daniel Junior.
 */
public abstract class AbstractPage {

    Logger log = Logger.getLogger(this.getClass());

    @Autowired
    WebDriverProvider webDriverProvider;

    private static WebDriverWait wait;

    private static final int TIMER = 15;

    private WebDriverWait wait(WebDriverProvider driverProvider) {
        if (wait == null) {
            wait = new WebDriverWait(driverProvider.get(), TIMER);
        }
        return wait;
    }

    private void waitUntil(WebElement element) {
        wait(webDriverProvider).until((ExpectedConditions.visibilityOf(element)));
    }

    public void selectByVisibleText(WebElement element, String text) {
        waitUntil(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public String getFirstSelectedValue(WebElement element) {
        waitUntil(element);
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public List<String> getAllDropDownOptions(WebElement element) {
        waitUntil(element);
        Select select = new Select(element);
        List<String> stringList = new LinkedList<>();
        for (WebElement webElement : select.getOptions()) {
            stringList.add(webElement.getText().trim());
        }
        return stringList;
    }
}