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

public class DataDrivenExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fi=new FileInputStream("C:\\Users\\Subhojit\\Desktop\\Pandit.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		int size=wb.getNumberOfSheets();
		int rowcount=wb.getSheetAt(0).getPhysicalNumberOfRows();
		int cellcount=wb.getSheetAt(0).getRow(0).getLastCellNum();//or wb.getSheetAt(0).getRow(0).getPhysicalNumberOfCells()
		System.out.println(rowcount);
		System.out.println(cellcount);
		ArrayList<String> ar=new ArrayList<String>();
		for(int i=0;i<size;i++)
		{
			if(wb.getSheetName(i).equals("Details"))
			{
				XSSFSheet sheet=wb.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(0).getStringCellValue().equalsIgnoreCase("Login"))
					{
						Iterator<Cell> cells=r.iterator();
						cells.next();
						while(cells.hasNext())
						{
							Cell c=cells.next();
							if(c.getCellType()==CellType.STRING)
							{
								ar.add(c.getStringCellValue());
							}
							else
							{
								ar.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		
		ar.stream().forEach(a->System.out.print(a+" "));
	}

}
