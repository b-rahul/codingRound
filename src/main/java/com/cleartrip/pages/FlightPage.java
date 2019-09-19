package com.cleartrip.pages;

import com.cleartrip.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.fail;

public class FlightPage extends HomePage {


    @FindBy(id = "OneWay")
    WebElement oneWay;

    @FindBy(id = "FromTag")
    WebElement fromTag;

    @FindBy(id = "ui-id-1")
    WebElement originOptions;

    @FindBy(id = "toTag")
    WebElement toTag;

    @FindBy(id = "ui-id-2")
    WebElement destinationOptions;

    @FindBy(id = "SearchBtn")
    WebElement searchBtn;

    public FlightPage(WebDriver nDriver) {
        super(nDriver);
        waitHelper = new WaitHelper(nDriver);
        PageFactory.initElements(driver, this);
    }


    private List<WebElement> getOriginOptions() {
        return originOptions.findElements(By.tagName("li"));
    }

    private List<WebElement> getDestinationOptions() {
        return destinationOptions.findElements(By.tagName("li"));
    }


    public void selectFirstOriginOption(String seachedText) {
        fromTag.clear();
        fromTag.sendKeys(seachedText);

        // can add some fluent wait until the optinos are available
        waitHelper.waitFor(2000);

        List<WebElement> originOptions = getOriginOptions();
        if (originOptions.size() != 0)
            originOptions.get(0).click();
        else
            fail("No origin options available !! ");
    }


    public void selectFirstDestinationOption(String searchedText) {
        toTag.clear();
        toTag.sendKeys(searchedText);

        waitHelper.waitFor(2000);

        List<WebElement> originOptions = getDestinationOptions();
        if (originOptions.size() != 0)
            originOptions.get(0).click();
        else
            fail("No destination options available !! ");
    }

    public void clickSearch() {
        searchBtn.click();
    }

    public void clickOneWay(){
        oneWay.click();
    }
}
