package academy.testobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class dataDriventest {

	
	public ArrayList<String> gettestdata(String TestcaseName) throws IOException
	{
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C://Users//v.singaravelu//OneDrive - Perficient, Inc//Onboarding//Automation//Selenium//TesData//clientdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
			{
			XSSFSheet sheet = workbook.getSheetAt(i);
			Iterator<Row> rows= sheet.iterator();
			Row firstRow = rows.next();
			Iterator<Cell> cells = firstRow.cellIterator();
			int k=0;
			int coloumn=0;
			while(cells.hasNext())
			{
				Cell value = cells.next();
				if (value.getStringCellValue().equalsIgnoreCase("TestCase"));
				{
				 	coloumn=k;
				}
				k++;
			}System.out.println(coloumn);
			while(rows.hasNext())
			{
				Row rowvalue= rows.next();
				if(rowvalue.getCell(coloumn).getStringCellValue().equalsIgnoreCase(TestcaseName))
				{
					Iterator<Cell> cr = rowvalue.cellIterator();
					while(cr.hasNext())
					{
						Cell c	= cr.next();
						if(c.getCellType()== CellType.STRING)
						{
						a.add(c.getStringCellValue());
						}
						else
						{
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					}
				
			}
			}
		}
	
	}
		return a;
}		
	public static void main(String[] args) throws IOException {
		   
	}
}	

