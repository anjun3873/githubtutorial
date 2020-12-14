package com.elsys.common.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import com.elsys.common.exception.NCException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  ETRI Distributed Resource/Mediation System for new re-generation Energy Exchange
 *
 *  Copyright ⓒ [2016] ETRI. All rights reserved.
 *
 *    This is a proprietary software of ETRI, and you may not use this file except in
 *  compliance with license agreement with ETRI. Any redistribution or use of this
 *  software, with or without modification shall be strictly prohibited without prior written
 *  approval of ETRI, and the copyright notice above does not evidence any actual or
 *  intended publication of such software.
 *
 * com.nc.common.utils : JsonUtils.java
 * @author creme55
 * @since 2016. 10. 12.
 * @version 1.0
 * @see 
 * @Copyright © [2016] By ETRI. All rights reserved.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *      수정일              수정자                  수정내용
 *  -------------        -----------       -------------------------
 *  2016. 10. 12.          creme55         최초 생성(JSON 유틸리티 정의)                  
 *
 * </pre>
 **/
public class JsonUtils {

	/**
	 * <pre>
	 * 1. 개요 : API 유형별 처리
	 * 2. 처리내용 : JSON 헤더 가져오는 부분
	 * </pre>
	 *
	 * @method Name : isJsonBody
	 * @param HttpServletRequest request
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public static final boolean isJsonBody(HttpServletRequest request){
		String contentType = request.getContentType();
		
		if (contentType != null && contentType.toLowerCase().startsWith("application/json") ) {
			return true;
		}
		
		return false;
	}

	/**
	 * <pre>
	 * 1. 개요 : API 유형별 처리
	 * 2. 처리내용 : JSON 헤더 가져오는 부분
	 * </pre>
	 *
	 * @method Name : isJsonAccept
	 * @param HttpServletRequest request
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public static final boolean isJsonAccept(HttpServletRequest request){
		String accept = request.getHeader("Accept");
		
		if (accept != null && accept.toLowerCase().startsWith("application/json")) {
			return true;
		}
		
		return false;
	}

	/**
	 * <pre>
	 * 1. 개요 : API 유형별 처리
	 * 2. 처리내용 : JSON URI를 가져오는 부분
	 * </pre>
	 *
	 * @method Name : isJsonExtension
	 * @param HttpServletRequest request, String jsonExtension
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public static final boolean isJsonExtension(HttpServletRequest request, String jsonExtension){
		if (jsonExtension != null) {
			String uri = request.getRequestURI();
			if (uri.endsWith("." + jsonExtension)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * <pre>
	 * 1. 개요 : JSON 변환
	 * 2. 처리내용 : 입력된 맵을 JSON String으로 변환
	 * </pre>
	 *
	 * @method Name : exchangeMapToJson
	 * @param Map<String, String> params
	 * @return String
	 * @throws none
	 * 
	 */
	public static String exchangeMapToJson(Map<String, Object> params) throws Exception {
		String retVal = "";
		
		ObjectMapper obm = new ObjectMapper();
		
		try {
			retVal = obm.writeValueAsString(params);
		} catch (Exception mapErr) {
			throw new NCException("params happend error. error is " + mapErr.getMessage());
		}
		
		return retVal;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : JSON 변환
	 * 2. 처리내용 : 입력된 리스트를 JSON String으로 변환
	 * </pre>
	 *
	 * @method Name : exchangeListToJson
	 * @param Map<String, String> params
	 * @return String
	 * @throws none
	 * 
	 */
	public static String exchangeListToJson(List<Map<String, Object>> params) throws Exception {
		String retVal = "";
		
		ObjectMapper obm = new ObjectMapper();
		
		try {
			retVal = obm.writeValueAsString(params);
		} catch(Exception listErr) {
			throw new NCException("params happend error. error is " + listErr.getMessage());
		}
		
		return retVal;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : JSON 스트링 변환
	 * 2. 처리내용 : JSON 스트링을 맵으로 변환
	 * </pre>
	 *
	 * @method Name : exchangeJSONStrToMap
	 * @param String jsonStr
	 * @return Map<?,?>
	 * @throws none
	 * 
	 */
	public static Map<?, ?> exchangeJSONStrToMap(String jsonStr) throws Exception {
		Map<?, ?> retVal = null;
		
		ObjectMapper obm = new ObjectMapper();
		
		try {
			retVal = obm.readValue(jsonStr, new TypeReference<Map<?, ?>>(){});
		} catch(Exception jsonError) {
			throw new NCException("json string conver error happend..." + jsonError);
		}
		
		return  retVal;
	}
	
	public static Map<String, Object> parseJsonToMap(JSONObject json , Map<String, Object> out) throws Exception {
    	Set<String> setKeys = json.keySet();
    	Iterator<String> keys = setKeys.iterator();
	    while(keys.hasNext()){
	        String key = keys.next();
	        Object val = null;
	        try{
	             JSONObject value = (JSONObject) json.get(key);
	             parseJsonToMap(value, out);
	        } catch (Exception e){
	            val = json.get(key);
	        }

	        if (val != null){
	            out.put(key, val);
	        }
	    }
	    return out;
	}
}