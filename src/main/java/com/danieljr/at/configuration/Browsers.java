package com.danieljr.at.configuration;

/**
 * Created by Daniel Junior
 */
public enum Browsers {
    CHROME("chrome", "webdriver.chrome.driver", "/src/main/resources/drivers/chromedriver.exe"),
    FIREFOX("firefox", "webdriver.gecko.driver", "/src/main/resources/drivers/geckodriver.exe"),
    IE("ie", "webdriver.ie.driver", "/src/main/resources/drivers/IEDriverServer.exe");

    private final String name;
    private final String propertyName;
    private final String driverPath;

    Browsers(String name, String propertyName, String driverPath) {
        this.name = name;
        this.propertyName = propertyName;
        this.driverPath = driverPath;
    }

    public static Browsers of(String name) {
        for (Browsers browser : Browsers.values()) {
            if (browser.getName().equalsIgnoreCase(name)) {
                return browser;
            }
        }
        throw new IllegalArgumentException("Browser Name '" + name + "' not found");
    }

    public String getName() {
        return name;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getDriverPath() {
        return driverPath;
    }
}