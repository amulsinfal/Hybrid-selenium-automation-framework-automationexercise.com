package com.ae.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ae.constants.TestConstants;

public class JSONReader {

	public static String getExistingUserDetails(String data){
        String value = null;
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader fileReader = new FileReader(TestConstants.getJSONDataFilePath() + "ExistingUser.json");
			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
			value = (String) jsonObject.get(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;	
	}
	
	public static String getNewUserDetails(String data){
        String value = null;
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader fileReader = new FileReader(TestConstants.getJSONDataFilePath()+ "NewUser.json");
			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
			value = (String) jsonObject.get(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;	
	}
	
	public static String getCheckoutInfoDetails(String data){
        String value = null;
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader fileReader = new FileReader(TestConstants.getJSONDataFilePath());
			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
			value = (String) jsonObject.get(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;	
	}
}