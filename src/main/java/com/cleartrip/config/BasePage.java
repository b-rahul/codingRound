package com.cleartrip.config;

import com.cleartrip.utils.WaitHelper;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public WaitHelper waitHelper;
    public BasePage(WebDriver nDriver) {
        this.driver = nDriver;
    }
}
