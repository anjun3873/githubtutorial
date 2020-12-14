package com.elsys.scheduler.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BackUpTaskMapper {

	/****************************************************************************************/

	// 컬럼명
	public List<Map<String, Object>> selectTableColumns(Map<String, Object> map) throws Exception;
	// 데이터
	public List<Map<String, Object>> selectBackupData(Map<String, Object> map) throws Exception;
	// 5분 데이터
	public List<Map<String, Object>> selectBackup5minData(Map<String, Object> map) throws Exception;
	// 레거시 데이터 삭제
	public void deleteData(Map<String, Object> map) throws Exception;
	/****************************************************************************************/
}
