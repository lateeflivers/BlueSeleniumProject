package blueSource;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import blueHelpers.BlueUser;
import blueModal.BlueManageEmployeeModal;


/**
 * Index Page
 * @author Lateef Livers
 * Jan 22, 2014
 * Updated: Jun 27, 2014
 *
 */
public class BlueIndex extends BluePage {
	//TODO look for a less messy way of handling this
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeFullName;
	private static String addButtonXpath = ".//*[@id='all-content']/div[2]/div/div[2]/button";
	private static String showInactivesXpath = "html/body/div[1]/section/div[1]/div[2]/div/div[1]/label";
	private static String flashMessagePanelXpath = "html/body/div[1]/section/div[1]/div[1]";
	private static String welcomeHeaderXpath ="html/body/div[1]/section/div[1]/h1";
	protected BlueManageEmployeeModal AddEmployee;
	
	/**
	 * Constructor for index page with first and last name of an employee
	 * @param driver
	 * @param employeeFirstName Employees first name
	 * @param employeeLastName Employees last name
	 */
	public BlueIndex(WebDriver driver, String employeeFirstName, String employeeLastName){
		super(driver);
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		employeeFullName = employeeFirstName+" "+employeeLastName;
	}

	/**
	 * Default constructor for index page when first and last name are not given
	 * @param driver
	 */
	public BlueIndex(WebDriver driver){
		super(driver);
		this.employeeFirstName = null;
		this.employeeLastName = null;
		this.AddEmployee = new BlueManageEmployeeModal(driver);
	}
	
	/**
	 * Set firstName field
	 * @param employeeFirstName
	 */
	public void setFirstName(String employeeFirstName){
		this.employeeFirstName = employeeFirstName;
	}
	
	/**
	 * Sets lastName field
	 * @param employeeLastName
	 */
	public void setLastName(String employeeLastName){
		this.employeeLastName = employeeLastName;
	}
	
	
	
	/**
	 * Searches for a particular employee in the search bar
	 * @param Employee
	 */
	public void searchEmployee(String Employee){
		searchBar(Employee);
	}
	
	
	/**
	 * Searches for a employee, Also sets EmployeeFullName, FirstName, and LastName
	 * @param FirstName
	 * @param LastName
	 */
	public void searchEmployee(String FirstName, String LastName){
		setEmployeeFullName(FirstName, LastName);
		setFirstName(FirstName);
		setLastName(LastName);
		searchBar(employeeFullName);
	}
	
	/**
	 * Navigates to the selected employees page. Clicks on the employee's Last Name
	 * @return BlueEmployee
	 */
	public BlueEmployee selectEmployee(){
		
		 element = getWebElementBy(By.linkText(employeeLastName));
		 driver.get(element.getAttribute("href"));
		 return new BlueEmployee(driver);
		 
	}
	
	
	/**
	 * Sets the employeeFullName to 'FirstName LastName'
	 * @param FirstName
	 * @param LastName
	 */
	private void setEmployeeFullName(String FirstName, String LastName){
		employeeFullName = FirstName+" "+LastName;
	}
	
	/**
	 * Sets employeeFullName to 'FirstName LastName'
	 */
	private void setEmployeeFullName(){
		employeeFullName = employeeFirstName+" "+employeeLastName;
	}

	/**
	 * Opens the Employee modal and enters in all relevant data.
	 * @param newEmployee
	 */
	public void addNewEmployee(BlueUser newEmployee){
		openEmployeeModal();
		AddEmployee.fillFields(newEmployee);
		AddEmployee.AddUser();
	}

	/**
	 * Clicks the "Add" button and opens the create employee modal
	 */
	public void openEmployeeModal(){
	//	getWebElementBy(By.xpath(addButtonXpath)).click();
		clickButton("Add", "button");
	//	getWebElementBy(By.linkText("Add")).click();
	}
	
	/**
	 * Clicks the "Show Inactives" button
	 */
	public void toggleInactives(){
		clickButton("Show Inactives");
	//	getWebElementBy(By.xpath(showInactivesXpath)).click();
	}
	
	/**
	 * Returns the flash message if present, returns null otherwise
	 * @return text
	 */
	public String getFlashMessage(){
		//Should this be a try/catch block?
		//if(isElementPresentAndDisplayed(By.xpath(flashMessagePanelXpath)))
		try{
			return getWebElementBy(By.xpath(flashMessagePanelXpath)).getText();
		}catch(NoSuchElementException ne){
			System.err.println("Element not found");
		
		}
		
		
		return null;
	}
	
	/**
	 * Returns the Welcome, %NAME text string
	 * @return text
	 */
	public String getWelcomeTitle(){
		return getWebElementBy(By.xpath(welcomeHeaderXpath)).getText();
	}

}
