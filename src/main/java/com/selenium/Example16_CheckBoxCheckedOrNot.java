package com.selenium;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;



/**
 * Example for how to - check if certain text boxes are checked are not in the application
 
 Also an example for how to use assertions using if else block :-) 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example16_CheckBoxCheckedOrNot {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://my.monsterindia.com/create_account.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='cat_value']")).click();

		driver.findElement(By.xpath("//div[text()='Admin/Secretarial']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//div[text()='IT']/preceding-sibling::div")).click();

		String check1 = driver.findElement(By.xpath("//*[text()='Admin/Secretarial']/preceding-sibling::input"))
				.getAttribute("checked");
		System.out.println(check1);

		String check2 = driver.findElement(By.xpath("//*[text()='IT']/preceding-sibling::input"))
				.getAttribute("checked");
		System.out.println(check2);

		String check3 = driver.findElement(By.xpath("//*[text()='Finance & Accounts']/preceding-sibling::input"))
				.getAttribute("checked");
		System.out.println(check3);

		if (check1.equals("true") && check2.equals("true") && check3 == null) {
			System.out.println("Inside if condition");
			Assert.assertTrue(true);
		} else {
			System.out.println("Inside else condition");
			Assert.assertTrue(false, "issue with one of the checkboxes");
		}

	}
}