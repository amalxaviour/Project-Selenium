package baseClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilityClasses.ExcelDataHub;

public class DataProviders{
	String clientName1;
	String clientName2;
	String clientName3;
	String clientId1;
	String clientId2;
	String clientId3;
	
	ExcelDataHub e;
	
	public  DataProviders()
	{
		e=new ExcelDataHub();
		clientName1=e.getDataFromExcel(0, 5, 0);
		clientName2=e.getDataFromExcel(0, 6, 0);
		clientName3=e.getDataFromExcel(0, 7, 0);
		
		
		clientId1=e.getDataFromExcel(0, 5, 1);
		clientId2=e.getDataFromExcel(0, 6, 1);
		clientId3=e.getDataFromExcel(0, 7, 1);



	}
	
	@DataProvider(name="SearchClient")
	public Object[][] methodData2()
	{
		return new Object [][] {{clientName1,clientId1},{clientName2,clientId2},{clientName3,clientId3}};
	}
	
	
	
	@DataProvider(name="clientNames")
	public Object[][] methodData3()
	{
		return new Object [][] {{"1","Amal xaviour"},{"2","Kuttu"},{"3","~AmAl"},{"4","~amal_xaviour"},{"5","Selenium"},{"6","Dennis"},{"7","amal"},{"8","Bimal"}
		
		,{"9","Diya"},{"10","Clarke"},{"11","Sid"},{"12","Tom"},{"13","Jerry"},{"14","Amalx"},{"15","Python"},{"16","Amazon"},{"17","TestNg"},{"18","DennisBenny"},{"19","akshay"},{"20","AMAL"}
		
		};
	}
	
	
}
	
	
	
  

	
