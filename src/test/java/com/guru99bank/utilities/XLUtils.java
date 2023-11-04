	package com.guru99bank.utilities;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//7. create xl class to read data from excel files
public class XLUtils {

		public static FileInputStream file_input;
		public static FileOutputStream file_output;
		public static XSSFWorkbook work_book;
		public static XSSFSheet sheet;
		public static XSSFRow row;
		public static XSSFCell cell;
		
		public static int getRowCount(String xlfile,String Xlsheet)throws IOException {
			file_input = new FileInputStream(xlfile);
			work_book = new XSSFWorkbook(file_input);
			sheet = work_book.getSheet(Xlsheet);
			int rowcount = sheet.getLastRowNum();
			work_book.close();
			file_input.close();
			return rowcount;
		}
		
		public static int getCellCount(String xlfile,String Xlsheet,int rownum)throws IOException {
			file_input = new FileInputStream(xlfile);
			work_book = new XSSFWorkbook(file_input);
			sheet = work_book.getSheet(Xlsheet);
			row = sheet.getRow(rownum);
			int cellcount = row.getLastCellNum();
			work_book.close();
			file_input.close();
			return cellcount;
		}
		
		public static String getCellData(String xlfile,String Xlsheet,int rownum,int column)throws IOException {
			file_input = new FileInputStream(xlfile);
			work_book = new XSSFWorkbook(file_input);
			sheet = work_book.getSheet(Xlsheet);
			row = sheet.getRow(rownum);
			cell = row.getCell(column);
			String data;
			try {
				DataFormatter formatter = new DataFormatter();
				String celldata = formatter.formatCellValue(cell);
				return celldata;
				
			} catch (Exception e) {
				data = "";
			}
			work_book.close();
			file_input.close();
			return data;
		}
		
		public static void setCellCount(String xlfile,String Xlsheet,int rownum,int clonum, String data)throws IOException {
			file_input = new FileInputStream(xlfile);
			work_book = new XSSFWorkbook(file_input);
			sheet = work_book.getSheet(Xlsheet);
			row = sheet.getRow(rownum);
			cell = row.getCell(clonum);
			cell.setCellValue(data);
			file_output = new FileOutputStream(xlfile);
			work_book.write(file_output);
			work_book.close();
			file_input.close();
			file_output.close();
		}
}

