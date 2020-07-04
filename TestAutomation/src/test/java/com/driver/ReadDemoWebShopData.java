package com.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDemoWebShopData {
	
	public static Object[][] readExcel() {
		String path="src\\test\\resources\\Test Data.xlsx";
		File file=new File(path);//locating the file
		Object[][] obj=null;
		try {
			InputStream is=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet1=workbook.getSheet("Sheet1");
			obj=new Object[sheet1.getLastRowNum()][2];
			for(int i=1;i<=sheet1.getLastRowNum();i++)
			{
				for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++)
				{
					obj[i-1][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
				}
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
