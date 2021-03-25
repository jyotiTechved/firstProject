package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Singleton class (design pattern)

public class InitDriver {
	
	private static WebDriver driver;
	
	
	private InitDriver() {
		
	}
	
	public static WebDriver getDriverInstance(String strBrowserName) {
		
		if(driver==null) {
			if(strBrowserName.contentEquals("CHROME")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Resources\\chromedriver.exe");			
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				
			}
			else if(strBrowserName.contentEquals("FIREFOX")) {
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Resources\\chromedriver.exe");			
				//driver = new ChromeDriver();
				
			}
			
			
		}
		
		
		
		return driver;
		
	}
	
	
	
	

}
