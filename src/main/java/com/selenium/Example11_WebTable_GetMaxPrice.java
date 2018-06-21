package com.selenium;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Example for how to - capture the data from a webtable and print the smallest and biggest value from a column
 
 we can create this as a method and pass month and date as arguments to it so that anybody can call it as per their requirement
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example11_WebTable_GetMaxPrice {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		// get the number of rows so that we can iterate the loop
		int rowData = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr")).size();
		System.out.println("Number of rows in the webtable are : " + rowData);

		// splitting the xpath into two so that we can pass a parameter in run-time i.e. buding a dynamic xpath
	
		String firstPart = "//*[@id='leftcontainer']/table/tbody/tr[";
		String secondPart = "]/td[4]";
		
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for (int i = 1; i <= rowData; i++) {
			String finalpart = firstPart+i+secondPart; // building a dynamic xpath, which will get constructed during the run time
			System.out.println(finalpart);
			String price = driver.findElement(By.xpath(finalpart)).getText();
			System.out.println(price);
		//	Double dPrice = Double.parseDouble(price);
		// 	int intPrice = dPrice.intValue();
				
			// to remove the commas from the price value (so that we can compare / sort them in an order)
			NumberFormat numberFormat = NumberFormat.getNumberInstance();
			Number num = numberFormat.parse(price);
			
			// to make it a proper string 
			price = num.toString();
			System.out.println(price);
			
			// to convert string into double
			Double m = Double.parseDouble(price);
			
			//to get integer value of double
			int intPrice = m.intValue();
			
			// to add the value the array
			array.add(intPrice);
			
		}

			Collections.sort(array);
			System.out.println(array);
			
			// to print the first value  of the array which is also the smallest
			System.out.println(array.get(0));
			
			// to print the last value  of the array which is also the biggest
			System.out.println(array.get(array.size()-1));
	}
}
