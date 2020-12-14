package com.elsys.scheduler.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.elsys.scheduler.service.PcsEssTaskService;
import com.elsys.util.StrUtil;

@Service("pcsEssTaskService")
public class PcsEssTaskServiceImpl implements PcsEssTaskService{

		@Autowired
		private Environment env;

		public StrUtil sut = new StrUtil();

		@Resource(name = "pcsEssTaskMapper")
	    private PcsEssTaskMapper pcsEssTaskDAO;

		/*********************************************************************************/
		
		// 세대 ID 가져오기
		public ArrayList<HashMap<String, Object>> getHouseIdList(HashMap<String, Object> datamap) throws Exception {
			return pcsEssTaskDAO.getHouseIdList(datamap);
		}
		
		// 순시 PCS_ESS 데이터 삽입
		public void insertPcsEss(HashMap<String,Object> paramMap) throws Exception{
			pcsEssTaskDAO.insertPcsEss(paramMap);
		}
		
		// 순시 PCS_ESS 3일전 데이터 삭제
		public void delPcsEssData(HashMap<String,Object> paramMap) throws Exception{
			pcsEssTaskDAO.delPcsEssData(paramMap);
		}
		/*********************************************************************************/

}
