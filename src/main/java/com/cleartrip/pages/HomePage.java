package com.cleartrip.pages;

import com.cleartrip.config.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//aside//li[@class='flightApp']")
    WebElement flightApp;

    @FindBy(xpath = "//aside//li[@class='hotelApp ']")
    WebElement hotelApp;

    @FindBy(xpath = "//aside//li[@class='trainsApp']")
    WebElement trainsApp;


    public HomePage(WebDriver nDriver) {
        super(nDriver);
    }


}
