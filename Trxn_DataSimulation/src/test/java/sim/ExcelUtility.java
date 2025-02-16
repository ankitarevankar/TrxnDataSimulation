package sim;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class ExcelUtility {
	
	String testData=Driver.path;
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream(testData);
		 Workbook wb = WorkbookFactory.create(fis);
		  String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		 wb.close();
		return data ;
		
	}
	public int  getRowCount(String sheetName) throws Throwable {
		FileInputStream fis= new FileInputStream(testData);
		 Workbook wb = WorkbookFactory.create(fis);
		    int rowCount = wb.getSheet(sheetName).getLastRowNum();
		    wb.close();
		    return rowCount;
		
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum,int celNum, String data) throws Throwable {
		FileInputStream fis= new FileInputStream(testData);
		  Workbook wb = WorkbookFactory.create(fis);
				  wb.getSheet(sheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
				  FileOutputStream fos = new FileOutputStream(testData);
				  wb.write(fos);
				  wb.close();
		
	}
	

}
