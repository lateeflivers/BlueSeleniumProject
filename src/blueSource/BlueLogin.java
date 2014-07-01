package blueSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Login page for BlueSource
 * @author Lateef Livers
 * Created: Jan 22, 2014
 * Updated: Jun 27, 2014 Code cleanup
 */
public class BlueLogin extends BluePage {
	private static final String passwordErrorMessageXpath =  ".//*[@id='new_employee']/div[2]/div[1]";

	/**
	 * Constructor for BlueLogin page
	 * @param Driver
	 * @param url
	 */
/*	public BlueLogin(WebDriver Driver, String url){
		super(driver,url);
		
	}*/
	
	/**
	 * Constructor for BlueLogin Page
	 * @param driver 
	 */
	public BlueLogin(WebDriver driver){
		super(driver);
	}
	
	/**
	 * Enters the userName into the username field in the format of firstname.lastname
	 * @param firstName - First name of person trying to log in
	 * @param lastName - Last name of person trying to log in
	 */
	public void enterFirstAndLastName(String firstName, String lastName){
		String userName;
		userName = firstName+"."+lastName;
		userName = userName.toLowerCase();
		//driver.findElement
		getWebElementBy(By.name("employee[username]")).sendKeys(userName);
	}
	
	/**
	 * Enters password into the correct field
	 * @param password - Users' password
	 */
	public void enterPassword(String password){
		
		//driver.findElement
		getWebElementBy(By.name("employee[password]")).sendKeys(password);
	}
	
	/**
	 * Logs into the site with sucessful crediantals
	 * @return  BlueIndex
	 */
	public BlueIndex submitForm()
	{
		getWebElementBy(By.name("employee[password]")).submit();
		//driver.findElement(By.name("employee[password]")).submit();
		return new BlueIndex(driver);
	}

	/**
	 * Use for incorrect login attempts. Attempts a bad login
	 */
	public void submitFormIncorrect(){
		//driver.findElement
		getWebElementBy(By.name("employee[password]")).submit();
	}
	
	/**
	 * Gets error message after a login error
	 * TODO add logic to handle when error message isn't displayed. 
	 * @return Password Error Message
	 */
	public String getPasswordErrorMsg(){
		return getWebElementBy(By.xpath(passwordErrorMessageXpath)).getText();

	}
	
	/**
	 * Returns if the login error message is displayed
	 * @return True if error message appears, otherwise false.
	 */
	public boolean isLoginErrorMsgPresent(){
		return isElementPresentAndDisplayed(By.xpath(passwordErrorMessageXpath));
	}
	
	/**
	 * Logs in the user
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	public BlueIndex validLogin(String firstName, String lastName, String password){
		enterFirstAndLastName(firstName, lastName);
		enterPassword(password);
		submitForm();
		return new BlueIndex(driver);
		
	}
}
