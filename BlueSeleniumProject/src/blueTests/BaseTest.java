package blueTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
	
/**
 * Provides some commonly used methods for writing selenium tests
 * @author Lateef Livers
 * Updated: Jun 27, 2014
 * TODO Clean up code
 * TODO I have a few methods being reused in various places. I should look into interfaces maybe?
 */
public abstract class BaseTest {



	protected static WebDriver driver;
	protected static WebElement element;
	private static String url;
		
	/**
	 * Sets up driver and timeout
	 */
	@BeforeTest
	public static void initializeTest(){
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
		
	/**
	 * Opens webpage
	 */
	public void open(){
		driver.get(url);
	}
		
	/**
	 * Returns the title of the current webpage
	 * @return text title
	 */
	public String getTitle(){
		return driver.getTitle();
	}
		
	/**
	 * Returns the URL of the current webpage
	 * @return url
	 */
	public String getURL(){
		return driver.getCurrentUrl();
	}
		
		

	/**
	 * Gets the WebElement by the chosen method
	 * @param locator
	 * @return WebElement if true, NULL otherwise
	 */
	public WebElement getWebElementBy(By locator){
		if(isElementPresent(locator)==true){
			return driver.findElement(locator);
		}
			return null;
			
	}
		
	/**
	 * Verify if specified web element is present
	 * @param locator
	 * @return True if successful, False otherwise
	 */
	public boolean isElementPresent(By locator){
		try{
			driver.findElement(locator); 
			return true;
		}catch(NoSuchElementException ne){
			return false;
		}
		
	}
		
	/**
	 * Verifies the web element is there and displayed
	 * @param locator
	 * @return True if successful, False otherwise
	 */
	public boolean isElementPresentAndDisplayed(By locator){
		try{
			driver.findElement(locator).isDisplayed();
			return true;
		}catch(NoSuchElementException ne){
			return false;
		}
	}
		
	/**
	 * Verifies text is or is not present anywhere on the page. with error checking
	 * @param text
	 * @return True or False
	 */
	public boolean isTextPresent(String text){
		return driver.getPageSource().contains(text);
	}
		
	/**
	 * Sends text to the text field via the provided xpath
	 * @param xpath
	 * @param text
	 */
	protected void sendText(String xpath, String text){
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
		
		
	/**
	 * Clears any text in the targeted text area and then enters in selected text. 
	 * @param text
	 * @param path
	 */
	private void setTextPath(String text, By path){
		//driver.findElement(path)
		getWebElementBy(path).clear();
		//driver.findElement(path).
		getWebElementBy(path).sendKeys(text);
	}
		
	/**
	 * Selects a option from a Select box by name
	 * @param option Name of entry in the select box
	 * @param xpath xpath of the selectbox
	 */
	private void SelectBox(String option, By xpath){
		element = driver.findElement(xpath);
		new Select(element).selectByVisibleText(option);
	}
		
		/**
		 * Closes driver after test is complete
		 */
	@AfterTest(description="closes driver")
		public void cleanup(){
		driver.quit();
	}
	

}
