package blueSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/* TODO before going any further on details page. We need to know what should be covered on the modals
 * TODO Logic for determining vacation accrual rates Feb 3
 * TODO Method for grabbing number of Min/Max days for each PDO type. 
 */
public class BlueRequestTimeOff extends BluePage {
	
	private static final String EmailManagerButtonXpath = "html/body/div[1]/div[2]/a";
	private static final String RequestTimeOffButtonXpath = "html/body/div[1]/div[3]/button";
	
	private static final String StartDateNewModalXpath = ".//*[@id='start_date-new']";
	private static final String EndDateNewModalXpath = ".//*[@id='end_date-new']";
	private static final String VacationTypeScollXpath = ".//*[@id='vacation_vacation_type']";
	private static final String HalfDayCheckBoxXpath = ".//*[@id='half_day-new']";
	private static final String CCMeOnThisEmailXpath = ".//*[@id='cc_check_box']";
	private static final String SaveVacationButtonXpath = ".//*[@id='modal_2']/div/div/div[2]/form/input[2]";
	private static final String CloseModalXpath = ".//*[@id='modal_2']/div/div/div[1]/button";
	private static final String FiscalYearScrollXpath = ".//*[@id='fy']";
	private static final String DetailsLinkXpath = "html/body/div[1]/div[1]/a";
	private static final String MemoEditFormXpath = ".//*[@id='memo']";
	
	
	
	/* Main Time Off Page */
	/**
	 * Cancels the PDO quest on the given row
	 * @param row
	 */
	public void CancelRequestPDO(int row){
		//TODO Stub Grab logic from delete row method in BlueTimeOff. 

	}

	/**
	 * Clicks the 'Request Time Off' Button
	 */
	public void RequestTimeOff(){
		getWebElementBy(By.xpath(RequestTimeOffButtonXpath)).click();
	}

	public BlueRequestTimeOff(WebDriver driver) {
		super(driver);
	}

	/* Request Time Off Modal */
	
	/**
	 * Enters the start date in the Request PDO modal. DOES NOT CHECK FORMAT
	 * Correct Format should be YYYY-MM-DD
	 * @param startDate  Correct Format should be YYYY-MM-DD
	 */
	public void EnterStartDate(String startDate){
		getWebElementBy(By.xpath(StartDateNewModalXpath)).sendKeys(startDate);
	}
	
	/**
	 * Enters the end date in the Request PDO modal. DOES NOT CHECK FORMAT
	 * @param endDate Correct Format should be YYYY-MM-DD
	 */
	public void EnterEndDate(String endDate){
		getWebElementBy(By.xpath(EndDateNewModalXpath)).clear();	
		getWebElementBy(By.xpath(EndDateNewModalXpath)).sendKeys(endDate);
	}
	
	/**
	 * Enters the PDO type 
	 * @param vacationType Options are Sick, Vacation, Floating Holiday
	 */
	public void SelectVacationType(String vacationType){
		 new Select(getWebElementBy(By.xpath(VacationTypeScollXpath))).selectByValue(vacationType);
	}
	
	/**
	 * Clicks the 'Half day(style?)' button
	 */
	public void SelectHalfDay(){
		getWebElementBy(By.xpath(HalfDayCheckBoxXpath)).click();
	}
	
	/**
	 * Clicks the 'CC me on this email' button
	 */
	public void SelectCCMeOnEmail(){
		getWebElementBy(By.xpath(CCMeOnThisEmailXpath)).click();
	}
	
	/**
	 * Enters text into the memo field of the Request time off modal
	 * @param text 
	 */
	public void EnterMemoText(String text){
		getWebElementBy(By.xpath(MemoEditFormXpath)).sendKeys(text);
	}
	
	//TODO ask Lew if this should be 'Save Time Off' instead of 'Save Vacation'
	//
	/**
	 * Clicks the 'Save Vacation' Button to save and send off request
	 */
	public void ClickSaveVacation(){
		getWebElementBy(By.xpath(SaveVacationButtonXpath)).click();
	}
	
	/**
	 * Clicks the Close button for the 'Request PDO' Modal
	 */
	public void CloseTimeOffRequestModal(){
		getWebElementBy(By.xpath(CloseModalXpath)).click();
	}
	
	/**
	 * Clicks the 'Email manager' Button, 
	 */
	public void EmailManager(){
		//Written as a stub only. 
	}

	
	
	/* Time Off Details Modal*/
	/**
	 * Clicks the 'Details' button
	 */
	public void ClickDetails(){
		getWebElementBy(By.xpath(DetailsLinkXpath)).click();
	}
}


