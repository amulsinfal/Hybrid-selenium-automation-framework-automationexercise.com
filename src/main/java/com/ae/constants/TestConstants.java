package com.ae.constants;

public class TestConstants {

	private static final String CONFIG_PROPERTIES_FILE =  System.getProperty("user.dir") + "\\src\\test\\resources\\configurations\\config.properties";
	private static final String EXTENT_REPORT_FILE = System.getProperty("user.dir")+"\\reports\\ExecutionReport.html";
	private static final String JSON_DATA_FILE_LOCATION = System.getProperty("user.dir")+ "\\src\\test\\resources\\testdata\\";

	public static String getConfigPropertiesFile() {
		return CONFIG_PROPERTIES_FILE;
	}

	public static String getReportFileName() {
		return EXTENT_REPORT_FILE;
	}
	
	public static String getJSONDataFilePath() {
		return JSON_DATA_FILE_LOCATION;
	}
	
}
