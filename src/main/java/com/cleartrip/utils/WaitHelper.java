package com.cleartrip.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WaitHelper {

    private WebDriver driver;

    public WaitHelper(WebDriver nDriver) {
        this.driver = nDriver;

    }

    public void waitFor(int inMilliSeconds) {
        try {

            TimeUnit.MILLISECONDS.sleep(inMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hard wait...");
    }


    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
