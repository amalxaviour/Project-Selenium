package ExecuteClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.BaseClass;
import elementResources.LoginClass;
import utilityClasses.ExcelDataHub;

public class ExecuteLogin extends BaseClass {

	LoginClass login;
	ExcelDataHub excel;

	SoftAssert softassert;

	@Test
	public void executeLoginFunction() {
		login = new LoginClass(driver);
		softassert = new SoftAssert();
		login.wait(10);

		excel=new ExcelDataHub();
		String userName=excel.getDataFromExcel(0, 1, 0);
		String password=excel.getDataFromExcel(0, 1, 1);
		
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickLoginButton();

		String expected = "CAROL THOMAS";
		softassert.assertEquals(expected, login.profileText());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyErrorMessage() {
		login = new LoginClass(driver);
		softassert = new SoftAssert();

		String expectedMessage = "Incorrect username or password.";
		login.enterUserName("amal");
		login.enterPassword("1234");
		login.clickLoginButton();
		login.wait(10);

		softassert.assertEquals(expectedMessage, login.getErrorMessageText());

		System.out.println(login.getErrorMessageText());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyCheckBoxFunction() {
		login = new LoginClass(driver);

		softassert = new SoftAssert();

		login.clickRememberMeCheckBox();
		login.clickRememberMeCheckBox();

		softassert.assertEquals(true, login.rememberMeBoxStatus());
		softassert.assertAll();

	}

	
	@Test
	public void executeVerifyResetLink()
	{		softassert = new SoftAssert();

		login=new LoginClass(driver);
		login.wait(10);
		
		softassert.assertTrue(login.verifyResetLink());
		softassert.assertAll();
	}
	
	
	
}
