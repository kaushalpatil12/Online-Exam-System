package com.oes.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XlsWriter {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	String filePath;
	String sheetName;
	

	public XlsWriter(String filePath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.filePath = filePath;
		this.sheetName = sheetName;
		this.sheet = workbook.getSheet(sheetName);
	}
	
	public boolean addRow(Map<Integer, String> rowData) {
		int currentRow = sheet.getLastRowNum();
		Row row = sheet.createRow(currentRow + 1);
		for (Integer col : rowData.keySet()) {
			Cell cell = row.createCell(col);
			cell.setCellValue(rowData.get(col));
		}
		return writeData();
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
