package com.nobroker.pages;

import com.nobroker.utility.BrowserFactory;
import com.nobroker.utility.ConfigDataProvider;
import com.nobroker.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    public WebDriver driver;
    public ConfigDataProvider config;
    @BeforeSuite
    public void setUpSuite() {
        config = new ConfigDataProvider();
    }
    @BeforeClass
    public void setup() {
        driver = BrowserFactory.startBrowser(driver, config.getBrowser(), config.getUrl());
    }
    @AfterClass
    public void teardown() {
        BrowserFactory.quitBrowser(driver);
    }

	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			Helper.CaptureScreenshot(driver);
		}

	}
}
