package com.selenium;

import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.By;

/**
 * Example for how to - scroll in selenium
 
 */

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example20_ScrollInSelenium {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		// First setup browser properties
		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		
		// create driver object
		driver = new ChromeDriver();

		driver.navigate().to("https://www.tirerack.com");
		
		driver.manage().window().maximize();

/*
	 JavaScriptExecutor is an interface which provides mechanism to execute Javascript through 
	 selenium driver.  It provides “executescript” & “executeAsyncScript” methods, to run JavaScript
	in the context of  the currently selected frame or window
*/		
		
// to scroll vertically down -  to the bottom
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		
		Thread.sleep(4000);

		// to scroll vertically up -  to the top
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, - document.body.scrollHeight)");

		Thread.sleep(4000);
		// to scroll down by mentioned number of pixels
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 1500)");
		
		Thread.sleep(4000);
		//to scroll up by mentioned number of pixels
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, -1500)");
		
		Thread.sleep(4000);
		//to scroll to the position of the object mentioned
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[text()='Create Your Package']")));
		
		
		
	}
}