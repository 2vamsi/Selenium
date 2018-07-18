package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 *we use send keys to enter the text into a text box
 *
 */
public class Example01_WebElement_TextBox {

		// create the reference of webDriver , as in selenium every driver class implements the WebDriver interface
	
		WebDriver driver; 
		
		/**
		 *  Launch facebook and enter user id and password
		 */
	@Test
	public void enterDataInTextField() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Vamsi/git/seleniumBasic/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("helloworld");
		

		
	}
}
