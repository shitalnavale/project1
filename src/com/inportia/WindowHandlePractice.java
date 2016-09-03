package com.inportia;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Set Up\\chromedriver.exe");
        WebDriver drv= new ChromeDriver();
        drv.manage().window().maximize();
        drv.get("http://www.naukri.com/");
        Set <String> allhandles=drv.getWindowHandles();
        Iterator<String> iterator=allhandles.iterator();
        String mainwindow=iterator.next();
        String popupwindow=iterator.next();
        System.out.println("Main Window : "+mainwindow);
        System.out.println("Pop Window  :"+popupwindow);
         drv.switchTo().window(popupwindow);
             
	System.out.println("title of popup window is ::  "+drv.getTitle());
drv.close();

drv.switchTo().window(mainwindow); // one way of doing it

}
}