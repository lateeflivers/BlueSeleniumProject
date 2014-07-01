package blueModal;

/* Currently not in Use -Lateef*/
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public abstract class BlueModalBase {
	
	private  WebDriver driver; 
	private  WebElement element;
	
	public BlueModalBase(WebDriver driver){
		this.driver = driver;
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

}
