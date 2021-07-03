package elementResources;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.GeneralUtilities;
import utilityClasses.MouseActions;

public class WorkersClass {

	WebDriver driver;
	GeneralUtilities generalUtil = new GeneralUtilities();

	@FindBy(xpath = "//a[text()='Workers']")
	WebElement workersButton;

	@FindBy(xpath = "//a[text()='Create Worker']")
	WebElement createWorkerButton;

	@FindBy(xpath = "//select[@id='worker-title']")
	WebElement titleDropDownElement;

	@FindBy(xpath = "//input[@id='worker-first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='worker-last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='worker-phone']")
	WebElement phoneNumber;

	@FindBy(xpath = "//input[@id='worker-email']")
	WebElement emailId;

	@FindBy(xpath = "//select[@id='worker-gender']")
	WebElement genderDropDown;

	@FindBy(xpath = "//input[@id='worker-dob']")
	WebElement dateOfBirth;

	@FindBy(xpath = "//input[@id='worker-address1']")
	WebElement workersAddress1;

	@FindBy(xpath = "//input[@id='worker-postcode']")
	WebElement postCode;

	@FindBy(xpath = "//select[@id='worker-branch_id']")
	WebElement branchDropDown;

	@FindBy(xpath = "//select[@id='worker-division_id']")
	WebElement divisionDropDown;

	@FindBy(xpath = "//select[@id='worker-employment_type']")
	WebElement employmentTypeDropDown;

	@FindBy(xpath = "//select[@id='worker-payslip_method']")
	WebElement paySlipMethodDropDown;

	@FindBy(xpath = "//select[@id='worker-engage_status']")
	WebElement engageStatusDropDown;

	@FindBy(xpath = "//input[@id='worker-ni_number']")
	WebElement niNumber;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement nextButton;

//next page opens in same window.

	@FindBy(xpath = "//select[@id='worker-payment_method']")
	WebElement paymentMethodDropDown;

	@FindBy(xpath = "//select[@id='worker-ac_type']")
	WebElement accountTypeDropDown;

	@FindBy(xpath = "//input[@id='worker-ac_name']")
	WebElement accountName;

	@FindBy(xpath = "//input[@id='worker-ac_no']")
	WebElement accountNumber;

	@FindBy(xpath = "//input[@id='worker-sort_code']")
	WebElement sortCode;

	@FindBy(xpath = "//input[@id='worker-start_date']")
	WebElement startDate;

	@FindBy(xpath = "//input[@id='worker-roll_no']")
	WebElement rollNumber;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//a[text()='Bank Details']")
	WebElement bankDetailsButton;

	@FindBy(xpath = "//a[text()='2']")
	WebElement bottom2Button;

	@FindBy(xpath = "//ul[@class='pagination']//li[3]")
	WebElement bottom2Visibility;

	@FindBy(xpath = "//div[text()='Email cannot be blank.']")
	WebElement emailErrorMessage;
	@FindBy(xpath = "//div[text()='First Name cannot be blank.']")
	WebElement nameErrorMessage;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr[1]//td[2]")
	WebElement workerNametext;

	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	WebElement savedText;

	String expectedLocator;
	WebElement updateLoc;
	MouseActions action;
	String currentMonthText;

	public void clickWorkersButton() {
		workersButton.click();
	}

	public void clickCreateWorkerButton() {
		createWorkerButton.click();
	}

