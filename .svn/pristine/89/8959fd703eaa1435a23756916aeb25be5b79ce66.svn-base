package com.elsys.common.spring;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;

import com.elsys.common.CommonConstants;
import com.elsys.common.constants.APIConstants;

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
 * com.nc.common.spring : APICsvView.java
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
 *  2016. 10. 12.          creme55         최초 생성 (CSV 랜더링 정의)
 *
 * </pre>
 **/
public class APICsvView implements View {
	
	private static final Logger log = LoggerFactory.getLogger(APICsvView.class);
	
	public static final String DEFAULT_CONTENT_TYPE = "text/plain";
	public static final String CSV_KEY = "_csv";
	
	
	private String contentType = DEFAULT_CONTENT_TYPE;
	private String encoding = CommonConstants.DEFAULT_CHARSET;
	

	public APICsvView() {
		setContentType(DEFAULT_CONTENT_TYPE);
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = null;

		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= CsvView Rendering... =");
			log.debug("==========================================================================================");
		}
		
		try {
			response.setContentType(getContentType());
			response.setCharacterEncoding(this.encoding);
			response.addHeader("Pragma", "no-cache");
			response.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
			response.addDateHeader("Expires", 1L);
			
			String output = null;
			if (model.containsKey(APIConstants.ERROR_CODE_KEY.getCode()) || model.containsKey(APIConstants.ERROR_MESSAGE_KEY.getCode())) {
				Map<String, Object> errorMap = new HashMap<String, Object>();
				errorMap.put(APIConstants.ERROR_CODE_KEY.getCode(), model.get(APIConstants.ERROR_CODE_KEY.getCode()));
				errorMap.put(APIConstants.ERROR_MESSAGE_KEY.getCode(), model.get(APIConstants.ERROR_MESSAGE_KEY.getCode()));
				
				output = new StringBuffer()
				.append(APIConstants.ERROR_CODE_KEY.getCode()).append(",")
				.append(model.get(APIConstants.ERROR_CODE_KEY.getCode())).append(",")
				.append(APIConstants.ERROR_MESSAGE_KEY.getCode()).append(",")
				.append(model.get(APIConstants.ERROR_MESSAGE_KEY.getCode())).toString();
			} else {
				output = String.valueOf(model.get(CSV_KEY));
			}
			
			out = response.getWriter();
			out.print(output);
			
			out.flush();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}