package blueSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import blueModal.BlueManageEmployeeModal;


/**
 * Employee Page extends from BluePage
 * @author Lateef Livers
 * Created: Jan 22, 2014
 * Updated: Jun 27, 2014
 * TODO logic for General info Modal Feb 3, 2014 Update: in progress see ManageEmployeeModal
 */
public class BlueEmployee extends BluePage{

	private boolean generalInfoExpanded;
	private boolean projectInfoExpanded;
	private boolean timeOffInfoExpanded;
	public BlueManageEmployeeModal EmployeeModal;
	private double years;
	private double months;
	private double days;
	
	//TODO look for a less messy way of handling this
	private static final String manageTimeOffXpath = ".//*[@id='accordion']/div/div[7]/div[1]/a[2]";
	private static final String viewTimeOffXpath = ".//*[@id='accordion']/div/div[7]/div[1]/a[1]";
	private static final String manageProjectInfoXpath = ".//*[@id='accordion']/div/div[5]/button";
	private static final String manageGeneralXpath = ".//*[@id='accordion']/div/div[3]/button";
	private static final String backButtonXpath = "html/body/div[1]/a";
	private static final String generalTabBarXpath =".//*[@id='accordion']/div/div[3]";
	private static final String projectTabBarXpath =".//*[@id='accordion']/div/div[5]";
	private static final String timeOffTabBarXpath = ".//*[@id='accordion']/div/div[7]";
	private static final String timeWithOrasiXpath =".//*[@id='panel_body_1']/div/table/tbody/tr[9]/td[2]";
	private static final String EmployeeNameXpath =".//*[@id='content']/h1";
	
	/**
	 * Default constructor for BlueEmployee, Sets default state of the info panels and Intailized EmployeeModal
	 * @param driver 
	 */
	public BlueEmployee(WebDriver driver){
		super(driver);
		generalInfoExpanded = true;
		projectInfoExpanded = false;
		timeOffInfoExpanded = false;
		EmployeeModal = new BlueManageEmployeeModal(driver);
	}
	
	/**
	 * Gets the name for the employee
	 * @return String 
	 */
	public String getEmpolyeeName(){
		return getWebElementBy(By.xpath(EmployeeNameXpath)).getText();
	}

	/**
	 * Clicks the Manage button for "General Info"
	 */
	public void manageGenernalInfo(){
		getWebElementBy(By.xpath(manageGeneralXpath)).click();
	}
	
	/**
	 * Clicks the Manage button for "Project Info"
	 */
	public void manageProjectInfo(){
		getWebElementBy(By.xpath(manageProjectInfoXpath)).click();
	}

	/**
	 * Navigates to the Manage time off screen
	 * @return new BlueTimeOff driver
	 */
	public BlueTimeOff manageTimeOff(){
		getWebElementBy(By.xpath(manageTimeOffXpath)).click();
		return new BlueTimeOff(driver);
	}
	
	/**
	 * Clicks the view button on the Employee page
	 * @return new BlueTimeOff object
	 */
	public BlueTimeOff viewTimeOff(){
		getWebElementBy(By.xpath(viewTimeOffXpath)).click();
		return new BlueTimeOff(driver);
	}

	/**
	 * If the general tab is not already expanded. Click to expand
	 */
	public void expandGeneralTab(){
		if(isExpanded(generalInfoExpanded)==false)
		{

			getWebElementBy(By.xpath(generalTabBarXpath)).click();
			generalInfoExpanded = true;
			projectInfoExpanded = false;
			timeOffInfoExpanded = false;
		}
	}
	
	/**
	 * If the project tab is not already expanded. Click to expand
	 */
	public void expandProjectTab(){
		if(isExpanded(projectInfoExpanded)==false)
		{
			getWebElementBy(By.xpath(projectTabBarXpath)).click();
			generalInfoExpanded = false;
			projectInfoExpanded = true;
			timeOffInfoExpanded = false;
		}
	}

	/**
	 * If the Time Off  tab is not already expanded. Click to expand
	 */
	public void expandTimeOffTab(){
		if(isExpanded(timeOffInfoExpanded)==false)
		{
			getWebElementBy(By.xpath(timeOffTabBarXpath)).click();

			generalInfoExpanded = false;
			projectInfoExpanded = false;
			timeOffInfoExpanded = true;
		}
	}
	
	
	/**
	 * Navigates back to the index
	 * @return new BlueIndex driver
	 */
	public BlueIndex goBack(){
		getWebElementBy(By.xpath(backButtonXpath)).click();
		return new BlueIndex(driver);
	}

	/**
	 * Returns if a panel is expanded or not
	 * @param panel	If true table is expanded else it is false
	 * @return True or False
	 */
	private boolean isExpanded(boolean panel){
		return panel;
	}
	
	/**
	 * Gets the Year, Month, and Day from employee page if they exist on the page and set the values
	 * TODO logic to handle when months and days don't appear
	 */
	public void setTimeWithCompany(){
		String TimeToDateString = getWebElementBy(By.xpath(timeWithOrasiXpath)).getText();
		String[] YearMonthDay = TimeToDateString.split(",");
		years = Double.parseDouble(YearMonthDay[0]);
		
	}
	
	/**
	 * Returns number of years
	 * @return years - Number of years with orasi
	 */
	public double getYears(){
		return years;
	}
	/*Manage Employee Modal*/

	
	
}
