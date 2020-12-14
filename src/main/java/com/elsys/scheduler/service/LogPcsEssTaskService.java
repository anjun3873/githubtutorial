package com.elsys.scheduler.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface LogPcsEssTaskService {

	/****************************************************************************************/
	/* pcsEss 순시데이터 가공 후 가져오기 */
	public HashMap<String,Object> getPcsEssDataMap(HashMap<String, Object> paramMap) throws Exception;
	
	/* log_pcs_ess_hour 데이터 적재 */
	public int insetLogPcsEssHourData(HashMap<String,Object> paramMap) throws Exception;
	
	/* log_pcs_ess_day 데이터 적재 */
	public int insetLogPcsEssDayData(HashMap<String,Object> paramMap) throws Exception;
	
	/* log_pcs_ess_day 데이터 가져오기 */
	public HashMap<String,Object> getPcsEssDayDataMap(HashMap<String, Object> paramMap) throws Exception;
	
	/* log_pcs_ess_month 데이터 적재 */
	public int insetLogPcsEssMonthData(HashMap<String,Object> paramMap) throws Exception;
	/****************************************************************************************/
}
