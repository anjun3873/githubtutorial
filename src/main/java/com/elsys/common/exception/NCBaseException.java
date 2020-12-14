package com.elsys.common.exception;

import java.text.MessageFormat;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

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
 * com.nc.common.exception : NCBaseException.java
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
 *  2016. 10. 12.          creme55         최초 생성 (공통 예외처리)
 *
 * </pre>
 **/
@SuppressWarnings("serial")
public class NCBaseException extends Exception {
	private static final Logger log = LoggerFactory.getLogger(NCBaseException.class);
	
	protected String message = null;
	protected String messageKey = null;
	protected Object[] messageParameters = null;
	protected Exception wrappedException = null;

	public String getMessage() {
		log.debug("Basic Exception...");
		
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageKey() {
		return this.messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public Object[] getMessageParameters() {
		return this.messageParameters;
	}

	public void setMessageParameters(Object[] messageParameters) {
		this.messageParameters = messageParameters;
	}

	public Exception getWrappedException() {
		return this.wrappedException;
	}
	
	public void setWrappedException(Exception wrappedException) {
		this.wrappedException = wrappedException;
	}
	
	public NCBaseException() {
		this("Basic Exception without message", null, null);
	}
	
	public NCBaseException(String defaultMessage)
	{
		this(defaultMessage, null, null);
	}
	
	public NCBaseException(Throwable wrappedException)
	{
		this("Basic Exception without message", null, wrappedException);
	}
	
	public NCBaseException(String defaultMessage, Throwable wrappedException)
	{
		this(defaultMessage, null, wrappedException);
	}

	public NCBaseException(String defaultMessage, Object[] messageParameters, Throwable wrappedException)
	{
		super(wrappedException);
		
		String userMessage = defaultMessage;
		if (messageParameters != null) {
		  userMessage = MessageFormat.format(defaultMessage, messageParameters);
		}
		this.message = userMessage;
	}

	public NCBaseException(MessageSource messageSource, String messageKey)
	{
		this(messageSource, messageKey, null, null, Locale.getDefault(), null);
	}

	public NCBaseException(MessageSource messageSource, String messageKey, Throwable wrappedException)
	{
		this(messageSource, messageKey, null, null, Locale.getDefault(), wrappedException);
	}

	public NCBaseException(MessageSource messageSource, String messageKey, Locale locale, Throwable wrappedException)
	{
		this(messageSource, messageKey, null, null, locale, wrappedException);
	}

	public NCBaseException(MessageSource messageSource, String messageKey, Object[] messageParameters, Locale locale, Throwable wrappedException)
	{
		this(messageSource, messageKey, messageParameters, null, locale, wrappedException);
	}

	public NCBaseException(MessageSource messageSource, String messageKey, Object[] messageParameters, Throwable wrappedException)
	{
		this(messageSource, messageKey, messageParameters, null, Locale.getDefault(), wrappedException);
	}

	public NCBaseException(MessageSource messageSource, String messageKey, Object[] messageParameters, String defaultMessage, Throwable wrappedException)
	{
		this(messageSource, messageKey, messageParameters, defaultMessage, Locale.getDefault(), wrappedException);
	}

	public NCBaseException(MessageSource messageSource, String messageKey, Object[] messageParameters, String defaultMessage, Locale locale, Throwable wrappedException)
	{
		super(wrappedException);
		
		this.messageKey = messageKey;
		this.messageParameters = messageParameters;
		this.message = messageSource.getMessage(messageKey, messageParameters, defaultMessage, locale);
	}
}