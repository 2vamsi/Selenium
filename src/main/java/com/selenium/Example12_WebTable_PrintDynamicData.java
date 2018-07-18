package com.selenium;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Example for how to - print the number of links in the given web page
 This way we can print any dynamic data from the web table
 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example12_WebTable_PrintDynamicData {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println(links.size()); // to print the number of links

		ArrayList<String> data = new ArrayList<String>();
		for (int i = 0; i < links.size(); i++) {

			System.out.println(i + ". " + links.get(i).getText());
			data.add(links.get(i).getAttribute("href"));
			System.out.println(links.get(i).getAttribute("href"));
			System.out.println();
		}

		System.out.println(data.size());

	}
}