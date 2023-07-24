package test.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelReader;

public class ReadFromExcel {
	
		
		@Test(dataProvider = "dataProv1")
		public void test1(String customerID, String accountNumber, String customerFirstName, String customerLastName, String customerHomeAddress, String accountType) {
			System.out.println(customerID + " : " + accountNumber + " : " + customerLastName + " : " + accountType);
		}
		
		@DataProvider
		public Object[][] dataProv1() {
			ExcelReader excelReader = new ExcelReader("src\\main\\java\\testdata\\CustomersTable.xlsx", "Sheet1");
			return excelReader.getTableData("Table1");
		}
		
		
	}


