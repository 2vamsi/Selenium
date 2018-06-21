package com.selenium;

/**
 * Example of how to do a mouse-over
 * 

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Example04_Actions_MouseOver {

	// create the reference or instance of webDriver , as in selenium every driver
	// class implements the WebDriver interface

	WebDriver driver;

	@Test
	public void enterText() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.actitime.com/download");

		WebElement features = driver.findElement(By.xpath("/a[@href='/features']"));
		// for all mouse related actions we use actions class
		// to do a mouse over we need to create an object of this class
		
		Actions action = new Actions(driver);
		// below is standard way of doing mouse-over in selenium

		action.moveToElement(features).build().perform();

	}
}
