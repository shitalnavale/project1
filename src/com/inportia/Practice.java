package com.inportia;
import java.util.concurrent.TimeUnit;

import org.openqa.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {
WebDriver drv;

public void openBrowser(String browsername){

	if(browsername.equalsIgnoreCase("Firefox"))
	{
     System.setProperty("webdriver.gecko.driver", "D:\\Selenium Set Up\\geckodriver.exe");
     drv=new FirefoxDriver();
	}
	else if(browsername.equalsIgnoreCase("IE"))
	{
	 System.setProperty("Webdriver.ie.driver", "D:\\Selenium Set Up\\IEDriverServer.exe");
	 drv=new InternetExplorerDriver();
	 
	}
	else
	{
		
	 System.setProperty("webdriver.chrome.driver", "D:\\Selenium Set Up\\chromedriver.exe");
	 drv=new ChromeDriver();
	}
}
	public void openApplication()
	{
	drv.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1");	
	drv.manage().window().maximize();
	drv.findElement(By.id("Email")).sendKeys("sd.navale");
	drv.findElement(By.id("next")).click();
	WebDriverWait wa=new WebDriverWait(drv,30);//explict wait used only for on one element
	WebElement we= drv.findElement(By.id("Passwd"));
	wa.until(ExpectedConditions.visibilityOf(we));
	drv.findElement(By.id("Passwd")).sendKeys("abc");;
	
		drv.findElement(By.name("signIn")).click();
	}
    

}