package blueModal;

//TODO add comments for javadocs
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Class that handles access to the Details Modal in the Time Off page
 * @author Lateef
 *
 */
public class TimeOffDetailsModal {
	
	private WebDriver driver; 
	private static WebElement element;
	private double vacationSurplusToDate;
	private double estimatedVacation; 
	
	private static final String VacationDaysAccruedToDateXpath =".//*[@id='modal_1']/div/div/div[2]/table/tbody/tr[4]/td[2]";
	private static final String VacationDaysEstimatedForFiscalYearXpath =".//*[@id='modal_1']/div/div/div[2]/table/tbody/tr[1]/td[2]";
	
	
	public TimeOffDetailsModal(WebDriver driver){
		this.driver = driver;
		setAccruedToDate();
		setEstimatedVaction();
	}
	
	public void setAccruedToDate(){
		vacationSurplusToDate = Double.parseDouble(driver.findElement(By.xpath(VacationDaysAccruedToDateXpath)).getText());
		
		}
	
	public void setEstimatedVaction(){
		estimatedVacation = Double.parseDouble(driver.findElement(By.xpath(VacationDaysAccruedToDateXpath)).getText());
		
		}
	
	public double getAccruedTodate(){
		return vacationSurplusToDate;
	}

	public double getEstimatedVaction(){
		return estimatedVacation;
	}
}
