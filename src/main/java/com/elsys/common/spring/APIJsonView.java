package com.elsys.common.spring;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.servlet.View;

import com.elsys.common.constants.APIConstants;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

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
 * com.nc.common.spring : APIJsonView.java
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
 *  2016. 10. 12.          creme55         최초 생성(JSON 랜더링 정의)
 *
 * </pre>
 **/
public class APIJsonView implements View {

	private static final Logger log = LoggerFactory.getLogger(APIJsonView.class);
	
	public static final String DEFAULT_CONTENT_TYPE = "application/json";
	private String contentType = DEFAULT_CONTENT_TYPE;
	private ObjectMapper objectMapper = new ObjectMapper();
	private JsonEncoding encoding = JsonEncoding.UTF8;
	private boolean prefixJson = false;
	private Boolean prettyPrint;

	public APIJsonView() {
		setContentType(DEFAULT_CONTENT_TYPE);
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
		configurePrettyPrint();
	}

	public void setEncoding(JsonEncoding encoding) {
		Assert.notNull(encoding, "'encoding' must not be null");
		this.encoding = encoding;
	}

	public void setPrefixJson(boolean prefixJson) {
		this.prefixJson = prefixJson;
	}

	public void setPrettyPrint(boolean prettyPrint) {
		this.prettyPrint = prettyPrint;
		configurePrettyPrint();
	}

	private void configurePrettyPrint() {
		if (this.prettyPrint != null) {
			this.objectMapper.configure(SerializationFeature.INDENT_OUTPUT, this.prettyPrint);
		}
	}

	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= JsonView Rendering... =");
			log.debug("==========================================================================================");
		}
		
		response.setContentType(getContentType());
		response.setCharacterEncoding(this.encoding.getJavaName());
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
		response.addDateHeader("Expires", 1L);

		LinkedHashMap<String,Object> outValue = new LinkedHashMap<String,Object>();
		if (model.containsKey(APIConstants.ERROR_CODE_KEY.getCode()) || model.containsKey(APIConstants.ERROR_MESSAGE_KEY.getCode())) {
			Map<String, Object> errorMap = new HashMap<String, Object>();
			errorMap.put(APIConstants.ERROR_CODE_KEY.getCode(), model.get(APIConstants.ERROR_CODE_KEY.getCode()));
			errorMap.put(APIConstants.ERROR_MESSAGE_KEY.getCode(), model.get(APIConstants.ERROR_MESSAGE_KEY.getCode()));
			outValue.put(APIConstants.ERROR_KEY.getCode(), errorMap);
			writeContent(response.getOutputStream(), outValue, this.prefixJson);
			return;
		}
		
		outValue.putAll(model);
		writeContent(response.getOutputStream(), outValue, this.prefixJson);
	}

	protected void writeContent(OutputStream stream, Object value, boolean prefixJson) throws IOException {
		JsonGenerator generator = this.objectMapper.getFactory().createGenerator(stream, this.encoding);

		if (this.objectMapper.isEnabled(SerializationFeature.INDENT_OUTPUT)) {
			generator.useDefaultPrettyPrinter();
		}

		if (prefixJson) {
			generator.writeRaw("{} && ");
		}
		
		this.objectMapper.writeTree(generator, this.objectMapper.convertValue(value, JsonNode.class)); //.writeValue(generator, value);
	}
}