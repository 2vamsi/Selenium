package com.selenium;

import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.By;

/**
 * Example for how to - zoom in and zoom out using selenium
 * we can achive this using java script
 
 */

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example21_ZoomInZoomOut {

	// creating the isntance of the WebDriver
	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		// setting the properties of chrome driver ***
		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		
		// create driver object
		driver = new ChromeDriver();

		driver.navigate().to("https://www.tirerack.com");
		
		driver.manage().window().maximize();
		
		//driver.manage().window().fullscreen();

		// we need to cast the driver with JavascriptExecutor so that - all the functionalities of JavascriptExecutor related
		//  methods will come to the driver 
		
		// executeScript is a method will execute your java script
		// to zoom in by 80%
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");

		Thread.sleep(4000);

		// to zoom out by 100%
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");

		Thread.sleep(4000);
		// to zoom out by 120%
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='120%'");
	
		// sometimes, we would need to  -  zoom in / zoom out while capturing the screenshots using selenium
		
		
	}
}