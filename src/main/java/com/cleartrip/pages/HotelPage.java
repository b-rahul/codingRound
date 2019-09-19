package com.cleartrip.pages;

import com.cleartrip.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelPage extends HomePage {


    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    public HotelPage(WebDriver nDriver) {
        super(nDriver);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitFor(3000);
        
        PageFactory.initElements(driver, this);
    }


    public void clickHotelLink() {
        hotelLink.click();
    }

    public void setLocalityTextBox(String seachTex) {
        localityTextBox.sendKeys(seachTex);
    }


    public void selectByText(String text) {
        new Select(travellerSelection).selectByVisibleText(text);
        searchButton.click();
    }
}
