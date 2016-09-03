package com.inportia;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Set Up\\chromedriver.exe");
		WebDriver drv=new ChromeDriver();
		drv.manage().window().maximize();
		drv.get("http://money.rediff.com/gainers/bse/daily/groupa");
		List<WebElement>allCompanies =drv.findElements(By.xpath("//table[@ class='dataTable']//tr/td[1]"));
		
		Thread(20000);
		
		List<WebElement>allCurrencies =drv.findElements(By.xpath("//table[@ class='dataTable']//tr/td[4]"));
		for(int i=0;i<allCompanies.size();i++)
		{ System.out.println(allCompanies.size());
		String sname=allCompanies.get(i).getText();
		System.out.println(sname);
		
			if (allCompanies.get(i).getText().equals("Bajaj Holdings & Inv"))
				
			{
				System.out.println("Print Price : "+allCurrencies.get(i).getText());
				break;
			}
		}
		
	}

	private static void Thread(int i) {
		// TODO Auto-generated method stub
		
	}
}
