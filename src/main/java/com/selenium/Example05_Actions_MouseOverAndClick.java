package com.selenium;

/**
 * Example of how to do a mouse-over & then click on an element ( menu item) 
 * 

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Example05_Actions_MouseOverAndClick {

	// create the reference or instance of webDriver , as in selenium every driver
	// class implements the WebDriver interface

	WebDriver driver;

	@Test
	public void enterText() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.actitime.com/download");

		WebElement features = driver.findElement(By.xpath("//a[@href='/features']"));

		Actions action = new Actions(driver);
		action.moveToElement(features).build().perform();

		// giving a wait of 1 sec just to make sure
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		WebElement WCM = driver.findElement(By.linkText("Work Scope Management"));
		WCM.click();

	}
}
