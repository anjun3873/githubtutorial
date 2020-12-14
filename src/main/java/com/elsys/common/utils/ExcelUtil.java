package com.elsys.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elsys.common.exception.NCException;


/**
 *  ETRI Distributed Resource/Mediation System for new re-generation Energy Exchange
 *
 *  Copyright ⓒ [2016] ETRI. All rights reserved.
 *
 *    This is a proprietary software of ETRI, and you may not use this file except in
 *  compliance with license agreement with ETRI. Any redistribution or use of this
 *  software, with or without modification shall be strictly prohibited without prior written
 *  approval of ETRI, and the copyright notice above does not evidence any actual or
 *  intended publication of such software.
 *
 * com.nc.common.utils : ExcelUtil.java
 * @author creme55
 * @since 2016. 10. 20.
 * @version 1.0
 * @see 
 * @Copyright © [2016] By ETRI. All rights reserved.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *      수정일              수정자                  수정내용
 *  -------------        -----------       ---------------------------------
 *  2016. 10. 20.          creme55         최초 생성 (Excel file management)
 *
 * </pre>
 **/
public class ExcelUtil {
	private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);
	
	/**
	 * <pre>
	 * 1. 개요 : POI Util
	 * 2. 처리내용 : Excel 파일 읽기(*.xls, *.xlsx 파일 가능)
	 * </pre>
	 *
	 * @method Name : readExcel
	 * @param strFullFilePath, serviceType
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static List<Map<String, Object>> readExcel(String strFullFilePath, String serviceType) throws Exception
	{
		String tmpFile = strFullFilePath;
		File wbfile = new File(tmpFile);
		
		Workbook wb = null;
		FileInputStream file = null;

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;

		try {
			file = new FileInputStream(wbfile);

			wb =  new HSSFWorkbook(file); /* WorkbookFactory.create(file); Version change */
			
			/* Sheet 수 만큼 반복, 현재 단일 쉬트만 사용하도록 제한 */
			/* for (int sheetIdx=0; sheetIdx<wb.getNumberOfSheets(); sheetIdx++) { */
			for (int sheetIdx = 0; sheetIdx < 1; sheetIdx++) {		/* 1번째 시트만 읽기 */

				Sheet sheet = wb.getSheetAt(sheetIdx);

				/* 첫 번째 라인 비교 해당 문서가 맞는지 확인, 구현 예정 */
				

				/* row 수 만큼 반복 */
				int cellCount = 0;
				for (int rowIdx = sheet.getFirstRowNum()+1; rowIdx <= sheet.getLastRowNum(); rowIdx++) {

					Row row = sheet.getRow(rowIdx);
					cellCount = row.getLastCellNum();
					map = new HashMap<String, Object>();

					if (row != null) {
						// cell 수 만큼 반복
						for (int cellIdx = 0; cellIdx < cellCount; cellIdx++) {

							Cell cell = row.getCell(cellIdx);
							if (cell != null) {

								int cellType = cell.getCellType();
								String value = "";
								
								if(serviceType.equals("order")){
									switch (cellType)
									{
										case HSSFCell.CELL_TYPE_FORMULA : //수식자체
											value = cell.getStringCellValue();//cell.getCellFormula();
											break;
										
										case HSSFCell.CELL_TYPE_NUMERIC ://숫자
											if (HSSFDateUtil.isCellDateFormatted(cell)){
										         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
										         value = formatter.format(cell.getDateCellValue());
										    } else{
										    	cell.setCellType(Cell.CELL_TYPE_STRING);
										    	value = cell.getStringCellValue();
										    }
											break;
										
										case HSSFCell.CELL_TYPE_STRING : //문자
											value = cell.getStringCellValue();
											break;
										
										case HSSFCell.CELL_TYPE_BLANK : //빈칸
											value = cell.getStringCellValue();
											break;
										
										case HSSFCell.CELL_TYPE_ERROR : //BYTE
											value = cell.getErrorCellValue() + "";
											break;
										
										default: ;
									}	
								} else {
									switch (cellType)
									{
										case HSSFCell.CELL_TYPE_FORMULA : //수식자체
											value = cell.getStringCellValue();//cell.getCellFormula();
										break;
										
										case HSSFCell.CELL_TYPE_NUMERIC ://숫자
											value = cell.getNumericCellValue() + "";
										break;
										
										case HSSFCell.CELL_TYPE_STRING : //문자
											value = cell.getStringCellValue();
										break;
										
										case HSSFCell.CELL_TYPE_BLANK : //빈칸
											value = cell.getStringCellValue();
										break;
										
										case HSSFCell.CELL_TYPE_ERROR : //BYTE
											value = cell.getErrorCellValue() + "";
										break;
										
										default:
									}									
								}
								map.put("colName" + cellIdx, value);
							} else {
								map.put("colName" + cellIdx, "");
							}
						}

						list.add(map);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Excel File Reading ... Error : [{}] =", e);
				log.debug("==========================================================================================");
			}
			
			throw new NCException("ExcelUtil > readExcel 에러");
		} finally {
			
			/* 파일 자원 종료 */
			file.close();
			wb.close();
		}
		
		return list;
	}

	/**
	 * <pre>
	 * 1. 개요 : POI Util
	 * 2. 처리내용 : Excel 파일 읽기(*.xls, *.xlsx 파일 가능), sheet 지정 지원
	 * </pre>
	 *
	 * @method Name : readExcelMulti
	 * @param strFullFilePath, serviceType, sheetNo
	 * @return 
	 * @throws
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static List<LinkedHashMap<String, Object>> readExcelMulti(String strFullFilePath, String serviceType, int sheetNo) throws Exception {
		String tmpFile = strFullFilePath;
		File wbfile = new File(tmpFile);
		
		Workbook wb = null;
		FileInputStream file = null;

		List<LinkedHashMap<String, Object>> list = new ArrayList<LinkedHashMap<String, Object>>();
		LinkedHashMap<String, Object> map = null;

		try {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= file path : {} =", strFullFilePath);
				log.debug("= tmp file  : {} =", tmpFile);
				log.debug("==========================================================================================");
			}
			
			file = new FileInputStream(wbfile);
			
			wb = new HSSFWorkbook(file); /* WorkbookFactory.create(file); */
			
			Sheet sheet = wb.getSheetAt(sheetNo);

			/* row 수 만큼 반복 */
			int cellCount = 0;
			for (int rowIdx = sheet.getFirstRowNum() + 1; rowIdx <= sheet.getLastRowNum(); rowIdx++) {

				Row row = sheet.getRow(rowIdx);
				cellCount = row.getLastCellNum();
				map = new LinkedHashMap<String, Object>();

				if (rowIdx == 0) {
					if (log.isDebugEnabled()) {
						log.debug("==================================================================================");
						log.debug("= sheet no  : {} =", sheetNo);
						log.debug("= row count : {} =", sheet.getLastRowNum());
						log.debug("= col count : {} =", cellCount);
						log.debug("==================================================================================");
					}
				}
				
				if (row != null) {
					// cell 수 만큼 반복
					for (int cellIdx = 0; cellIdx < cellCount; cellIdx++) {

						Cell cell = row.getCell(cellIdx);
						if (cell != null) {

							int cellType = cell.getCellType();
							String value = "";

							switch (cellType)
							{
								case HSSFCell.CELL_TYPE_FORMULA : //수식자체
									value = cell.getStringCellValue();//cell.getCellFormula();
									break;
								
								case HSSFCell.CELL_TYPE_NUMERIC ://숫자
									value = cell.getNumericCellValue() + "";
									break;
								
								case HSSFCell.CELL_TYPE_STRING : //문자
									value = cell.getStringCellValue();
									break;
								
								case HSSFCell.CELL_TYPE_BLANK : //빈칸
									value = cell.getStringCellValue();
									break;
								
								case HSSFCell.CELL_TYPE_ERROR : //BYTE
									value = cell.getErrorCellValue() + "";
									break;
								
								default:
							}

							map.put("item" + String.valueOf(cellIdx), value);
						} else {
							map.put("item" + String.valueOf(cellIdx), "");
						}
					}
					
					if (log.isDebugEnabled()) {
						log.debug("==================================================================================");
						log.debug("= map : {} =", map);
						log.debug("==================================================================================");
					}
					
					list.add(map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Excel File Reading ... Error : [{}] =", e);
				log.debug("==========================================================================================");
			}
			
			throw new NCException("ExcelUtil > readExcel 에러");
		} finally {

			/* 파일 자원 종료 */
			file.close();
			wb.close();
		}

		return list;
	}

	/**
	 * <pre>
	 * 1. 개요 : POI Util
	 * 2. 처리내용 : Excel 파일 읽고 쓰기(매크로 적용), 사용자가 서비스마다 컬럼정보를 제공하여 데이터를 생성
	 * </pre>
	 *
	 * @method Name : readWriteExcel
	 * @param response, codeList, serviceType, templateFile
	 * @return none
	 * @throws Exception
	 * 
	 */
	public static void readWriteExcel(HttpServletResponse response, List<Map<String, Object>> codeList, String serviceType, String templateFile) throws Exception {
		OutputStream fileOut = null;

		/* 각 서비스마다 조건 등을 기술 예정 */
		
		File wbfile = new File(templateFile);
		Workbook wb = null;
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(wbfile);
			
			wb = new HSSFWorkbook(file); /* WorkbookFactory.create(file); */
			
			for (int i=0; i<wb.getNumberOfSheets(); i++) {
				wb.removeSheetAt(wb.getNumberOfSheets()-1);
			}
			
			/* Sheet 생성, 템플릿의 경우, 관련된 코드 매핑정보와 사용자 매핑정보를 생성 예정 */
			/* 표준코드 쉬트 생성*/
			/* 사용자정보 예시 : wb = createWorkBook(wb, "sheet Name", "dataList", "header column List");*/

		} catch (Exception e) {
			e.printStackTrace();
			
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Excel File Reading ... Error : [{}] =", e);
				log.debug("==========================================================================================");
			}
			
			throw new NCException("ExcelUtil > readWriteExcel 에러");
		} finally {
			/* 파일 자원 종료 */
			file.close();
			wb.close();
		}
		
		String fileName = serviceType + ".xlsm";

		/* 헤더 설정 */
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

		/* 출력, to file */
		fileOut = response.getOutputStream(); 
		wb.write(fileOut);
		fileOut.close();
		fileOut.flush();
	}

	/**
	 * <pre>
	 * 1. 개요 : POI UTIL 
	 * 2. 처리내용 : Excel 파일 읽고 쓰기(매크로 적용)
	 * </pre>
	 *
	 * @method Name : readWriteWbsExcel
	 * @param response, codeList, serviceType, templateFile
	 * @return none 
	 * @throws Exception
	 * 
	 */
	public static void readWriteWbsExcel(HttpServletResponse response, List<Map<String, Object>> codeList, String serviceType, String templateFile) throws Exception {
		OutputStream fileOut = null;

		templateFile += ".xlsx";
		
		File wbfile = new File(templateFile);
		Workbook wb = null;
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(wbfile);
			
			wb = new HSSFWorkbook(file);

			/* Sheet 삭제, 템플릿의 경우, 관련된 코드 매핑정보와 사용자 매핑정보를 삭제 예정 */
			/* 표준코드 쉬트 생성*/
			/* 사용자정보 예시 : wb.removeSheetAt(wb.getSheetIndex("사용자id")); */

			/* Sheet 생성, 템플릿의 경우, 관련된 코드 매핑정보와 사용자 매핑정보를 생성 예정 */
			/* 표준코드 쉬트 생성*/
			/* 사용자정보 예시 : wb = createWorkBook(wb, "sheet Name", "dataList", "header column List");*/


		} catch (Exception e) {
			e.printStackTrace();
			throw new NCException("ExcelUtil > readWriteExcel 에러");
		} finally {
			/* 파일 자원 종료 */
			file.close();
			wb.close();
		}

		String fileName = serviceType + ".xlsx";

		/* 헤더 설정 */
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

		/* 출력 */
		fileOut = response.getOutputStream(); 
		wb.write(fileOut);
		fileOut.close();
		fileOut.flush();
	}	
	
	/**
	 * <pre>
	 * 1. 개요 : POI UTIL
	 * 2. 처리내용 : 엑셀 파일 다운로드
	 * </pre>
	 *
	 * @method Name : excelFileDownload
	 * @param response, list, serviceType, colNames
	 * @return none
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("resource")
	public static void excelFileDownload(HttpServletResponse response, List<Map<String, Object>> list, String serviceType, List<LinkedHashMap<String, Object>> colNames) throws Exception {
		
		OutputStream fileOut = null;

		String filename = serviceType;
	    String currentDateTime = getCurrentDateNum();
		
		String newFileName = filename + "_" + currentDateTime + ".xls";

		/* 헤더 설정 */
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(newFileName, "UTF-8")); 

		Workbook workbook = new HSSFWorkbook();
		
		workbook = createWorkBook(workbook, "데이터 리스트", list, colNames);  /* 엑셀생성 */
		
		/* 출력 */
		fileOut = response.getOutputStream();
		workbook.write(fileOut);
		fileOut.close();
		fileOut.flush();
	}

	/**
	 * <pre>
	 * 1. 개요 : POI UTIL
	 * 2. 처리내용 : 현재 날짜를 리턴
	 * </pre>
	 *
	 * @method Name : getCurrentDateNum
	 * @param 
	 * @return String
	 * @throws 
	 * 
	 */
	public static String getCurrentDateNum() {
		String strDate = "";
		
		Calendar aCalendar = Calendar.getInstance();

		String year = Integer.toString(aCalendar.get(Calendar.YEAR));
		String month = Integer.toString(aCalendar.get(Calendar.MONTH) + 1);
		String date = Integer.toString(aCalendar.get(Calendar.DATE));
		String hour = Integer.toString(aCalendar.get(Calendar.HOUR_OF_DAY));
		String min = Integer.toString(aCalendar.get(Calendar.MINUTE));
		String sec = Integer.toString(aCalendar.get(Calendar.SECOND));
		String mil = Integer.toString(aCalendar.get(Calendar.MILLISECOND));
		strDate = year + month + date + hour + min + min + sec + mil;
		
		return strDate;
	}

	/**
	 * <pre>
	 * 1. 개요 : POI UTIL
	 * 2. 처리내용 : POI WORKBOOK 생성 / String 시트명, List<Map<String, Object>> 헤더 , List<Map<String, Object>> 컬럼
	 * </pre>
	 *
	 * @method Name : createWorkBook
	 * @param workbook, sheetName, list, colNames
	 * @return Workbook
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static Workbook createWorkBook(Workbook workbook, String sheetName, List<Map<String, Object>> list, List<LinkedHashMap<String, Object>> colNames) throws Exception {
		Row row;
		Cell cell;
		
		/* 엑셀 파일 생성 START */
		/* Workbook workbook = new Workbook(); */

		CellStyle titleStyle = workbook.createCellStyle();
		CellStyle cellStyle = workbook.createCellStyle();
		CellStyle contentStyle = workbook.createCellStyle();
		CellStyle contentStyle_2 = workbook.createCellStyle();
		
		/* 폰트 설정 */
		/* 타이틀 폰트 */
		Font titleFont = workbook.createFont();
		
		titleFont.setFontHeightInPoints((short)13);
		titleFont.setFontName("맑은 고딕");
		
		/* 컬럼명 폰트 */
		Font colNameFont = workbook.createFont();
		
		colNameFont.setFontHeightInPoints((short)12);
		colNameFont.setFontName("맑은 고딕");
		
		/* 내용 폰트 */
		Font contentFont = workbook.createFont();
		
		/* 타이틀 폰트 스타일 지정 */
		titleStyle.setFont(titleFont);
		
		/* 컬럼 셀 테두리 / 폰트 스타일 지정 */
		cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index); /* 셀 색상 */
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//테두리 설정
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setFont(colNameFont);
		
		/* 내용 셀 테두리 / 폰트 지정 */
		contentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); /* 테두리 설정 */
		contentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		contentStyle.setFont(contentFont);
		
		/* 내용 셀 테두리 / 폰트 지정 왼쪽정렬 */
		contentStyle_2.setBorderRight(HSSFCellStyle.BORDER_THIN); /* 테두리 설정 */
		contentStyle_2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		contentStyle_2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		contentStyle_2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		contentStyle_2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		contentStyle_2.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		contentStyle_2.setFont(contentFont);
		
		/* 시트 생성 */
		Sheet sheet = workbook.createSheet(sheetName);
		
		/* 행 인덱스 */
		int sheet1_row = 0;
		
		List<LinkedHashMap<String, Object>> colList = colNames;
		
		/* 헤더 START */
		row = sheet.createRow(sheet1_row);
		for (int ii = 1; ii <= colList.get(1).keySet().size(); ii++) {
			cell = row.createCell(ii);
			
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Header [{}] : [{}] =", ii, colList.get(1).get("item" + ii));
				log.debug("==========================================================================================");
			}
			
			cell.setCellValue(String.valueOf(colList.get(1).get("item" + ii)));
			cell.setCellStyle(cellStyle);
		}
		
		sheet1_row++;
		
		/* 헤더 END */
		for (Map<String, Object> map : list) {

			row = sheet.createRow(sheet1_row);

			for (int j = 1; j <= colList.get(0).keySet().size(); j++) {
				cell = row.createCell(j);
				cell.setCellStyle(contentStyle);

				if (log.isDebugEnabled()) {
					log.debug("==========================================================================================");
					log.debug("= Value [{}] : [{}] =", j, map.get(String.valueOf(colList.get(0).get("item" + j))));
					log.debug("==========================================================================================");
				}
				
				if (null != map.get(colList.get(0).get("item" + j))) {
					cell.setCellValue(map.get(String.valueOf(colList.get(0).get("item" + j))).toString());
				} else {
					cell.setCellValue("");
				}
				
				/* 셀 사이즈 자동 조절 */
				sheet.autoSizeColumn((short)j);
				sheet.setColumnWidth(j, (sheet.getColumnWidth(j)) + 312);
			}
			
			sheet1_row++;
		}
		return workbook;
	}
}