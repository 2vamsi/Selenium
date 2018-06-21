package com.selenium;

import java.text.ParseException;
import java.util.Set;
import java.util.concurrent.TimeUnit;



/**
 * Example for how to - add a cookie in selenium & to print all the cookies of a webstie
 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example17_Cookies_AddCookies {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.navigate().to("https://www.flipkart.com/");
		
		driver.navigate().to("https://www.amazon.in/");
		// an implicit wait will the webdriver to poll the DOM for a certain amount of time 
		//or elements if they are not immediately available
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// adding a cookie
		Cookie cookie = new Cookie("customCookie", "12345");
		driver.manage().addCookie(cookie);
		
		// fetching and printing all the cookies - - using for each loop
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cook: cookies) {
			System.out.println(cook);
		}

		
	}
}