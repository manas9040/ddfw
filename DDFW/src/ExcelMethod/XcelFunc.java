package ExcelMethod;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelFunc 
{
	XSSFWorkbook wb;
	FileInputStream fis;
	FileOutputStream fout;
	String xcelpath;
	
public XcelFunc (String xcelpath) throws Exception{
	this.xcelpath = xcelpath;
	fis = new FileInputStream(xcelpath);
	wb = new XSSFWorkbook(fis);
}
public int getRowcount(String sheetname){
int row= wb.getSheet(sheetname).getLastRowNum();
row = row+1;
return row ;
}
 public String getcelldata (String sheetname,int rownum,int colname){
	 String data= wb.getSheet(sheetname).getRow(rownum).getCell(colname).getStringCellValue();
	 return data;
 }
 public void setcelldata (String sheetname, int rownum,int cellnum,String cellval) throws IOException{
	 wb.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(cellval);
	 fout =new FileOutputStream(xcelpath);
	 wb.write(fout);
	 
 }
}
	
	
	
	
	
	
	
	
	
	 
	
	
		
		
		
	