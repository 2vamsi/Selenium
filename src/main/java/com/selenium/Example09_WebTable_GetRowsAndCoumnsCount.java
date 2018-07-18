package com.selenium;

import java.util.concurrent.TimeUnit;

/**
 * Example for how to get rows and column counts from a web table
 
 we can create this as a method and pass month and date as arguments to it so that anybody can call it as per their requirement
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example09_WebTable_GetRowsAndCoumnsCount {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// we are taking a reference of a row in the table and counting how many such references are there
		int rowsNumber = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr")).size();
		System.out.println("Number of rows in the webtable are : "+rowsNumber);
		
		// we are taking a reference of a column in the table and counting how many such references are there
		int colNumber = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th")).size();
		System.out.println("Number of columns in the webtable are : "+colNumber);
		
		
		
	}
}