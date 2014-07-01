package blueModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

// TODO for nested selectboxes (I.E. Departments and sub departments) into a for each loop
// TODO add functionally for Bridge time

import blueHelpers.BlueUser;
/**
 * Used to fill in data for the "Manage and Add Employee Modals" 
 * @author Lateef
 *
 */
public class BlueManageEmployeeModal {
	private static final String blueSourceUserNameXPATH = ".//*[@id='employee_username']";
	private static final String FirstNameXpath = ".//*[@id='employee_first_name']";
	private static final String LastNameXpath = ".//*[@id='employee_last_name']";
	private static final String SelectEmpLevelXpath = ".//*[@id='employee_level']";
	private static final String SelectRoleXpath = ".//*[@id='employee_role']";
	private static final String SelectManagerXpath = ".//*[@id='employee_manager_id']";
	private static final String SelectStatusDropdownXpath = ".//*[@id='employee_status']";
	private static final String SelectLocationXpath = ".//*[@id='employee_location']";
	private static final String StartDateXpath = ".//*[@id='employee_start_date']";
	private static final String CellPhoneStartDateXpath =".//*[@id='employee_cell_phone']";
	private static final String OfficePhoneXpath = ".//*[@id='employee_office_phone']";
	private static final String EmailXpath = ".//*[@id='employee_email']";
	private static final String IMNameXpath =".//*[@id='employee_im_name']";
	private static final String IMClientXpath = ".//*[@id='employee_im_client']";
	private static final String SelectIMClientXpath = ".//*[@id='employee_im_client']";
	private static final String SelectDeptXpath = "html/body/div[1]/section/div[1]/div[5]/div/div/div[2]/form/div[17]/select[1]";
	private static final String SelectSubDeptXpath = "html/body/div[1]/section/div[1]/div[5]/div/div/div[2]/form/div[17]/select[2]";
	private static final String CloseBtnName = "button";
	private static final String UpdateEmployeeName = "commit";
	private static final String SelectTitleXpath = ".//*[@id='employee_title_id']";
	private static final String SelectStatusXpath = ".//*[@id='employee_status']";
	private static final String CellPhoneXpath = ".//*[@id='employee_cell_phone']";
	private static final String CreateEmployeeXpath = ".//*[@id='new_employee']/div[18]/input";

	
	
	private static WebDriver driver; 
	private static WebElement element;
	
	/**
	 * Constructor 
	 * @param driver
	 */
	public BlueManageEmployeeModal(WebDriver driver){
		this.driver = driver;
	}
	
	
	/**
	 * Sets the blueSource user name e.g. first.last
	 * @param firstName 
	 * @param lastName
	 */
	public void setUserName(String firstName, String lastName){
		//driver.findElement(By.xpath(blueSourceUserNameXPATH)).sendKeys(firstName+"."+lastName);
		setPath(firstName+"."+lastName, By.xpath(blueSourceUserNameXPATH));
	//	setFirstName(firstName);
	//	setLastName(lastName);
	}
	
	/**
	 * Enters fills fields in the employee modal
	 * @param firstName
	 * @param lastName
	 * @param role
	 * @param Dept
	 * @param level
	 * @param Location
	 */
	public void fillFields(String firstName, String lastName, String role, String Dept, String level, String Location){
		setUserName(firstName, lastName);
		setFirstName(firstName);
		setLastName(lastName);
		selectRole(role);
		selectLevel(level);
		selectDepartment(Dept);
		selectLocation(Location);
	}
	
	public void fillFields(BlueUser newEmployee){
		setUserName(newEmployee.getEmployeeFirstName(), newEmployee.getEmployeeLastName());
		setFirstName(newEmployee.getEmployeeFirstName());
		setLastName(newEmployee.getEmployeeLastName());
		selectRole(newEmployee.getEmployeeRole());
		selectDepartment(newEmployee.getDepartment());
		selectSubDepartment(newEmployee.getSubDepartment());
		selectLocation(newEmployee.getLocation());
		selectManager(newEmployee.getEmployeeManager());
		selectTitle(newEmployee.getEmployeeTitle());
		setStartDate(newEmployee.getStartDate());
		selectStatus(newEmployee.getStatus());
		setCellPhone(newEmployee.getCellNumber());
		setOfficePhone(newEmployee.getOfficeNumber());
		setEmail(newEmployee.getEmail());
		setIMname(newEmployee.getIM_name());
		setIMClient(newEmployee.getIM_Client());
	}
	
