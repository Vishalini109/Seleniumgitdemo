package academy.testobjects;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataDrivenTestNG {

	DataFormatter formatter = new DataFormatter();
	
	
	@DataProvider(name="driveTest")
	@Test
	public Object[][] getData() throws IOException
	{
		//Object[][] data	= {{"seleniumprac5@gmail.com","Seleniumprac@26"}};
		//return data;
		FileInputStream fis = new FileInputStream("C://Users//v.singaravelu//OneDrive - Perficient, Inc//Onboarding//Automation//Selenium//TesData//clientdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount=row.getLastCellNum();
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i=0;i<rowCount-1;i++)
		{
			    row = sheet.getRow(i+1);
				for(int j=0;j<colCount;j++)
				{
					XSSFCell cell = row.getCell(j);
					data[i][j]=formatter.formatCellValue(cell);
					System.out.println(data[i][j]);
				}	
		}
		return data;
	}
}
