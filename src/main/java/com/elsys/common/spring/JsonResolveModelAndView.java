package com.elsys.common.spring;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

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
 * com.nc.common.spring : JsonResolveModelAndView.java
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
 *  2016. 10. 12.          creme55         최초 생성 (JSON Resolve 정의)                  
 *
 * </pre>
 **/
public class JsonResolveModelAndView implements ModelAndViewResolver {
	
	private View jsonView;
	private String jsonExtension;

	public void setJsonView(View jsonView) {
		this.jsonView = jsonView;
	}

	public void setJsonExtension(String jsonExtension) {
		this.jsonExtension = jsonExtension;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ModelAndView resolveModelAndView(Method handlerMethod,
			Class handlerType, Object returnValue,
			ExtendedModelMap implicitModel, NativeWebRequest webRequest) {
		if(returnValue == null) {
			HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
			if(JsonUtils.isJsonAccept(request) || JsonUtils.isJsonExtension(request,jsonExtension)){
				ModelAndView mv = new ModelAndView(jsonView);
				mv.addAllObjects(implicitModel);
				return mv;
			}
		} else if(returnValue instanceof Map || returnValue instanceof List) {
			HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
			if(JsonUtils.isJsonAccept(request) || JsonUtils.isJsonExtension(request,jsonExtension)){
				ModelAndView mv = new ModelAndView(jsonView);
				mv.addAllObjects(implicitModel);
				return mv;
			}
		}
		return UNRESOLVED;
	}
}