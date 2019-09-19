package com.cleartrip.booking.hotel;

import com.cleartrip.pages.HotelPage;
import com.cleartrip.test_conf.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseTest {


    @Test
    public void shouldBeAbleToSearchForHotels() {

        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.clickHotelLink();

        hotelPage.setLocalityTextBox("Indiranagar, Bangalore");
        hotelPage.selectByText("1 room, 2 adults");
        
    }

}
