package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ex07_Calender {

	WebDriver driver;
	String month = "September 2018";
	String date = "11";

	@Test

	public void Calender() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.phptravels.net/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='checkin']")).click();

		WebElement mon = driver
				.findElement(By.xpath("//*/div[8]/div[@class='datepicker-days']/table/thead/tr[1]/th[2]"));

	/*	while (true) {
			if (mon.getText().equals(month)) {
				System.out.println("Month match found");
				break;
			} else {
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/thead/tr[1]/th[3]")).click();
			}
		}

		driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/tbody/tr/td[contains(text(),'" + date + "')]"))
				.click();
		
		///html/body/div[8]/div[1]/table/tbody/tr/td[contains(text(),25)]  - awesme
*/
		
		while(true) {
			
			if(mon.getText().equals(month)) {
				System.out.println("Found Month match");
				break;
			} else {
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/thead/tr[1]/th[3]")).click();
			}
			
		}
		
		driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/tbody/tr/td[contains(text(),'"+ date+"')]")).click();
	}
}
