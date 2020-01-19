package Jan2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteIntoExcel {

	public static void main(String[] args) throws Throwable{

		FileInputStream fi=new FileInputStream("G:\\Dummy.xlsx");

		XSSFWorkbook wb=new XSSFWorkbook(fi); 	// get workbook
		XSSFSheet ws=wb.getSheet("Login"); 		// get sheet from workbook
		XSSFRow r=ws.getRow(0);					// get 1st row from sheet

		int rc=ws.getLastRowNum();
		int cc=r.getLastCellNum();
		System.out.println("No of Rows : "+rc+" -- No of Columns : "+cc);

		for(int i=1; i<=rc; i++)
		{
			String userName=ws.getRow(i).getCell(0).getStringCellValue();
			
			//String Password=ws.getRow(i).getCell(1).getStringCellValue();
			// this statement is wrong.
			//cell value is integer so we need to find out and convert into string
			

			// suppose cell data contains only integer, unable to get cell data. 
			// so we need to find out that cell and convert into string.
			if(wb.getSheetAt(0).getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				// getting integer cell data if any
				int cellData=(int)wb.getSheetAt(0).getRow(i).getCell(1).getNumericCellValue();
				// converting integer type into string type
				String Result=String.valueOf(cellData);

				System.out.println("User Name : "+userName+"            Password : "+Result);
				ws.getRow(i).createCell(2).setCellValue("Hello...");
			}
		}
		fi.close();

		//creating new workbook
		FileOutputStream fo=new FileOutputStream("G:\\Dummysss.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}
}
