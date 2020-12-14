package com.elsys.scheduler.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmartMeterTaskMapper {

	/****************************************************************************************/
	// device ID 가져오기
	public ArrayList<HashMap<String, Object>> getDeviceIdList(HashMap<String,Object> map) throws Exception;
	
	// 순시 SMARTMETER 데이터 삽입
	public void insertSmartMeter(HashMap<String,Object> paramMap) throws Exception;
	
	// 순시 SMARTMETER 3일전 데이터 삭제
	public void delSmartMeterData(HashMap<String,Object> paramMap) throws Exception;

	/****************************************************************************************/
}
