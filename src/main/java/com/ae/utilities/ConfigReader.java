package com.ae.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.ae.constants.TestConstants;

public class ConfigReader {
	
	public static String readProperty(String key) {
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(TestConstants.getConfigPropertiesFile());
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties.getProperty(key);
	}

}
