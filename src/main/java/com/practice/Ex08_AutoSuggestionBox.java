package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ex08_AutoSuggestionBox {

	WebDriver driver;

	String InmonthExp = "November 2018";
	String IndateExp = "21";

	String OutmonthExp = "December 2018";
	String OutdateExp = "29";

	int ExpAdults = 8;
	int ExpChildren = 4;

	@Test

	public void Reservation() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vamsi.dadi/Documents/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.phptravels.net/");

		
		// Choose destination
		driver.findElement(By.xpath("//*[@id='s2id_autogen8']/a")).click();
		System.out.println("Clicked");
		driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("block");
		Thread.sleep(5000);
		List<WebElement> data = driver.findElements(By.xpath("//ul[@class='select2-result-sub']/li"));
		for (int i = 0; i < data.size(); i++) {
			WebElement element = data.get(i);
			String text = element.getText();
			System.out.println(text);
			if (text.equals("Block Island, United States")) {
				element.click();
				break;
			}
		}

		
		
		// Choose checkin date
		driver.findElement(By.xpath("//*[@name='checkin']")).click();
		WebElement InmonthAct = driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/thead/tr[1]/th[2]"));
		while (true) {
			if (InmonthAct.getText().equals(InmonthExp)) {
				System.out.println("Month Match found");
				break;
			} else {
				System.out.println(InmonthAct.getText());	
				driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/thead/tr[1]/th[3]")).click();
			}
		}
		driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/tbody/tr/td[contains(text(),'" + IndateExp + "')]"))
				.click();

		
		
		Thread.sleep(2000);
		// Choose Checkout date
		//driver.findElement(By.xpath("//*[@name='checkout']")).click();

		WebElement OutmonthAct = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[1]/th[2]"));
		while (true) {
			if (OutmonthAct.getText().equals(OutmonthExp)) {
				System.out.println("Month Match found");
				break;
			} else {
				driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[1]/th[3]")).click();
			}
		}
		driver.findElement(
				By.xpath("/html/body/div[9]/div[1]/table/tbody/tr/td[contains(text(),'" + OutdateExp + "')]")).click();

		
		
		
		// choose number of guests
		driver.findElement(By.xpath("//*[@id='travellersInput']")).click();

		while (true) {

			String ActualAdults = driver.findElement(By.xpath("//*[@id='adultInput']")).getAttribute("value");
			String ActualChildren = driver.findElement(By.xpath("//*[@id='childInput']")).getAttribute("value");

			Double a = Double.parseDouble(ActualAdults);
			Double c = Double.parseDouble(ActualChildren);

			if (a.intValue() < ExpAdults) {
				driver.findElement(By.xpath("//*[@id='adultPlusBtn']")).click();
				Thread.sleep(1000);
			} else {
				break;
			}

			if (c.intValue() < ExpChildren) {
				driver.findElement(By.xpath("//*[@id='childPlusBtn']")).click();
				Thread.sleep(1000);
			} else {
				break;
			}

		}

		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"HOTELS\"]/form/div[5]/button")).click();
		
		Thread.sleep(2000);
	}

}
