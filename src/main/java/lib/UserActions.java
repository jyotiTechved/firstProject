package lib;

import java.io.IOException;

import org.openqa.selenium.WebElement;


public class UserActions {
	
	
	
	
	/**Methodname:enterText : it is used to enter the text into the text box
	 * return : Recordset
	 * @author Dharm
	 * @throws IOException 
	 *
	 */
	public static boolean enterText(WebElement ele , String label , String strColumn) throws IOException {
		
		String strValue = TestData.readValueBasedOnTheKey(strColumn);
		
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return true;
		}
		
		try {
			ele.sendKeys(strValue);
			Reporting.writeHtmlLogs("PASS", "sucessfully enter the " + strValue + " in the text box " + label);
			Reporting.takeScreenshot("PASS");
		}
		catch(Exception e) {
			Reporting.writeHtmlLogs("FAIL", "Failed to enter the " + strValue + " in the text box " + label + "  . " + e.getMessage());
			Reporting.takeScreenshot("FAIL");
		}
		return true;
		
		
	}
	
	/**Methodname:enterText : it is used to click on the webelement
	 * return : Recordset
	 * @author Dharm
	 *
	 */
	public static boolean clickElement(WebElement ele , String label , String strColumn) {
		
		String strValue = TestData.readValueBasedOnTheKey(strColumn);
		
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return true;
		}
		
		try {
			ele.click();
			Reporting.writeHtmlLogs("PASS", "sucessfully click on " + label);
			Reporting.takeScreenshot("PASS");
		}
		catch(Exception e) {
			Reporting.writeHtmlLogs("FAIL", "Failed to  click on " + label + " " +e.getMessage());
		}
		return true;
		
		
	}
	
	
	
	
	
	
	

}
