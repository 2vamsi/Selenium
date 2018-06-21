package com.selenium;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;



/**
 * Example for how to - select various fields in a web page
 
 very important example - covers various ways of trail and methods of clicking an object when it doesn't work 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example14_RadioButton_AutoSuggestionTextBox {

	WebDriver driver;

	@Test
	public void enterText() throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://my.monsterindia.com/create_account.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		driver.findElement(By.xpath("//*[@id='firstName_id']")).sendKeys("Vamsi");
		driver.findElement(By.xpath("//*[@id='lastName_id']")).sendKeys("Dadi");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("23523533i@gmail.com");
		driver.findElement(By.xpath("//*[@id='passwd_id']")).sendKeys("Oct0120009");
		
		Thread.sleep(2000);
		
		// highlight object in selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yello; border : 2px solid red;')" , driver.findElement(By.xpath("//*[@id='email_msg']/a/img")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='email_msg']/a/img")).click();
		
		//***************** how you should try to click when normal Selenium Click API is not working  ***********
		
		// *** through action class
		//Actions action = new Actions(driver);
		// by using click method of action class
		//action.click(driver.findElement(By.xpath("//*[@id='email_msg']/a/img")));
		
		// by using move to element and click 
		// action.moveToElement(driver.findElement(By.xpath("//*[@id='email_msg']/a/img"))).click();
		
		// by using java script click
		//js.executeScript("arguments[0].click", driver.findElement(By.xpath("//*[@id='email_msg']/a/img")));
		
		
		
		driver.findElement(By.xpath("//*[@id='CREATEACCTFORM']/div[4]")).click();
		driver.findElement(By.xpath("//*[@id='s2id_autogen1_search']")).sendKeys("Bang");
		Thread.sleep(2000);
		
		
		//driver.findElement(By.xpath("//*[@id='select2-results-1']")).click();
		driver.findElement(By.xpath("//div[contains(text(), 'Bengaluru')]")).click();
		
		
		driver.findElement(By.xpath("//*[@id='mobile2']")).sendKeys("9054342323");
		
		driver.findElement(By.xpath("//*[@id='expYrMonth_value']")).click();
		driver.findElement(By.xpath("//*[@id='exp_year5']")).click();
		driver.findElement(By.xpath("//*[@id='exp_month6']")).click();
		driver.findElement(By.xpath("//*[@id='expYrMonth']/div[2]")).click();
		
		driver.findElement(By.xpath("//*[@id='skills']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='skills']")).sendKeys("Jav");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Java OR C']")).click();
		Thread.sleep(2000);
		
		
	
		//driver.findElement(By.xpath("//div[@id='ind']/div[2]")).click();
		driver.findElement(By.xpath("//*[@id='main_form']")).click();
		driver.findElement(By.xpath("//*[@id='ind_value']")).click();
		
		
		driver.findElement(By.xpath("//*[@id='cat_typeahead']")).click();
		
		driver.findElement(By.xpath("//*[@id=\'cat_typeahead\']")).sendKeys("IT");
		
		driver.findElement(By.xpath("//*[@title='IT/ Computers - Software']/preceding-sibling::*[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='ind']/div[2]")).click();
		
		
	
		//*[@id='s2id_autogen1_search']	
	

	}
}