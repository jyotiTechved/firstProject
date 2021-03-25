package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import lib.Global;
import lib.Utility;

public class brokenImages {

WebDriver driver;
	
	
	
	public brokenImages() {
		driver = Utility.returnDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	
	 public void verifyBrokenImagesUsingJSOUP() throws Exception
	  {
		 driver.get(Global.appURL);
		 
		 
		  List<WebElement> images = driver.findElements(By.tagName("img"));
		  System.out.println("Total images are :" + images.size());


		  
		  for (WebElement image : images)
		  {
			  String imageSrc = image.getAttribute("src");
			  
		      Scanner scanner = new Scanner(imageSrc); 
			 try 
			 {
			  URL url = new URL(imageSrc);
			  URLConnection urlconnection = url.openConnection();
			  HttpURLConnection httpURLConnection = (HttpURLConnection) urlconnection;
			  httpURLConnection.setConnectTimeout(5000);
			  httpURLConnection.connect();
				
//			  scanner.skip(imageSrc.contains("loading"));
			if(httpURLConnection.getResponseCode()!=200)
			{
				System.err.println(imageSrc + ">>" + httpURLConnection.getResponseCode() + " >> " + httpURLConnection.getResponseMessage() + " is a broken image" );
				//scanner.skip(Pattern.compile("loading"));
			}
			
			  else { 
				  System.out.println(imageSrc + ">>" + httpURLConnection.getResponseCode() + " - " + httpURLConnection.getResponseMessage() ); 
				  }
		
					/*
					 * if(imageSrc.contains("loading")) { System.out.print("info: " + "\b\b\b\b\b\b" + " || " + null); }
					 */
			 
			httpURLConnection.disconnect();
			}
			 catch(Exception e)
			 {
				System.err.println(imageSrc);
			 }
		  }
	  }

		  public void tearDown()
		  {
			  driver.close();
		  }
	
	
}
