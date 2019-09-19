package com.cleartrip.booking.flight;

import com.cleartrip.pages.FlightPage;
import com.cleartrip.test_conf.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseTest {


    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        FlightPage flightPage = new FlightPage(driver);

        flightPage.clickOneWay();

        flightPage.selectFirstOriginOption("Bangalore");


        flightPage.selectFirstDestinationOption("Delhi");


        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

        flightPage.clickSearch();

        waitHelper.waitFor(5000);

        Assert.assertTrue(waitHelper.isElementPresent(By.className("searchSummary")));
        
    }

}
