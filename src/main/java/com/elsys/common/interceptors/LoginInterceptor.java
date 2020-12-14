package com.elsys.common.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.assertj.core.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;


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
 * com.nc.common.interceptors : LoginInterceptor.java
 * @author creme55
 * @since 2016. 11. 8.
 * @version 1.0
 * @see 
 * @Copyright © [2016] By ETRI. All rights reserved.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *      수정일              수정자                  수정내용
 *  -------------        -----------       --------------------------------------------
 *  2016. 11. 8.          creme55          최초 생성 (로그인 관련 정보를 세션에서 체크)
 *
 * </pre>
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("==========================================================================================");
			log.debug("= Login Check now, using the session ..... =");
			log.debug("==========================================================================================");
		}
		
		HttpSession session = request.getSession();
//		Map<?, ?> loginSessionInfo = (Map<?, ?>) session.getAttribute("loginSessionInfo");
		Map<?, ?> loginSessionInfo = (Map<?, ?>) session.getServletContext().getContext("/main").getAttribute("loginSessionInfo");
		
		if (loginSessionInfo == null) {
			String url = null;
			
			if ("GET".equals(request.getMethod())) {
				url = new UrlPathHelper().getRequestUri(request);
				String queryString = request.getQueryString();
				
				if (!Strings.isNullOrEmpty(url)) {
					if (!Strings.isNullOrEmpty(queryString)) {
						url += "?" + queryString;
					}
				}
			} else {
				url = request.getContextPath();
			}
			
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Redirect URL : [{}] =", url);
				log.debug("==========================================================================================");
			}
			
			session.getServletContext().getContext("/main").setAttribute("redirectUrl",url);
			session.setAttribute("redirectUrl", url);
			
			response.sendRedirect(request.getContextPath() + "/login/loginForm.do");
			
			return false;
		}
		
		return true;
	}
}