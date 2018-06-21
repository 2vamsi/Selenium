package com.selenium;

import java.text.ParseException;
import java.util.Set;
import java.util.concurrent.TimeUnit;



/**
 * Example for how to - delete a cookie in selenium & to print all the cookies of a webstie
 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example18_Cookies_DeleteCookie {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com/");
		
		//delete a cookie
		driver.manage().deleteCookieNamed("customCookie");
		//driver.manage().deleteCookie(arg0);
		
		// check if the cookie is deleted or not by printing all the cookies -  using for each loop
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cook: cookies) {
			System.out.println(cook);
		}

		
	}
}