	public WorkersClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// first page methods >>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	public void selectTitleDropDownByName(String val) {
		generalUtil.selectDropByVisibleText(titleDropDownElement, val);
	}

	public void inputFirstName(String name) {
		firstName.sendKeys(name);

	}

	public void inputLastName(String name) {
		lastName.sendKeys(name);
	}

	public void inputPhone(String x) {
		phoneNumber.sendKeys(x);
	}

	public void inputEmailId(String em) {
		emailId.sendKeys(em);
	}

	public void selectGenderDropDownByName(String val) {
		generalUtil.selectDropByVisibleText(genderDropDown, val);

	}

	public void inputDateOfBirth(String x) {
		dateOfBirth.sendKeys(x);

	}

	public void inputAddressLine1(String x) {
		workersAddress1.sendKeys(x);
	}

	public void inputPostCode(String x) {
		postCode.sendKeys(x);
	}

	public void selectBranchDropDownByName(String val) {
		generalUtil.selectDropByVisibleText(branchDropDown, val);
	}

	public void selectDivisionDropDownByName(String val) {
		generalUtil.selectDropByVisibleText(divisionDropDown, val);
	}

	public void selectEmploymentTypeDropDownByName(String val) {
		generalUtil.selectDropByVisibleText(employmentTypeDropDown, val);
	}

	public void selectPaySlipMethodDropDownByName(String val) {
		generalUtil.selectDropByVisibleText(paySlipMethodDropDown, val);
	}

	public void selectEngageStatusDropDown(String val) {
		generalUtil.selectDropByVisibleText(engageStatusDropDown, val);
	}

	public void inputNiNumber(String x) {
		niNumber.sendKeys(x);
	}

	public void clickNextButton() {
		generalUtil.applyExplicitWaitElementTobeClickable(driver, nextButton, 20);
		generalUtil.scrollDown(driver, "0", "10000");

		nextButton.click();
	}

	// >>>>>>>>>>>>>>>>First page Filling form Ends Here >>>>>>>>>>>>>>>>>>>>>>>>

	public void clickBankDetailsButton() {
		bankDetailsButton.click();
	}

	public void selectPaymentMethodDropDownByName(String val) {
		generalUtil.selectDropByVisibleText(paymentMethodDropDown, val);
	}

	public void selectAccountTypeDropByName(String val) {
		generalUtil.selectDropByVisibleText(accountTypeDropDown, val);
	}

	public void inputAccountName(String x) {
		accountName.sendKeys(x);
	}

	public void inputAccountNumber(String x) {
		accountNumber.sendKeys(x);
	}

	public void inputSortCode(String x) {
		sortCode.sendKeys(x);
	}

	public void selectStartDateDropDownByName(String val) {
		generalUtil.selectDropByVisibleText(startDate, val);
	}

	public void inputRollNumber(String x) {
		rollNumber.sendKeys(x);
	}

	public void mouseClickSaveButton() {
		action = new MouseActions(driver);
		generalUtil.scrollDown(driver, "0", "20000");
		action.mouseClick(saveButton);
	}

	public void clickSaveButton() {
		generalUtil.applyExplicitWaitElementTobeClickable(driver, saveButton, 20);
		generalUtil.scrollDown(driver, "0", "20000");
		saveButton.click();
	}

	public void scrollDownPage() {
		generalUtil.scrollDown(driver, "0", "10000");
	}

	public Boolean verifyVisibilityOfNextPageButton() {
		bottom2Button.click();
		return generalUtil.getAttributeValue(bottom2Visibility, "class", "active");
	}

	public String verifyErrorTextOfEmail() {
		return generalUtil.getElementText(emailErrorMessage);
	}

	public String verifyErrorTextOfName() {
		return generalUtil.getElementText(nameErrorMessage);
	}

	public String verifyWorkersListName() {

		return generalUtil.getElementText(workerNametext);
	}

	public String getNameOfSavedProfile() {
		return generalUtil.getElementText(savedText);
	}

	public void verifyUpdateFunctionalityOfWorkersGRid(String editIcon) {

		generalUtil = new GeneralUtilities(driver);
		String path = "//table[@class='table table-striped table-bordered']//tbody//tr//td[1]";
		List<String> textValuesOfRow = new ArrayList<String>();

		textValuesOfRow = generalUtil.dynamicLocatorOfTableGrid(path);

		for (int j = 0; j < textValuesOfRow.size(); j++) {
			if (textValuesOfRow.get(j).contentEquals(editIcon)) {
				j++;
				expectedLocator = "//table[@class='table table-striped table-bordered']//tr[" + j
						+ "]//td[8]//span[@class='glyphicon glyphicon-pencil']";

				break;
			}
		}

		updateLoc = driver.findElement(By.xpath(expectedLocator));

	}

	public boolean reportStatus() {
		generalUtil = new GeneralUtilities(driver);

		return generalUtil.isElementEnabled(firstName);
	}

	public void clickUpdateButton() {
		updateLoc.click();
	}

	public void datePicker(String expectedMonth) {
		
		int j=0;
		dateOfBirth.click();
		WebElement nextButton=driver.findElement(By.xpath("(//table[@class='table-condensed']//tr[2]//th[3])[1]"));
		WebElement prevButton=driver.findElement(By.xpath("(//table[@class='table-condensed']//tr[2]//th[1])[1]"));
		
		
		
		List<String> months=new ArrayList<String>();
		months.add("January 2021");
		months.add("February 2021");
		months.add("March 2021");
		months.add("April 2021");
		months.add("May 2021");
		months.add("June 2021");
		months.add("July 2021");
		months.add("August 2021");
		months.add("September 2021");
		months.add("October 2021");
		months.add("November 2021");
		months.add("December 2021");
		
		for(int i=0;i<months.size();i++)
		{
			System.out.println(months.get(i));
			if(expectedMonth.equalsIgnoreCase(months.get(i)))
			{
				j=i+1;
				
				break;
				
			}
		}

		

		
		
		
		while(true)
		{
			WebElement currentMonthElement=driver.findElement(By.xpath("(//table[@class='table-condensed']//tr[2]//th[2])[1]"));
			currentMonthText=generalUtil.getElementText(currentMonthElement);
			if(currentMonthText.equalsIgnoreCase(expectedMonth))
			{
				break;
			}
			 if(j>=6)
			{
				nextButton.click();
			}
			 if(j<=6)
			{
				prevButton.click();
			}
			
			
		}
		WebElement actualDate=driver.findElement(By.xpath("//table[@class='table-condensed']//tr[5]//td[1]"));
		actualDate.click();
		

	}
	
	public String returnCurrentMonthText()
	{
		return currentMonthText;
	}
	

}
