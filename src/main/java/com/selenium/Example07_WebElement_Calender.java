package com.selenium;

/**
 * Example for how to handle calendar in selenium
 
 we can create this as a method and pass month and date as arguments to it so that anybody can call it as per their requirement
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example07_WebElement_Calender {

	WebDriver driver;

	String month = "December 2018";

	String date = "29";

	@Test
	public void enterText() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.phptravels.net/");
		driver.findElement(By.xpath("//*[@name='checkin']")).click();

		Thread.sleep(2000);
		WebElement mon = driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/thead/tr[1]/th[2]"));

		while (true) {
			if (mon.getText().equals(month)) {
				System.out.println("Match found");
				break;
			} else {
				driver.findElement(
						By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(1000);
			}

		}
		driver.findElement(
				By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/tbody/tr/td[contains(text(),'" + date
						+ "')]"))
				.click();

	}
}
