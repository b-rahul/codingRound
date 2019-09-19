package com.cleartrip.factory;

import com.cleartrip.config.Config;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class LocalDriverFactory {


    public static WebDriver getDriver() {

        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Config.implicitTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Config.pageLoadTimeout, TimeUnit.SECONDS);
        maximizeWindow(driver);
        return driver;
    }


    public static void maximizeWindow(WebDriver driver) {

        if (PlatformUtil.isMac()) {
            java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Integer width = (int) screenSize.getWidth();
            Integer height = (int) screenSize.getHeight();

            org.openqa.selenium.Point targetPosition = new org.openqa.selenium.Point(0, 0);
            driver.manage().window().setPosition(targetPosition);
            org.openqa.selenium.Dimension targetSize = new org.openqa.selenium.Dimension(width, height);
            driver.manage().window().setSize(targetSize);
        } else {
            driver.manage().window().maximize();
        }


    }
}
