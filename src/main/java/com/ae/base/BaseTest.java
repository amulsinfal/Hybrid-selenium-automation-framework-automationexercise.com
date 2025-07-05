package com.ae.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ae.factory.DriverFactory;
import com.ae.utilities.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	private final static Logger LOG = LogManager.getLogger(BaseTest.class);
	private static String browser;
	
	
	@BeforeMethod (alwaysRun = true)
	public void initializeBrowser() {
		browser = System.getProperty("browser")!=null ? System.getProperty("browser") : ConfigReader.readProperty("browser");
		driver = DriverFactory.intializeDriver(browser);
		LOG.info("Navigating to url: '" + ConfigReader.readProperty("url") + "'");
		driver.get(ConfigReader.readProperty("url"));
	}
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser() {
		DriverFactory.getDriver().quit();
		LOG.info("'" + browser + "' browser closed successfully.");
	}
}