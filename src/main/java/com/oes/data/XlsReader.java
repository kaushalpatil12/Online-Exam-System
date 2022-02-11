package com.oes.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	String filePath;
	String sheetName;
	

	public XlsReader(String filePath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.filePath = filePath;
		this.sheetName = sheetName;
		this.sheet = workbook.getSheet(sheetName);
	}
	
	public boolean addData(int row, int col, String data) {
		Cell cell = sheet.getRow(row).getCell(col);
		cell.setCellValue(data);
		return writeData();
	}
	
	public String getData(int row, int col) {
		Cell cell = sheet.getRow(row).getCell(col);
		return cell.getStringCellValue();
	}
	
	private boolean writeData() {
		try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(filePath));
            workbook.write(out);
            out.close();
            System.out.println(filePath + " is written successfully.");
            return true;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		return false;
	}

}
