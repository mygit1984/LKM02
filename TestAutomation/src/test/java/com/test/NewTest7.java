package com.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.dp.TestData;
import com.driver.DriverUtility;

public class NewTest7 {
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver=DriverUtility.supplyDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url="http://demowebshop.tricentis.com/";
		driver.get(url);
		driver.findElement(By.linkText("Log in")).click();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	
	@Test(dataProvider="supplyData",dataProviderClass = TestData.class)
	public void login(String userName,String password) {
		driver.findElement(By.id("Email")).sendKeys(userName);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		String email=driver.findElement(By.className("account")).getText();
		
		if(userName.equals(email)) {
			driver.findElement(By.linkText("Log out")).click();
			driver.findElement(By.linkText("Log in")).click();
			Assert.assertTrue(true);
			System.out.println("Test Passed");
		}else {
			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Password")).clear();
			Assert.assertTrue(false);
		}
	}
	
}
