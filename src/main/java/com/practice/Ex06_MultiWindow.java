package com.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ex06_MultiWindow {

	WebDriver driver;
	
	@Test
	public void MultiWindow() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='social_block']/ul/li[3]/a")).click();
		
		Thread.sleep(3000);
		
/*		Set<String> windowsId = driver.getWindowHandles();
		Iterator<String> itr = windowsId.iterator();
		
		String parentId = itr.next();
		String childId = itr.next();
		
		driver.switchTo().window(childId);
		Thread.sleep(3000);
		driver.close();
		
		driver.switchTo().window(parentId);
		*/
				
		
	/*	Set<String> windowsId = driver.getWindowHandles();
		Iterator<String> iterator = windowsId.iterator();
		
		String parentID = iterator.next();
		String childID = iterator.next();
		
		System.out.println(parentID);
		System.out.println(childID);
		
		driver.switchTo().window(childID);	
		Thread.sleep(3000);
		//driver.close();
		
		driver.switchTo().window(parentID);
		Thread.sleep(3000);
		
		driver.switchTo().window(childID);
		Thread.sleep(3000);
			
		driver.switchTo().window(parentID);
		Thread.sleep(3000);
		
		driver.switchTo().window(childID);
		Thread.sleep(3000);*/
		
		Set<String> windowsID = driver.getWindowHandles();
		Iterator<String> iterator = windowsID.iterator();
		
		String parentId = iterator.next();
		String childId = iterator.next();
		
		driver.switchTo().window(parentId);
		Thread.sleep(2000);
		
		driver.switchTo().window(childId);
		Thread.sleep(2000);
		
		driver.switchTo().window(parentId);
		Thread.sleep(2000);
		
		driver.switchTo().window(childId);
		Thread.sleep(2000);
		
		driver.switchTo().window(parentId);
		Thread.sleep(2000);
		
		driver.switchTo().window(childId);
		Thread.sleep(2000);
		
		
		
		
		
	}
}
