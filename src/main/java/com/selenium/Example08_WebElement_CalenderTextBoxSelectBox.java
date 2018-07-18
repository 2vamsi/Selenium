package com.selenium;

import java.util.List;


/*
 * To choose a value from auto-suggestion :
 * 		enter some text into text box
 *  	use driver.findElements to get the suggestions displayed into List of webElements
 *  	use for loop to iterate through and match the expected value
 *  	Click on it, when u find the expected value
 *  
 *   To enter the number of adults/ children :
 *   	capture the default value displayed ( Eg. 2)
 *   	if it is less than the required value ( Eg. 4)
 *   		Click on + button
 *   	if it is greater than the required value ( Eg. 1)  
 *   		click on - button
 *   
 *		Note: this is a very good example covering various types of items
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example08_WebElement_CalenderTextBoxSelectBox {

	WebDriver driver;

	String month = "November 2018";
	String month1 = "December 2018";

	String date = "21";
	String date1 = "22";

	@Test
	public void enterText() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/Vamsi/Installables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/");

		driver.findElement(By.xpath("//*[@id='s2id_autogen8']/a")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("Block");
		Thread.sleep(5000);

		// to click on the required location from the options displayed
		List<WebElement> data = driver.findElements(By.xpath("//ul[@class='select2-result-sub']/li"));
		for (int i = 0; i < data.size(); i++) {
			WebElement element = data.get(i);
			String text = data.get(i).getText();
			System.out.println(text);
			if (text.equals("Block Island, United States")) {
				element.click();
				break;
			}
		}

		// To enter Check-in dates
		driver.findElement(By.xpath("//*[@name='checkin']")).click();

		Thread.sleep(2000);
		WebElement mon = driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/thead/tr[1]/th[2]"));
		// to look for the required month
		while (true) {
			if (mon.getText().equals(month)) {
				System.out.println("Match found");
				break;
			} else {
				driver.findElement(
						By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(1000);
			}

		}
		// to click on the required date
		driver.findElement(
				By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/tbody/tr/td[contains(text(),'" + date
						+ "')]"))
				.click();

		// To enter Check-out dates

		Thread.sleep(2000);
		WebElement mon1 = driver
				.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][2]/div[1]/table/thead/tr[1]/th[2]"));

		while (true) {
			if (mon1.getText().equals(month1)) {
				System.out.println("Match found");
				break;
			} else {
				driver.findElement(
						By.xpath("//div[@class='datepicker dropdown-menu'][2]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(1000);
			}

		}
		driver.findElement(
				By.xpath("//div[@class='datepicker dropdown-menu'][2]/div[1]/table/tbody/tr/td[contains(text(),'"
						+ date1 + "')]"))
				.click();

		
		
		// to enter the number of adults and number of children
		driver.findElement(By.xpath("//*[@id='travellersInput']")).click();
		Thread.sleep(1000);
		while (true) {
			// get text data from textbox
			String text = driver.findElement(By.xpath("//*[@id='adultInput']")).getAttribute("value");
			String text1 = driver.findElement(By.xpath("//*[@id='childInput']")).getAttribute("value");
			System.out.println(text);
			Double t = Double.parseDouble(text);
			Double t1 = Double.parseDouble(text1);
			// here I want to select 4 adults
			if (t.intValue() < 4) {
				// click on plus button
				driver.findElement(By.xpath("//*[@id='adultPlusBtn']")).click();
				Thread.sleep(1000);
			} else {
				break;
			}

			if (t1.intValue() < 2) {
				// click on plus button
				driver.findElement(By.xpath("//*[@id='childPlusBtn']")).click();
				Thread.sleep(1000);
			} else {
				break;
			}

		}

		driver.findElement(By.xpath("//*[@id=\'HOTELS\']/form/div[5]/button")).click();

	}
}