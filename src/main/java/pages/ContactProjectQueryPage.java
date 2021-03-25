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

public class ContactProjectQueryPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@href='/contact-us-techved'][1]")
	public WebElement contactTab;
	
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_txtName']")
	public WebElement name;
	
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_txtPhone']")
	public WebElement phone;
	
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_txtEmail']")
	public WebElement email;
	
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_txtCompanyName']")
	public WebElement companyName;
	
	@FindBy(xpath="//label[text()='Digital Transformation']")
	public WebElement services;
	
	@FindBy(xpath="//textarea[@id='ContentPlaceHolder1_txtDescription']")
	public WebElement description;
	
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_btnSubmit123']")
	public WebElement sendDetails;
	
	
	@FindBy(xpath="//input[@name='ctl00$txtLeadGenPopName']")
	public WebElement popupName;
	
	@FindBy(xpath="//input[@name='ctl00$txtLeadGenPopPhone']")
	public WebElement popupMobile;
	
	@FindBy(xpath="//input[@name='ctl00$txtLeadGenPopEmail']")
	public WebElement popupEmail;
	
	@FindBy(xpath="//input[@name='ctl00$txtLeadGenPopCompanyName']")
	public WebElement popupCompanyName;
	
	
	
	//Hello  - by ABC person
	
	public ContactProjectQueryPage() {
		driver = Utility.returnDriver();
		PageFactory.initElements(driver, this);
	}
	
	//Business components (it just method)
	public void projectQuery() throws IOException, Exception 
	{	
		
		driver.get(Global.appURL);

		Global.dataMap = TestData.readTestData(Global.id, Global.className, Global.methodName);
		UserActions.clickElement(contactTab, "CONTACT TAB", "ContactTab_C");
		UserActions.enterText(name, "Name", "name_c");
		UserActions.enterText(phone, "Phone", "phone_c");
		UserActions.enterText(email, "Email", "email_c");
		UserActions.enterText(companyName, "Company Name", "companyName_c");
		UserActions.clickElement(services, "Services", "services_c");
		UserActions.enterText(description, "Description", "description_c");
		
		
		String mathquestionvalue = driver
				.findElement(By.xpath("//div[@class='contact-us-form-wrapper']//child::span[@class='cc-label'][1]"))
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

		WebElement capta = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_projectEnqCaptchaInput']"));
		capta.clear();
		capta.sendKeys("" + summation);

		UserActions.clickElement(sendDetails, "Send Details" , "sendDetails_c");
		
		Thread.sleep(5000);
		
		UserActions.enterText(popupName, "Popup Name", "popupName_c");
		UserActions.enterText(popupMobile, "Popup Mobile" , "popupMobile_c");
		UserActions.enterText(popupEmail, "Popup Email", "popupEmail_c");
		UserActions.enterText(popupCompanyName, "Popup Company Name", "popupCompanyName_c");
		
		
		
		
		System.out.println("Hi in contact project query page");	
		
	}
}
