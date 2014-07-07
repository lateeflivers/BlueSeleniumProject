package blueSource;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



/**
 * Template page for all pages on BlueSource. The idea behind this is to help with 
 * code reuse in regards to page navagation
 * @author Lateef Livers
 * Created: Jan 22, 2014
 * Updated: Jun 27, 2014 
 * TODO Make 'Projects' Page *BlueProject. Needs to be created Feb 3, 2014
 * TODO Make 'Directory' Page *BlueDirectory Page needs to be created Feb 3, 2014
 * TODO Make 'My Information' Page *BlueInfomation
 */
public abstract class BluePage {
	
	private List<WebElement> buttonsCollection;
	protected WebDriver driver;
	protected WebElement element;
	public String url;
	private static final String showInactiveXpath = ".//*[@id='ng-app']/div[2]/div/div[2]/label";
	//private static final String addEmployeeBtnXpath = ".//*[@id='ng-app']/div[2]/div/div[2]/button";
	private static final String addEmployeeBtnXpath = ".//button";
	/**
	 * Constructor base for pages
	 * @param driver
	 * @param url
	 */
	public BluePage(WebDriver driver, String url){
		this.driver = driver;
		this.url = url;
	}
	
	/**
	 * Constructor for driver when no URL is given, Maximizes window
	 * @param driver
	 */
	public BluePage(WebDriver driver){
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * Opens webpage and navigates to url
	 * @param url
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
	 * Sets the url to a new webaddress
	 * @param url - webaddress
	 */
	public void setURL(String url){
		this.url = url;
	}

	/**
	 * Gets the WebElement by the chosen method
	 * @param locator used to find element. (e.g. By.Xpath, By.Name, and By.Id)
	 * @return WebElement if true, NULL otherwise
	 */
	public WebElement getWebElementBy(By locator){
		if(isElementPresent(locator)==true){
			return driver.findElement(locator);
		}
			System.err.println("Not Found");
			return null;
		
	}
	
	/**
	 * Verify if specified web element is present
	 * @param locator used to find element. (e.g. By.Xpath, By.Name, and By.Id)
	 * @return True if successful, False otherwise
	 */
	public boolean isElementPresent(By locator){
		try{
			driver.findElement(locator); 
			return true;
		}catch(NoSuchElementException ne){
//			System.err.println("Element not found");
			return false;
		}
		
	}
	
	/**
	 * Verifies the web element is there and displayed
	 * @param locator used to find element. (e.g. By.Xpath, By.Name, and By.Id)
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
	 * Verifies text is or is not present. with error checking
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
	//	driver.findElement(By.xpath(xpath)).sendKeys(text);
		getWebElementBy(By.xpath(xpath)).sendKeys(text);
	}
	
	/**
	 * Click the "Directory" link at the top of the page
	 * TODO BlueDirectory class file not currently created Feb 3
	 */
	public void Directory(){
		getWebElementBy(By.linkText("Directory")).click();
/*		if(isElementPresent(By.linkText("Directory"))==true){
			driver.findElement(By.linkText("Directory")).click();
			//return new BlueProject(driver);
		}*/
		// return null;
	}
	
	/**
	 * Click the "Projects" link at the top of the page
	 * TODO Create BlueProject class
	 */	
	public void clickProjects(){
		getWebElementBy(By.linkText("Projects")).click();
//		if(isElementPresent(By.linkText("Projects"))==true){
//			driver.findElement(By.linkText("Projects")).click();	
//			// return new BlueProject(driver);		
//		}
		//return null;
	}
	
	/**
	 * Click the "Employees" link at the top of the page
	 * @return a new BlueEmployee if true, NULL otherwise
	 */	
	public BlueIndex clickEmployees(){
		getWebElementBy(By.linkText("Employees")).click();
		return new BlueIndex(driver);
/*		if(isElementPresent(By.linkText("Employees"))==true){
			driver.findElement(By.linkText("Employees")).click();
			return new BlueIndex(driver);
		}
		return null;*/
	}
	
	/**
	 * Click the "Logout" link at the top of the page
	 */	
	public void clickLogout(){
		getWebElementBy(By.linkText("Logout")).click();	
/*		if(isElementPresent(By.linkText("Logout"))==true)
			driver.findElement(By.linkText("Logout")).click();*/
	}

	/**
	 * Clicks the "help" icon
	 */
	public void clickHelp(){
		getWebElementBy(By.className("help-icon")).click();
/*		if(isElementPresent(By.className("help-icon"))==true)
			driver.findElement(By.className("help-icon")).click();*/
	}

	/**
	 * Enters given text into the search bar
	 * @param text
	 */
	public void searchBar(String text){
		getWebElementBy(By.id("search-bar")).sendKeys(text);		
/*		if(isElementPresent(By.id("search-bar")))
			driver.findElement(By.id("search-bar")).sendKeys(text);	*/	

	}
	
	/*Buttons */
	
	/**
	 * Finds and clicks target button, currently uses By.name("options") will probably generalize a bit
	 * @author Lateef Livers
	 * Created: Jul 1, 2014
	 * @param ButtonName
	 */
	public void clickButton(String ButtonName){
		findButtons(ButtonName);
	}
	
	/**
	 * Finds and clicks target button, 
	 * @author Lateef Livers
	 * Created: Jul 1, 2014
	 * @param ButtonName -Name of button
	 * @param byNamePath	-(i.e. By.xpath(path), By.name(path))
	 */
	public void clickButton(String ButtonName, String byNamePath){
		findButtons(ButtonName, byNamePath);
	}
	
	
	/**
	 * Finds the target button and clicks it.  By.name("Options")
	 * @param target
	 */
	private void findButtons(String target){
		buttonsCollection = driver.findElements(By.name("options"));
		
		for(WebElement btnElement: buttonsCollection){
			if(btnElement.getText().contains(target)){
				btnElement.click();
				break;
			}
		}
	}
	
	
	/**
	 * More general method. 
	 * TODO test this
	 * @param target
	 * @param byNamePath
	 */
	private void findButtons(String target, String byNamePath){
		buttonsCollection = driver.findElements(By.name(byNamePath));
		
		for(WebElement btnElement: buttonsCollection){
			if(btnElement.getText().contains(target)){
				btnElement.click();
				break;
			}
		}
		
	}
	/**
	 * Clicks the Show Inactives button
	 */
	public void toggleInactive(){

		getWebElementBy(By.xpath(showInactiveXpath)).click();
	}
	//TODO Add other buttons here or way to find a button randomly?
	/**
	 * Clicks the "Add" button for adding a new employee
	 */
	public void addEmployee(){
		getWebElementBy(By.xpath(addEmployeeBtnXpath)).click();

	}
	
}
