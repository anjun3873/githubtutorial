package com.elsys.common.tags;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.Strings;

import com.elsys.common.CommonConstants;



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
 * com.nc.common.tags : TagUtility.java
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
 *  2016. 10. 12.          creme55         최초 생성 (HTML Tag 관련 유틸리티)                  
 *
 * </pre>
 **/
public class TagUtility {
	/**
	 * <pre>
	 * 1. 개요 : URL Encoding
	 * 2. 처리내용 : 주어진 URL 인코딩 처리
	 * </pre>
	
	 * @method Name : encode
	 * @param input 
	 * @return String
	 * @throws Exception
	 * 
	 */
	public static String encode(String input) throws Exception {
		return URLEncoder.encode(input, CommonConstants.DEFAULT_CHARSET);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : URL encoding
	 * 2. 처리내용 : 주어진 URL과 문자셋을 통한 인코딩
	 * </pre>
	
	 * @method Name : encode
	 * @param input, charset 
	 * @return String 
	 * @throws Exception
	 * 
	 */
	public static String encode(String input, String charset) throws Exception {
		return URLEncoder.encode(input, charset);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : URL Decoding 
	 * 2. 처리내용 : 주어진 URL에 대한 디코딩
	 * </pre>
	
	 * @method Name : decode
	 * @param input
	 * @return String
	 * @throws Exception
	 * 
	 */
	public static String decode(String input) throws Exception {
		return URLDecoder.decode(input, CommonConstants.DEFAULT_CHARSET);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : URL 디코딩 
	 * 2. 처리내용 : 주어진 URL과 문자셋을 통한 디코딩
	 * </pre>
	
	 * @method Name : decode
	 * @param input, charset 
	 * @return String
	 * @throws Ecxeption
	 * 
	 */
	public static String decode(String input, String charset) throws Exception {
		return URLDecoder.decode(input, charset);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 문자열 추출 
	 * 2. 처리내용 : 바이트로 문자열 자르기
	 * </pre>
	
	 * @method Name : subByte
	 * @param szText, nLength
	 * @return String
	 * @throws Exception
	 * 
	 */
	public static String subByte(String szText, int nLength) throws Exception {
		String r_val = szText;
		int oF = 0, oL = 0, rF = 0, rL = 0;
		int nLengthPrev = 0;
		byte[] bytes = r_val.getBytes(CommonConstants.DEFAULT_CHARSET);

		int byteLen = bytes.length;
		int j = 0;
		if (nLengthPrev > 0) {
			while (j < byteLen) {
				if ((bytes[j] & 0x80) != 0) {
					oF += 2;
					rF += 3;
					if (oF + 2 > nLengthPrev) {
						break;
					}
					j += 3;
				} else {
					if (oF + 1 > nLengthPrev) {
						break;
					}
					++oF;
					++rF;
					++j;
				}
			}
			j = rF;
		}
		
		while (j < byteLen) {
			if ((bytes[j] & 0x80) != 0) {
				if (oL + 2 > nLength) {
					break;
				}
				oL += 2;
				rL += 3;
				j += 3;
			} else {
				if (oL + 1 > nLength) {
					break;
				}
				++oL;
				++rL;
				++j;
			}
		}
		
		r_val = new String(bytes, rF, rL, CommonConstants.DEFAULT_CHARSET);

		return r_val;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 문자열 추출 
	 * 2. 처리내용 : 바이트로 문자열 자르기(말줄임 변수 추가)
	 * </pre>
	
	 * @method Name : subByteTail
	 * @param szText, nLength
	 * @return String
	 * @throws Exception
	 * 
	 */
	public static String subByteTail(String szText, int nLength, String tail) throws Exception {
		String r_val = szText;
		int oF = 0, oL = 0, rF = 0, rL = 0;
		int nLengthPrev = 0;
		byte[] bytes = r_val.getBytes(CommonConstants.DEFAULT_CHARSET);

		int byteLen = bytes.length;
		int j = 0;
		if (nLengthPrev > 0) {
			while (j < byteLen) {
				if ((bytes[j] & 0x80) != 0) {
					oF += 2;
					rF += 3;
					if (oF + 2 > nLengthPrev) {
						break;
					}
					j += 3;
				} else {
					if (oF + 1 > nLengthPrev) {
						break;
					}
					++oF;
					++rF;
					++j;
				}
			}
			j = rF;
		}
		
		while (j < byteLen) {
			if ((bytes[j] & 0x80) != 0) {
				if (oL + 2 > nLength) {
					break;
				}
				oL += 2;
				rL += 3;
				j += 3;
			} else {
				if (oL + 1 > nLength) {
					break;
				}
				++oL;
				++rL;
				++j;
			}
		}
		
		r_val = new String(bytes, rF, rL, CommonConstants.DEFAULT_CHARSET);
		
		//System.out.println("cnt: !!!!!!!!!    oL:  " + oL + "     nLength:  "+ nLength);
		
		if(nLength <= oL ) {
			r_val = r_val + tail;
		}
		
		return r_val;
	}	

	/**
	 * <pre>
	 * 1. 개요 : 문자열 변환 
	 * 2. 처리내용 : 문자열을 숫자로 변환
	 * </pre>
	
	 * @method Name : parseInt
	 * @param str
	 * @return integer
	 * @throws Exception
	 * 
	 */
	public static int parseInt(String str) throws Exception {
		return Integer.parseInt(str);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 문자열 변환 
	 * 2. 처리내용 : 문자열을 실수로 변환
	 * </pre>
	
	 * @method Name : parseFloat
	 * @param str
	 * @return float
	 * @throws Exception
	 * 
	 */
	public static float parseFloat(String str) throws Exception {
		return Float.parseFloat(str);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 문자열 분리 
	 * 2. 처리내용 : 문자열을 주어진 구분자로 분리한 후 해당된 위치의 문자 반환
	 * </pre>
	
	 * @method Name : split
	 * @param str, gubun, idx
	 * @return String
	 * @throws Exception
	 * 
	 */
	public static String split(String str, String gubun, int idx) throws Exception {		
		if(Strings.isNullOrEmpty(str)) {
			return "";
		}		
		String[] strArray = str.split(gubun);		
		return strArray[idx];
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 문자열 비교
	 * 2. 처리내용 : 주어진 요청 URL에서 특정 위치에 있는 값을 비교
	 * </pre>
	
	 * @method Name : uriStartsMatch
	 * @param request, path
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public static boolean uriStartsMatch(HttpServletRequest request, String path) throws Exception {
		String url = (String)request.getAttribute("javax.servlet.forward.request_uri");
		String contextPath = request.getContextPath();
		if(Strings.isNullOrEmpty(url) || Objects.equals(url, contextPath + "/")) {
			url = request.getRequestURI();
		}
		if(!Strings.isNullOrEmpty(url)) {
			if(url.startsWith(contextPath + path)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * \n 문자를 <br/> 태그로 교체
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	/**
	 * <pre>
	 * 1. 개요 : 문자 치환
	 * 2. 처리내용 : 개행문자를 '<br />' 태그로 변환
	 * </pre>
	
	 * @method Name : nl2br
	 * @param input
	 * @return String
	 * @throws Exception
	 * 
	 */
	public static String nl2br(String input) throws Exception {
		if(input == null || input.length() < 1) {
			return input;
		}
		return input.replaceAll("(\r)?\n", "<br />");
	}
}