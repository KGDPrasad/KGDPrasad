package Jan3;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Using_Interface 
{
	public static void main(String[] args) throws Throwable
	{

		FileInputStream fi=new FileInputStream("G://Dummy.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet ws=wb.getSheetAt(0);
		Row r=ws.getRow(0);
		int rc=ws.getLastRowNum();
		int cc=r.getLastCellNum();
		
		System.out.println("No of Rows : "+rc+"  No of Columns : "+cc);
	
		for(int i=1;i<=rc;i++)
		{
			String username=ws.getRow(i).getCell(0).getStringCellValue();
			if(wb.getSheet("Login").getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				int celldata=(int)wb.getSheet("Login").getRow(i).getCell(1).getNumericCellValue();
				String password=String.valueOf(celldata);
				System.out.println(username+"   "+password);
				ws.getRow(i).createCell(2).setCellValue("Pass");
			}
		}
		fi.close();
		FileOutputStream fo=new FileOutputStream("G://eveng.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}

}
