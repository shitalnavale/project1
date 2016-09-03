package com.inportia;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RadioButtonExample {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium Set Up\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		
		List<WebElement> allRadios= driver.findElements(By.xpath("//input[@type='radio'][@name='group2']"));
		allRadios.get(1).click();
	}

}











