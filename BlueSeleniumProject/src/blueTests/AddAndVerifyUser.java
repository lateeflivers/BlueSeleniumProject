package blueTests;

import static org.testng.AssertJUnit.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import blueHelpers.BlueUser;
import blueSource.BlueEmployee;
import blueSource.BlueIndex;
import blueSource.BlueLogin;

public class AddAndVerifyUser extends BaseTest {

	public static BlueUser user;
	

	/**
	 * Logs into site 
	 * @param url
	 * @param firstName active user's first name
	 * @param lastName active user's last name
	 * @param password active user's password
	 */
	public void LoginIntoSite(String url, String firstName, String lastName, String password ){
		BlueLogin loginPage = new BlueLogin(driver);
		
		loginPage.setURL(url);
		loginPage.open();
		loginPage.validLogin(firstName, lastName, password);


	}
	
	/**
	 * Adds a user to BlueSource
	 * 
	 * @param employeeManager Manager that the created user reports to
	 */
	public void AddUser(String employeeManager){
		BlueIndex indexPage = new BlueIndex(driver);
		user = new BlueUser(employeeManager);
		indexPage.addNewEmployee(user);
		
	}
	
	
	/**
	 * Test creates a new user and verifies it was successfully created
	 * @param url
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param manager
	 */
	@Test(description="Add and Verify new user")
	@Parameters({"url","firstName","lastName","password","manager"})
	public void VerifyAddedUser(String url, String firstName, String lastName, String password, String manager){
		//Login
		LoginIntoSite(url, firstName, lastName, password);
		
		
		AddUser(manager);

		System.out.println("Created user"+ user.getEmployeeFullName());
		BlueIndex indexPage = new BlueIndex(driver);
		indexPage.searchBar(user.getEmployeeFirstAndLast());
		indexPage.setFirstName(user.getEmployeeFirstName());
		indexPage.setLastName(user.getEmployeeLastName());
		BlueEmployee EmployeePage =  indexPage.selectEmployee();
		assertEquals(EmployeePage.getEmpolyeeName(), user.getEmployeeFullName());
		EmployeePage.clickLogout();
		

	try{

		 
		File file =new File("RandomlyCreatedUsers.txt");

		//if file doesnt exists, then create it
		if(!file.exists()){
			file.createNewFile();
		}

		//true = append file
		FileWriter fileWritter = new FileWriter(file.getName(),true);
	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	        bufferWritter.write(user.getEmployeeFullName()+"; ");
	        bufferWritter.close();

        System.out.println("Done");

		}catch(IOException e){
			e.printStackTrace();
		
		}
	}
	
	
}
