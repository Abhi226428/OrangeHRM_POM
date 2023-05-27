package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XLUtils 
{
       public static FileInputStream fi;
       public static FileOutputStream fo;
	   public static Workbook wb;
	   public static Sheet ws;
	   public static Row row; 
	   public static Cell cell;
	   public static CellStyle Style;
	   
	   
	  public static int getRowCount(String xlfile,String xlsheet) throws IOException
	  {
		  fi = new FileInputStream(xlfile);
		  wb = new XSSFWorkbook(fi);
		  ws = wb.getSheet(xlsheet);
		  int RowCount = ws.getLastRowNum();
		  wb.close();
		  fi.close();
		  return RowCount;		  	  
	 }
	
	public static short getColumnCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		
		fi = new FileInputStream(xlfile);
		  wb = new XSSFWorkbook(fi);
		  ws = wb.getSheet(xlsheet);
		  row = ws.getRow(rownum);
		  short ColumnCount = row.getLastCellNum();
		  wb.close();
		  fi.close();
		  return ColumnCount;	
	}
	
	public static String getStringCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		
		
		String Data;
		try 
		{
			cell = row.getCell(colnum);
			Data = cell.getStringCellValue();
		} catch (Exception e)
		{
			Data = " ";
		}
		return Data;		
	}
	
	public static double getNumericCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		
		
		double Data;
		try 
		{
			cell = row.getCell(colnum);
			Data = cell.getNumericCellValue();
		} catch (Exception e)
		{
			Data = 0.0;
		}
		return Data;		
	}
	
	public static boolean getbooleanCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		
		
		boolean Data;
		try 
		{
			cell = row.getCell(colnum);
			Data = cell.getBooleanCellValue();
		} catch (Exception e)
		{
			Data = false;
		}
		return Data;		
	}
	
	public static void setCelldata(String xlfile, String xlsheet, int rownum, int colnum, String Data) throws IOException
	{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(Data);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();		
	}
	
	
	public static void FillGreenColour(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		Style = wb.createCellStyle();
		Style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(Style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);		
	}	
	
	
	public static void FillRedColour(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		Style = wb.createCellStyle();
		Style.setFillForegroundColor(IndexedColors.RED.getIndex());
		Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(Style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);		
	}	
}
