package com.inportia;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumClass {
	WebDriver drv;
	//String appUrl="http://naukri.com";
	
	public void openbrowser(String browsername){
		if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium Set Up\\geckodriver.exe");
			drv=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Selenium Set Up\\IEDriverServer.exe");
			drv=new InternetExplorerDriver();			
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Set Up\\chromedriver.exe");
			drv=new ChromeDriver();
			//drv.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("TV");
		    this.implicitWaitExample();
		}
		
	}
	
	public void testcase1()
	{
	  SeleniumClass obj=new SeleniumClass();
		obj.openbrowser("");
		obj.openApplication("http://naukri.com");
		obj.handleWindowExample();
		//obj.getAllLinksFromPage();
		//obj.toRefreshPage();
		//obj.getValueFromDropDwon();
		//obj.listCount();
		//obj.closeApplication(false);
		
	}
    public void openApplication(String aapUrl){
    	
    	drv.get(aapUrl);
    	drv.manage().window().maximize(); //never use both wait together
    	String url=drv.getCurrentUrl();
    	//System.out.println(url);
    	String actualTitle=drv.getTitle();
    	System.out.println(actualTitle);
    	if(url.contains("naukri"))
    	{
    		if(actualTitle.startsWith("Jobs"))
    		{
    			System.out.println("Test case Paased");
       		}
    		else{
    			System.out.println("Test case failed");
    		}
    		
    	}
    }
    public void handleWindowExample()
    {
	  // String gw=drv.getWindowHandle();
	  // System.out.println(gw);
	   Set<String> gw1 =drv.getWindowHandles();
	   //System.out.println(gw1);
	   // int len=gw1.size();
	   // System.out.println(len);
		   for(String s:gw1)//for each loop
		 	{
			 //System.out.println(s);
			 drv.switchTo().window(s);
			// System.out.println(drv.getTitle());
			 String gtitle= drv.getTitle();
			 System.out.println(gtitle);
			 String exped="Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
			  if (gtitle!=exped)
				{
				  //drv.switchTo().window(s);
					drv.switchTo().window(s).close();
				}
	 		    }
		   //System.out.println(drv.switchTo().window(gw));
				/*Iterator<String> itr =gw1.iterator(); 
			while(itr.hasNext())
			{
			System.out.println(itr.next());
			}*/
		
    }
    public void getAllLinksFromPage()
    {
    	List<WebElement> we= drv.findElements(By.tagName("a"));
    	
	    	for(WebElement s:we)
	    	{
		      System.out.println(s.getText());
	    	}
    }
    public void toRefreshPage()
    {
    	drv.findElement(By.name("qp")).sendKeys("abc");
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//drv.findElement(By.name("qp")).sendKeys(Keys.F5);
    	//drv.findElement(By.name("qp")).sendKeys("\uE035");//Ascii value
    	//drv.navigate().refresh();
    	drv.navigate().to(drv.getCurrentUrl());
    }
    public void getValueFromDropDwon()
    {
    	drv.get("http://the-internet.herokuapp.com/dropdown");
    	///drv.findElement(By.xpath("//*[@id='exp_dd']/div[1]/input[1]")).click();
    	WebElement we=drv.findElement(By.id("dropdown"));
    	Select s= new Select(we);// tag name is select for drop down
    	s.selectByIndex(1);
       	s.selectByValue("2");
    }
    public void listCount()
    {
    	drv.get("http://naukri.com");
    	drv.findElement(By.xpath("//*[@id='exp_dd']/div[1]/input[1]")).click();
    int len =drv.findElements(By.xpath("//div[@id='exp_dd']//div[@class='matchParent content']/ul/li")).size();
    	System.out.println(len);
    	
    }
    
    
    public void closeApplication(boolean Inflag){
        if(Inflag)
        {
        	drv.close();
        }
        else
        {
        	drv.quit();
        }
    }
    public void identifyById(){
    	drv.findElement(By.id("lst-ib")).sendKeys("inportia");
    	
    }
	public void identifyByName(){
	  drv.findElement(By.name("btnG")).click(); 
	  drv.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	}
	public void identifyByTagName(){
	List<WebElement> ls= drv.findElements(By.tagName("a"));
	int len=ls.size();
	System.out.println(len);
	for(int i=0;i<len;i++)
	{
		System.out.println(ls.get(i).getText());
	}
	for(WebElement we:ls){
		System.out.println(we.getText());
	}
	Iterator<WebElement> itr=ls.iterator();
	while(itr.hasNext()){
		System.out.println(itr.next().getText());
	}
	}
	
	public void identifyByLinkText(){
		drv.findElement(By.linkText("InPortia | Best Training Center in pune for software testing, web ...")).click();
	 	
	}
	public void identifyByPartailLinkText(){
	 	
	}
	public void identifyByXPath(){
	 	
	}
	public void identifyByCss(){
	 	
	}

    public void implicitWaitExample(){
    	drv.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
    }
   
    public void explicitWaitExample(String title){
    WebDriverWait wa=new WebDriverWait(drv,20); 
    WebElement we=drv.findElement(By.linkText("InPortia | Best Training Center in pune for software testing, web ..."));
    //wa.until(ExpectedConditions.titleContains(title)));
    wa.until(ExpectedConditions.visibilityOf(we));
    }

  
}
