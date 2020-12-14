package com.elsys.scheduler.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.elsys.scheduler.service.impl.BackUpTaskMapper;
import com.elsys.util.CsvHelper;

@Service
public class BackUpTaskService {
	
	@Autowired BackUpTaskMapper backUpTaskMapper;
//	@Autowired DeleteMapper deleteMapper;
	
	// local 백업 경로
	String backupPath ="C:/backup";
	// server 백업 경로
	//String backupPath ="/backup";
	// 데이터베이스 스키마
	String schema ="ah_hems_v2"; 

	
	private static final DateTimeFormatter dfmFN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final DateTimeFormatter dfmPN = DateTimeFormatter.ofPattern("yyyyMMdd");
	private static final DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyyMMddHH");
	
	// 백업에 사용할 테이블명
	@SuppressWarnings("serial")
	private final static List<String> tableNm = new ArrayList<String>(){{		
		add("data_pcs_ess_v2");
	}};
	
	// 백업 시작
	public void backup() throws Exception {

		LocalDateTime now = LocalDateTime.now();		// 현재
		LocalDateTime before = now.minusHours(1);		// 1시간 전
		LocalDateTime beforeDay = before.minusDays(1);	// 하루 전 
		
		String dataDate = dfm.format(before);		// 백업 데이터 날짜 조건
		String tableDate = dfmFN.format(before);	// 날짜명 파일 지정
		String folderPath = dfmPN.format(before);	// 날짜명 폴더 지정
		
		// 삭제 날짜
		String deleteDate = dfm.format(beforeDay);	// 삭제 조건 날짜
		
		File folder = new File(backupPath + File.separator + folderPath);	// 폴더 경로 생성
		if (!folder.exists()){ folder.mkdirs(); }							// 폴더 여부 체크 후 생성
		
		List<Map<String, Object>> data;
		List<Map<String, Object>> columns;
		
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("dateDate", dataDate);
		info.put("schema", schema);
		info.put("deleteDate", deleteDate);
		
		for(String tn : tableNm){
			info.put("tableNm", tn);
			// 컬럼 조회
			columns =  backUpTaskMapper.selectTableColumns(info);
			// 백업 데이터 조회
			data = backUpTaskMapper.selectBackupData(info);
			
			String fileNm = tn + "_backup(" + tableDate + ")" +".csv";
			
			// 엑셀로 백업
			File excelFile = new File(backupPath + File.separator + folderPath + File.separator + fileNm);
			CsvHelper.write(excelFile, data, columns, "COLUMN_COMMENT", "COLUMN_NAME", excelFile.isFile());
			
			backUpTaskMapper.deleteData(info);	// 레거시 데이터 삭제
		}
		
//		deleteMapper.deletePhysicalData(info);	// physical 데이터 삭제
		
	}
}
