package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.Global;
import lib.TestData;
import lib.UserActions;
import lib.Utility;

public class IntroPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//a[@href='/contact-us-techved'][1]")
	public WebElement contactTab;

	public IntroPage() {
		driver = Utility.returnDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void intro() throws IOException {

		driver.get(Global.appURL);

		Global.dataMap = TestData.readTestData(Global.id, Global.className, Global.methodName);
		UserActions.clickElement(contactTab, "CONTACT TAB", "I_ContactTab");

		
		System.out.println("Hi in intro page");
	}

	
	
	

}
