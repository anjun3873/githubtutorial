package com.elsys.scheduler.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface SmartMeterTaskService {

	/****************************************************************************************/
	// device ID가져오기
	public ArrayList<HashMap<String, Object>> getDeviceIdList(HashMap<String, Object> dataMap) throws Exception;
	
	// 순시 SMARTMETER 데이터 삽입
	public void insertSmartMeter(HashMap<String, Object> paramMap) throws Exception;
	
	// 순시 SMARTMETER 3일전 데이터 삭제
	public void delSmartMeterData(HashMap<String, Object> paramMap) throws Exception;
	/****************************************************************************************/
}
