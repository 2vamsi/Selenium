package com.selenium;

import java.util.concurrent.TimeUnit;

/**
 * Example for how to get the share price of a company, which changes dynamically at any given point of time
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example10_WebTable_GetRowData {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// this is hard-coded way of getting the current share price which is not suggested for dynamic data
		String price = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[4]")).getText();
		System.out.println("Value is  : "+price);
		
		// go one level up and then go the required field using parent sibling conceptf
		String aPrice = driver.findElement(By.xpath("//a[contains(text(),'Cipla')]/parent::*/following-sibling::td[3]")).getText();
		System.out.println("Actual Price : "+aPrice);
				
	}
}