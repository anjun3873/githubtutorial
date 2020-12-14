package com.elsys.scheduler.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.elsys.common.utils.StaticVO;
import com.elsys.scheduler.service.LogPcsEssTaskService;


@Controller("LogPcsEssTask")
public class LogPcsEssTask {
	
	protected StaticVO staticVO = new StaticVO();

	@Resource(name="logPcsEssTaskService")
	private LogPcsEssTaskService logPcsEssTaskService;

	private static final Logger log = LoggerFactory.getLogger(PcsEssTask.class);

	/**
	 * LOG-PCS-ESS hour, day 데이터 적재
	 * @throws Exception
	 */
	public void logPcsEssDataDel() throws Exception { 
		
		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= smpData -- Batch Job Execution on basis the scheduler... =");
			log.debug("==========================================================================================");
		}
		
		
		try {
			System.out.println("LOG-PCS-ESS hour, day 데이터 적재 스케줄러 ");
			
			String house_id = "Yongin_Raemian_101_603";
			
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("house_id", house_id);
			
			HashMap<String,Object> pcsEssDataMap = new HashMap<String,Object>();
			
			// raw data 충/방전/pv 전력  SUM 값, SOC 최신 값 가져오기
			pcsEssDataMap = logPcsEssTaskService.getPcsEssDataMap(paramMap);
			
			paramMap.put("charge_hour", pcsEssDataMap.get("pcs_bat_c_power"));
			paramMap.put("discharge_hour", pcsEssDataMap.get("pcs_bat_dc_power"));
			paramMap.put("soc_hour", pcsEssDataMap.get("pcs_bat_soc"));
			paramMap.put("gen_eng_day", pcsEssDataMap.get("pcs_pv_power"));
			paramMap.put("gen_eng_month", pcsEssDataMap.get("gen_eng_month"));
			
			
			// log_pcs_ess_hour 데이터 insert 
			logPcsEssTaskService.insetLogPcsEssHourData(paramMap);
			
			// log_pcs_ess_day 데이터 insert
			logPcsEssTaskService.insetLogPcsEssDayData(paramMap);
			
            
		} catch(Exception err) {
			err.printStackTrace();
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Batch Process : Query Execution Error - [{}], [{}] =", err.getLocalizedMessage(), err);
				log.debug("==========================================================================================");
			}
		}
		
	}
	
	/**
	 * LOG-PCS-ESS month 데이터 적재
	 * @throws Exception
	 */
	public void logPcsEssMonthDataDel() throws Exception { 
		
		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= smpData -- Batch Job Execution on basis the scheduler... =");
			log.debug("==========================================================================================");
		}
		
		
		try {
			System.out.println("LOG-PCS-ESS month 데이터 적재 스케줄러 ");
			
			String house_id = "Yongin_Raemian_101_603";
			
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("house_id", house_id);
			
			HashMap<String,Object> pcsEssDataMap = new HashMap<String,Object>();
			pcsEssDataMap = logPcsEssTaskService.getPcsEssDayDataMap(paramMap);
			
			
			paramMap.put("log_month", pcsEssDataMap.get("log_month"));
			paramMap.put("charge_month", pcsEssDataMap.get("charge_month"));
			paramMap.put("discharge_month", pcsEssDataMap.get("discharge_month"));
			paramMap.put("soc_month", pcsEssDataMap.get("soc_month"));
			paramMap.put("gen_eng_month", pcsEssDataMap.get("gen_eng_month"));
			
			// log_pcs_ess_month 데이터 insert'
			logPcsEssTaskService.insetLogPcsEssMonthData(paramMap);
			
			
            
		} catch(Exception err) {
			err.printStackTrace();
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Batch Process : Query Execution Error - [{}], [{}] =", err.getLocalizedMessage(), err);
				log.debug("==========================================================================================");
			}
		}
		
	}

}
