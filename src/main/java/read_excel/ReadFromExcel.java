package read_excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	public static void main(String[] args) {
	FileInputStream fis;
	XSSFWorkbook workbook;
	
		//Open the Excel workbook
	try { 
		fis = new FileInputStream("src\\main\\java\\testdata\\CustomersTable.xlsx");
		workbook = new XSSFWorkbook(fis);
		
			//Open the sheet in that workbook
			XSSFSheet sheet1 = workbook.getSheet("Sheet1");
			
			//Read rows
			Row row1 = sheet1.getRow(0);
			
			//Read columns/cells cells - object
			Cell cell1 = row1.getCell(0);
			
			//Get the value in it
			String cell1Value = cell1.getStringCellValue();
			System.out.println(cell1Value);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		

	}

}
