package com.selenium;

import java.util.Iterator;
import java.util.Set;

/**
 * Example of how to handle multiple windows
 * To handle browser tabs and windows, we need to use windowsHandles method
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example06_HandlingMultipleWindows {

	WebDriver driver;

	@Test
	public void enterText() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

		System.out.println("Clicking on youtube Link");
		driver.findElement(By.xpath("//*[@id='social_block']/ul/li[3]/a")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Set<String> windowsId = driver.getWindowHandles(); // this will give you the Ids for all the windows
		Iterator<String> itr = windowsId.iterator();
		// System.out.println(itr);

		String parentId = itr.next();
		// System.out.println("parent ID: "+parentId);
		String childId = itr.next();
		// System.out.println("child ID: "+childId);

		driver.switchTo().window(childId);
		driver.close();

		driver.switchTo().window(parentId);

		driver.findElement(By.xpath("//*[@id='footer']/div/section[2]/div/div/ul/li/a")).click();

	}
}
