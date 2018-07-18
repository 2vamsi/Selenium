package com.selenium;

import java.text.ParseException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/***
 * 
 * Example for how to - handle iframes in selenium
 * 
 * The iframe stands for inline frame. An inline frame is used to embed another document
 *  within a HTML document. We can say - It is like a page inside a page. 

 */
public class Example22_IFrames {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// it is a standard practice in selenium to make sure that you use Implicit wait
		
		driver.navigate().to("file:///C:/Users/vamsi.dadi/Desktop/startbootstrap-sb-admin-2-gh-pages/startbootstrap-sb-admin-2-gh-pages/pages/forms.html");
		
		driver.manage().window().maximize();
		// we always need to switch to an iframe before operating on any element which is inside of that  iframe
		
		// switching to iframe using index
		//driver.switchTo().frame(0); 
		
		//switching to iframe using iframe name
		//driver.switchTo().frame("name of the iframe, if we have it");
		
		
		//switching to an  iframe which is inside of an another iframe
		//driver.switchTo().frame(0).switchTo().frame(1);
		//driver.switchTo().frame("xpath of iframe").switchTo().frame("xpath of inner frame").switchTo().frame("index of inner inner frame");
		
		
		//switching to iframe based on it's xpath
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='frame.html']")));
		System.out.println("switched");
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("/html/body/div/form/div/input[1]")));
		
		driver.findElement(By.xpath("/html/body/div/form/div/input[1]")).sendKeys("Vamsi");

		Thread.sleep(2000);
		// we need to always have to come out of the iframe to operate on the elements which are outside of that iframe
		driver.switchTo().defaultContent();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div/div[2]/div/div[1]/form/div[1]/input[1]")));
		driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div/div[2]/div/div[1]/form/div[1]/input[1]")).sendKeys("Dadi");
		

	}
}