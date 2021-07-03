package ExecuteClasses;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.BaseClass;
import elementResources.InvoiceClass;
import elementResources.LoginClass;
import utilityClasses.DelayCall;

public class ExecuteInvoice extends BaseClass {
	
	LoginClass login;
	SoftAssert softassert;
	InvoiceClass invoice;

	
	
  @Test
  public void executeVerifyNewWindowTab()throws Exception {
	  login = new LoginClass(driver);
	  softassert = new SoftAssert();
	  invoice=new InvoiceClass(driver);
		login.wait(20);
	

		login.shortcutToLogin();
		
		invoice.clickInvoiceButton();
		
		invoice.clickNewTabButtonOfFirstRow();
		DelayCall.delay(3);
		
		String parentWindow=driver.getWindowHandle();
		
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> iterator=allWindows.iterator();
		
		while(iterator.hasNext())
		{
			String childWindow=iterator.next();
			if(!parentWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				DelayCall.delay(4);
			
				softassert.assertEquals("https://www.qabible.in/payrollapp/invoice/generate?id=1218",driver.getCurrentUrl());
				softassert.assertAll();
				driver.close();
			}
		}
		
		driver.switchTo().window(parentWindow);
		
		
		
		
		
		
  }
  
  @Test
  public void executeVerifyHeadingClientNumberOfInvoiceTable()
  {
	  login = new LoginClass(driver);
	  softassert = new SoftAssert();
	  invoice=new InvoiceClass(driver);
		login.wait(20);
	

		login.shortcutToLogin();
		
		invoice.clickInvoiceButton();
		
		softassert.assertEquals("Client Number",invoice.getTextOfClientNumberText());
		softassert.assertAll();
	  
  }
  
  
  @Test
  public void executeVerifyHeadDate()
  {
	  login = new LoginClass(driver);
	  softassert = new SoftAssert();
	  invoice=new InvoiceClass(driver);
		login.wait(20);
	

		login.shortcutToLogin();
		
		invoice.clickInvoiceButton();
		
		softassert.assertEquals("Date",invoice.getTextOfDateText());
		softassert.assertAll();
		
  }
  
  @Test
  public void executeVerifyHeadAmount()
  {
	  login = new LoginClass(driver);
	  softassert = new SoftAssert();
	  invoice=new InvoiceClass(driver);
		login.wait(20);
	

		login.shortcutToLogin();
		
		invoice.clickInvoiceButton();
		
		softassert.assertEquals("Amount",invoice.getTextOfAmountText());
		softassert.assertAll();
		
	  
  }
  
  
  @Test
  public void executeVerifyVisibilityOfNextPage()
  {
	  login = new LoginClass(driver);
	  softassert = new SoftAssert();
	  invoice=new InvoiceClass(driver);
		login.wait(20);
	

		login.shortcutToLogin();
		
		invoice.clickInvoiceButton();
		
		softassert.assertTrue(invoice.verifyVisibilityOfNextPageButtonClick());
		softassert.assertAll();
	  
  }
}
