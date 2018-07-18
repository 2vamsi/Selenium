package com.selenium;

import java.text.ParseException;
import java.util.Set;




/**
 * Example for how to - delete all cookies  & to print all the cookies to check if they are deleted or not
 
 */

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example19_Cookies_DeleteAllCookies {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com/");
		
		//delete a cookie
		driver.manage().deleteAllCookies();
		
		// check if the cookie is deleted or not by printing all the cookies -  using for each loop
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cook: cookies) {
			System.out.println(cook);
		}

		
	}
}