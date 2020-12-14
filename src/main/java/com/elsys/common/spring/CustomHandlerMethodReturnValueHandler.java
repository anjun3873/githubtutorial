package com.elsys.common.spring;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.View;

import com.elsys.common.utils.JsonUtils;


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
 * com.nc.common.spring : CustomHandlerMethodReturnValueHandler.java
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
 *  2016. 10. 12.          creme55         최초 생성 (사용자 정의 실행 결과 핸들러 정의)                  
 *
 * </pre>
 **/
public class CustomHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

	private View jsonView;
	private String jsonExtension;

	public void setJsonView(View jsonView) {
		this.jsonView = jsonView;
	}
	public void setJsonExtension(String jsonExtension) {
		this.jsonExtension = jsonExtension;
	}

	public boolean supportsReturnType(MethodParameter returnType) {
		/*Class<?> paramType = returnType.getParameterType();
		return void.class.equals(paramType);*/
		return true;
	}

	public void handleReturnValue(Object returnValue,MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
		if(returnValue == null){
			HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
			if(JsonUtils.isJsonAccept(request) || JsonUtils.isJsonExtension(request,jsonExtension)){
				mavContainer.setView(jsonView);
				return;
			}
		} else if(returnValue instanceof Map || returnValue instanceof List) {
			HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
			if(JsonUtils.isJsonAccept(request) || JsonUtils.isJsonExtension(request,jsonExtension)){
				mavContainer.setView(jsonView);
				return;
			}
		}
	}
}