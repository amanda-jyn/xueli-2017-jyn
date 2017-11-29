package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvicer {

	@DataProvider(name="s1")
	public static Object[][] getTxt1(){
		FileDataProvider ft = new FileDataProvider("data/news.txt");
		return ft.getTestDataByTxt();
	}
	@DataProvider(name="s2")
	public static Object[][] getTxt2(){
		FileDataProvider ft = new FileDataProvider("data/pic.txt");
		return ft.getTestDataByTxt();
	}
	@DataProvider(name="s3")
	public static Object[][] getTxt3(){
		FileDataProvider ft = new FileDataProvider("data/tips.txt");
		return ft.getTestDataByTxt();
	}
	

	
	@DataProvider(name="s9")
	public static Object[][] getXsl() throws IOException{
		ExcelDataProvider ft = new ExcelDataProvider("data/testData.xlsx","Sheet1");
		return ft.getTestDataByExcel();
	}
	
	
}
