package com.elsys.common.spring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

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
 * com.nc.common.spring : CustomRequestMappingHandlerAdapter.java
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
 *  2016. 10. 12.          creme55         최초 생성 (사용자 정의 URI 매핑 핸들러 정의)                  
 *
 * </pre>
 **/
public class CustomRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {

	private static final Logger log = LoggerFactory.getLogger(CustomRequestMappingHandlerAdapter.class);

	private List<HandlerMethodArgumentResolver> preCustomArgumentResolvers;

	public void setPreCustomArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		this.preCustomArgumentResolvers = argumentResolvers;
	}
	public List<HandlerMethodArgumentResolver> getPreCustomArgumentResolvers() {
		return this.preCustomArgumentResolvers;
	}

	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		if (getPreCustomArgumentResolvers() != null) {
			
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("Settings preCustomArgumentResolvers");
				log.debug("==========================================================================================");
			}
			
			ArrayList<HandlerMethodArgumentResolver> list = new ArrayList<HandlerMethodArgumentResolver>();
			list.addAll(getPreCustomArgumentResolvers());
			
			if (getArgumentResolvers() != null){
				/*list.addAll(getArgumentResolvers().getResolvers());*/
				list.addAll(getArgumentResolvers());
			}
			setArgumentResolvers(list);
		}
	}
}
