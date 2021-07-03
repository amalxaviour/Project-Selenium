package ExecuteClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.BaseClass;
import elementResources.ClientClass;
import elementResources.LoginClass;
import elementResources.WorkersClass;
import utilityClasses.DelayCall;
import utilityClasses.ExcelDataHub;

public class ExecuteWorkers extends BaseClass {

	LoginClass login;
	WorkersClass work;
	ExcelDataHub excel;

	SoftAssert softassert;

	@Test
	public void createNewWorker() throws Exception {
		login = new LoginClass(driver);
		excel = new ExcelDataHub();
		work = new WorkersClass(driver);
		softassert = new SoftAssert();
		login.wait(20);

		login.shortcutToLogin();

		work.clickWorkersButton();

		work.clickCreateWorkerButton();

		// >>>>>>>>>>>>>>>Filling First Page<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<,

		work.selectTitleDropDownByName(excel.getDataFromExcel(1, 5, 1));
		work.scrollDownPage();

		work.inputFirstName(excel.getDataFromExcel(1, 6, 1));
		work.inputLastName(excel.getDataFromExcel(1, 7, 1));

		work.inputPhone(excel.getDataFromExcel(1, 8, 1));

		work.inputEmailId(excel.getDataFromExcel(1, 9, 1));

		work.selectGenderDropDownByName(excel.getDataFromExcel(1, 10, 1));

		work.inputDateOfBirth("22-06-2021");

		work.inputAddressLine1(excel.getDataFromExcel(1, 12, 1));

		work.inputPostCode(excel.getDataFromExcel(1, 13, 1));

		DelayCall.delay(3);
		work.selectBranchDropDownByName(excel.getDataFromExcel(1, 14, 1));

		work.selectDivisionDropDownByName(excel.getDataFromExcel(1, 15, 1));

		work.selectEmploymentTypeDropDownByName(excel.getDataFromExcel(1, 16, 1));
		DelayCall.delay(2);
		work.selectPaySlipMethodDropDownByName(excel.getDataFromExcel(1, 17, 1));

		work.selectEngageStatusDropDown(excel.getDataFromExcel(1, 18, 1));

		work.inputNiNumber(excel.getDataFromExcel(1, 19, 1));

		work.clickNextButton();

		// <<<<<<<<<<<<<<<<<<End Of First Fill page>>>>>>>>>>>>>>>>>>>>>>>>>

		work.selectPaymentMethodDropDownByName(excel.getDataFromExcel(1, 5, 3));
		work.selectAccountTypeDropByName(excel.getDataFromExcel(1, 6, 3));
		work.inputAccountName(excel.getDataFromExcel(1, 7, 3));
		work.inputAccountNumber(excel.getDataFromExcel(1, 8, 3));

		work.inputSortCode(excel.getDataFromExcel(1, 9, 3));

		work.selectStartDateDropDownByName("22-08-2020");
		work.inputRollNumber(excel.getDataFromExcel(1, 11, 3));
		DelayCall.delay(5);
		 work.clickSaveButton();
		//work.mouseClickSaveButton();
		 
		 softassert.assertEquals(excel.getDataFromExcel(1, 6, 1),work.getNameOfSavedProfile());
		 softassert.assertAll();

	}

	@Test
	public void executeVerifyCheckVisibilityOfBottomNext2Button() {
		login = new LoginClass(driver);
		excel = new ExcelDataHub();
		work = new WorkersClass(driver);
		softassert = new SoftAssert();
		login.wait(20);

		login.shortcutToLogin();

		work.clickWorkersButton();

		work.scrollDownPage();

		softassert.assertTrue(work.verifyVisibilityOfNextPageButton());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyErrorMessageOfMandatoryFieldEmail() {
		login = new LoginClass(driver);
		excel = new ExcelDataHub();
		work = new WorkersClass(driver);
		softassert = new SoftAssert();
		login.wait(20);

		login.shortcutToLogin();

		work.clickWorkersButton();

		work.clickCreateWorkerButton();

		work.selectTitleDropDownByName(excel.getDataFromExcel(1, 5, 1));
		work.scrollDownPage();

		work.inputFirstName(excel.getDataFromExcel(1, 6, 1));
		work.clickNextButton();

		softassert.assertEquals("Email cannot be blank.", work.verifyErrorTextOfEmail());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyErrorMessageOfMandatoryFieldName() {
		login = new LoginClass(driver);
		excel = new ExcelDataHub();
		work = new WorkersClass(driver);
		softassert = new SoftAssert();
		login.wait(20);

		login.shortcutToLogin();

		work.clickWorkersButton();

		work.clickCreateWorkerButton();

		work.selectTitleDropDownByName(excel.getDataFromExcel(1, 5, 1));
		work.scrollDownPage();
		work.clickNextButton();
		softassert.assertEquals("First Name cannot be blank.", work.verifyErrorTextOfName());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyWorkerName() {
		login = new LoginClass(driver);
		work = new WorkersClass(driver);
		softassert = new SoftAssert();
		login.wait(20);

		login.shortcutToLogin();

		work.clickWorkersButton();
		softassert.assertEquals("Jiya Janvi1 Appu", work.verifyWorkersListName());
		softassert.assertAll();
	}

	@Test
	public void executeVerifyUpdateOfMemberSecond() throws Exception {
		login = new LoginClass(driver);
		work = new WorkersClass(driver);
		softassert = new SoftAssert();
		login.wait(20);

		login.shortcutToLogin();

		work.clickWorkersButton();

		work.verifyUpdateFunctionalityOfWorkersGRid("2");
		work.clickUpdateButton();

		softassert.assertTrue(work.reportStatus());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyUpdateOfMemberFifth() {
		login = new LoginClass(driver);
		work = new WorkersClass(driver);
		softassert = new SoftAssert();
		login.wait(20);

		login.shortcutToLogin();

		work.clickWorkersButton();

		work.verifyUpdateFunctionalityOfWorkersGRid("5");
		work.clickUpdateButton();

		softassert.assertTrue(work.reportStatus());
		softassert.assertAll();
	}

	
	@Test
	public void executeDatePicker()throws Exception
	{
		login = new LoginClass(driver);
		work = new WorkersClass(driver);
		softassert = new SoftAssert();
		

		login.shortcutToLogin();
		
		String month="August 2021";

		work.clickWorkersButton();
		work.clickCreateWorkerButton();
		work.datePicker(month);
		
		DelayCall.delay(5);
		
		softassert.assertEquals(month,work.returnCurrentMonthText());
		softassert.assertAll();
		
		
		
		
		
	}
}
