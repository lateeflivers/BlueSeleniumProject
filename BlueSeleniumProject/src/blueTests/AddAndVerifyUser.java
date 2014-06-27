package blueTests;

//import static org.testng.AssertJUnit.assertTrue;
//import static org.testng.AssertJUnit.assertEquals;
import org.testng.Assert;


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

/**
 * Test to add new employee and verify that it was created
 * @author Lateef Livers
 * Created Jun 25, 2014
 */
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
		BlueIndex indexPage;
		
		loginPage.setURL(url);
		loginPage.open();
		indexPage = loginPage.validLogin(firstName, lastName, password);
		//Assert.assertTrue(indexPage.getWelcomeTitle().contains(firstName)==true,"Login unsucessful");


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
	 * Test creates a new user and verifies it was successfully created, Also write out the user name of the generated user to a text file called "RandomlyCreatedUsers.txt"
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
	//	assertEquals(indexPage.getFlashMessage(), "Employee added successfully.");
		Assert.assertTrue( indexPage.getFlashMessage().contains("Employee added successfully.")==true,"User not created");
		indexPage.searchBar(user.getEmployeeFirstAndLast());
		indexPage.setFirstName(user.getEmployeeFirstName());
		indexPage.setLastName(user.getEmployeeLastName());
		BlueEmployee EmployeePage =  indexPage.selectEmployee();
		Assert.assertEquals(EmployeePage.getEmpolyeeName(), user.getEmployeeFullName(), "User not found");
		EmployeePage.clickLogout();
		outputGeneratedUserToFile(user.getEmployeeFullName());

	}
	
	/**
	 * Outputs the name of the generated user to a file
	 * @param genUserName
	 */
	public void outputGeneratedUserToFile(String genUserName){
		try{

			 
			File file =new File("RandomlyCreatedUsers.txt");

			//if file doesnt exists, then create it
			if(!file.exists()){
				file.createNewFile();
			}

			//true = append file
			FileWriter fileWritter = new FileWriter(file.getName(),true);
		        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		        bufferWritter.write(genUserName+"; ");
		        bufferWritter.close();

	        System.out.println("Done");

			}catch(IOException e){
				e.printStackTrace();
			
			}
	}
}
