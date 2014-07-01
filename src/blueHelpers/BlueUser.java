package blueHelpers;

import java.util.Random;

/**
 * Helper class to hold data for a newly generated user
 * @author Lateef
 * Created Jun 25, 2014
 */
public class BlueUser {
	
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeRole;
	private String employeeTitle;
	private String employeeManager;
	private String department;
	private String subDepartment;
	private String location; 
	private String status;
	private String cellNumber;
	private String officeNumber;
	private String email; 
	private String startDate;
	private String IM_name;
	private String IM_Client;
	private String employeeFullName;


	public  String getIM_name() {
		return IM_name;
	}

	public  void setIM_name(String iM_name) {
		IM_name = iM_name;
	}

	private Random rand = new Random();
	
	/**
	 * Creates a new randomly generated userUser
	 * @param employeeManager
	 * @param employeeTitle
	 * @param status
	 */
	public BlueUser(String employeeManager, String employeeTitle, String status){
		employeeFirstName = "Generated" + rand.nextInt(5000)+1;
		employeeLastName = "User" + rand.nextInt(5000)+1;
		this.employeeManager = employeeManager;
		this.employeeTitle = employeeTitle;
		this.status = status; 
		department = "Services";
		subDepartment = "Rural";
		email = employeeFirstName + "." + employeeLastName +"@orasi.com";
		location = "Remote";
		cellNumber = "3365555555";
		officeNumber = "(336)555-5555";
		
	}
	
	/**
	 * Creates a new consultant and assigns them to a given manager.
	 * @param employeeManager
	 */
	public BlueUser(String employeeManager){
		employeeFirstName = "Generated" + rand.nextInt(5000)+1;
		employeeLastName = "User" + rand.nextInt(5000)+1;
		setEmployeeFullName(employeeFirstName + " " + employeeLastName);
		this.employeeManager = employeeManager;
		employeeTitle = "Consultant";
		status = "Permanent"; 
		employeeRole = "Base";
		department = "Services";
		subDepartment = "Rural";
		email = employeeFirstName + "." + employeeLastName +"@orasi.com";
		location = "Remote";
		cellNumber = "3365555555";
		officeNumber = "(336)555-5555";
		startDate = "2014-06-26";
		IM_name = email;
		IM_Client = "Skype";
	}

	
	public String getEmployeeFirstAndLast(){
		return employeeFirstName+" "+employeeLastName;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public  String getEmployeeLastName() {
		return employeeLastName;
	}

	public  void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public  String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getEmployeeTitle() {
		return employeeTitle;
	}

	public void setEmployeeTitle(String employeeTitle) {
		this.employeeTitle = employeeTitle;
	}

	public String getEmployeeManager() {
		return employeeManager;
	}

	public void setEmployeeManager(String employeeManager) {
		this.employeeManager = employeeManager;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSubDepartment() {
		return subDepartment;
	}

	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public String getIM_Client() {
		return IM_Client;
	}

	public void setIM_Client(String iM_Client) {
		IM_Client = iM_Client;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEmployeeFullName() {
		return employeeFullName;
	}

	public void setEmployeeFullName(String employeeFullName) {
		this.employeeFullName = employeeFullName;
	}

}
