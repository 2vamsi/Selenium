package com.selenium;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

/**
 * Example for how to - get all links form the web table
 *  in this manner we can print any data from a web table
 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example13_WebTable_GetAllLinks {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// get the number of rows so that we can iterate the internal loop
		int rowData = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr")).size();
		System.out.println("Number of rows in the webtable are : " + rowData);

		// get the number of coloumns also so that we can iterate the external loop
		int colData = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td")).size();
		System.out.println("Number of columns  in the webtable are : " + colData);

		// splitting the xpath into multiple parts -  so that we can pass a parameter in run-time i.e.
		// buding a dynamic xpath

		String firstPart = "//*[@id='leftcontainer']/table/tbody/tr[";
		String secondPart = "]/td[";
		String thirdPart = "]";

		for (int i = 1; i <= rowData; i++) {

			for (int j = 1; j <= colData; j++) {

				String finalPart = firstPart + i + secondPart + j + thirdPart;
				//System.out.println(finalPart);
				String text = driver.findElement(By.xpath(finalPart)).getText();
				System.out.print(text + " | ");
			}
			System.out.println();
		}

	}
}