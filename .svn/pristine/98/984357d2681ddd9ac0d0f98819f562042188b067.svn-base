package com.elsys.common.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.elsys.common.utils.CsvUtils;
import com.elsys.common.utils.JsonUtils;
import com.elsys.common.utils.XmlUtils;


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
 * com.nc.common.spring : CustomHandlerInterceptorAdapter.java
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
 *  2016. 10. 12.          creme55         최초 생성 (시스템 인터셉트 핸들러 정의, 정의된 타입)                  
 *
 * </pre>
 **/
public class CustomHandlerInterceptorAdapter extends HandlerInterceptorAdapter {
	
	private View fwkJsonView;
	private View apiJsonView;
	private String fwkJsonExtension;
	private String apiJsonExtension;
	private View apiXmlView;
	private String xmlExtension;
	private View apiCsvView;
	private String csvExtension;
	
	
	public void setFwkJsonView(View fwkJsonView) {
		this.fwkJsonView = fwkJsonView;
	}

	public void setApiJsonView(View apiJsonView) {
		this.apiJsonView = apiJsonView;
	}

	public void setFwkJsonExtension(String fwkJsonExtension) {
		this.fwkJsonExtension = fwkJsonExtension;
	}

	public void setApiJsonExtension(String apiJsonExtension) {
		this.apiJsonExtension = apiJsonExtension;
	}

	public void setApiXmlView(View apiXmlView) {
		this.apiXmlView = apiXmlView;
	}

	public void setXmlExtension(String xmlExtension) {
		this.xmlExtension = xmlExtension;
	}
	
	public void setApiCsvView(View apiCsvView) {
		this.apiCsvView = apiCsvView;
	}

	public void setCsvExtension(String csvExtension) {
		this.csvExtension = csvExtension;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if (JsonUtils.isJsonAccept(request) || JsonUtils.isJsonExtension(request, fwkJsonExtension)) {
			modelAndView.setView(fwkJsonView);
		}/* else if (JsonUtils.isJsonAccept(request) || JsonUtils.isJsonExtension(request, apiJsonExtension)) {
			modelAndView.setView(apiJsonView);
		}*/ else if (XmlUtils.isXmlAccept(request) || XmlUtils.isXmlExtension(request, xmlExtension)) {
			modelAndView.setView(apiXmlView);
		} else if (CsvUtils.isCsvAccept(request) || CsvUtils.isCsvExtension(request, csvExtension)) {
			modelAndView.setView(apiCsvView);
		}
	}
}