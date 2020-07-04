package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverUtility {
	//Input:Browser Name
	//Output:Return browser instance
	public static WebDriver supplyDriver(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Driver Files\\chromedriver.exe");
			return new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Driver Files\\geckodriver.exe");
			return new FirefoxDriver();
		}else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Driver Files\\xyz.exe");
			return new InternetExplorerDriver();
		}else {
			return null;
		}
	}

}
