package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 *we use send keys to enter the text into a text box
 *
 */

public class Example02_WebElement_MultipleTextBoxs {

	// create the reference or instance of webDriver , as in selenium every driver
	// class implements the WebDriver interface

	WebDriver driver;

	@Test
	public void MultipleTextBoxs() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Vamsi/eclipse-workspace/Selenium/Selenium/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("2vamsi@gmail.com");
		driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("firstname");
		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("firstname");
		driver.findElement(By.xpath("//*[@name='reg_email__']")).sendKeys("regemail");
		driver.findElement(By.xpath("//*[@name='reg_passwd__']")).sendKeys("regpassword");

	}
}
