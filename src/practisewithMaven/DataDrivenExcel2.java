package practisewithMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenExcel2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
FileInputStream fi=new FileInputStream("C:\\Users\\Subhojit\\Desktop\\Pandit.xlsx");
DataFormatter fm=new DataFormatter();

XSSFWorkbook workbook=new XSSFWorkbook(fi);
int sheets=workbook.getNumberOfSheets();
int rowcount=workbook.getSheetAt(0).getPhysicalNumberOfRows();

int cellcount=workbook.getSheetAt(0).getRow(0).getPhysicalNumberOfCells();

Object[][] obj=new Object[rowcount-1][cellcount-1];

for(int i=0;i<sheets;i++)
{
if(workbook.getSheetName(i).equals("Details"))
{
XSSFSheet sheet=workbook.getSheetAt(i);
for(int j=1;j<rowcount;j++)
{Row r=sheet.getRow(j);
for(int k=1;k<cellcount;k++)
{Cell c=r.getCell(k);
obj[j-1][k-1]=fm.formatCellValue(c);
	}
	}

}
}

int a=obj.length;
int b=obj[0].length;

for(int i=0;i<a;i++)
{for(int j=0;j<b;j++)
{System.out.println(obj[i][j]);
	}
	}

	}

}
