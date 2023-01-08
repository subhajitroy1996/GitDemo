package practisewithMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
//Identify the TestCases column by searching entire 1st row
//	once column is identified then scan entire TestCase column to find Purchase testcase row
//after identifying the testrow pull all the data from the row and feed into test.
	public ArrayList<String> getdata(String strtype) throws IOException
	{
		FileInputStream f=new FileInputStream("C://Users//Subhojit//Desktop//Sample.xlsx");//FileInputStream is a class which can read from any file,Opening a channel to read the data
		XSSFWorkbook workbook=new XSSFWorkbook(f);//XSSFWorkbook class accepts a FileInputStream object as an argument
		int size=workbook.getNumberOfSheets();
		ArrayList<String> str=new ArrayList<String>();
		
		for(int i=0;i<size;i++)
		{if(workbook.getSheetName(i).equalsIgnoreCase("sheet1"))
			{XSSFSheet sheet=	workbook.getSheetAt(i);
			int colno=0;
			int k=0;
			Iterator<Row> rows=sheet.iterator();
			
				
				Row firstrow=rows.next();
				Iterator<Cell> cells=firstrow.iterator();
				while(cells.hasNext())
				{   
					Cell c=cells.next();
					if(c.getStringCellValue().equalsIgnoreCase("testcases"))
					{
					k=colno;
//					System.out.println(colno);
					
					}
					colno++;
				}
//				System.out.println(colno);
				while(rows.hasNext())
				{
				Row r1=rows.next();
				if(r1.getCell(k).getStringCellValue().equalsIgnoreCase(strtype))//getStringCellValue works only for value of string in the excel shell.
				{
					Iterator<Cell> t=r1.iterator();
					while(t.hasNext())
					{	Cell c=t.next();
						if(c.getCellType()==CellType.STRING)
						{
						str.add(c.getStringCellValue());
					}
						else {
							str.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
				
				}
				}
			
			}
			
	
		}
		return str;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		
	}	
	
}

