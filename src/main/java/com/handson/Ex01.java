package com.handson;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Ex01 {

	WebDriver driver;
	
	@Test
	public void enterText() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		/*	
		 * 	driver.get("https://www.facebook.com/");
		 * // Entering text in a text box
		 
		driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("handson-sel");
		driver.findElement(By.xpath("//*[@id=\'u_0_l\']")).sendKeys("hello");
	
		
		// Choosing value in a select box/ dropdown list
		WebElement day = driver.findElement(By.xpath("//*[@id=\'day\']"));
		Select select=  new Select(day);
		select.selectByValue("10");		
		
		
		WebElement month = driver.findElement(By.xpath("//*[@id=\'month\']"));
		select=  new Select(month);
		select.selectByIndex(0);
		
		WebElement year = driver.findElement(By.xpath("//*[@id=\'year\']"));
		select=  new Select(year);
		select.selectByVisibleText("2005");
		

		
		driver.get("https://www.actitime.com/download");
		// performing a mouse over
		WebElement features = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(features).build().perform();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/ul/li[2]/a")).click();
				*/
		
		driver.get("http://automationpractice.com/index.php");
		
		
		driver.findElement(By.xpath("//*[@id=\'social_block\']/ul/li[3]/a")).click();
		
		Set<String> WindowID = driver.getWindowHandles();
		Iterator<String> itr = WindowID.iterator();
		
		String parentID = itr.next();
		String childID = itr.next();
		
		driver.switchTo().window(childID);
		Thread.sleep(2000);
		driver.close();
		
		driver.switchTo().window(parentID);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'footer\']/div/section[2]/div/div/ul/li/a")).click();
		
		
		
		
	}
}
