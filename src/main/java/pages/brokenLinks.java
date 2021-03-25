package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import lib.Global;
import lib.Utility;

public class brokenLinks {
	
	WebDriver driver;
	
	
	
	public brokenLinks() {
		driver = Utility.returnDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	 public void VerifyBrokenLinks() {
		 driver.get(Global.appURL);
		  List<WebElement> links = driver.findElements(By.tagName("a"));	
			System.out.println("Total links are "+links.size());	
			for(int i=0; i<links.size(); i++) {
				WebElement element = links.get(i);
				String url=element.getAttribute("href");
				
				verifyLink(url);
	  }
	 }
			public static void verifyLink(String urlLink) {
			      try {
						URL link = new URL(urlLink);
						HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
						httpConn.setConnectTimeout(5000);
						httpConn.connect();
							if(httpConn.getResponseCode()>= 400) {	
								System.err.println(urlLink+" - "+ httpConn.getResponseCode() + " - " + httpConn.getResponseMessage() + " is a broken link");
							}
							
							  else { System.out.println(urlLink+" - "+ httpConn.getResponseCode() + " - " +
							  httpConn.getResponseMessage()); }
							 
						}
					catch (Exception e) {
					}
			  }
			  
			  public void tearDown()
			  {
				  driver.close();
			  }
	

}
