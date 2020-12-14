package com.elsys.common.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.elsys.common.constants.APIConstants;
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
 * com.nc.common.spring : CustomExceptionResolver.java
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
 *  2016. 10. 12.          creme55         최초 생성 (사용자 정의 예외처리 Resolver 정의)
 *
 * </pre>
 **/
public class CustomExceptionResolver extends AbstractHandlerExceptionResolver {

	private static final Logger log = LoggerFactory.getLogger(CustomExceptionResolver.class);

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
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		if (shouldApplyTo(request, handler)) {
			logException(ex, request);
			prepareResponse(ex, response);
			return doResolveException(request, response, handler, ex);
		} else {
			return null;
		}
	}

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception exception) {

		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= Exception Rendering... =");
			log.debug("==========================================================================================");
		}
		
		if (JsonUtils.isJsonAccept(request) || JsonUtils.isJsonExtension(request, fwkJsonExtension)) {
			String msg = exception.getMessage();
			ModelAndView mv = new ModelAndView(fwkJsonView);
			mv.addObject(FwkJsonView.JSON_STATUS_KEY, -1);
			mv.addObject(FwkJsonView.JSON_MESSAGE_KEY ,msg);
			return mv;
		} else if (JsonUtils.isJsonAccept(request) || JsonUtils.isJsonExtension(request, apiJsonExtension)) {
			String msg = exception.getMessage();
			ModelAndView mv = new ModelAndView(apiJsonView);
			mv.addObject(APIConstants.ERROR_CODE_KEY.getCode(), APIConstants.ERROR_SYSTEM.getCode());
			mv.addObject(APIConstants.ERROR_MESSAGE_KEY.getCode(), msg);
			return mv;
		} else if (XmlUtils.isXmlAccept(request) || XmlUtils.isXmlExtension(request, xmlExtension)) {
			String msg = exception.getMessage();
			ModelAndView mv = new ModelAndView(apiXmlView);
			mv.addObject(APIConstants.ERROR_CODE_KEY.getCode(), APIConstants.ERROR_SYSTEM.getCode());
			mv.addObject(APIConstants.ERROR_MESSAGE_KEY.getCode(),msg);
			return mv;
		} else if (CsvUtils.isCsvAccept(request) || CsvUtils.isCsvExtension(request, csvExtension)) {
			String msg = exception.getMessage();
			ModelAndView mv = new ModelAndView(apiCsvView);
			mv.addObject(APIConstants.ERROR_CODE_KEY.getCode(), APIConstants.ERROR_SYSTEM.getCode());
			mv.addObject(APIConstants.ERROR_MESSAGE_KEY.getCode(),msg);
			return mv;
		}
		
		return null;
	}
}