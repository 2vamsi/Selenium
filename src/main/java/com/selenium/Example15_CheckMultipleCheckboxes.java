package com.selenium;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;



/**
 * Example for how to - select multiple check boxes
 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example15_CheckMultipleCheckboxes {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://my.monsterindia.com/create_account.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='cat_value']")).click();
		
		driver.findElement(By.xpath("//div[text()='Admin/Secretarial']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//div[text()='IT']/preceding-sibling::div")).click();
	
		
		//org.openqa.selenium.InvalidSelectorException: invalid selector: Compound class names not permitted 
		// driver.findElement(By.className("right clip_image closedropdown")).click();
		// we cannot give a class with multiple class names/ spaces in between - we will get above exception 
		
		driver.findElement(By.xpath("//*[@id='cat']/div[2]")).click();
		

	}
}