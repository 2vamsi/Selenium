package com.selenium;

/**
 * Example of how to do a mouse-over
 * 

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Example04_Actions_MouseOver {

/*	# For all mouse related actions we use Actions class
	# Action.moveToElement(element).build().perform()  -  is standard way of doing mouse-over in Selenium
*/
	
	WebDriver driver;

	@Test
	public void MouseOver() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Vamsi/eclipse-workspace/Selenium/Selenium/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.actitime.com/download");

		/*	
		To do a mouse over we need to create an object of this class
		 */
		
		WebElement features = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(features).build().perform();

	}
}
