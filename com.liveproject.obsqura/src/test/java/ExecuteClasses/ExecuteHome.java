package ExecuteClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.BaseClass;
import elementResources.ClientClass;
import elementResources.HomePageClass;
import elementResources.LoginClass;

public class ExecuteHome extends BaseClass {

	LoginClass login;
	SoftAssert softassert;
	HomePageClass home;

	@Test
	public void executeVerifyVisibityOfWorkersWindow() {
		login = new LoginClass(driver);

		softassert = new SoftAssert();
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);

		home.clickWorkersButton();

		softassert.assertTrue(home.verifyVisibilityOfWorkersWindow());
		softassert.assertAll();
	}

	@Test
	public void executeVerifyVisibityOfDeductionWindow() {
		
		softassert = new SoftAssert();
		login = new LoginClass(driver);
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);

		home.clickDeductionButton();
		softassert.assertTrue(home.verifyVisibilityOfDeductionWindow());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyVisibilityOfTimeSheetWindow() {
		login = new LoginClass(driver);

		softassert = new SoftAssert();
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);
		home.clickTimeSheetButton();
		softassert.assertTrue(home.verifyVisibilityOfTimeSheetWindow());
		softassert.assertAll();

	}
	@Test
	public void executeVerifyVisibilityOfPaySlip()
	{
		login = new LoginClass(driver);

		softassert = new SoftAssert();
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);
		home.clickpaySlipButton();
		softassert.assertTrue(home.verifyVisibilityOfPaySlipWindow());
		softassert.assertAll();
	}
	@Test
	public void executeVerifyVisibilityOfInvoice()
	{
		login = new LoginClass(driver);

		softassert = new SoftAssert();
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);

		home.clickInvoiceButton();
		softassert.assertTrue(home.verifyVisibilityOfInvoiceWindow());
		softassert.assertAll();
	}
	
	@Test
	public void executeVerifyLogoDisplay()
	{
		login = new LoginClass(driver);

		softassert = new SoftAssert();
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);
		
		softassert.assertTrue(home.reportStatusOfLogo());
		softassert.assertAll();
	}
	
	@Test
	public void executeVerifyColorOfSettingsButton()
	{
		login = new LoginClass(driver);

		softassert = new SoftAssert();
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);
		
		softassert.assertEquals("rgba(12, 13, 17, 1)",home.getColorOfSettingsButton());
		softassert.assertAll();
		
	}
	
	@Test
	public void executeVerifySizeofSettingsButton()
	{
		login = new LoginClass(driver);

		softassert = new SoftAssert();
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);
	softassert.assertEquals("14px",home.getSizeOfSettingsButton());
	softassert.assertAll();
	
	}

	@Test
	public void executeVerifyLogOut()
	{
		String loginPageUrl="https://www.qabible.in/payrollapp/site/login";
		login = new LoginClass(driver);

		softassert = new SoftAssert();
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);
		
		home.profileButtonClick();
		home.logOutButtonClick();
		
		softassert.assertEquals(loginPageUrl,driver.getCurrentUrl());
		softassert.assertAll();
		
	}
	
	@Test
	public void executeVerifySettingsButtonDisplayed()
	{
		login = new LoginClass(driver);

		softassert = new SoftAssert();
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);
		
		softassert.assertTrue(home.reportStatusOfSettingsButton());
		softassert.assertAll();
	}
	
	@Test
	public void executeVerifyLogOutUsingMouse()
	{
		String loginPageUrl="https://www.qabible.in/payrollapp/site/login";
		login = new LoginClass(driver);

		softassert = new SoftAssert();
		home = new HomePageClass(driver);

		login.shortcutToLogin();
		login.wait(10);
		home.mouseClickOnProfileButton();
		home.mouseClickLogOut();
		
		softassert.assertEquals(loginPageUrl,driver.getCurrentUrl());
		softassert.assertAll();
	}
	
}
