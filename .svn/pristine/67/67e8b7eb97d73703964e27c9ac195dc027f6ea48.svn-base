package com.elsys.scheduler.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.elsys.scheduler.service.LogPcsEssTaskService;
import com.elsys.util.StrUtil;

@Service("logPcsEssTaskService")
public class LogPcsEssTaskServiceImpl implements LogPcsEssTaskService{

		@Autowired
		private Environment env;

		public StrUtil sut = new StrUtil();

		@Resource(name = "logPcsEssTaskMapper")
	    private LogPcsEssTaskMapper logPcsEssTaskDAO;

		/********************************************************************************/
		/* pcsEss 순시데이터 가공 후 가져오기 */
		public HashMap<String, Object> getPcsEssDataMap(HashMap<String, Object> paramMap) throws Exception {
			return logPcsEssTaskDAO.getPcsEssDataMap(paramMap);
		}
		
		/*log_pcs_ess_hour 데이터 적재*/
		public int insetLogPcsEssHourData(HashMap<String, Object> paramMap) throws Exception{
			return logPcsEssTaskDAO.insetLogPcsEssHourData(paramMap);
		}
		
		/*log_pcs_ess_day 데이터 적재*/
		public int insetLogPcsEssDayData(HashMap<String, Object> paramMap) throws Exception{
			return logPcsEssTaskDAO.insetLogPcsEssDayData(paramMap);
		}
		
		/* log_pcs_ess_day 데이터 가져오기 */
		public HashMap<String, Object> getPcsEssDayDataMap(HashMap<String, Object> paramMap) throws Exception {
			return logPcsEssTaskDAO.getPcsEssDayDataMap(paramMap);
		}
		
		/* log_pcs_ess_month 데이터 적재 */
		public int insetLogPcsEssMonthData(HashMap<String, Object> paramMap) throws Exception{
			return logPcsEssTaskDAO.insetLogPcsEssMonthData(paramMap);
		}
		/*********************************************************************************/

}
