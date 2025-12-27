package com.store.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	String pathOfFile = "C:\\Users\\amitj\\OneDrive\\Desktop\\Demo_Test\\com.store.v1\\Configuration\\config.properties";
	
	
	
	
	public ReadConfig(){
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(pathOfFile);
			prop.load(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//url config method
	public String getBaseURL() {
		String value = prop.getProperty("url");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("Url not specified in config file.");
		}
	}
	
	//browser config method
	public String getBrowser() {
		String browser = prop.getProperty("browser");
		if(browser!=null) {
			return browser;
		}else {
			throw new RuntimeException("Browser not specified in config file.");
		}
	}
	
	//get seleniumGrid
	/*public boolean getGrid() {
		boolean seleniumGrid = Boolean.parseBoolean(prop.getProperty("seleniumGrid"));
		return seleniumGrid;
	}*/
	
	//get gridURL
	/*public String gridURL() {
		String gridURL = prop.getProperty("gridURL");
		return gridURL;
	}*/
	
	

}
