package com.selenium;

/**
 * Example of how to select the data from select box
 * 
 * some fields may appear like select boxes, but they may not be 
 * you can go to HTML code and see the tag 
 * for select box, tag starts with select
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/* for this, we use select class on the web-element 
 * and then use select class methods like :
 * 		SelectByValue  (or)
 *		SelectByIndex   (or)
 * 		SelectByVisibleText
 */

public class Example03_WebElement_SelectBox {
	
	/*
	Sometimes some elements look like select-boxes but they are not
	you can figure out by right-clicking on the element in inspect mode
	and then looking at the tag name
	 */
	
	
	/*
	create the reference or instance of webDriver , as in selenium every driver
	class implements the WebDriver interface
	 */
	WebDriver driver;

	@Test
	public void SelectBox() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Vamsi/eclipse-workspace/Selenium/Selenium/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		/*  *******
		to select any data from the select box,
		 first we need to create the object of the select class  -  
		 which will take the element we are trying to select as argument
		*/
		
		
		WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
		Select select = new Select(day);
		select.selectByValue("10");

		WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
		
		/*	we can not create the reference again, 
		 * so we are creating only object which is allowed
		*/
		
		select = new Select(month);
		select.selectByIndex(3);

		WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
		
		/*	we can not create the reference again, 
		 * so we are creating only object which is allowed
		*/
		select = new Select(year);
		select.selectByVisibleText("1982");

	}
}
