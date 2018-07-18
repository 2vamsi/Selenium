package com.selenium;

/*
 	Look for the expected 'Month & Year' displayed at the top of the Calendar window 
 	& keep clicking next button until you get it
 	Once you get it, look for the expected date 
 	& click on it once you find it
 		
 	Note: we can create this as a method and pass month and date as arguments to it so that anybody can call it 
 
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example07_WebElement_Calender {

	WebDriver driver;

	String month = "October 2018";

	String date = "11";

	@Test
	public void Calender() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
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
