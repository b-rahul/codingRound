package com.cleartrip.factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {


    private static DriverFactory instance = new DriverFactory();
    String runtype = System.getProperty("runtype");


    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {

        @Override
        protected WebDriver initialValue() {

            System.out.println("runtype :: " + runtype);

            if (runtype.equalsIgnoreCase("local")) {
                return LocalDriverFactory.getDriver();
            }

            if (runtype.equalsIgnoreCase("remote")) {
                // For remote driver
                //  return RemoteDriverFactory.getDriver(browser);
            }
            return null;
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();

    }
}
