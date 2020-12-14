package com.elsys.scheduler.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PcsEssTaskMapper {

	/****************************************************************************************/
	// 세대 ID 가져오기
	public ArrayList<HashMap<String, Object>> getHouseIdList(HashMap<String,Object> map) throws Exception;

	// 순시 PCS_ESS 데이터 삽입
	public void insertPcsEss(HashMap<String,Object> paramMap) throws Exception;
	
	// 순시 PCS_ESS 3일전 데이터 삭제
	public void delPcsEssData(HashMap<String,Object> paramMap) throws Exception;
	/****************************************************************************************/
}
