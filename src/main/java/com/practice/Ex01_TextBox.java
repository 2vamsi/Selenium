package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Ex01_TextBox {

	WebDriver driver;
	
@Test 

public void enterText() {
	
	System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("2vamsi@gmail.com	");
	driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("secret");
	
	driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("Vamsi");
	driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("Dadi");
	
	driver.findElement(By.xpath("//*[@name='reg_email__']")).sendKeys("9052124848");
	driver.findElement(By.xpath("//*[@name='reg_passwd__']")).sendKeys("newsecret");
	
	WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
	Select select = new Select(day);
	select.selectByValue("20");
	
	WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
	select = new Select(month);
	select.selectByIndex(3);
	
	WebElement year = driver.findElement(By.xpath("//*[@title='Year']"));
	select = new Select(year);
	select.selectByVisibleText("1982");
	
}

	
}
