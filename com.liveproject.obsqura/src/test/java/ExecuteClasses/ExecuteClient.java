package ExecuteClasses;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.BaseClass;
import baseClasses.DataProviders;
import elementResources.ClientClass;
import elementResources.LoginClass;
import utilityClasses.DelayCall;
import utilityClasses.ExcelDataHub;
import utilityClasses.GeneralUtilities;
import utilityClasses.MouseActions;

public class ExecuteClient extends BaseClass {

	LoginClass login;
	ClientClass client;
	DataProviders ob;
	ExcelDataHub excel;

	SoftAssert softassert;
	GeneralUtilities generalUtil;

	@Test
	public void executeVerifyClientTitle() {
		login = new LoginClass(driver);
		client = new ClientClass(driver);
		softassert = new SoftAssert();
		

		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginButton();
		client.clickClientButton();

		String expected = "Clients";
		System.out.println(client.getTitleOfClientPageTab());
		softassert.assertEquals(expected, client.getTitleOfClientPageTab());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyClientsNameSearchBarText() {
		login = new LoginClass(driver);
		client = new ClientClass(driver);
		softassert = new SoftAssert();
		login.wait(10);

		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginButton();
		client.clickClientButton();

		softassert.assertEquals("Client Name", client.getclientNameText());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyClientsIdsearchBarText() {
		login = new LoginClass(driver);
		client = new ClientClass(driver);
		softassert = new SoftAssert();
		login.wait(10);

		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginButton();
		client.clickClientButton();

		softassert.assertEquals("Client ID", client.getclientIdText());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyClientsWindowVisibility() {
		login = new LoginClass(driver);
		client = new ClientClass(driver);
		softassert = new SoftAssert();
		login.wait(10);
		login.shortcutToLogin();
		client.clickClientButton();
		softassert.assertTrue(client.verifyClientsWindowVisibility());
		softassert.assertAll();

	}

	@Test
	public void executeVerifyclientsSearchName() {
		login = new LoginClass(driver);
		client = new ClientClass(driver);
		softassert = new SoftAssert();
		login.wait(10);
		login.shortcutToLogin();
		client.clickClientButton();
		// System.out.println(client.searchClientName("Claydon ","10"));

		softassert.assertEquals("Claydon", client.searchClientName("Claydon", "10"));
		softassert.assertAll();

	}

	@Test(dataProvider = "SearchClient", dataProviderClass = DataProviders.class)
	public void executeVerifySearchingFunctionality(String name, String id) throws Exception {
		login = new LoginClass(driver);
		client = new ClientClass(driver);
		ob = new DataProviders();

		softassert = new SoftAssert();
		login.wait(10);
		login.shortcutToLogin();
		client.clickClientButton();

		softassert.assertEquals(name, client.searchClientName(name, id));
		softassert.assertAll();

	}

	@Test
	public void executeVerifyNamesOfGrid() {
		List<String> expected = new ArrayList<String>();

		login = new LoginClass(driver);
		client = new ClientClass(driver);
		excel = new ExcelDataHub();

		for (int i = 0; i < 20; i++) {
			expected.add(excel.getDataFromExcel(2, i, 0));
		}

		softassert = new SoftAssert();
		login.wait(10);
		login.shortcutToLogin();
		client.clickClientButton();

		List<String> textValuesOfRow = new ArrayList<String>();

		textValuesOfRow = client.getNameOfGrid();

		for (int i = 0; i < textValuesOfRow.size(); i++) {

			softassert.assertEquals(expected.get(i), textValuesOfRow.get(i));
			softassert.assertAll();
		}

	}

	@Test
	public void executeEditDetailsOfGrid() {
		String expectedUrl = "https://www.qabible.in/payrollapp/client/update?id=2";
		login = new LoginClass(driver);
		client = new ClientClass(driver);

		softassert = new SoftAssert();
		login.wait(10);
		login.shortcutToLogin();
		client.clickClientButton();

		client.verifyUpdateOfgrid("2");
		client.updateIconClick();

		softassert.assertEquals(expectedUrl, driver.getCurrentUrl());
		softassert.assertAll();

	}

	@Test(dataProvider = "clientNames", dataProviderClass = DataProviders.class)
	public void executeEditNameFunc(String id, String name) throws Exception {
		login = new LoginClass(driver);
		client = new ClientClass(driver);
		generalUtil = new GeneralUtilities(driver);
		softassert = new SoftAssert();
		login.wait(10);
		login.shortcutToLogin();
		client.clickClientButton();

		client.verifyUpdateName(id);

		int x = Integer.parseInt(id);

		if (x >= 4) {
			generalUtil.scrollDown(driver, "0", "600");
		}
		
		if(x>=9)
		{
			generalUtil.scrollDown(driver, "0", "700");

		}

		client.updateIconClick();
		client.updateNameIn(name);
		client.clickSaveButton();

		DelayCall.delay(5);

		client.clickClientButton();
		DelayCall.delay(5);

		softassert.assertEquals(name, client.getName(id));
		softassert.assertAll();

	}

}
