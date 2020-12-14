package com.elsys.scheduler.web;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.python.icu.text.DateFormat;
import org.python.icu.text.SimpleDateFormat;
import org.python.icu.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.elsys.common.utils.StaticVO;
import com.elsys.scheduler.service.SmartMeterTaskService;


@Controller("SmartMeterTask")
public class SmartMeterTask {
	
	protected StaticVO staticVO = new StaticVO();

	@Resource(name="smartMeterTaskService")
	private SmartMeterTaskService smartMeterTaskService;

	private static final Logger log = LoggerFactory.getLogger(SmartMeterTask.class);

	/**
	 * API를 통해 SMART-METER 순시 데이터 가져오기
	 * @throws Exception
	 */
	
	public void smartMeterData() throws Exception { 
		
		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= smpData -- Batch Job Execution on basis the scheduler... =");
			log.debug("==========================================================================================");
		}
		
		
		try {
			System.out.println("smartmeter 스케줄러 ");
			
			ArrayList<HashMap<String,Object>> houseIdList = new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> dataMap = new HashMap<String,Object>();
			HashMap<String, Object> paramMap = new HashMap<String,Object>();
			//houseIdList = pcsEssTaskService.getHouseIdList(dataMap); // 세대 리스트 가져오기 위해 선언
			
			// 세대 수 만큼 for 돌림
			//for(int i=0; i < houseIdList.size(); i++){
				//String houseId = houseIdList.get(i).get("HOUSE_ID").toString();
				String houseId = "Yongin_Raemian_101_603";
				
				dataMap.put("houseId", houseId);
				paramMap.put("houseId", houseId);
				
				ArrayList<HashMap<String,Object>> deviceIdList = new ArrayList<HashMap<String, Object>>();
				
				deviceIdList = smartMeterTaskService.getDeviceIdList(dataMap);
				
				for(int k = 0; k < deviceIdList.size(); k++){
					String deviceId = deviceIdList.get(k).get("DEVICE_ID").toString();
					
					paramMap.put("deviceId", deviceId);
					
					URL url = new URL("http://101.55.126.224/Hems/"+houseId+"/SMARTMETER/"+deviceId+"/DATA/latest");
		        	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        	conn.setDoOutput(true);
		        	
		        	conn.setRequestMethod("GET");
		        	conn.setRequestProperty("X-M2M-RI", "12345");
		        	conn.setRequestProperty("accept", "application/vnd.onem2m-prsp+json");
		        	conn.setRequestProperty("X-M2M-Origin", "SOrigin");
		        	
		        	if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
		                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		            }
		        	
		        	
		        	JSONObject connObj = new JSONObject();
		        	connObj = (JSONObject)JSONValue.parse(new InputStreamReader(conn.getInputStream()));
		        	
		        	JSONObject m2mCin = (JSONObject) connObj.get("m2m:cin");
		        	
		        	/**
		        	 * API에서 받아온 UTC 날짜 date를 변환 작업
		        	*/
		        	String ltDate = m2mCin.get("lt").toString();
		        	
		        	String eventTimeKo = "";
		        	
		        	DateFormat inDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
		            inDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		            //outDate
		            SimpleDateFormat outDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		            eventTimeKo = outDateFormat.format(inDateFormat.parse(ltDate));
		        	// 변환 작업 끝
		        	
		            JSONObject jobCon = (JSONObject) m2mCin.get("con");
		            JSONObject jobResult = (JSONObject) jobCon.get("results");
		            
		            paramMap.put("reg_dt", eventTimeKo.toString());
		            paramMap.put("momen_power", jobResult.get("momen_power").toString());
		            paramMap.put("current", jobResult.get("current").toString());
		            paramMap.put("powerfactor", jobResult.get("powerfactor").toString());
		            paramMap.put("cumul_power", jobResult.get("cumul_power").toString());
		            paramMap.put("firmware_version", jobResult.get("firmware_version").toString());
		            paramMap.put("switch_status", jobResult.get("switch_status").toString());
		            paramMap.put("voltage", jobResult.get("voltage").toString());
		            
		            smartMeterTaskService.insertSmartMeter(paramMap);
				}
				
				
			//}
            
		} catch(Exception err) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Batch Process : Query Execution Error - [{}], [{}] =", err.getLocalizedMessage(), err);
				log.debug("==========================================================================================");
			}
		}finally{
		
		}
	
	}
	
	/**
	 * SMARTMETER 순시데이터 현재날짜기준 3일전 데이터 삭제
	 * @throws Exception
	 */
	public void smartMeterDataDel() throws Exception { 
		
		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= smpData -- Batch Job Execution on basis the scheduler... =");
			log.debug("==========================================================================================");
		}
		
		
		try {
			System.out.println("smartmeter 3일전 데이터 삭제 스케줄러 ");
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			smartMeterTaskService.delSmartMeterData(paramMap);
			
            
		} catch(Exception err) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Batch Process : Query Execution Error - [{}], [{}] =", err.getLocalizedMessage(), err);
				log.debug("==========================================================================================");
			}
		}
		
	}

}
