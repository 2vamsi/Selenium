package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Ex04_MouseOver {

	
	WebDriver driver;
	
	@Test
	public void mouseOver() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.actitime.com/download");
		
		WebElement features = driver.findElement(By.xpath("//a[text()='Features']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(features).build().perform();
		
		WebElement ltm = driver.findElement(By.linkText("Leave Time Management"));
		action.moveToElement(ltm).build().perform();
		
		Thread.sleep(3000);
		
	}
}
