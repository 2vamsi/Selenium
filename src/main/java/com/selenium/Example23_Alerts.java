package com.selenium;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/***
 * 
 * Example for how to - handle alerts in selenium
 *i.e. both java script alerts &  browser alerts
 */

public class Example23_Alerts {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// it is a standard practice in selenium to make sure that you use Implicit wait

		driver.navigate().to(
				"file:///C:/Users/vamsi.dadi/Desktop/startbootstrap-sb-admin-2-gh-pages/startbootstrap-sb-admin-2-gh-pages/pages/index.html");

		driver.manage().window().maximize();

	//************** below is for Java script alerts ******************//
		
		// to scrolldown to the location of the URL - Optional 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//a[text()=' JavaScriptAlert']")));
		
		driver.findElement(By.xpath("//a[text()=' JavaScriptAlert']")).click();

		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		Thread.sleep(3000);

		// below 2 statements are used to Click OK or cancel for java script alerts
		// **********

		driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();

		String text = driver.findElement(By.xpath("//*[@id=\'demo\']")).getText();

		if (text.equals("You pressed OK!")) {
			System.out.println("got into if condition");
			Assert.assertTrue(true, "You Pressed True & text displayed is : " + text);
		} else {
			System.out.println("got into else condition");
			Assert.assertTrue(false, "You Pressed False & text displayed is : " + text);
		}

		
		
		// below is for browser alerts
		
		driver.navigate().to(
				"file:///C:/Users/vamsi.dadi/Desktop/startbootstrap-sb-admin-2-gh-pages/startbootstrap-sb-admin-2-gh-pages/pages/index.html");
		driver.findElement(By.xpath("//a[text()=' Alert']")).click();
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		Thread.sleep(3000);

		// for browser alerts only accept is applicable. i.e. dismiss is not applicable
	  		driver.switchTo().alert().accept();
	  
		
	}
}