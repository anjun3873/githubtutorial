package com.elsys.scheduler.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.elsys.scheduler.service.SmartMeterTaskService;
import com.elsys.util.StrUtil;

@Service("smartMeterTaskService")
public class SmartMeterTaskServiceImpl implements SmartMeterTaskService{

		@Autowired
		private Environment env;

		public StrUtil sut = new StrUtil();

		@Resource(name = "smartMeterTaskMapper")
	    private SmartMeterTaskMapper smartMeterTaskDAO;

		/*********************************************************************************/
		// device ID 가져오기
		public ArrayList<HashMap<String, Object>> getDeviceIdList(HashMap<String, Object> datamap) throws Exception {
			return smartMeterTaskDAO.getDeviceIdList(datamap);
		}
		
		// 순시 SMARTMETER 데이터 삽입
		public void insertSmartMeter(HashMap<String,Object> paramMap) throws Exception{
			smartMeterTaskDAO.insertSmartMeter(paramMap);
		}
		
		// 순시 SMARTMETER 3일전 데이터 삭제
		public void delSmartMeterData(HashMap<String,Object> paramMap) throws Exception{
			smartMeterTaskDAO.delSmartMeterData(paramMap);
		}

		/*********************************************************************************/

}
