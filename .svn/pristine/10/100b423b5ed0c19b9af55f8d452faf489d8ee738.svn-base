package com.elsys.common.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

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
 * com.nc.common.utils : SessionUtil.java
 * @author creme55
 * @since 2016. 10. 21.
 * @version 1.0
 * @see 
 * @Copyright © [2016] By ETRI. All rights reserved.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *      수정일              수정자                  수정내용
 *  -------------        -----------       ----------------------------------------------------------
 *  2016. 10. 21.          creme55         최초 생성 (Spring의 기능을 이용하여 서비스 정의 없이 사용)
 *
 * </pre>
 **/
public class SessionUtil {
	/**
	 * <pre>
	 * 1. 개요 : 세션 관리
	 * 2. 처리내용 : attribute 값을 가져 오기 위한 method
	 * </pre>
	 *
	 * @method Name : getAttribute
	 * @param name (attribute name of key)
	 * @return  Object (attribute of object)
	 * @throws Exception
	 * 
	 */
	public static Object getAttribute(String name) throws Exception {
		if ((Object)RequestContextHolder.getRequestAttributes() == null){
			return null;
		}
		
		return (Object)RequestContextHolder.getRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
 	
	/**
	 * <pre>
	 * 1. 개요 : 세션 관리
	 * 2. 처리내용 : attribute 설정 method
	 * </pre>
	 *
	 * @method Name : setAttribute
	 * @param name, object
	 * @return none
	 * @throws Exeption
	 * 
	 */
	public static void setAttribute(String name, Object object) throws Exception {
		RequestContextHolder.getRequestAttributes().setAttribute(name, object, RequestAttributes.SCOPE_SESSION);
	}
 
	/**
	 * <pre>
	 * 1. 개요 : 세션 관리
	 * 2. 처리내용 : 설정한 attribute 삭제
	 * </pre>
	 *
	 * @method Name : removeAttribute
	 * @param name 
	 * @return 
	 * @throws Exception
	 * 
	 */
	public static void removeAttribute(String name) throws Exception {
		RequestContextHolder.getRequestAttributes().removeAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 세션 관리
	 * 2. 처리내용 : session id 조회
	 * </pre>
	 *
	 * @method Name : getSessionId
	 * @param 
	 * @return String 
	 * @throws Exception
	 * 
	 */
	public static String getSessionId() throws Exception  {
		return RequestContextHolder.getRequestAttributes().getSessionId();
	}	
}