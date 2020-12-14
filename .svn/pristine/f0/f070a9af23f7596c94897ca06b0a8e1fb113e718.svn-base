package com.elsys.common.constants;

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
 * com.nc.common.constants : APIConstants.java
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
 *  2016. 10. 12.          creme55         최초 생성 (공통 API 상수 정의)
 *
 * </pre>
 **/
public enum APIConstants {
	
	ERROR_KEY("error"),						// 오류 Key
	ERROR_CODE_KEY("error_code"),			// 오류 코드 Key
	ERROR_MESSAGE_KEY("error_message"),		// 오류 메시지 Key
	ERROR_SYSTEM("000"),  					// System Error
	ERROR_REQUEST_COUNT("010"),  			// Request Count Error
	ERROR_PARAMETER("100"),  				// Parameter Error
	ERROR_UNREGISTERED_KEY("101");  		// Unregistered key

	//page size
	public static final int DEFAULT_PAGING_SIZE = 10;
	public static final int DEFAULT_LIMIT_SIZE = 1000;
	
	private String code;
	
	private APIConstants(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}