	public void selectSubDepartment(String subDept){
		SelectBox(subDept, By.xpath(SelectSubDeptXpath));
	}
	
	public void setIMClient(String IM_Client){
		SelectBox(IM_Client, By.xpath(IMClientXpath));
	}
	
	/**
	 * Sets IM Name
	 * @param IM_name
	 */
	public void setIMname(String IM_name){
		setPath(IM_name, By.xpath(IMNameXpath));
	}
	
	/**
	 * Sets the email field
	 * @param Email
	 */
	public void setEmail(String Email){
		setPath(Email, By.xpath(EmailXpath));
	}
	
	/**
	 * Sets the cellphone number
	 * @param cellNumber
	 */
	public void setCellPhone(String cellNumber){
		setPath(cellNumber, By.xpath(CellPhoneXpath));
	}
	
	/**
	 * Sets office number
	 * @param officePhone
	 */
	public void setOfficePhone(String officePhone){
		setPath(officePhone, By.xpath(OfficePhoneXpath));
	}
	/**
	 * Select the Employee's status 
	 * @param status Permanent, Contractor, Inactive
	 */
	public void selectStatus(String status){
		SelectBox(status, By.xpath(SelectStatusXpath));
	}
	
	/**
	 * Selects the title for the Employee
	 * @param Title
	 */
	public void selectTitle(String Title){
		SelectBox(Title, By.xpath(SelectTitleXpath));
	}
	
	/**
	 * Enters the First Name field. 
	 * @param firstName
	 */
	public void setFirstName(String firstName){
	//	driver.findElement(By.xpath(FirstNameXpath)).sendKeys(firstName);
		setPath(firstName,By.xpath(FirstNameXpath));
	}
	
	/**
	 * Enters text in the last name field
	 * @param lastName
	 */
	public void setLastName(String lastName){
	//	 driver.findElement(By.xpath(LastNameXpath)).sendKeys(lastName);
		 setPath(lastName,By.xpath(LastNameXpath));

	}
	
	/** 
	 * Selects the level of the employee e.g. Consulting Manager, Consultant
	 * @param level
	 */
	public void selectLevel(String level){

		SelectBox(level, By.xpath(SelectEmpLevelXpath));
	}
	
	/**
	 * Selects the role of the employee e.g. Consultant, Manager, etc
	 * @param role
	 */
	public void selectRole(String role){
		SelectBox(role,By.xpath(SelectRoleXpath));
	}
	
	/**
	 * Selects the manager for the current employee
	 * @param Manager
	 */
	public void selectManager(String Manager){
		SelectBox(Manager, By.xpath(SelectManagerXpath));
	}
	
	/**
	 * Selects the Location where this person is based.  
	 * @param Location
	 */
	public void selectLocation(String Location){
		SelectBox(Location, By.xpath(SelectLocationXpath));
	}
	
	/**
	 * Selects the IM Client 
	 * @param IMClient
	 */
	public void selectIMClient(String IMClient){
		SelectBox(IMClient, By.xpath(SelectIMClientXpath));
	}
	
	/**
	 * Selects the department of the user. Should this be auto set?
	 * @param Dept
	 */
	public void selectDepartment(String Dept){
		SelectBox(Dept, By.xpath(SelectDeptXpath));
	}
	
	
	/**
	 * Fills the email field
	 * @param firstName
	 * @param lastName
	 */
	public void setEmail(String firstName, String lastName){
		String email =firstName+"."+lastName+"@orasi.com";
		setPath(email,By.xpath(EmailXpath));
	}
	
	/**
	 * Enters the Start Date field.
	 * @param StartDate
	 */
	public void setStartDate(String StartDate){
		setPath(StartDate,By.xpath(StartDateXpath));
	}
	
	/**
	 * Clicks the update employee method
	 */
	public void UpdateEmployee(){
		driver.findElement(By.name(UpdateEmployeeName)).click();
	}
	
	private void setPath(String text, By path){
		driver.findElement(path).clear();
		driver.findElement(path).sendKeys(text);
	}
	
	private void SelectBox(String option, By xpath){
		element = driver.findElement(xpath);
		new Select(element).selectByVisibleText(option);

	}
	public void AddUser(){
		driver.findElement(By.xpath(CreateEmployeeXpath)).click();
	}
	
}
