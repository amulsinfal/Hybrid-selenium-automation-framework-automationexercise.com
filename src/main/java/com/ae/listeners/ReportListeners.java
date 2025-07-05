package com.ae.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ae.factory.DriverFactory;
import com.ae.reports.ExtentReportManager;
import com.ae.utilities.ConfigReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ReportListeners implements ITestListener {

	private static final Logger LOG = LogManager.getLogger(ReportListeners.class);
	public static ExtentReports report;
	public static ExtentTest test;
	private static String browser;

	@Override
	public void onStart(ITestContext context) {
		report = ExtentReportManager.setupExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		File extentReport = new File(ExtentReportManager.extentReportFile);
		LOG.info("ExtentReport generated : " + ExtentReportManager.extentReportFile);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
			LOG.info("Extent Report opened on the default browser.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getTestClass().getRealClass().getName() + " :: " +result.getMethod().getMethodName());
		browser = System.getProperty("browser")!=null ? System.getProperty("browser") : ConfigReader.readProperty("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			browser = "Chrome";
			test.log(Status.INFO, "'" + browser + "' Browser launched.");
		} else if (browser.equalsIgnoreCase("Chromeheadless") ) {
			browser = "Chrome";
			test.log(Status.INFO, "'" + browser + "' Browser launched in Headless mode.");
		} else if (browser.equalsIgnoreCase("Firefox") ) {
			browser = "Firefox";
			test.log(Status.INFO, "'" + browser + "' Browser launched.");
		} else if (browser.equalsIgnoreCase("Firefoxheadless") ) {
			browser = "Firefox";
			test.log(Status.INFO, "'" + browser + "' Browser launched in Headless mode.");
		} else if (browser.equalsIgnoreCase("Edge") ) {
			browser = "Edge";
			test.log(Status.INFO, "'" + browser + "' Browser launched.");
		} else if (browser.equalsIgnoreCase("Edgeheadless") ) {
			browser = "Edge";
			test.log(Status.INFO, "'" + browser + "' Browser launched in Headless mode.");
		} 
		test.log(Status.INFO, "Navigated to url: '" + ConfigReader.readProperty("url") + "'.");
		test.log(Status.INFO, "Test case '" + result.getMethod().getMethodName() + "' execution started.");
		test.log(Status.INFO, "Test description -'" + result.getMethod().getDescription() + "'.");
		LOG.info("********** Execution of '" + result.getMethod().getMethodName() + "' test has started **********");
		LOG.info("Test description -'" + result.getMethod().getDescription() + "'.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LOG.info("********** Execution of '" + result.getMethod().getMethodName() + "' test has passed **********");
		Markup markup = MarkupHelper.createLabel("Test case '" + result.getMethod().getMethodName() + "' execution passed.", ExtentColor.GREEN);
		test.log(Status.PASS, markup);
		test.log(Status.INFO, "'" + browser + "' browser quit successfully.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LOG.info("********** Execution of '" + result.getMethod().getMethodName() + "' test has failed **********");
		Markup markup = MarkupHelper.createLabel("Test case '" + result.getMethod().getMethodName() + "' execution failed.", ExtentColor.RED);
		test.log(Status.FAIL, markup);
		test.log(Status.FAIL, result.getThrowable());
		
		File source = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		String fileName = "Screenshot_" + result.getMethod().getMethodName() + "_" + new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date()) + ".png";
		String destinationPath = System.getProperty("user.dir") + "\\screenshots\\" + fileName;
		try {
			FileHandler.copy(source, new File(destinationPath));
		} catch (IOException e) {
			throw new RuntimeException("Error occured while copying screenshot to " + destinationPath);
		}
		test.addScreenCaptureFromPath(destinationPath);
		LOG.info("Screenshot captured : " + fileName);
		LOG.info("Exception occured : " + result.getThrowable());
		test.log(Status.INFO, "'" + browser + "' browser quit successfully.");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LOG.info("********** Execution of '" + result.getMethod().getMethodName() + "' test has skipped **********");
		LOG.info("Exception occured : " + result.getThrowable());
		Markup markup = MarkupHelper.createLabel("Test case '" + result.getMethod().getMethodName() + "' execution skipped.", ExtentColor.AMBER);
		test.log(Status.SKIP, markup);
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.INFO, "'" + browser + "' browser quit successfully.");
	}
}