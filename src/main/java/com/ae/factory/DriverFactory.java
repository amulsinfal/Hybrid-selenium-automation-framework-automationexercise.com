package com.ae.factory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ae.utilities.ConfigReader;

public class DriverFactory {

	private static WebDriver driver;
	private static final Logger LOG = LogManager.getLogger(DriverFactory.class);

	public static WebDriver intializeDriver(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("Chromeheadless")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			if(browserName.contains("headless")) {
				chromeOptions.addArguments("--headless");
				LOG.info("Chrome browser will be launched in headless mode.");
			}
			driver = new ChromeDriver(chromeOptions);
			LOG.info("Chrome browser launched.");
		} else if (browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("Firefoxheadless")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--private");
			if(browserName.contains("headless")) {
				firefoxOptions.addArguments("--headless");
				LOG.info("Firefox browser will be launched in headless mode.");
			}
			driver = new FirefoxDriver(firefoxOptions);
			LOG.info("Firefox browser launched.");
		} else if (browserName.equalsIgnoreCase("Edge") || browserName.equalsIgnoreCase("Edgeheadless")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("-inprivate");
			if(browserName.contains("headless")) {
				edgeOptions.addArguments("--headless");	
				LOG.info("Edge browser will be launched in headless mode.");
			}
			driver = new EdgeDriver(edgeOptions);
			LOG.info("Edge browser launched.");
		} else {
			LOG.error("Invalid browser name provided: " + browserName+ ". Launching the test in chrome browser.");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			if(browserName.contains("headless")) {
				chromeOptions.addArguments("--headless");
				LOG.info("Chrome browser will be launched in headless mode.");
			}
			driver = new ChromeDriver(chromeOptions);
			LOG.info("Chrome browser launched.");
		}
		driver.manage().window().maximize();
		LOG.info("Browser maximised.");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.readProperty("implicitWait"))));
		LOG.info("Implicit wait set to " + ConfigReader.readProperty("implicitWait") + " seconds.");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.readProperty("pageLoadTime"))));
		LOG.info("Page load timeout set to " + ConfigReader.readProperty("implicitWait") + " seconds.");		
		driver.manage().deleteAllCookies();
		LOG.info("All browser cookies deleted.");
		LOG.info("WebDriver initialization complete.");
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
