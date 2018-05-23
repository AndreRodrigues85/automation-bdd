package com.danieljr.at.configuration;

import org.jbehave.web.selenium.PropertyWebDriverProvider;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Daniel Junior.
 */
@Configuration
@ComponentScan({"com.danieljr.at"})
@PropertySource("classpath:data/test-data.properties")
public class ProjectConfiguration {

    @Value("${browser.name}")
    private String browserName;

    @Bean
    public WebDriverProvider webDriverProvider() {
        WebDriverProvider webDriverProvider = new PropertyWebDriverProvider();

        Browsers browser = Browsers.of(browserName);
        String browserDriverLocation = System.getProperty("user.dir") + browser.getDriverPath();
        System.setProperty("browser", browser.getName());
        System.setProperty(browser.getPropertyName(), browserDriverLocation);

        return webDriverProvider;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public WebDriverScreenshotOnFailure screenshotOnFailureDriver() {
        return new WebDriverScreenshotOnFailure(webDriverProvider());
    }
}