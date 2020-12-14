package com.elsys.common.spring;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

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
 * com.nc.common.spring : CustomHandlerMethodArgumentResolver.java
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
 *  2016. 10. 12.          creme55         최초 생성 (사용자 정의 파라미터 핸들러 정의)                  
 *
 * </pre>
 **/
public class CustomHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
	private static final Logger log = LoggerFactory.getLogger(CustomHandlerMethodArgumentResolver.class);
	
	@Override
	public boolean supportsParameter(MethodParameter mthodParameter){
		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("supportsParameter type : {}", mthodParameter.getParameterType());
			log.debug("supportsParameter name : {}", mthodParameter.getParameterName());
			log.debug("==========================================================================================");
		}
		
    	Class<?> paramType = mthodParameter.getParameterType();
    	String paramName = mthodParameter.getParameterName();
    	
    	return ( Map.class.isAssignableFrom(paramType) && "paramMap".equals(paramName) );
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public Object resolveArgument(MethodParameter methodParameter
    		, ModelAndViewContainer modelAndViewContainer, NativeWebRequest webRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Enumeration<String> en = request.getParameterNames();
		
		while (en.hasMoreElements()){
			String key = en.nextElement();
			String [] values = request.getParameterValues(key);
			if(values.length == 1 ){
				paramMap.put(key, values[0]);
			} else {
				paramMap.put(key, values);
			}
		}
		request.setAttribute("paramMap", paramMap);
		
		Map<String, Object> newParamMap = new HashMap<String, Object>(paramMap);
		request.setAttribute("paramMap", newParamMap);
		
		return paramMap;
    }
}