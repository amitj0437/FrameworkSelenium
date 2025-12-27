package com.store.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.store.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseURL();
	String browser = readConfig.getBrowser();
//	boolean grid = readConfig.getGrid();
//	String gridURL = readConfig.gridURL();
	
	@BeforeClass
	public void setUp() throws MalformedURLException {

		switch (browser.toLowerCase()) {
		case "chrome":
			
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless=new");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(opt);
//			driver = new RemoteWebDriver(new URL(gridURL), opt);
			break;
		case "firefox":
			FirefoxOptions opt1 = new FirefoxOptions();
			opt1.addArguments("--headless=new");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(opt1);
//			driver = new RemoteWebDriver(new URL(gridURL), opt1);
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			break;
		}
		
		//global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//for logging
		logger = LogManager.getLogger("MyStoreV1");
		
		//url open
		driver.get(url);
		logger.info("Url opened");
	}
	
	//Screenshot capture code
	public void captureScreenshot(WebDriver driver, String testName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File destination = new File(System.getProperty("user.dir")+"//Screenshots//"+testName + "_"+ timeStamp + ".png");
		
		FileUtils.copyFile(src, destination);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
