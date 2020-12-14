package com.elsys.common.utils;

import javax.servlet.http.HttpServletRequest;

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
 * com.nc.common.utils : XmlUtils.java
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
 *  2016. 10. 12.          creme55         최초 생성 (XML 기반의 http 유틸리티)                  
 *
 * </pre>
 **/
public class XmlUtils {

	public static final boolean isXmlBody(HttpServletRequest request){
		String contentType = request.getContentType();
		if(contentType != null && contentType.toLowerCase().startsWith("application/xml") ){
			return true;
		}
		return false;
	}
	
	public static final boolean isXmlAccept(HttpServletRequest request){
		String accept = request.getHeader("Accept");
		if(accept != null && accept.toLowerCase().startsWith("application/xml")){
			return true;
		}
		return false;
	}
	
	public static final boolean isXmlExtension(HttpServletRequest request,String xmlExtension){
		if(xmlExtension != null){
			String uri = request.getRequestURI();
			if( uri.endsWith("."+xmlExtension) ){
				return true;
			}
		}
		return false;
	}
}