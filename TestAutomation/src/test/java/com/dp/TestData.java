package com.dp;

import org.testng.annotations.DataProvider;

import com.driver.ReadDemoWebShopData;

public class TestData {
	
	@DataProvider
	public static Object[][] supplyData() {
		/*
		 * Object[][] obj= { {"kannan1@gmail.com","test1234"},
		 * {"kim@gmail.com","pass123"}, {"kannan2@gmail.com","test1234"} }; return obj;
		 */
		return ReadDemoWebShopData.readExcel();
	}

}
