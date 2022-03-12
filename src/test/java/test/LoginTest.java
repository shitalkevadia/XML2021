package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	WebDriver driver;

	@Test
	@Parameters({"UserName", "password"})
	public void validUserShoulBeAbleToLogin(String userName, String password) throws InterruptedException {
		
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.insertuserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignin();
		
		DashBoardPage dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardPage.varifyDashbardHeader();
		BrowserFactory.tearDown();
	}

}
