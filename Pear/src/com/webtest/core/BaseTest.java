package com.webtest.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.webtest.util.Log;



public class BaseTest {
	public final static String DATA_ROOT = "data";

	String dataRestore=null;
	public  Checker check;
	public RobotExp robot;
	public static Properties conf = null;
	public final static String CONF_PATH = "conf/config.properties";
	public  WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;
	protected ObjectMap objectMap=null;

	private WebDriver newWebDriver(String driverType) {
		WebDriver driver = null;
	 if (driverType.equalsIgnoreCase("firefox")) {
		    String firefox_driver =getCfgProperty("gecko_driver");
			String firefox_path = getCfgProperty("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();
			Log.info("Using Firefox");
		} 		
		return driver;	
	}

	public static void loadConfig() throws IOException {
		conf = new Properties();
		InputStream is = new BufferedInputStream(new FileInputStream(CONF_PATH));
		conf.load(is);
	}

	public static String getCfgProperty(String key) {

		if (null == conf) {
			try {
				loadConfig();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (null == conf.getProperty(key)) {
			return "";
		}
		return conf.getProperty(key);
	}
	
	 public  WebDriverEngine getCurrentWebtest()
	  {
		  return webtest;
	  }
	  public void setCurrentWebTest(WebDriverEngine webtest)
	  {
		  this.webtest=webtest;
	  }
	public String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time = sdf.format(new Date());
		return time;
	}

	public void screenShot() {

		String dir_name = getCfgProperty("screen_name");
		
		try {
			File source_file = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source_file, new File(dir_name + File.separator
					+ getDate() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	


	@BeforeTest
	public void doBeforeMethod() throws Exception {
		driverType=getCfgProperty("driverType");
		driver = this.newWebDriver(driverType);
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
		check=new Checker(webtest);
		robot = new RobotExp();
		if(dataRestore != null){
		objectMap = new ObjectMap(dataRestore);
		}

		
	}

//	@AfterTest
//	public void doAfterMethod() throws InterruptedException {
//		if(this.driver != null){
//			this.driver.quit();
//			}
//		Log.info("Quitted Browser");
//	}	

}
