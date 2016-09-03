package com.inportia;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RediifPopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Set Up\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("http://yahoo.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='UHSearchBox']")).sendKeys("hello kitty");
		
		WebElement box =driver.findElement(By.xpath("//*[@id='yucs-satray']"));
		Thread.sleep(2000);
		List<WebElement> allSuggestions =box.findElements(By.tagName("a"));
		System.out.println("total auto suggest are :: "+allSuggestions.size());
		Thread.sleep(2000);
		for(int i=0;i<allSuggestions.size();i++)
		{
			System.out.println(allSuggestions.get(i).getText());
		}
		
	

	}

}











