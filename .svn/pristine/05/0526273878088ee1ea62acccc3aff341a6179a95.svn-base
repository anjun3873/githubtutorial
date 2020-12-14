package com.elsys.common.utils;

import java.security.MessageDigest;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
 * com.nc.common.utils : ApiKeyUtils.java
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
 *  2016. 10. 12.          creme55         최초 생성(API 키생성 및 암호화)                  
 *
 * </pre>
 **/
@Component
public class ApiKeyUtils {
	
	private static final Logger log = LoggerFactory.getLogger(ApiKeyUtils.class);
	
	
	/**
	 * Api Key 생성
	 * 
	 * @return
	 * @throws Exception
	 */
	public String createApiKey(String fusionStr) throws Exception {
		String apiKey = null;
		int apiKeyCnt = 0;
		
		while(true) {
			apiKey = getMD5(fusionStr + new Date().toString() + Integer.toString((int)(Math.random()*10000)));
			apiKeyCnt = 0; //(Integer)sqlTemplate.selectOne("main.selectApiKeyCnt", apiKey);
			if(apiKeyCnt < 1) {
				break;
			}
		}

		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= create Api Key : [{}] =", apiKey);
			log.debug("==========================================================================================");
		}
		
		return apiKey;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 암호화
	 * 2. 처리내용 : MD5 암호화
	 * </pre>
	
	 * @method Name : getMD5
	 * @param orgKey
	 * @return String
	 * @throws Exception
	 * 
	 */
	private String getMD5(String orgKey) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(orgKey.getBytes()); 
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < byteData.length ; i++){
            sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
	}
}