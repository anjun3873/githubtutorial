package com.elsys.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	
	public static void write(File file, List<Map<String, Object>> data, 
			List<Map<String, Object>> headers, String headerNmKey, String dataKey) throws IOException, InvalidFormatException {
		// workbook 생성
		Workbook workbook = new XSSFWorkbook(); // EXCEL 2007 이상
		// sheet 생성
		Sheet sheet = workbook.createSheet("data" + Math.random());
		
		Row row = null;
		Cell cell = null;
		
		// 제목 row
		row = sheet.createRow(0);
		for (int i = 0, size = headers.size(); i < size; i++) {
			Map<String, Object> header = headers.get(i);
			cell = row.createCell(i);
			cell.setCellValue(String.valueOf(header.get(headerNmKey)));
		}
		
		// 데이터 저장
		for (int i = 0, size = data.size(); i < size; i++) {
			Map<String, Object> d = data.get(i);
			row = sheet.createRow(i + 1);
			
			for (int j = 0, size2 = headers.size(); j < size2; j++) {
				Map<String, Object> header = headers.get(j);
				cell = row.createCell(j);
				cell.setCellValue(String.valueOf(d.get(header.get(dataKey))));
			}
		}
		
		// file 생성
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
	}
}
