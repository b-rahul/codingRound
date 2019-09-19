package com.cleartrip.test_conf;

import com.cleartrip.config.Config;
import com.cleartrip.factory.DriverFactory;
import com.cleartrip.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.fail;

public class BaseTest {

    public WebDriver driver;

    public WaitHelper waitHelper;

    @BeforeClass
    public void runBeforeEveryTestClass() {
        System.out.println("===================== Base Start Classes ===================== ");
        driver = DriverFactory.getInstance().getDriver();

        if (driver == null)
            fail("Driver not initialized !!!");
        driver.get(Config.BASE_URL);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitFor(2000);
    }


    @AfterClass(alwaysRun = true)
    public void baseTearDown() {
        System.out.println("===================== Base Tear Classes ===================== ");
        DriverFactory.getInstance().removeDriver();
    }


}
