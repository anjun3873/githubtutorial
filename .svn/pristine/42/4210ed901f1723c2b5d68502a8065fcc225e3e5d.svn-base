package com.elsys.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * com.nc.common.utils : DateUtils.java
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
 *  2016. 10. 12.          creme55         최초 생성 (일자 유틸리티)                  
 *
 * </pre>
 **/
@Component
public class DateUtils {

	/**
	 * <pre>
	 * 1. 개요 : 정합성 체크 
	 * 2. 처리내용 : 일자의 유효성 체크
	 * </pre>
	
	 * @method Name : validateDate
	 * @param date 
	 * @return boolean
	 * @throws none
	 * 
	 */
	public boolean validateDate(String date) {
	    try {
	    	DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    	sdf.setLenient(false);
	    	sdf.parse(date);
	        return true;
	    } catch(ParseException ex) {
	        return false;
	    }
	}
}