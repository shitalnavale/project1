package com.inportia;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooAutoSuggest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.setProperty("webdriver.chrome.driver", "D:\\Selenium Set Up\\chromedriver.exe");
     WebDriver drv=new ChromeDriver();
     drv.manage().window().maximize();
     drv.get("http://yahoo.com");
     drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     drv.findElement(By.xpath("//*[@id='UHSearchBox']")).sendKeys("Hello kitty");
     WebDriverWait wa=new WebDriverWait(drv,20);
     WebElement box= drv.findElement(By.xpath("//*[@id='yucs-satray']"));
 // System.out.println(box.findElements(By.tagName("a")));
     wa.until(ExpectedConditions.visibilityOf(box));
  List<WebElement>wl=box.findElements(By.tagName("a"));
    for(WebElement s:wl){
	   System.out.println(s.getText());
  }
	
	}
}
