package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {
	public FileInputStream f;
	@DataProvider(name="dp")
    public String[][] getData() throws IOException {
    	f=new FileInputStream(".//testData/giftCardDetails.xlsx");
    	XSSFWorkbook b=new XSSFWorkbook(f);
    	XSSFSheet sheet=b.getSheet("sheet1");
    	int rows=sheet.getLastRowNum();
    	int cells=sheet.getRow(0).getLastCellNum();
    	System.out.println(rows);
    	System.out.println(cells);
    	String[][] data=new String[rows+1][cells];
    	for(int i=0;i<=rows;i++) {
    		XSSFRow row=sheet.getRow(i);
    		for(int j=0;j<cells;j++) {
    			data[i][j]=row.getCell(j).toString();
    		}
    	}
    	return data;
    	
    }

}
