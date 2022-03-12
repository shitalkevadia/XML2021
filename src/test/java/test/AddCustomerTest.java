package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	WebDriver driver;

	// Login Data
	
	String userName ;
	String password; 
	String fullName;
    String companyName; 
    String email ; 
    String phone;  
    String address; 
    String city ;
    String state; 
    String zip ;
    String country; 
    String enterName;
    
	//@Test
	@Parameters({"UserName", "Password", "FullName", "CompanyName", "Email",  "Phone", "Address", "City", "Country", "State", "Zip"})
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String fullName, String companyName, String email,  String phone, String address, String city, String state, String zip, String country) throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertuserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignin();
		
		DashBoardPage dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardPage.varifyDashbardHeader();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertCompany(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.insertCountry(country);
		addCustomerPage.clickSubmitButton();
		dashboardPage.clickListCustomerButton();
		
}
	@Test
	@Parameters({"UserName", "Password", "FullName", "CompanyName", "Email",  "Phone", "Address", "City", "Country", "State", "Zip"})
	public void validUserShouldBeAbleToAddCustomerFromListCustomer(String userName, String password, String fullName, String companyName, String email,  String phone, String address, String city, String state, String zip, String country, String enterName) throws InterruptedException {
		
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertuserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignin();
		
		DashBoardPage dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardPage.varifyDashbardHeader();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickListCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickAddCustomerOnListCustomer();
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertCompany(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.insertCountry(country);
		addCustomerPage.clickSubmitButton();
		dashboardPage.clickListCustomerButton();
		addCustomerPage.insertInToSearchBar(enterName);
		//addCustomerPage.verifyEnteredName();
		addCustomerPage.verifyEnteredNameAndDelete();
		addCustomerPage.veryfySearchBarAndProfile();
		addCustomerPage.veryfySearchBarAndProfile();
		
		
	}
	
	
}
	