package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utils {
	
	public static void main(String[] args) {
		getRowCount();
	}
	
	
	public static void getRowCount() {
		String ExcelPath= "C:\\Users\\Abhishek\\OneDrive\\Desktop\\Auto_SalePoint\\RESTAssured_Auto\\Excel_Data\\TestData.xlsx";
		
		try {
			XSSFWorkbook workbook= new XSSFWorkbook(ExcelPath);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			int rowcount= sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows: "+rowcount);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

}
