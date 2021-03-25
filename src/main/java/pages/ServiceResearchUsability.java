package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.Global;
import lib.TestData;
import lib.UserActions;
import lib.Utility;

public class ServiceResearchUsability {
	
WebDriver driver;
	
	@FindBy(xpath="//li[@id='servicesTab']")
	public WebElement serviceTab;
	
	@FindBy(xpath="//a[text()='Research & Insights'][1]")
	public WebElement research;
	
	@FindBy(xpath="//span[.='Usability Test & Remote Usability Testing'][1]")
	public WebElement usability;
	
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$drop_us_your_link$url']")
	public WebElement URL;
	
	@FindBy(xpath="//button[text()='Proceed']")
	public WebElement proceedButton;
	
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$drop_us_your_link$usr1']")
	public WebElement fullName;
	
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$drop_us_your_link$usr2']")
	public WebElement mobileNumber;
	
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$drop_us_your_link$usr3']")
	public WebElement emailID;
	
	@FindBy(xpath="//a[text()='Submit']")
	public WebElement submit;
	
	@FindBy(xpath="//input[@name='ctl00$txtLeadGenPopName']")
	public WebElement popupName;
	
	@FindBy(xpath="//input[@name='ctl00$txtLeadGenPopPhone']")
	public WebElement popupMobile;
	
	@FindBy(xpath="//input[@name='ctl00$txtLeadGenPopEmail']")
	public WebElement popupEmail;
	
	@FindBy(xpath="//input[@name='ctl00$txtLeadGenPopCompanyName']")
	public WebElement popupCompanyName;
	
	@FindBy(xpath="//input[@name='ctl00$txtLeadGenPopDescription']")
	public WebElement popupDecription;
	
	@FindBy(xpath="//input[@name='txtLeadGenPopBtnSubmit']")
	public WebElement popupSendDetails;
	
	@FindBy(xpath="//button[@class='close animated'][1]")
	public WebElement closePopup;
	
	
	
	public ServiceResearchUsability() {
		driver = Utility.returnDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void researchUsability() throws IOException, Exception {

		driver.get(Global.appURL);
		Thread.sleep(1000);

		Global.dataMap = TestData.readTestData(Global.id, Global.className, Global.methodName);
		UserActions.clickElement(serviceTab, "Service TAB", "ServiceTab_c");
		UserActions.clickElement(research, "Data", "data_c");
		UserActions.clickElement(usability, "Usability", "usability_c");
		UserActions.enterText(URL, "URL", "url_c");
		UserActions.clickElement(proceedButton, "Process Button", "Proceed Button_c");
		UserActions.enterText(fullName, "Full Name", "fullName_c");
		UserActions.enterText(mobileNumber, "Mobile Number", "mobileNumber_c");
		UserActions.enterText(emailID, "EmailID", "emailID_c");
		UserActions.clickElement(submit, "Submit", "submit_c");
		
		Thread.sleep(3000);
		
		UserActions.enterText(popupName, "Popup Name", "popupName_c");
		UserActions.enterText(popupMobile, "Popup Mobile", "popupMobile_c");
		UserActions.enterText(popupEmail, "Popup Email", "Popup Email_c");
		UserActions.enterText(popupCompanyName, "Popup Company Name", "popupCompanyName_c");
		UserActions.enterText(popupDecription, "Popup Decription", "popupDecription_c");
		
		Thread.sleep(1000);
		
		String mathquestionvalue = driver
				.findElement(By.xpath("//div[@class='form-group captcha cc-container']//child::span[@class='cc-label'][1]"))
				.getText().trim();
		System.out.println(mathquestionvalue);
		// remove space if exist
		String removespace = mathquestionvalue.replaceAll("\\s+", "");
		// get two numbers
		String[] parts = removespace.split("\\+");
		String part1 = parts[0];
		String part2 = parts[1];
		String[] parts1 = part2.split("\\=");
		String part11 = parts1[0];

		// sum two numbers
		int summation = Integer.parseInt(part1) + Integer.parseInt(part11);

		WebElement capta = driver.findElement(By.xpath("//input[@name='ctl00$txtLeadGenPopCaptchaInput']"));
		capta.clear();
		capta.sendKeys("" + summation);

		UserActions.clickElement(popupSendDetails, "Send Details" , "sendDetails_c");
	
		Thread.sleep(1000);
		
		UserActions.clickElement(closePopup, "Close Popup", "closePopup_c");
	
	}
	
	public void tearDown() {
		driver.close();
}

}
