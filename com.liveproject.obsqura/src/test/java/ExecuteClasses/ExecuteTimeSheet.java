package ExecuteClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.BaseClass;
import elementResources.LoginClass;
import elementResources.TimeSheetClass;
import utilityClasses.DelayCall;
import utilityClasses.MouseActions;

public class ExecuteTimeSheet extends BaseClass {

	TimeSheetClass timesheet;
	SoftAssert softassert;
	LoginClass login;
	MouseActions alerthandle;

	@Test
	public void executeVerifyGenerateInvoice() throws Exception {

		timesheet = new TimeSheetClass(driver);
		alerthandle = new MouseActions(driver);
		softassert = new SoftAssert();
		login = new LoginClass(driver);
		login.wait(10);
		login.shortcutToLogin();

		timesheet.timeSheetButtonClick();
		timesheet.generateInvoiceButtonClick();
		alerthandle.acceptAlertPopUp();
		DelayCall.delay(6);
		softassert.assertEquals("Invoice generated!!!", alerthandle.getAlertText());
		softassert.assertAll();
		alerthandle.acceptAlertPopUp();

	}
	
	@Test
	public void executeVerifyGeneratePaySlipFunction()throws Exception
	{
		timesheet = new TimeSheetClass(driver);
		alerthandle = new MouseActions(driver);
		softassert = new SoftAssert();
		login = new LoginClass(driver);
		login.wait(10);
		login.shortcutToLogin();

		timesheet.timeSheetButtonClick();
		
		timesheet.generatePaySlipButtonClick();
		alerthandle.acceptAlertPopUp();
		DelayCall.delay(6);
		softassert.assertEquals("Payslip generated!!!",alerthandle.getAlertText());
		softassert.assertAll();
		alerthandle.acceptAlertPopUp();

		
	}
	
	@Test
	public void executeVerifyGenerateInvoiceButtonColor()
	{
		timesheet = new TimeSheetClass(driver);
		
		softassert = new SoftAssert();
		login = new LoginClass(driver);
		login.wait(10);
		login.shortcutToLogin();

		timesheet.timeSheetButtonClick();
		
		softassert.assertEquals("rgba(240, 173, 78, 1)",timesheet.getGenerateInvoiceButtonColor());
		softassert.assertAll();
		
	}
}
