package com.equalExports.technical.assement;

import com.equalExports.technical.assement.driver.DriverHelp;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    public DriverHelp driverHelper = new DriverHelp();

    @Before
    public void setUp()  {
        driverHelper.openBrowser();
        driverHelper.navigateTo();
        driverHelper.maxBrowser();
        driverHelper.applyImpWait();
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            driverHelper.embedScreenshot(scenario);
        }
        driverHelper.closeBrowser();
    }
}
