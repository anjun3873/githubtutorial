package com.elsys.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Pattern;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * com.nc.common.utils : StringUtil.java
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
 *  2016. 10. 12.          creme55         최초 생성(문자열 관리 유틸리티)              
 *
 * </pre>
 **/
@SuppressWarnings("serial")
public class StringUtil extends Exception {
	private static final Logger log = LoggerFactory.getLogger(StringUtil.class);
	
	public static final String EMPTY = "";
	private static final int PAD_LIMIT = 8192;
	private static final String[] PADDING = new String[Character.MAX_VALUE];
	
	public StringUtil() {
		super("StringUtil");
	}
	
	static {
		// space padding 은 일반적으로 64바이트로 시작합니다.
		PADDING[32] = "                                                                ";
	}
	
    /**
     * <pre>
     * 1. 개요 : 특정 문자열이 empty 상태인지 검사함. empty 상태인 경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isEmpty(null)      = true  
     *    StringUtil.isEmpty(&quot;&quot;)        = true  
     *    StringUtil.isEmpty(&quot; &quot;)       = false 
     *    StringUtil.isEmpty(&quot;bob&quot;)     = false 
     *    StringUtil.isEmpty(&quot;  bob  &quot;) = false 
     * </pre>
    
     * @method Name : isEmpty
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열이 empty 상태가 아닌지 검사함 empty 상태가 아닌 경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isNotEmpty(null)      = false
     *    StringUtil.isNotEmpty(&quot;&quot;)        = false
     *    StringUtil.isNotEmpty(&quot; &quot;)       = true
     *    StringUtil.isNotEmpty(&quot;bob&quot;)     = true
     *    StringUtil.isNotEmpty(&quot;  bob  &quot;) = true
     * </pre>
    
     * @method Name : isNotEmpty
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isNotEmpty(String str) {
        return (str != null && str.length() > 0);
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열이 space 또는 empty("") 또는 null인지 검사함 SPACE 또는 empty("") 또는 null인 경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isBlank(null)      = true
     *    StringUtil.isBlank(&quot;&quot;)        = true
     *    StringUtil.isBlank(&quot; &quot;)       = true
     *    StringUtil.isBlank(&quot;bob&quot;)     = false
     *    StringUtil.isBlank(&quot;  bob  &quot;) = false
     * </pre>
    
     * @method Name : isBlank
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열이 space 또는 empty("") 또는 null이 아닌지 검사함 space, empty("") 그리고 null인 아닌경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isNotBlank(null)      = false
     *    StringUtil.isNotBlank(&quot;&quot;)        = false
     *    StringUtil.isNotBlank(&quot; &quot;)       = false
     *    StringUtil.isNotBlank(&quot;bob&quot;)     = true
     *    StringUtil.isNotBlank(&quot;  bob  &quot;) = true
     * </pre>
    
     * @method Name : isNotBlank
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isNotBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return false;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽끝에서부터 space를 제거한 문자열을 리턴한다. 문자열이 null인 경우 empty("")를 return한다.
     * 2. 처리내용 : 
     *    StringUtil.clean(null)            = &quot;&quot;
     *    StringUtil.clean(&quot;&quot;)    = &quot;&quot;
     *    StringUtil.clean(&quot;abc&quot;) = &quot;abc&quot;
     *    StringUtil.clean(&quot;    abc    &quot;) = &quot;abc&quot;
     *    StringUtil.clean(&quot;     &quot;)       = &quot;&quot;
     * </pre>
    
     * @method Name : clean
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String clean(String str) {
        return (str == null ? EMPTY : str.trim());
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽끝에서부터 space를 제거한 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.trim(null)          = null
     *    StringUtil.trim(&quot;&quot;)            = &quot;&quot;
     *    StringUtil.trim(&quot;     &quot;)       = &quot;&quot;
     *    StringUtil.trim(&quot;abc&quot;)         = &quot;abc&quot;
     *    StringUtil.trim(&quot;    abc    &quot;) = &quot;abc&quot;
     * </pre>
    
     * @method Name : trim
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String trim(String str) {
        return (str == null ? null : str.trim());
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽끝에서부터 space를 제거한 문자열을 리턴한다. space를 제거한 문자열이 empty("")인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.trimToNull(null)          = null
     *    StringUtil.trimToNull(&quot;&quot;)            = null
     *    StringUtil.trimToNull(&quot;     &quot;)       = null
     *    StringUtil.trimToNull(&quot;abc&quot;)         = &quot;abc&quot;
     *    StringUtil.trimToNull(&quot;    abc    &quot;) = &quot;abc&quot;
     * </pre>
    
     * @method Name : trimToNull
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String trimToNull(String str) {
        String ts = trim(str);
        return (ts == null || ts.length() == 0 ? null : ts);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽끝에서부터 space를 제거한 문자열을 리턴한다. 특정문자열이 null인 경우 empty("")를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.trimToEmpty(null)          = &quot;&quot;
     *    StringUtil.trimToEmpty(&quot;&quot;)            = &quot;&quot;
     *    StringUtil.trimToEmpty(&quot;     &quot;)       = &quot;&quot;
     *    StringUtil.trimToEmpty(&quot;abc&quot;)         = &quot;abc&quot;
     *    StringUtil.trimToEmpty(&quot;    abc    &quot;) = &quot;abc&quot;
     * </pre>
    
     * @method Name : trimToEmpty
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String trimToEmpty(String str) {
        return (str == null ? EMPTY : str.trim());
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽끝에서부터 space를 제거한 문자열을 리턴한다. 그러나 문자열 사이에 있는 space른 제거하지 않는다. 특정문자열이 null인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.strip(null)     = null
     *    StringUtil.strip(&quot;&quot;)       = &quot;&quot;
     *    StringUtil.strip(&quot;   &quot;)    = &quot;&quot;
     *    StringUtil.strip(&quot;abc&quot;)    = &quot;abc&quot;
     *    StringUtil.strip(&quot;  abc&quot;)  = &quot;abc&quot;
     *    StringUtil.strip(&quot;abc  &quot;)  = &quot;abc&quot;
     *    StringUtil.strip(&quot; abc &quot;)  = &quot;abc&quot;
     *    StringUtil.strip(&quot; ab c &quot;) = &quot;ab c&quot;
     * </pre>
    
     * @method Name : strip
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String strip(String str) {
        return strip(str, null);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽끝에서부터 space를 제거한 문자열을 리턴한다. 그러나 문자열 사이에 있는 space를 제거하지 않는다. 특정문자열이 null인 경우 null을 리턴한다. space를 제거한 문자열이 empty("")인 경우 null를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.stripToNull(null)     = null
     *    StringUtil.stripToNull(&quot;&quot;)       = null
     *    StringUtil.stripToNull(&quot;   &quot;)    = null
     *    StringUtil.stripToNull(&quot;abc&quot;)    = &quot;abc&quot;
     *    StringUtil.stripToNull(&quot;  abc&quot;)  = &quot;abc&quot;
     *    StringUtil.stripToNull(&quot;abc  &quot;)  = &quot;abc&quot;
     *    StringUtil.stripToNull(&quot; abc &quot;)  = &quot;abc&quot;
     *    StringUtil.stripToNull(&quot; ab c &quot;) = &quot;ab c&quot;
     * </pre>
    
     * @method Name : stripToNull
     * @param 
     * @return 
     * @throws
     * 
     */
    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        str = strip(str, null);
        return (str.length() == 0 ? null : str);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽끝에서부터 space를 제거한 문자열을 리턴한다. 그러나 문자열 사이에 있는 space를 제거하지 않는다. 특정문자열이 null인 경우 empty("")를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.stripToEmpty(null) = &quot;&quot;
     *    StringUtil.stripToEmpty(&quot;&quot;)   = &quot;&quot;
     *    StringUtil.strip(&quot;   &quot;)       = &quot;&quot;
     *    StringUtil.strip(&quot;abc&quot;)       = &quot;abc&quot;
     *    StringUtil.strip(&quot;  abc&quot;)     = &quot;abc&quot;
     *    StringUtil.strip(&quot;abc  &quot;)     = &quot;abc&quot;
     *    StringUtil.strip(&quot; abc &quot;)     = &quot;abc&quot;
     *    StringUtil.strip(&quot; ab c &quot;)    = &quot;ab c&quot;
     * </pre>
    
     * @method Name : stripToEmpty
     * @param str
     * @return String
     * @throws none
     * 
     */
    public static String stripToEmpty(String str) {
        return (str == null ? EMPTY : strip(str, null));
    }

    /**
     * <pre>
     * 1. 개요 : 파라메터로 들어온 스트링이 널이면 빈 문자열로 변환해 줍니다.
     * 2. 처리내용 : 
     * StringUtil.nvl(null) = &quot;&quot;
     * </pre>
    
     * @method Name : nvl
     * @param str
     * @return String
     * @throws none
     * 
     */
    public static String nvl(String str) {
        return (str == null || "null".equals(str)) ? "" : str;
    }
    
    /**
     * <pre>
     * 1. 개요 : 문자열에 대한 NULL 처리
     * 2. 처리내용 : NULL인 문자열을 빈 공란으로 처리한 후 리턴
     * </pre>
    
     * @method Name : nvl
     * @param object
     * @return String
     * @throws null
     * 
     */
    public static String nvl(Object object)
    {
        String string = "";
        if (object != null)
            string = object.toString().trim();
        return string;
    }    
    
    /**
     * <pre>
     * 1. 개요 : 문자열에 대한 NULL 처리
     * 2. 처리내용 : 문자열에 대한 NULL을 주어진 문자로 대체
     * </pre>
    
     * @method Name : nvl
     * @param object, str
     * @return String
     * @throws none
     * 
     */
    public static String nvl(Object object, String str)
    {
        String string = "";
        try
        {
            if (object != null) {
            	if (!object.toString().equals("")) {
            		string = object.toString().trim();
            	} else {
            		string = str;
            	}
            } else {
                string = str;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return string;
    }    
    
    /**
     * <pre>
     * 1. 개요 : 파라메터로 들어온 스트링이 널이면 다른 문자열로 대체한다.
     * 2. 처리내용 : 
     * StringUtil.nvl(null) = &quot;&quot;
     * </pre>
    
     * @method Name : nvl
     * @param str, nullString 
     * @return String
     * @throws none
     * 
     */
    public static String nvl(String str, String nullString) {
        return (str == null || "null".equals(str)) ? nullString : str;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽끝에서부터 제거대상문자열에 속해있는 문자를 제거한 문자열을 리턴한다. 특정문자열이 null인 경우 null을 리턴한다. 특정문자열이 empty("")인 경우 empty("")를 리턴한다. 제거대상문자열이 null이더라도 특정문자열의 양쪽끝에서 space를 제거한다.
     * 2. 처리내용 : 
     *    StringUtil.strip(null, *)          = null
     *    StringUtil.strip(&quot;&quot;, *)            = &quot;&quot;
     *    StringUtil.strip(&quot;abc&quot;, null)      = &quot;abc&quot;
     *    StringUtil.strip(&quot;  abc&quot;, null)    = &quot;abc&quot;
     *    StringUtil.strip(&quot;abc  &quot;, null)    = &quot;abc&quot;
     *    StringUtil.strip(&quot; abc &quot;, null)    = &quot;abc&quot;
     *    StringUtil.strip(&quot;  abcyx&quot;, &quot;xyz&quot;) = &quot;  abc&quot;
     * </pre>
    
     * @method Name : strip
     * @param str, stripChars 
     * @return 
     * @throws
     * 
     */
    public static String strip(String str, String stripChars) {
        if (str == null || str.length() == 0) {
            return str;
        }
        str = stripStart(str, stripChars);
        return stripEnd(str, stripChars);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 시작부에서 부터 제거대상문자열에 속해있는 문자를 제거한 문자열을 리턴한다. 특정문자열이 null인 경우 null을 리턴한다. 특정문자열이 empty("")인 경우 empty("")를 리턴한다. 제거대상문자열이 null이더라도 특정문자열의 시작부에서 부터 space를 제거한다. 
     * 2. 처리내용 : 
     *    StringUtil.stripStart(null, *)          = null
     *    StringUtil.stripStart(&quot;&quot;, *)            = &quot;&quot;
     *    StringUtil.stripStart(&quot;abc&quot;, &quot;&quot;)        = &quot;abc&quot;
     *    StringUtil.stripStart(&quot;abc&quot;, null)      = &quot;abc&quot;
     *    StringUtil.stripStart(&quot;  abc&quot;, null)    = &quot;abc&quot;
     *    StringUtil.stripStart(&quot;abc  &quot;, null)    = &quot;abc  &quot;
     *    StringUtil.stripStart(&quot; abc &quot;, null)    = &quot;abc &quot;
     *    StringUtil.stripStart(&quot;yxabc  &quot;, &quot;xyz&quot;) = &quot;abc  &quot;
     * </pre>
    
     * @method Name : stripStart
     * @param str, stripChars 
     * @return String
     * @throws none
     * 
     */
    public static String stripStart(String str, String stripChars) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        int start = 0;
        if (stripChars == null) {
            while ((start != strLen) && Character.isWhitespace(str.charAt(start))) {
                start++;
            }
        } else if (stripChars.length() == 0) {
            return str;
        } else {
            while ((start != strLen) && (stripChars.indexOf(str.charAt(start)) != -1)) {
                start++;
            }
        }
        return str.substring(start);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 끝부분에서 부터 제거대상문자열에 속한 문자를 제거한 문자열을 리턴한다. 특정문자열이 null인 경우 null을 리턴한다. 특정문자열이 empty("")인 경우 empty("")를 리턴한다. 제거대상문자열이null이더라도 특정문자열의 끝부분에서 부터 space를 제거한다. 
     * 2. 처리내용 : 
     *    StringUtil.stripEnd(null, *)          = null
     *    StringUtil.stripEnd(&quot;&quot;, *)            = &quot;&quot;
     *    StringUtil.stripEnd(&quot;abc&quot;, &quot;&quot;)        = &quot;abc&quot;
     *    StringUtil.stripEnd(&quot;abc&quot;, null)      = &quot;abc&quot;
     *    StringUtil.stripEnd(&quot;  abc&quot;, null)    = &quot;  abc&quot;
     *    StringUtil.stripEnd(&quot;abc  &quot;, null)    = &quot;abc&quot;
     *    StringUtil.stripEnd(&quot; abc &quot;, null)    = &quot; abc&quot;
     *    StringUtil.stripEnd(&quot;  abcyx&quot;, &quot;xyz&quot;) = &quot;  abc&quot;
     * </pre>
    
     * @method Name : stripEnd
     * @param 
     * @return 
     * @throws
     * 
     */
    public static String stripEnd(String str, String stripChars) {
        int end;
        if (str == null || (end = str.length()) == 0) {
            return str;
        }

        if (stripChars == null) {
            while ((end != 0) && Character.isWhitespace(str.charAt(end - 1))) {
                end--;
            }
        } else if (stripChars.length() == 0) {
            return str;
        } else {
            while ((end != 0) && (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
                end--;
            }
        }
        return str.substring(0, end);
    }

    /**
     * <pre>
     * 1. 개요 : 문자열 배열의 모든 문자열의 양쪽끝에서부터 space를 제거한 후 문자열 배열을 리턴한다. 문자열 배열이 null인 경우 null을 리턴한다. empty 배열인 경우 empty배열을 리턴한다. 배열의 문자열이 null인 경우 처리하지 않는다. 
     * 2. 처리내용 : 
     *    StringUtil.stripAll(null)             = null
     *    StringUtil.stripAll([])               = []
     *    StringUtil.stripAll([&quot;abc&quot;, &quot;  abc&quot;]) = [&quot;abc&quot;, &quot;abc&quot;]
     *    StringUtil.stripAll([&quot;abc  &quot;, null])  = [&quot;abc&quot;, null]
     * </pre>
    
     * @method Name : stripAll
     * @param strs
     * @return String[] 
     * @throws none
     * 
     */
    public static String[] stripAll(String[] strs) {
        return stripAll(strs, null);
    }

    /**
     * <pre>
     * 1. 개요 : 문자열 배열의 모든 문자열의 양쪽끝에서부터 제거대상문자열에 속한 문자를 제거한 후 문자열 배열을 리턴한다. 문자열 배열이 null인 경우 null을 리턴한다. empty 배열인 경우 empty 배열을 리턴한다.제거대상문자열이 null이면 배열의 문자열에서 space를 제거한다. 배열의 문자열이 null인 경우 처리 하지 않는다. 
     * 2. 처리내용 : 
     *    StringUtil.stripAll(null, *)                = null
     *    StringUtil.stripAll([], *)                  = []
     *    StringUtil.stripAll([&quot;abc&quot;, &quot;  abc&quot;], null) = [&quot;abc&quot;, &quot;abc&quot;]
     *    StringUtil.stripAll([&quot;abc  &quot;, null], null)  = [&quot;abc&quot;, null]
     *    StringUtil.stripAll([&quot;abc  &quot;, null], &quot;yz&quot;)  = [&quot;abc  &quot;, null]
     *    StringUtil.stripAll([&quot;yabcz&quot;, null], &quot;yz&quot;)  = [&quot;abc&quot;, null]
     * </pre>
    
     * @method Name : stripAll
     * @param strs, stripsChars 
     * @return String[]
     * @throws none
     * 
     */
    public static String[] stripAll(String[] strs, String stripChars) {
        int strsLen;
        if (strs == null || (strsLen = strs.length) == 0) {
            return strs;
        }
        String[] newArr = new String[strsLen];
        for (int i = 0; i < strsLen; i++) {
            newArr[i] = strip(strs[i], stripChars);
        }
        return newArr;
    }

    /**
     * <pre>
     * 1. 개요 : 두 문자열을 비교하여 두 문자열이 동일한 경우 true를 리턴한다. 두 문자열이 모두 null인 경우 true를 리턴한다. null이 아닌 문자열과 null문자열을 비교하는 경우 false를 리턴한다. 대소문자를 구별하여 비교한다.
     * 2. 처리내용 : 
     *    StringUtil.equals(null, null)   = true
     *    StringUtil.equals(null, &quot;abc&quot;)  = false
     *    StringUtil.equals(&quot;abc&quot;, null)  = false
     *    StringUtil.equals(&quot;abc&quot;, &quot;abc&quot;) = true
     *    StringUtil.equals(&quot;abc&quot;, &quot;ABC&quot;) = false
     * </pre>
    
     * @method Name : equals
     * @param str1, str2 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean equals(String str1, String str2) {
        return (str1 == null ? str2 == null : str1.equals(str2));
    }

    /**
     * <pre>
     * 1. 개요 : 두문자열을 비교하여 두문자열이 동일한 경우 true를 리턴한다. 대소문자를 구분하지 않는다. 두 문자열이 모두 null인 경우 true를 리턴한다. null이 아닌 문자열과 null문자열을 비교하는 경우 false를 리턴한다. 
     * 2. 처리내용 : 
     *    StringUtil.equalsIgnoreCase(null, null)   = true
     *    StringUtil.equalsIgnoreCase(null, &quot;abc&quot;)  = false
     *    StringUtil.equalsIgnoreCase(&quot;abc&quot;, null)  = false
     *    StringUtil.equalsIgnoreCase(&quot;abc&quot;, &quot;abc&quot;) = true
     *    StringUtil.equalsIgnoreCase(&quot;abc&quot;, &quot;ABC&quot;) = true
     * </pre>
    
     * @method Name : equalsIgnoreCase
     * @param str1, str2
     * @return boolean
     * @throws none
     * 
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        return (str1 == null ? str2 == null : str1.equalsIgnoreCase(str2));
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 특정문자(searchChar)가 있는 첫번째 위치를 리턴한다. 특정문자가 문자열에 없는 경우 -1을 리턴한다. 문자열이 null이거나 empty인 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다.
     * 2. 처리내용 : 
     *    StringUtil.indexOf(null, *)         = -1
     *    StringUtil.indexOf(&quot;&quot;, *)           = -1
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, 'a') = 0
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, 'b') = 2
     * </pre>
    
     * @method Name : indexOf
     * @param str, searchChar 
     * @return int
     * @throws none
     * 
     */
    public static int indexOf(String str, char searchChar) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        return str.indexOf(searchChar);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 시작위치에서부터 시작하여 특정문자가 있는 첫번째 위치를 리턴한다. 특정문자열이 null이거나 empty("")인 경우 -1을 리턴한다. 특정문자가 문자열에 없는 경우 -1을 리턴한다. 시작위치가 0보다
     * 			작은 경우 시작위치는 0으로 간주된다. 시작위치가 문자열의 길이보다 큰 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다.
     * 2. 처리내용 : 
     *    StringUtil.indexOf(null, *, *)          = -1
     *    StringUtil.indexOf(&quot;&quot;, *, *)            = -1
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', 0)  = 2
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', 3)  = 5
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', 9)  = -1
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', -1) = 2
     * </pre>
    
     * @method Name : indexOf
     * @param str, searchChar, startPos 
     * @return 
     * @throws
     * 
     */
    public static int indexOf(String str, char searchChar, int startPos) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        return str.indexOf(searchChar, startPos);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 검색 대상 문자열이 시작된는 첫번째 위치를 리턴한다. 특정문자열이 null인 경우, 검색 대상 문자열이 null인 경우 -1을 리턴한다. match되는 문자열이 없는 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다.
     * 2. 처리내용 : 
     *    StringUtil.indexOf(null, *)          = -1
     *    StringUtil.indexOf(*, null)          = -1
     *    StringUtil.indexOf(&quot;&quot;, &quot;&quot;)           = 0
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;a&quot;)  = 0
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;)  = 2
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;ab&quot;) = 1
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;&quot;)   = 0
     * </pre>
    
     * @method Name : indexOf
     * @param str, searchChar 
     * @return int
     * @throws none
     * 
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 시작 위치에서 부터 검색 대상 문자열이 시작된는 첫번째 위치를 리턴한다. 특정문자열이 null인 경우, 검색 대상 문자열이 null인 경우 -1을 리턴한다. match되는 문자열이 없는 경우 -1을
     * 			리턴한다. 시작 위치가 0보다 작은 경우 시작위치는 0으로 간주된다. 검색대상 문자열이 empty("")인 경우 언제나 0을 리턴한다. 특정문자열이 null인 경우, 검색 대상 문자열이 null인 경우 -1을 리턴한다. 시작
     * 			위치가 문자열의 길이보다 큰 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다.
     * 2. 처리내용 : 
     *    StringUtil.indexOf(null, *, *)          = -1
     *    StringUtil.indexOf(*, null, *)          = -1
     *    StringUtil.indexOf(&quot;&quot;, &quot;&quot;, 0)           = 0
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;a&quot;, 0)  = 0
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 0)  = 2
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;ab&quot;, 0) = 1
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 3)  = 5
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 9)  = -1
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, -1) = 2
     *    StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;&quot;, 2)   = 2
     *    StringUtil.indexOf(&quot;abc&quot;, &quot;&quot;, 9)        = 3
     * </pre>
    
     * @method Name : indexOf
     * @param str, searchStr, startOs 
     * @return 
     * @throws
     * 
     */
    public static int indexOf(String str, String searchStr, int startPos) {
        if (str == null || searchStr == null) {
            return -1;
        }

        if (searchStr.length() == 0 && startPos >= str.length()) {
            return str.length();
        }
        return str.indexOf(searchStr, startPos);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 문자가 있는 마지막 위치를 return 한다. 문자열이 null이거나 empty("")인 경우 -1을 리턴한다. match되는 문자가 없는 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다.
     * 2. 처리내용 : 
     *    StringUtil.lastIndexOf(null, *)         = -1
     *    StringUtil.lastIndexOf(&quot;&quot;, *)           = -1
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'a') = 7
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b') = 5
     * </pre>
    
     * @method Name : lastIndexOf
     * @param 
     * @return 
     * @throws
     * 
     */
    public static int lastIndexOf(String str, char searchChar) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        return str.lastIndexOf(searchChar);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 시작 위치에서 부터 주어진 문자가 있는 마지막 위치를 return 한다. 문자열이 null이거나 empty("")인 경우 -1을 리턴한다. 시작 위치가 0보다 작은 경우 -1을 리턴한다. 시작 위치가 문자열의 길이보다 큰 경우 문자열 전체를 search해서 위치를 찾는다. match되는 문자가 없는 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다. 
     * 2. 처리내용 : 
     *    StringUtil.lastIndexOf(null, *, *)          = -1
     *    StringUtil.lastIndexOf(&quot;&quot;, *,  *)           = -1
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b', 8)  = 5
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b', 4)  = 2
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b', 0)  = -1
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b', 9)  = 5
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'b', -1) = -1
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, 'a', 0)  = 0
     * </pre>
    
     * @method Name : lastIndexOf
     * @param str, searchChar, startPos 
     * @return integer
     * @throws none
     * 
     */
    public static int lastIndexOf(String str, char searchChar, int startPos) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        return str.lastIndexOf(searchChar, startPos);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 맨오른쪽으로 부터 검색대상 문자열이 있는 마지막 인텍스를 리턴한다. 문자열이 null이거나 검색 대상 문자열이 null인 경우 -1을 리턴한다. match되는 문자열이 없는 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다.
     * 2. 처리내용 : 
     *    StringUtil.lastIndexOf(null, *)          = -1
     *    StringUtil.lastIndexOf(*, null)          = -1
     *    StringUtil.lastIndexOf(&quot;&quot;, &quot;&quot;)           = 0
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;a&quot;)  = 0
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;)  = 2
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;ab&quot;) = 1
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;&quot;)   = 8
     * </pre>
    
     * @method Name : lastIndexOf
     * @param str, searchChar 
     * @return integer
     * @throws none
     * 
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 시작 위치에서 부터 검색대상 문자열이 있는 마직막 인텍스를 리턴한다.
     * 2. 처리내용 : 문자열이 null이거나, 검색대상 문자열이 null인 경우 -1을 리턴한다. 시작위치가 0보다 작은 경우 -1을 리턴한다. 문자열이 empty("")인 경우는 항상 match unless the start position is negative. 시작 위치가 문자열의 길이보다 큰 경우 문자열 전체를 search 한다. 문자열의 인텍스는 0부터 시작한다.
     *    StringUtil.lastIndexOf(null, *, *)          = -1
     *    StringUtil.lastIndexOf(*, null, *)          = -1
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;a&quot;, 8)  = 7
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 8)  = 5
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;ab&quot;, 8) = 4
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 9)  = 5
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, -1) = -1
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;a&quot;, 0)  = 0
     *    StringUtil.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 0)  = -1
     * </pre>
    
     * @method Name : lastIndexOf
     * @param str, searchChar, startPos
     * @return integer
     * @throws none
     * 
     */
    public static int lastIndexOf(String str, String searchStr, int startPos) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr, startPos);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에 검색대상 문자가 포함되어있는지 검색한다. 검색 대상 문자가 포함되어 있는 경우 true를 리턴한다. 문자열이 null이거나 empty("")인 경우 false를 리턴한다. 문자열의 인텍스는 0부터 시작한다.
     * 2. 처리내용 : 
     *    StringUtil.contains(null, *)    = false
     *    StringUtil.contains(&quot;&quot;, *)      = false
     *    StringUtil.contains(&quot;abc&quot;, 'a') = true
     *    StringUtil.contains(&quot;abc&quot;, 'z') = false
     * </pre>
    
     * @method Name : contains
     * @param str, searchChar
     * @return boolean
     * @throws none
     * 
     */
    public static boolean contains(String str, char searchChar) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return (str.indexOf(searchChar) >= 0);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에 검색대상 문자열이 포함되어있는지 검색한다. 검색 대상 문자열이 포함되어 있는 경우 true를 리턴한다. 문자열이 null이거나 검색대상문자열이 null인 경우 false를 리턴한다. 문자열의 인텍스는 0부터 시작한다.
     * 2. 처리내용 : 
     *    StringUtil.contains(null, *)     = false
     *    StringUtil.contains(*, null)     = false
     *    StringUtil.contains(&quot;&quot;, &quot;&quot;)      = true
     *    StringUtil.contains(&quot;abc&quot;, &quot;&quot;)   = true
     *    StringUtil.contains(&quot;abc&quot;, &quot;a&quot;)  = true
     *    StringUtil.contains(&quot;abc&quot;, &quot;z&quot;)  = false
     * </pre>
    
     * @method Name : contains
     * @param str, searchChar
     * @return boolean
     * @throws none
     * 
     */
    public static boolean contains(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return false;
        }
        return (str.indexOf(searchStr) >= 0);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 검색대상문자배열에 있는 문자가 있는 첫번째 위치를 리턴한다. 문자열이 null이거나, empty인 경우 -1을 리턴한다. 검색대상문자배열이 null이거나 length가 0인 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다.
     * 2. 처리내용 : 
     *    StringUtil.indexOfAny(null, *)                = -1
     *    StringUtil.indexOfAny(&quot;&quot;, *)                  = -1
     *    StringUtil.indexOfAny(*, null)                = -1
     *    StringUtil.indexOfAny(*, [])                  = -1
     *    StringUtil.indexOfAny(&quot;zzabyycdxx&quot;,['z','a']) = 0
     *    StringUtil.indexOfAny(&quot;zzabyycdxx&quot;,['b','y']) = 3
     *    StringUtil.indexOfAny(&quot;aba&quot;, ['z'])           = -1
     * </pre>
    
     * @method Name : indexOfAny
     * @param str searchChars
     * @return integer
     * @throws none
     * 
     */
    public static int indexOfAny(String str, char[] searchChars) {
        if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0) {
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < searchChars.length; j++) {
                if (searchChars[j] == ch) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 검색대상 문자열에있는 문자가 있는 첫번째 위치를 리턴한다. 문자열이 null이거나, length가 0인 경우 -1을 리턴한다. 검색대상문자열이 null이거나, length가 0인 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다.
     * 2. 처리내용 : 
     *    StringUtil.indexOfAny(null, *)            = -1
     *    StringUtil.indexOfAny(&quot;&quot;, *)              = -1
     *    StringUtil.indexOfAny(*, null)            = -1
     *    StringUtil.indexOfAny(*, &quot;&quot;)              = -1
     *    StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, &quot;za&quot;) = 0
     *    StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, &quot;by&quot;) = 3
     *    StringUtil.indexOfAny(&quot;aba&quot;,&quot;z&quot;)          = -1
     * </pre>
    
     * @method Name : indexOfAny
     * @param str, searchChars
     * @return integer
     * @throws none
     * 
     */
    public static int indexOfAny(String str, String searchChars) {
        if (str == null || str.length() == 0 || searchChars == null || searchChars.length() == 0) {
            return -1;
        }
        return indexOfAny(str, searchChars.toCharArray());
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 검색대상 문자 배열에 없는 문자가 있는 첫번째 위치를 리턴한다. 문자열이 null이거나, length가 0인 경우 -1을 리턴한다. 검색대상문자열이 null이거나, length가 0인 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다. 검색 대상 문자 배열에 해당하지 않는 문자가 없는 경우 -1을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.indexOfAnyBut(null, *)           = -1
     *    StringUtil.indexOfAnyBut(&quot;&quot;, *)             = -1
     *    StringUtil.indexOfAnyBut(*, null)           = -1
     *    StringUtil.indexOfAnyBut(*, [])             = -1
     *    StringUtil.indexOfAnyBut(&quot;zzabyycdxx&quot;,'za') = 3
     *    StringUtil.indexOfAnyBut(&quot;zzabyycdxx&quot;, '')  = 0
     *    StringUtil.indexOfAnyBut(&quot;aba&quot;, 'ab')       = -1
     * </pre>
    
     * @method Name : indexOfAnyBut
     * @param str, searchChars 
     * @return integer
     * @throws none
     * 
     */
    public static int indexOfAnyBut(String str, char[] searchChars) {
        if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0) {
            return -1;
        }
        outer: for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < searchChars.length; j++) {
                if (searchChars[j] == ch) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 검색대상 문자열에 없는 문자가 있는 첫번째 위치를 리턴한다. 문자열이 null이거나, length가 0인 경우 -1을 리턴한다. 검색대상문자열이 null이거나, length가 0인 경우 -1을 리턴한다. 문자열의 인텍스는 0부터 시작한다. 검색 대상 문자열에 해당하지 않는 문자가 없는 경우 -1을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.indexOfAnyBut(null, *)            = -1
     *    StringUtil.indexOfAnyBut(&quot;&quot;, *)              = -1
     *    StringUtil.indexOfAnyBut(*, null)            = -1
     *    StringUtil.indexOfAnyBut(*, &quot;&quot;)              = -1
     *    StringUtil.indexOfAnyBut(&quot;zzabyycdxx&quot;, &quot;za&quot;) = 3
     *    StringUtil.indexOfAnyBut(&quot;zzabyycdxx&quot;, &quot;&quot;)   = 0
     *    StringUtil.indexOfAnyBut(&quot;aba&quot;,&quot;ab&quot;)         = -1
     * </pre>
    
     * @method Name : indexOfAnyBut
     * @param str, searchChars 
     * @return integer
     * @throws none
     * 
     */
    public static int indexOfAnyBut(String str, String searchChars) {
        if (str == null || str.length() == 0 || searchChars == null || searchChars.length() == 0) {
            return -1;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (searchChars.indexOf(str.charAt(i)) < 0) {
                return i;
            }
        }
        
        return -1;
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열이 검색 대상 문자 배열에 있는 문자만으로 구성되어있는지 검색해서 검색 대상 문자 배열의 문자만으로 구성된 경우 true를 리턴한다. 문자열이 null이거나, 검색 대상 문자 배열이 null이거나, 검색대상 문자 배열의 length가 0이면 false를 리턴한다. 문자열의 length가 0이면 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.containsOnly(null, *)       = false
     *    StringUtil.containsOnly(*, null)       = false
     *    StringUtil.containsOnly(&quot;&quot;, *)         = true
     *    StringUtil.containsOnly(&quot;ab&quot;, '')      = false
     *    StringUtil.containsOnly(&quot;abab&quot;, 'abc') = true
     *    StringUtil.containsOnly(&quot;ab1&quot;, 'abc')  = false
     *    StringUtil.containsOnly(&quot;abz&quot;, 'abc')  = false
     * </pre>
    
     * @method Name : containsOnly
     * @param str, valid 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean containsOnly(String str, char[] valid) {
        // All these pre-checks are to maintain API with an older version
        if ((valid == null) || (str == null)) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        if (valid.length == 0) {
            return false;
        }
        return indexOfAnyBut(str, valid) == -1;
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열이 검색 대상 문자열에 있는 문자만으로 구성되어있는지 검색해서 검색 대상 문자열의 문자만으로 구성된 경우 true를 리턴한다. 문자열이 null이거나, 검색 대상 문자 배열이 null이거나, 검색대상 문자 배열의 length가 0이면 false를 리턴한다. 문자열의 length가 0이면 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.containsOnly(null, *)       = false
     *    StringUtil.containsOnly(*, null)       = false
     *    StringUtil.containsOnly(&quot;&quot;, *)         = true
     *    StringUtil.containsOnly(&quot;ab&quot;, &quot;&quot;)      = false
     *    StringUtil.containsOnly(&quot;abab&quot;, &quot;abc&quot;) = true
     *    StringUtil.containsOnly(&quot;ab1&quot;, &quot;abc&quot;)  = false
     *    StringUtil.containsOnly(&quot;abz&quot;, &quot;abc&quot;)  = false
     * </pre>
    
     * @method Name : containsOnly
     * @param str, validChars
     * @return boolean
     * @throws none
     * 
     */
    public static boolean containsOnly(String str, String validChars) {
        if (str == null || validChars == null) {
            return false;
        }
        return containsOnly(str, validChars.toCharArray());
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열이 검색 대상 문자 배열에 있는 문자로 구성되어있는지 검색해서 검색 대상 문자 배열의 문자가 하나도 없으면 true를 리턴한다. 문자열이 null이거나, 검색 대상 문자 배열이 null이거나, 문자열이 length가 0이거나, 검색 대상 문자 배열의 length가 0이면 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.containsNone(null, *)       = true
     *    StringUtil.containsNone(*, null)       = true
     *    StringUtil.containsNone(&quot;&quot;, *)         = true
     *    StringUtil.containsNone(&quot;ab&quot;, '')      = true
     *    StringUtil.containsNone(&quot;abab&quot;, 'xyz') = true
     *    StringUtil.containsNone(&quot;ab1&quot;, 'xyz')  = true
     *    StringUtil.containsNone(&quot;abz&quot;, 'xyz')  = false
     * </pre>
    
     * @method Name : containsNone
     * @param str, invalidChars
     * @return boolean
     * @throws none
     * 
     */
    public static boolean containsNone(String str, char[] invalidChars) {
        if (str == null || invalidChars == null) {
            return true;
        }
        int strSize = str.length();
        int validSize = invalidChars.length;
        for (int i = 0; i < strSize; i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < validSize; j++) {
                if (invalidChars[j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열이 검색 대상 문자열에 있는 문자로 구성되어있는지 검색해서 검색 대상 문자열의 문자가 하나도 없으면 true를 리턴한다. 문자열이 null이거나, 검색 대상 문자열이 null이거나, 문자열이 length가 0이거나, 검색 대상 문자열의 length가 0이면 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.containsNone(null, *)       = true
     *    StringUtil.containsNone(*, null)       = true
     *    StringUtil.containsNone(&quot;&quot;, *)         = true
     *    StringUtil.containsNone(&quot;ab&quot;, &quot;&quot;)      = true
     *    StringUtil.containsNone(&quot;abab&quot;, &quot;xyz&quot;) = true
     *    StringUtil.containsNone(&quot;ab1&quot;, &quot;xyz&quot;)  = true
     *    StringUtil.containsNone(&quot;abz&quot;, &quot;xyz&quot;)  = false
     * </pre>
     *
     * @method Name : containsNone
     * @param str, invalidChars 
     * @return booleans
     * @throws none
     * 
     */
    public static boolean containsNone(String str, String invalidChars) {
        if (str == null || invalidChars == null) {
            return true;
        }
        return containsNone(str, invalidChars.toCharArray());
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 검색 대상 문자열 배열의 문자열이 있는 첫번째 위치를 리턴한다. 해당 문자열이 없으면 -1을 리턴한다. 문자열이 null이면 -1을 리턴한다. 검색 대상 문자열 배열이 null이거나 length가 0이면 -1을 리턴한다. 검색 대상 문자열 배열의 문자열이 null인 경우 그 문자열은 무시한다. 검색 대상 문자열 배열의 문자열이 empty("")인 경우 문자열이 null이 아닌경우 0을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.indexOfAny(null, *)                     = -1
     *    StringUtil.indexOfAny(*, null)                     = -1
     *    StringUtil.indexOfAny(*, [])                       = -1
     *    StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;ab&quot;,&quot;cd&quot;])   = 2
     *    StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;cd&quot;,&quot;ab&quot;])   = 2
     *    StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;op&quot;])   = -1
     *    StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;zab&quot;,&quot;aby&quot;]) = 1
     *    StringUtil.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;&quot;])          = 0
     *    StringUtil.indexOfAny(&quot;&quot;, [&quot;&quot;])                    = 0
     *    StringUtil.indexOfAny(&quot;&quot;, [&quot;a&quot;])                   = -1
     * </pre>
     *
     * @method Name : indexOfAny
     * @param str, searchStrs 
     * @return integer
     * @throws none
     * 
     */
    public static int indexOfAny(String str, String[] searchStrs) {
        if ((str == null) || (searchStrs == null)) {
            return -1;
        }
        int sz = searchStrs.length;
        int ret = Integer.MAX_VALUE;

        int tmp = 0;
        for (int i = 0; i < sz; i++) {
            String search = searchStrs[i];
            if (search == null) {
                continue;
            }
            tmp = str.indexOf(search);
            if (tmp == -1) {
                continue;
            }

            if (tmp < ret) {
                ret = tmp;
            }
        }

        return (ret == Integer.MAX_VALUE) ? -1 : ret;
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열에서 검색 대상 문자열 배열에 있는 문자열이 있는 마지막 위치를 리턴한다. 문자열이 null이거나, 검색 대상 문자열 배열이 null인 경우 -1을 리턴한다. 검색 대상 문자열 배열의 문자열이 null이거나 length가 0인 경우 무시한다. 그러나 검색 대상 문자열 배열의 문자열이 ""인 경우 문자열이 null이 아니면 문자열의 length를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.lastIndexOfAny(null, *)                   = -1
     *    StringUtil.lastIndexOfAny(*, null)                   = -1
     *    StringUtil.lastIndexOfAny(*, [])                     = -1
     *    StringUtil.lastIndexOfAny(*, [null])                 = -1
     *    StringUtil.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;ab&quot;,&quot;cd&quot;]) = 6
     *    StringUtil.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;cd&quot;,&quot;ab&quot;]) = 6
     *    StringUtil.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;op&quot;]) = -1
     *    StringUtil.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;op&quot;]) = -1
     *    StringUtil.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;&quot;])   = 10
     * </pre>
     *
     * @method Name : lastIndexOfAny
     * @param str, searchStrs
     * @return integer
     * @throws none
     * 
     */
    public static int lastIndexOfAny(String str, String[] searchStrs) {
        if ((str == null) || (searchStrs == null)) {
            return -1;
        }
        int sz = searchStrs.length;
        int ret = -1;
        int tmp = 0;
        for (int i = 0; i < sz; i++) {
            String search = searchStrs[i];
            if (search == null) {
                continue;
            }
            tmp = str.lastIndexOf(search);
            if (tmp > ret) {
                ret = tmp;
            }
        }
        return ret;
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열의 주어진 시작 위치에서 부터 끝까지의 문자열의 일부분을 리턴한다. 주어진 시작 위치가 0보다 작은 경우 문자열의 끝부분에서 부터 n번째를 시작포인트를 설정한다. 문자열이 null인 경우 null을 리턴한다. 문자열이 empty("")인 경우 ""을 리턴한다. 시작위치가 문자열의 length보다 큰 경우 ""을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.substring(null, *)   = null
     *    StringUtil.substring(&quot;&quot;, *)     = &quot;&quot;
     *    StringUtil.substring(&quot;abc&quot;, 0)  = &quot;abc&quot;
     *    StringUtil.substring(&quot;abc&quot;, 2)  = &quot;c&quot;
     *    StringUtil.substring(&quot;abc&quot;, 4)  = &quot;&quot;
     *    StringUtil.substring(&quot;abc&quot;, -2) = &quot;bc&quot;
     *    StringUtil.substring(&quot;abc&quot;, -4) = &quot;abc&quot;
     * </pre>
     *
     * @method Name : substring
     * @param str, start
     * @return String
     * @throws none
     * 
     */
    public static String substring(String str, int start) {
        if (str == null) {
            return null;
        }

        // handle negatives, which means last n characters
        if (start < 0) {
            start = str.length() + start; // remember start is negative
        }

        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return EMPTY;
        }

        return str.substring(start);
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열의 주어진 시작 위치에서 주어진 종료 위치 전 까지의 문자열의 일부분을 리턴한다. 주어진 시작 위치가 0보다 작은 경우 문자열의 끝부분에서 부터 n번째를 시작포인트를 설정한다. 문자열의 첫번째 위치는 0부터 시작한다. 주어진 시작위치와 종료위치가 0보다 작은 경우 문자열의 끝부분에서 부터 처리 한다. 시작 위치가 문자열이 length보다 큰 경우 ""을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.substring(null, *, *)    = null
     *    StringUtil.substring(&quot;&quot;, * ,  *)    = &quot;&quot;;
     *    StringUtil.substring(&quot;abc&quot;, 0, 2)   = &quot;ab&quot;
     *    StringUtil.substring(&quot;abc&quot;, 2, 0)   = &quot;&quot;
     *    StringUtil.substring(&quot;abc&quot;, 2, 4)   = &quot;c&quot;
     *    StringUtil.substring(&quot;abc&quot;, 4, 6)   = &quot;&quot;
     *    StringUtil.substring(&quot;abc&quot;, 2, 2)   = &quot;&quot;
     *    StringUtil.substring(&quot;abc&quot;, -2, -1) = &quot;b&quot;
     *    StringUtil.substring(&quot;abc&quot;, -4, 2)  = &quot;ab&quot;
     * </pre>
     *
     * @method Name : substring
     * @param str, start, end 
     * @return String
     * @throws none
     * 
     */
    public static String substring(String str, int start, int end) {
        if (str == null) {
            return null;
        }

        // handle negatives
        if (end < 0) {
            end = str.length() + end; // remember end is negative
        }
        if (start < 0) {
            start = str.length() + start; // remember start is negative
        }

        // check length next
        if (end > str.length()) {
            end = str.length();
        }

        // if start is greater than end, return ""
        if (start > end) {
            return EMPTY;
        }

        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열의 가장 왼쪽에서 부터의 n개의 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다. length가 부적절한 수이거나, 문자열이 empty("")인 경우 ""을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.left(null, *)    = null
     *    StringUtil.left(*, -ve)     = &quot;&quot;
     *    StringUtil.left(&quot;&quot;, *)      = &quot;&quot;
     *    StringUtil.left(&quot;abc&quot;, 0)   = &quot;&quot;
     *    StringUtil.left(&quot;abc&quot;, 2)   = &quot;ab&quot;
     *    StringUtil.left(&quot;abc&quot;, 4)   = &quot;abc&quot;
     * </pre>
     *
     * @method Name : left
     * @param str, len 
     * @return String
     * @throws none
     * 
     */
    public static String left(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        } else {
            return str.substring(0, len);
        }
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열의 가장 오른쪽에서 부터의 n개의 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다. length가 부적절한 수이거나, 문자열이 empty("")인 경우 ""을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.right(null, *)    = null
     *    StringUtil.right(*, -ve)     = &quot;&quot;
     *    StringUtil.right(&quot;&quot;, *)      = &quot;&quot;
     *    StringUtil.right(&quot;abc&quot;, 0)   = &quot;&quot;
     *    StringUtil.right(&quot;abc&quot;, 2)   = &quot;bc&quot;
     *    StringUtil.right(&quot;abc&quot;, 4)   = &quot;abc&quot;
     * </pre>
     *
     * @method Name : right
     * @param str, len 
     * @return String
     * @throws none
     * 
     */
    public static String right(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        } else {
            return str.substring(str.length() - len);
        }
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 시작위치에서 주어진 length 길이의 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다. 시작위치가 부적절하거나 length가 부적절한 수이거나, 문자열이 empty("")인 경우 ""을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.mid(null, *, *)    = null
     *    StringUtil.mid(*, *, -ve)     = &quot;&quot;
     *    StringUtil.mid(&quot;&quot;, 0, *)      = &quot;&quot;
     *    StringUtil.mid(&quot;abc&quot;, 0, 2)   = &quot;ab&quot;
     *    StringUtil.mid(&quot;abc&quot;, 0, 4)   = &quot;abc&quot;
     *    StringUtil.mid(&quot;abc&quot;, 2, 4)   = &quot;c&quot;
     *    StringUtil.mid(&quot;abc&quot;, 4, 2)   = &quot;&quot;
     *    StringUtil.mid(&quot;abc&quot;, -2, 2)  = &quot;ab&quot;
     * </pre>
     *
     * @method Name : mid
     * @param str, pos, len 
     * @return String
     * @throws none
     * 
     */
    public static String mid(String str, int pos, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0 || pos > str.length()) {
            return EMPTY;
        }
        if (pos < 0) {
            pos = 0;
        }
        if (str.length() <= (pos + len)) {
            return str.substring(pos);
        } else {
            return str.substring(pos, pos + len);
        }
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 분리기준문자열(separator) 이전까지의 문자열을 리턴한다. 분리기준문자열(separator)은 포함하지 않는다. 문자열이 null인 경우 null을 리턴한다. 문자열이 empty("")인 경우 empty("")를 리턴한다. 분리기준문자열(separator)이 null인 경우 문자열 전체를 리턴한다. 
     * 2. 처리내용 : 
     *    StringUtil.substringBefore(null, *)      = null
     *    StringUtil.substringBefore(&quot;&quot;, *)        = &quot;&quot;
     *    StringUtil.substringBefore(&quot;abc&quot;, &quot;a&quot;)   = &quot;&quot;
     *    StringUtil.substringBefore(&quot;abcba&quot;, &quot;b&quot;) = &quot;a&quot;
     *    StringUtil.substringBefore(&quot;abc&quot;, &quot;c&quot;)   = &quot;ab&quot;
     *    StringUtil.substringBefore(&quot;abc&quot;, &quot;d&quot;)   = &quot;abc&quot;
     *    StringUtil.substringBefore(&quot;abc&quot;, &quot;&quot;)    = &quot;&quot;
     *    StringUtil.substringBefore(&quot;abc&quot;, null)  = &quot;abc&quot;
     * </pre>
     *
     * @method Name : substringBefore
     * @param str, separator 
     * @return String
     * @throws none
     * 
     */
    public static String substringBefore(String str, String separator) {
        if (str == null || separator == null || str.length() == 0) {
            return str;
        }
        if (separator.length() == 0) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 분리기준문자열(separator) 이후까지의 문자열을 리턴한다. 분리기준문자열(separator)은 포함하지 않는다. 문자열이 null인 경우 null을 리턴한다. 문자열이 empty("")인 경우 empty("")를 리턴한다. 분리기준문자열(separator)이 null인 경우 문자열이 null이 아니면 empty("")를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.substringAfter(null, *)      = null
     *    StringUtil.substringAfter(&quot;&quot;, *)        = &quot;&quot;
     *    StringUtil.substringAfter(*, null)      = &quot;&quot;
     *    StringUtil.substringAfter(&quot;abc&quot;, &quot;a&quot;)   = &quot;bc&quot;
     *    StringUtil.substringAfter(&quot;abcba&quot;, &quot;b&quot;) = &quot;cba&quot;
     *    StringUtil.substringAfter(&quot;abc&quot;, &quot;c&quot;)   = &quot;&quot;
     *    StringUtil.substringAfter(&quot;abc&quot;, &quot;d&quot;)   = &quot;&quot;
     *    StringUtil.substringAfter(&quot;abc&quot;, &quot;&quot;)    = &quot;abc&quot;
     * </pre>
     *
     * @method Name : substringAfter
     * @param str, separator 
     * @return String
     * @throws none
     * 
     */
    public static String substringAfter(String str, String separator) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (separator == null) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열에서 주어진 분리기준문자열(separator)의 마지막 위치 이전 까지의 문자열을 리턴한다. 분리기준문자열(separator)은 포함하지 않는다. 문자열이 null인 경우 null을 리턴한다. 문자열이 empty("")인 경우 empty("")를 리턴한다. 분리기준문자열(separator)이 null이거나 empty("")이면 문자열 전체를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.substringBeforeLast(null, *)      = null
     *    StringUtil.substringBeforeLast(&quot;&quot;, *)        = &quot;&quot;
     *    StringUtil.substringBeforeLast(&quot;abcba&quot;, &quot;b&quot;) = &quot;abc&quot;
     *    StringUtil.substringBeforeLast(&quot;abc&quot;, &quot;c&quot;)   = &quot;ab&quot;
     *    StringUtil.substringBeforeLast(&quot;a&quot;, &quot;a&quot;)     = &quot;&quot;
     *    StringUtil.substringBeforeLast(&quot;a&quot;, &quot;z&quot;)     = &quot;a&quot;
     *    StringUtil.substringBeforeLast(&quot;a&quot;, null)    = &quot;a&quot;
     *    StringUtil.substringBeforeLast(&quot;a&quot;, &quot;&quot;)      = &quot;a&quot;
     * </pre>
     *
     * @method Name : substringBeforeLast
     * @param str, separator
     * @return String
     * @throws none
     * 
     */
    public static String substringBeforeLast(String str, String separator) {
        if (str == null || separator == null || str.length() == 0 || separator.length() == 0) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열에서 주어진 분리기준문자열(separator)의 마지막 위치 이후의 문자열을 리턴한다. 분리기준문자열(separator)은 포함하지 않는다. 문자열이 null인 경우 null을 리턴한다. 문자열이 empty("")인 경우 empty("")를 리턴한다. 분리기준문자열(separator)이 empty("")이거나 null인 경우 문자열이 null이 아닌 경우 문자열을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.substringAfterLast(null, *)      = null
     *    StringUtil.substringAfterLast(&quot;&quot;, *)        = &quot;&quot;
     *    StringUtil.substringAfterLast(*, &quot;&quot;)        = &quot;&quot;
     *    StringUtil.substringAfterLast(*, null)      = &quot;&quot;
     *    StringUtil.substringAfterLast(&quot;abc&quot;, &quot;a&quot;)   = &quot;bc&quot;
     *    StringUtil.substringAfterLast(&quot;abcba&quot;, &quot;b&quot;) = &quot;a&quot;
     *    StringUtil.substringAfterLast(&quot;abc&quot;, &quot;c&quot;)   = &quot;&quot;
     *    StringUtil.substringAfterLast(&quot;a&quot;, &quot;a&quot;)     = &quot;&quot;
     *    StringUtil.substringAfterLast(&quot;a&quot;, &quot;z&quot;)     = &quot;&quot;
     * </pre>
     *
     * @method Name : substringAfterLast
     * @param str, separator 
     * @return String
     * @throws none
     * 
     */
    public static String substringAfterLast(String str, String separator) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (separator == null || separator.length() == 0) {
            return EMPTY;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1 || pos == (str.length() - separator.length())) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 검색 문자열 사이의 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다. 검색 문자열이 null인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.substringBetween(null, *)            = null
     *    StringUtil.substringBetween(&quot;&quot;, &quot;&quot;)             = &quot;&quot;
     *    StringUtil.substringBetween(&quot;&quot;, &quot;tag&quot;)          = null
     *    StringUtil.substringBetween(&quot;tagabctag&quot;, null)  = null
     *    StringUtil.substringBetween(&quot;tagabctag&quot;, &quot;&quot;)    = &quot;&quot;
     *    StringUtil.substringBetween(&quot;tagabctag&quot;, &quot;tag&quot;) = &quot;abc&quot;
     * </pre>
     *
     * @method Name : substringBetween
     * @param str, tag
     * @return String
     * @throws none
     * 
     */
    public static String substringBetween(String str, String tag) {
        return substringBetween(str, tag, tag);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 시작 검색 문자열에서 종료 검색 문자열 사이의 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다. 시작 문자열과 종료 문자열이 null인 경우 null을 리턴한다. 시작 문자열과 종료 문자열이 empty("")인 경우 empty("")을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.substringBetween(null, *, *)             = null
     *    StringUtil.substringBetween(&quot;&quot;, &quot;&quot;, &quot;&quot;)             = &quot;&quot;
     *    StringUtil.substringBetween(&quot;&quot;, &quot;&quot;, &quot;tag&quot;)          = null
     *    StringUtil.substringBetween(&quot;&quot;, &quot;tag&quot;, &quot;tag&quot;)       = null
     *    StringUtil.substringBetween(&quot;yabcz&quot;, null, null)    = null
     *    StringUtil.substringBetween(&quot;yabcz&quot;, &quot;&quot;, &quot;&quot;)        = &quot;&quot;
     *    StringUtil.substringBetween(&quot;yabcz&quot;, &quot;y&quot;, &quot;z&quot;)      = &quot;abc&quot;
     *    StringUtil.substringBetween(&quot;yabczyabcz&quot;, &quot;y&quot;, &quot;z&quot;) = &quot;abc&quot;
     * </pre>
     *
     * @method Name : substringBetween
     * @param str, open, close
     * @return String
     * @throws none
     * 
     */
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 검색 문자열에서 검색 문자열 사이의 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다. 검색 문자열이 null인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.getNestedString(null, *)            = null
     *    StringUtil.getNestedString(&quot;&quot;, &quot;&quot;)             = &quot;&quot;
     *    StringUtil.getNestedString(&quot;&quot;, &quot;tag&quot;)          = null
     *    StringUtil.getNestedString(&quot;tagabctag&quot;, null)  = null
     *    StringUtil.getNestedString(&quot;tagabctag&quot;, &quot;&quot;)    = &quot;&quot;
     *    StringUtil.getNestedString(&quot;tagabctag&quot;, &quot;tag&quot;) = &quot;abc&quot;
     * </pre>
     *
     * @method Name : getNestedString
     * @param str, tag 
     * @return String
     * @throws none
     * 
     */
    public static String getNestedString(String str, String tag) {
        return substringBetween(str, tag, tag);
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열에서 주어진 두 검색 문자열 사이의 문자열을 리턴한다. 오직 첫번째 match되는 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다. 두 검색 문자열이 null인 경우 null을 리턴한다. 두 검색 문자열이 empty("")인 경우 empty("")를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.getNestedString(null, *, *)             = null
     *    StringUtil.getNestedString(&quot;&quot;, &quot;&quot;, &quot;&quot;)             = &quot;&quot;
     *    StringUtil.getNestedString(&quot;&quot;, &quot;&quot;, &quot;tag&quot;)          = null
     *    StringUtil.getNestedString(&quot;&quot;, &quot;tag&quot;, &quot;tag&quot;)       = null
     *    StringUtil.getNestedString(&quot;yabcz&quot;, null, null)    = null
     *    StringUtil.getNestedString(&quot;yabcz&quot;, &quot;&quot;, &quot;&quot;)        = &quot;&quot;
     *    StringUtil.getNestedString(&quot;yabcz&quot;, &quot;y&quot;, &quot;z&quot;)      = &quot;abc&quot;
     *    StringUtil.getNestedString(&quot;yabczyabcz&quot;, &quot;y&quot;, &quot;z&quot;) = &quot;abc&quot;
     * </pre>
     *
     * @method Name : getNestedString
     * @param str, open, close 
     * @return String
     * @throws none
     * 
     */
    public static String getNestedString(String str, String open, String close) {
        return substringBetween(str, open, close);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 space를 기준으로 분리하여 문자열 배열을 리턴한다. space 문자열은 리턴하지 않는다.
     * 2. 처리내용 : 
     *    StringUtil.split(null)       = null
     *    StringUtil.split(&quot;&quot;)         = []
     *    StringUtil.split(&quot;abc def&quot;)  = [&quot;abc&quot;, &quot;def&quot;]
     *    StringUtil.split(&quot;abc  def&quot;) = [&quot;abc&quot;, &quot;def&quot;]
     *    StringUtil.split(&quot; abc &quot;)    = [&quot;abc&quot;]
     * </pre>
     *
     * @method Name : split
     * @param str 
     * @return String[]
     * @throws none
     * 
     */
    public static String[] split(String str) {
        return split(str, null, -1);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 분리 기준 문자를 기준으로 분리하여 문자열 배열을 리턴한다. 리턴 되는 문자열 배열에는 분리 기준 문자를 포함 하지 않는다. 문자열이 null인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.split(null, *)         = null
     *    StringUtil.split(&quot;&quot;, *)           = []
     *    StringUtil.split(&quot;a.b.c&quot;, '.')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     *    StringUtil.split(&quot;a..b.c&quot;, '.')   = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     *    StringUtil.split(&quot;a:b:c&quot;, '.')    = [&quot;a:b:c&quot;]
     *    StringUtil.split(&quot;a\tb\nc&quot;, null) = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     *    StringUtil.split(&quot;a b c&quot;, ' ')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * </pre>
     *
     * @method Name : split
     * @param str, separatorChar
     * @return String[]
     * @throws none
     * 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static String[] split(String str, char separatorChar) {
        // Performance tuned for 2.0 (JDK1.4)

        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0) {
            return new String[0];
        }
        List list = new ArrayList();
        int i = 0, start = 0;
        boolean match = false;
        while (i < len) {
            if (str.charAt(i) == separatorChar) {
                if (match) {
                    list.add(str.substring(start, i));
                    match = false;
                }
                start = ++i;
                continue;
            }
            match = true;
            i++;
        }
        if (match) {
            list.add(str.substring(start, i));
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 분리 기준 문자열을 기준으로 분리하여 문자열 배열을 리턴한다. 리턴 되는 문자열 배열에는 분리 기준 문자를 포함 하지 않는다. 문자열이 null인 경우 null을 리턴한다. 분리 기준 문자열이 null인 경우 분리 기준 문자열을 space로 간주하여 처리한다.
     * 2. 처리내용 : 
     *    StringUtil.split(null, *)         = null
     *    StringUtil.split(&quot;&quot;, *)           = []
     *    StringUtil.split(&quot;abc def&quot;, null) = [&quot;abc&quot;, &quot;def&quot;]
     *    StringUtil.split(&quot;abc def&quot;, &quot; &quot;)  = [&quot;abc&quot;, &quot;def&quot;]
     *    StringUtil.split(&quot;abc  def&quot;, &quot; &quot;) = [&quot;abc&quot;, &quot;def&quot;]
     *    StringUtil.split(&quot;ab:cd:ef&quot;, &quot;:&quot;) = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * </pre>
     *
     * @method Name : split
     * @param str, separatorChars 
     * @return String[]
     * @throws none
     * 
     */
    public static String[] split(String str, String separatorChars) {
        return split(str, separatorChars, -1);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 분리 기준 문자열을 기준으로 분리하여 문자열 배열을 리턴한다. 리턴 되는 문자열 배열의 수는 max개로 제한한다. 단 max <= 0인 경우 제한하지 않는다. 리턴 되는 문자열 배열에는 분리 기준 문자를 포함 하지 않는다. 문자열이 null인 경우 null을 리턴한다. 분리 기준 문자열이 null인 경우 분리 기준 문자열을 space로 간주하여 처리한다.
     * 2. 처리내용 : 
     *    StringUtil.split(null, *, *)            = null
     *    StringUtil.split(&quot;&quot;, *, *)              = []
     *    StringUtil.split(&quot;ab de fg&quot;, null, 0)   = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     *    StringUtil.split(&quot;ab   de fg&quot;, null, 0) = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     *    StringUtil.split(&quot;ab:cd:ef&quot;, &quot;:&quot;, 0)    = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     *    StringUtil.split(&quot;ab:cd:ef&quot;, &quot;:&quot;, 2)    = [&quot;ab&quot;, &quot;cdef&quot;]
     * </pre>
     *
     * @method Name : split
     * @param str, separatorChars, max 
     * @return String[]
     * @throws none
     * 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static String[] split(String str, String separatorChars, int max) {

        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0) {
            return new String[0];
        }
        List list = new ArrayList();
        int sizePlus1 = 1;
        int i = 0, start = 0;
        boolean match = false;
        if (separatorChars == null) {
            // Null separator means use whitespace
            while (i < len) {
                if (Character.isWhitespace(str.charAt(i))) {
                    if (match) {
                        if (sizePlus1++ == max) {
                            i = len;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                match = true;
                i++;
            }
        } else if (separatorChars.length() == 1) {
            // Optimise 1 character case
            char sep = separatorChars.charAt(0);
            while (i < len) {
                if (str.charAt(i) == sep) {
                    if (match) {
                        if (sizePlus1++ == max) {
                            i = len;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                match = true;
                i++;
            }
        } else {
            // standard case
            while (i < len) {
                if (separatorChars.indexOf(str.charAt(i)) >= 0) {
                    if (match) {
                        if (sizePlus1++ == max) {
                            i = len;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                match = true;
                i++;
            }
        }
        if (match) {
            list.add(str.substring(start, i));
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    /**
     * <pre>
     * 1. 개요 : 배열의 구성요소를 하나의 문자열로 합해서 리턴한다. 배열의 null, empty("") 구성요소는 empty("")로 간주하여 처리한다.
     * 2. 처리내용 : 
     *    StringUtil.concatenate(null)            = null
     *    StringUtil.concatenate([])              = &quot;&quot;
     *    StringUtil.concatenate([null])          = &quot;&quot;
     *    StringUtil.concatenate([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]) = &quot;abc&quot;
     *    StringUtil.concatenate([null, &quot;&quot;, &quot;a&quot;]) = &quot;a&quot;
     * </pre>
     *
     * @method Name : concatenate
     * @param array 
     * @return String
     * @throws none
     * 
     */
    public static String concatenate(Object[] array) {
        return join(array, null);
    }

    /**
     * <pre>
     * 1. 개요 : 배열의 구성요소를 하나의 문자열로 합해서 리턴한다. 배열의 구성요소 분리 문자는 포함되지 않는다. 배열의 null, empty("") 구성요소는 empty("")로 간주하여 처리한다.
     * 2. 처리내용 : 
     *    StringUtil.join(null)            = null
     *    StringUtil.join([])              = &quot;&quot;
     *    StringUtil.join([null])          = &quot;&quot;
     *    StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]) = &quot;abc&quot;
     *    StringUtil.join([null, &quot;&quot;, &quot;a&quot;]) = &quot;a&quot;
     * </pre>
     *
     * @method Name : join
     * @param array 
     * @return String
     * @throws none
     * 
     */
    public static String join(Object[] array) {
        return join(array, null);
    }

    /**
     * <pre>
     * 1. 개요 : 배열의 구성요소를 주어진 분리자를 포함하여 하나의 문자열로 합해서 리턴한다. 배열의 null, empty("") 구성요소는 empty("")로 간주하여 처리한다.
     * 2. 처리내용 : 
     *    StringUtil.join(null, *)               = null
     *    StringUtil.join([], *)                 = &quot;&quot;
     *    StringUtil.join([null], *)             = &quot;&quot;
     *    StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], ';')  = &quot;a;b;c&quot;
     *    StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], null) = &quot;abc&quot;
     *    StringUtil.join([null, &quot;&quot;, &quot;a&quot;], ';')  = &quot;;;a&quot;
     * </pre>
     *
     * @method Name : join
     * @param array, separator 
     * @return String
     * @throws none
     * 
     */
    public static String join(Object[] array, char separator) {
        if (array == null) {
            return null;
        }
        int arraySize = array.length;
        int bufSize = (arraySize == 0 ? 0 : ((array[0] == null ? 16 : array[0].toString().length()) + 1) * arraySize);
        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = 0; i < arraySize; i++) {
            if (i > 0) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

    /**
     * <pre>
     * 1. 개요 : 배열의 구성요소를 주어진 분리문자열을 포함하여 하나의 문자열로 합해서 리턴한다. 분리 문자열이 null이면 empty("")으로 간주한다. 배열의 null, empty("") 구성요소는 empty("")로 간주하여 처리한다.
     * 2. 처리내용 : 
     *    StringUtil.join(null, *)                = null
     *    StringUtil.join([], *)                  = &quot;&quot;
     *    StringUtil.join([null], *)              = &quot;&quot;
     *    StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], &quot;--&quot;)  = &quot;a--b--c&quot;
     *    StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], null)  = &quot;abc&quot;
     *    StringUtil.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], &quot;&quot;)    = &quot;abc&quot;
     *    StringUtil.join([null, &quot;&quot;, &quot;a&quot;], ',')   = &quot;,,a&quot;
     * </pre>
     *
     * @method Name : join
     * @param array, separator 
     * @return String
     * @throws none
     * 
     */
    public static String join(Object[] array, String separator) {
        if (array == null) {
            return null;
        }
        if (separator == null) {
            separator = EMPTY;
        }
        int arraySize = array.length;

        int bufSize = ((arraySize == 0) ? 0 : arraySize
                * ((array[0] == null ? 16 : array[0].toString().length()) + ((separator != null) ? separator.length() : 0)));

        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = 0; i < arraySize; i++) {
            if ((separator != null) && (i > 0)) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정 Iterator의 구성요소를 주어진 분리문자을 포함하여 하나의 문자열로 합해서 리턴한다. 특정 Iterator의 null object, empty("")문자열 구성요소는 empty("")문자열로 간주되어 처리 한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : join
     * @param iterator, separator 
     * @return String
     * @throws none
     * 
     */
    @SuppressWarnings("rawtypes")
	public static String join(Iterator iterator, char separator) {
        if (iterator == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer(256); // Java default is 16,
        // probably too small
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj != null) {
                buf.append(obj);
            }
            if (iterator.hasNext()) {
                buf.append(separator);
            }
        }
        return buf.toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정 Iterator의 구성요소를 주어진 분리문자열을 포함하여 하나의 문자열로 합해서 리턴한다. 분리문자열이 null인 경우 empty("")로 간주하여 처리한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : join
     * @param iterator, separator 
     * @return String
     * @throws none
     * 
     */
    @SuppressWarnings("rawtypes")
	public static String join(Iterator iterator, String separator) {
        if (iterator == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer(256); // Java default is 16,
        // probably too small
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj != null) {
                buf.append(obj);
            }
            if ((separator != null) && iterator.hasNext()) {
                buf.append(separator);
            }
        }
        return buf.toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열에서 모든 space 문자를 제거한다. 제거하는 space문자는 {' ', '\t', '\r', '\n', '\b'} 문자를 포함 한다.
     * 2. 처리내용 : 
     *    StringUtil.deleteSpaces(null)           = null
     *    StringUtil.deleteSpaces(&quot;&quot;)             = &quot;&quot;
     *    StringUtil.deleteSpaces(&quot;abc&quot;)          = &quot;abc&quot;
     *    StringUtil.deleteSpaces(&quot; \t  abc \n &quot;) = &quot;abc&quot;
     *    StringUtil.deleteSpaces(&quot;ab  c&quot;)        = &quot;abc&quot;
     *    StringUtil.deleteSpaces(&quot;a\nb\tc     &quot;) = &quot;abc&quot;
     * </pre>
     *
     * @method Name : deleteWhitespace
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String deleteWhitespace(String str) {
        if (str == null) {
            return null;
        }
        int sz = str.length();
        StringBuffer buffer = new StringBuffer(sz);
        for (int i = 0; i < sz; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                buffer.append(str.charAt(i));
            }
        }
        return buffer.toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 교체 대상 문자열(repl)을 주어진 교체 문자열(with)로 한번만 교체하여 문자열를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.replaceOnce(null, *, *)        = null
     *    StringUtil.replaceOnce(&quot;&quot;, *, *)          = &quot;&quot;
     *    StringUtil.replaceOnce(&quot;aba&quot;, null, null) = &quot;aba&quot;
     *    StringUtil.replaceOnce(&quot;aba&quot;, null, null) = &quot;aba&quot;
     *    StringUtil.replaceOnce(&quot;aba&quot;, &quot;a&quot;, null)  = &quot;aba&quot;
     *    StringUtil.replaceOnce(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;)    = &quot;aba&quot;
     *    StringUtil.replaceOnce(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;)   = &quot;zba&quot;
     * </pre>
     *
     * @method Name : replaceOnce
     * @param text, repl, with 
     * @return String 
     * @throws none
     * 
     */
    public static String replaceOnce(String text, String repl, String with) {
        return replace(text, repl, with, 1);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 교체 대상 문자열(repl)을 주어진 교체 문자열(with)로 교체하여 문자열를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.replace(null, *, *)        = null
     *    StringUtil.replace(&quot;&quot;, *, *)          = &quot;&quot;
     *    StringUtil.replace(&quot;aba&quot;, null, null) = &quot;aba&quot;
     *    StringUtil.replace(&quot;aba&quot;, null, null) = &quot;aba&quot;
     *    StringUtil.replace(&quot;aba&quot;, &quot;a&quot;, null)  = &quot;aba&quot;
     *    StringUtil.replace(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;)    = &quot;aba&quot;
     *    StringUtil.replace(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;)   = &quot;zbz&quot;
     * </pre>
     *
     * @method Name : replace
     * @param text, repl, with 
     * @return String
     * @throws none
     * 
     */
    public static String replace(String text, String repl, String with) {
        return replace(text, repl, with, -1);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 교체 대상 문자열(repl)을 주어진 교체 문자열(with)로 max회만큼 교체하여 문자열를 리턴한다. max가 0보다 작은 경우 교체 횟수를 제한하지 않는다.
     * 2. 처리내용 : 
     *    StringUtil.replace(null, *, *, *)         = null
     *    StringUtil.replace(&quot;&quot;, *, *, *)           = &quot;&quot;
     *    StringUtil.replace(&quot;abaa&quot;, null, null, 1) = &quot;abaa&quot;
     *    StringUtil.replace(&quot;abaa&quot;, null, null, 1) = &quot;abaa&quot;
     *    StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, null, 1)  = &quot;abaa&quot;
     *    StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;&quot;, 1)    = &quot;abaa&quot;
     *    StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 0)   = &quot;abaa&quot;
     *    StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 1)   = &quot;zbaa&quot;
     *    StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 2)   = &quot;zbza&quot;
     *    StringUtil.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, -1)  = &quot;zbzz&quot;
     * </pre>
     *
     * @method Name : replace
     * @param text, repl, with, max 
     * @return String
     * @throws none
     * 
     */
    public static String replace(String text, String repl, String with, int max) {
        if (text == null || repl == null || with == null || repl.length() == 0 || max == 0) {
            return text;
        }

        StringBuffer buf = new StringBuffer(text.length());
        int start = 0, end = 0;
        while ((end = text.indexOf(repl, start)) != -1) {
            buf.append(text.substring(start, end)).append(with);
            start = end + repl.length();

            if (--max == 0) {
                break;
            }
        }
        buf.append(text.substring(start));
        return buf.toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 교체대상 문자(searchChar)를 주어진 교체 문자(replaceChar)로 교체한 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다. 문자열이 empty("")인 경우 empty("")를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.replaceChars(null, *, *)        = null
     *    StringUtil.replaceChars(&quot;&quot;, *, *)          = &quot;&quot;
     *    StringUtil.replaceChars(&quot;abcba&quot;, 'b', 'y') = &quot;aycya&quot;
     *    StringUtil.replaceChars(&quot;abcba&quot;, 'z', 'y') = &quot;abcba&quot;
     * </pre>
     *
     * @method Name : replaceChars
     * @param 
     * @return 
     * @throws
     * 
     */
    public static String replaceChars(String str, char searchChar, char replaceChar) {
        if (str == null) {
            return null;
        }
        return str.replace(searchChar, replaceChar);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 주어진 교체대상 문자열(searchChar)를 주어진 교체 문자열(replaceChar)로 교체되는 위치에 맞추어 교체한 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다. 문자열이
     * 			empty("")인 경우 empty("")를 리턴한다. 교체대상문자열(searchChar)이 null또는 empty("")이면 문자열(str)을 리턴한다. 교체대상문자열(searchCahr)의 length가
     * 			교체문자열(replaceChars)의 length와 같은것이 일반적이다. 만약 교체대상문자열(searchCahr)의 length가 더 길면 이후의 문자를 제거된다. 교체대상문자열(searchCahr)의 length가 더
     *			짧으면 이후에는 교체되지 않는다. 
     * 2. 처리내용 : 
     *    StringUtil.replaceChars(null, *, *)           = null
     *    StringUtil.replaceChars(&quot;&quot;, *, *)             = &quot;&quot;
     *    StringUtil.replaceChars(&quot;abc&quot;, null, *)       = &quot;abc&quot;
     *    StringUtil.replaceChars(&quot;abc&quot;, &quot;&quot;, *)         = &quot;abc&quot;
     *    StringUtil.replaceChars(&quot;abc&quot;, &quot;b&quot;, null)     = &quot;ac&quot;
     *    StringUtil.replaceChars(&quot;abc&quot;, &quot;b&quot;, &quot;&quot;)       = &quot;ac&quot;
     *    StringUtil.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;yz&quot;)  = &quot;ayzya&quot;
     *    StringUtil.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;y&quot;)   = &quot;ayya&quot;
     *    StringUtil.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;yzx&quot;) = &quot;ayzya&quot;
     * </pre>
     *
     * @method Name : replaceChars
     * @param str, searchChars, replaceChars 
     * @return String
     * @throws none
     * 
     */
    public static String replaceChars(String str, String searchChars, String replaceChars) {
        if (str == null || str.length() == 0 || searchChars == null || searchChars.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        boolean modified = false;
        for (int i = 0, isize = searchChars.length(); i < isize; i++) {
            char searchChar = searchChars.charAt(i);
            if (replaceChars == null || i >= replaceChars.length()) {
                // delete
                int pos = 0;
                for (int j = 0; j < len; j++) {
                    if (chars[j] != searchChar) {
                        chars[pos++] = chars[j];
                    } else {
                        modified = true;
                    }
                }
                len = pos;
            } else {
                // replace
                for (int j = 0; j < len; j++) {
                    if (chars[j] == searchChar) {
                        chars[j] = replaceChars.charAt(i);
                        modified = true;
                    }
                }
            }
        }
        if (modified == false) {
            return str;
        }
        return new String(chars, 0, len);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에 위치와 length를 지정하여 덧붙칠 문자열(overlay)을 덧붙친다. 위치가 부적절하거나, length가 부적절한 경우 exception
     * 2. 처리내용 : 
     *    StringUtil.overlayString(null, *, *, *)           = NullPointerException
     *    StringUtil.overlayString(*, null, *, *)           = NullPointerException
     *    StringUtil.overlayString(&quot;&quot;, &quot;abc&quot;, 0, 0)         = &quot;abc&quot;
     *    StringUtil.overlayString(&quot;abcdef&quot;, null, 2, 4)    = &quot;abef&quot;
     *    StringUtil.overlayString(&quot;abcdef&quot;, &quot;&quot;, 2, 4)      = &quot;abef&quot;
     *    StringUtil.overlayString(&quot;abcdef&quot;, &quot;zzzz&quot;, 2, 4)  = &quot;abzzzzef&quot;
     *    StringUtil.overlayString(&quot;abcdef&quot;, &quot;zzzz&quot;, 4, 2)  = &quot;abcdzzzzcdef&quot;
     *    StringUtil.overlayString(&quot;abcdef&quot;, &quot;zzzz&quot;, -1, 4) = IndexOutOfBoundsException
     *    StringUtil.overlayString(&quot;abcdef&quot;, &quot;zzzz&quot;, 2, 8)  = IndexOutOfBoundsException
     * </pre>
     *
     * @method Name : overlayString
     * @param text, overlay, start, end 
     * @return String
     * @throws none
     * 
     */
    public static String overlayString(String text, String overlay, int start, int end) {
        return new StringBuffer(start + overlay.length() + text.length() - end + 1).append(text.substring(0, start))
                .append(overlay).append(text.substring(end)).toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에 시작위치와 종료위치를 지정하여 덧붙칠 문자열(overlay)을 덧붙친다. 문자열이 null인 경우 null을 리턴한다. 시작위치가 0보다 작은 경우 시작위치를 0으로 간주한다. 시작위치가 문자열의 length보다 큰경우 시작위치는 문자열의 length로 간주된다. 시작위치는 항상 종료위치보다 작아야 한다.
     * 2. 처리내용 : 
     *    StringUtil.overlay(null, *, *, *)            = null
     *    StringUtil.overlay(&quot;&quot;, &quot;abc&quot;, 0, 0)          = &quot;abc&quot;
     *    StringUtil.overlay(&quot;abcdef&quot;, null, 2, 4)     = &quot;abef&quot;
     *    StringUtil.overlay(&quot;abcdef&quot;, &quot;&quot;, 2, 4)       = &quot;abef&quot;
     *    StringUtil.overlay(&quot;abcdef&quot;, &quot;&quot;, 4, 2)       = &quot;abef&quot;
     *    StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 2, 4)   = &quot;abzzzzef&quot;
     *    StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 4, 2)   = &quot;abzzzzef&quot;
     *    StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, -1, 4)  = &quot;zzzzef&quot;
     *    StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 2, 8)   = &quot;abzzzz&quot;
     *    StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, -2, -3) = &quot;zzzzabcdef&quot;
     *    StringUtil.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 8, 10)  = &quot;abcdefzzzz&quot;
     * </pre>
     *
     * @method Name : overlay
     * @param str, overlay, start, int 
     * @return String
     * @throws none
     * 
     */
    public static String overlay(String str, String overlay, int start, int end) {
        if (str == null) {
            return null;
        }
        if (overlay == null) {
            overlay = EMPTY;
        }
        int len = str.length();
        if (start < 0) {
            start = 0;
        }
        if (start > len) {
            start = len;
        }
        if (end < 0) {
            end = 0;
        }
        if (end > len) {
            end = len;
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        return new StringBuffer(len + start - end + overlay.length() + 1).append(str.substring(0, start)).append(overlay).append(
                str.substring(end)).toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자의 마직막에서 newline문자를 삭제 한다. newlinedms \n, \r, \r\n이다.
     * 2. 처리내용 : 
     *    StringUtil.chomp(null)          = null
     *    StringUtil.chomp(&quot;&quot;)            = &quot;&quot;
     *    StringUtil.chomp(&quot;abc \r&quot;)      = &quot;abc &quot;
     *    StringUtil.chomp(&quot;abc\n&quot;)       = &quot;abc&quot;
     *    StringUtil.chomp(&quot;abc\r\n&quot;)     = &quot;abc&quot;
     *    StringUtil.chomp(&quot;abc\r\n\r\n&quot;) = &quot;abc\r\n&quot;
     *    StringUtil.chomp(&quot;abc\n\r&quot;)     = &quot;abc\n&quot;
     *    StringUtil.chomp(&quot;abc\n\rabc&quot;)  = &quot;abc\n\rabc&quot;
     *    StringUtil.chomp(&quot;\r&quot;)          = &quot;&quot;
     *    StringUtil.chomp(&quot;\n&quot;)          = &quot;&quot;
     *    StringUtil.chomp(&quot;\r\n&quot;)        = &quot;&quot;
     * </pre>
     *
     * @method Name : chomp
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String chomp(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == '\r' || ch == '\n') {
                return EMPTY;
            } else {
                return str;
            }
        }

        int lastIdx = str.length() - 1;
        char last = str.charAt(lastIdx);

        if (last == '\n') {
            if (str.charAt(lastIdx - 1) == '\r') {
                lastIdx--;
            }
        } else if (last == '\r') {

        } else {
            lastIdx++;
        }
        return str.substring(0, lastIdx);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 끝부분에서 부터 삭제대상문자열(separator)을 제거한다.
     * 2. 처리내용 : 
     *    StringUtil.chomp(null, *)         = null
     *    StringUtil.chomp(&quot;&quot;, *)           = &quot;&quot;
     *    StringUtil.chomp(&quot;foobar&quot;, &quot;bar&quot;) = &quot;foo&quot;
     *    StringUtil.chomp(&quot;foobar&quot;, &quot;baz&quot;) = &quot;foobar&quot;
     *    StringUtil.chomp(&quot;foo&quot;, &quot;foo&quot;)    = &quot;&quot;
     *    StringUtil.chomp(&quot;foo &quot;, &quot;foo&quot;)   = &quot;foo&quot;
     *    StringUtil.chomp(&quot; foo&quot;, &quot;foo&quot;)   = &quot; &quot;
     *    StringUtil.chomp(&quot;foo&quot;, &quot;foooo&quot;)  = &quot;foo&quot;
     *    StringUtil.chomp(&quot;foo&quot;, &quot;&quot;)       = &quot;foo&quot;
     *    StringUtil.chomp(&quot;foo&quot;, null)     = &quot;foo&quot;
     * </pre>
     *
     * @method Name : chomp
     * @param str, separator 
     * @return String
     * @throws none
     * 
     */
    public static String chomp(String str, String separator) {
        if (str == null || str.length() == 0 || separator == null) {
            return str;
        }
        if (str.endsWith(separator)) {
            return str.substring(0, str.length() - separator.length());
        }
        return str;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 끝부분에서 \n을 제거한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : chompLast
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String chompLast(String str) {
        return chompLast(str, "\n");
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 끝부분에서 삭제대상문자열(sep)을 제거한 문자열을 리턴한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : chompLast
     * @param str, sep 
     * @return String
     * @throws none
     * 
     */
    public static String chompLast(String str, String sep) {
        if (str.length() == 0) {
            return str;
        }
        String sub = str.substring(str.length() - sep.length());
        if (sep.equals(sub)) {
            return str.substring(0, str.length() - sep.length());
        } else {
            return str;
        }
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에 검색대상문자열(sep)이 있는지 검색해서 검색대상문자열을 포함하여 이후의 문자열을 리턴한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : getChomp
     * @param str, sep 
     * @return String
     * @throws none
     * 
     */
    public static String getChomp(String str, String sep) {
        int idx = str.lastIndexOf(sep);
        if (idx == str.length() - sep.length()) {
            return sep;
        } else if (idx != -1) {
            return str.substring(idx);
        } else {
            return EMPTY;
        }
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에 검색대상문자열(sep)이 있는지 검색해서 검색대상문자열 이후의 문자열을 리턴한다.
     * 2. 처리내용 :
     * 				Remove the first value of a supplied String, and everything before it from a String. 
     * </pre>
     *
     * @method Name : prechomp
     * @param str, sep 
     * @return String
     * @throws none
     * 
     */
    public static String prechomp(String str, String sep) {
        int idx = str.indexOf(sep);
        if (idx != -1) {
            return str.substring(idx + sep.length());
        } else {
            return str;
        }
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에 검색대상문자열(sep)이 있는지 검색해서 문자열의 처음부터 검색대상문자열까지의 문자열을 리턴한다.
     * 2. 처리내용 :
     * 				Remove and return everything before the first value of a supplied String from another String. 
     * </pre>
     *
     * @method Name : getPrechomp
     * @param str, sep 
     * @return String
     * @throws none
     * 
     */
    public static String getPrechomp(String str, String sep) {
        int idx = str.indexOf(sep);
        if (idx != -1) {
            return str.substring(0, idx + sep.length());
        } else {
            return EMPTY;
        }
    }
	
	/**
	 * <pre>
	 * 1. 개요 : java.net.URLEncoder를 사용하여 인코딩 한다.
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @method Name : encode
	 * @param str, enc 
	 * @return String
	 * @throws none
	 * 
	 */
	public static String encode(String str, String enc) {
		if ( str != null ) {
			try {
			    str = URLEncoder.encode(str, enc);
			} catch ( UnsupportedEncodingException ex ) {
				return str;
			}
		}
		return str;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : java.net.URLDecoder를 사용하여 디코딩 한다.
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @method Name : decode
	 * @param str, enc 
	 * @return String
	 * @throws none
	 * 
	 */
	public static String decode(String str, String enc) {
		if ( str != null ) {
			try {
			    str = URLDecoder.decode(str, enc);
			} catch ( UnsupportedEncodingException ex ) {
				return str;
			}
		}
		return str;
	}

    /**
     * <pre>
     * 1. 개요 : 특정 문자열에서 마지막 문자를 삭제하여 리턴한다. 만약 문자열이 \r\n으로 끝나는 경우 \r, \n모두 삭제된다.
     * 2. 처리내용 : 
     *    StringUtil.chop(null)          = null
     *    StringUtil.chop(&quot;&quot;)            = &quot;&quot;
     *    StringUtil.chop(&quot;abc \r&quot;)      = &quot;abc &quot;
     *    StringUtil.chop(&quot;abc\n&quot;)       = &quot;abc&quot;
     *    StringUtil.chop(&quot;abc\r\n&quot;)     = &quot;abc&quot;
     *    StringUtil.chop(&quot;abc&quot;)         = &quot;ab&quot;
     *    StringUtil.chop(&quot;abc\nabc&quot;)    = &quot;abc\nab&quot;
     *    StringUtil.chop(&quot;a&quot;)           = &quot;&quot;
     *    StringUtil.chop(&quot;\r&quot;)          = &quot;&quot;
     *    StringUtil.chop(&quot;\n&quot;)          = &quot;&quot;
     *    StringUtil.chop(&quot;\r\n&quot;)        = &quot;&quot;
     * </pre>
     *
     * @method Name : chop
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int strLen = str.length();
        if (strLen < 2) {
            return EMPTY;
        }
        int lastIdx = strLen - 1;
        String ret = str.substring(0, lastIdx);
        char last = str.charAt(lastIdx);
        if (last == '\n') {
            if (ret.charAt(lastIdx - 1) == '\r') {
                return ret.substring(0, lastIdx - 1);
            }
        }
        return ret;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 끝부분에서 \n문자를 삭제하여 리턴한다. \n앞에 \r이 있는경우 \r도 삭제한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : chopNewline
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String chopNewline(String str) {
        int lastIdx = str.length() - 1;
        if (lastIdx <= 0) {
            return EMPTY;
        }
        char last = str.charAt(lastIdx);
        if (last == '\n') {
            if (str.charAt(lastIdx - 1) == '\r') {
                lastIdx--;
            }
        } else {
            lastIdx++;
        }
        return str.substring(0, lastIdx);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에 주어진 횟수(repeat)만큼 특정문자열내의 문자열을 반복하여 덧붙친 문자열을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.repeat(null, 2) = null
     *    StringUtil.repeat(&quot;&quot;, 0)   = &quot;&quot;
     *    StringUtil.repeat(&quot;&quot;, 2)   = &quot;&quot;
     *    StringUtil.repeat(&quot;a&quot;, 3)  = &quot;aaa&quot;
     *    StringUtil.repeat(&quot;ab&quot;, 2) = &quot;abab&quot;
     *    StringUtil.repeat(&quot;a&quot;, -2) = &quot;&quot;
     * </pre>
     *
     * @method Name : repeat
     * @param str, repeat 
     * @return String
     * @throws none
     * 
     */
    public static String repeat(String str, int repeat) {
        // Performance tuned for 2.0 (JDK1.4)

        if (str == null) {
            return null;
        }
        if (repeat <= 0) {
            return EMPTY;
        }
        int inputLength = str.length();
        if (repeat == 1 || inputLength == 0) {
            return str;
        }
        if (inputLength == 1 && repeat <= PAD_LIMIT) {
            return padding(repeat, str.charAt(0));
        }

        int outputLength = inputLength * repeat;
        switch (inputLength) {
        case 1:
            char ch = str.charAt(0);
            char[] output1 = new char[outputLength];
            for (int i = repeat - 1; i >= 0; i--) {
                output1[i] = ch;
            }
            return new String(output1);
        case 2:
            char ch0 = str.charAt(0);
            char ch1 = str.charAt(1);
            char[] output2 = new char[outputLength];
            for (int i = repeat * 2 - 2; i >= 0; i--, i--) {
                output2[i] = ch0;
                output2[i + 1] = ch1;
            }
            return new String(output2);
        default:
            StringBuffer buf = new StringBuffer(outputLength);
            for (int i = 0; i < repeat; i++) {
                buf.append(str);
            }
            return buf.toString();
        }
    }

    /**
     * <pre>
     * 1. 개요 : 주어진 문자(padChar)를 주어진 횟수(repeat)만큼 반복한 문자열을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.padding(0, 'e')  = &quot;&quot;
     *    StringUtil.padding(3, 'e')  = &quot;eee&quot;
     *    StringUtil.padding(-2, 'e') = IndexOutOfBoundsException
     * </pre>
     *
     * @method Name : padding
     * @param repeat, padChar 
     * @return String
     * @throws none
     * 
     */
    private static String padding(int repeat, char padChar) {
        String pad = PADDING[padChar];
        if (pad == null) {
            pad = String.valueOf(padChar);
        }
        while (pad.length() < repeat) {
            pad = pad.concat(pad);
        }
        PADDING[padChar] = pad;
        return pad.substring(0, repeat);
    }

    /**
     * <pre>
     * 1. 개요 : 특정 문자열의 오른쪽에 space문자를 덧붙쳐 문자열의 length가 주어진 length(size)가 되도록 한다.
     * 2. 처리내용 : 
     *    StringUtil.rightPad(null, *)   = null
     *    StringUtil.rightPad(&quot;&quot;, 3)     = &quot;   &quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 3)  = &quot;bat&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 5)  = &quot;bat  &quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 1)  = &quot;bat&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, -1) = &quot;bat&quot;
     * </pre>
     *
     * @method Name : rightPad
     * @param str, size 
     * @return String
     * @throws none
     * 
     */
    public static String rightPad(String str, int size) {
        return rightPad(str, size, ' ');
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 오른쪽에 주어진 문자(padChar)를 덧붙쳐 문자열의 length가 주어진 length(size)가 되도록 한다.
     * 2. 처리내용 : 
     *    StringUtil.rightPad(null, *, *)     = null
     *    StringUtil.rightPad(&quot;&quot;, 3, 'z')     = &quot;zzz&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 3, 'z')  = &quot;bat&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 5, 'z')  = &quot;batzz&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 1, 'z')  = &quot;bat&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, -1, 'z') = &quot;bat&quot;
     * </pre>
     *
     * @method Name : rightPad
     * @param str, size, padChar 
     * @return String
     * @throws none
     * 
     */
    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads > PAD_LIMIT) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(padding(pads, padChar));
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 오른쪽에 주어진 문자열(padStr)를 덧붙쳐 문자열의 length가 주어진 length(size)가 되도록 한다.
     * 2. 처리내용 : 
     *    StringUtil.rightPad(null, *, *)      = null
     *    StringUtil.rightPad(&quot;&quot;, 3, &quot;z&quot;)      = &quot;zzz&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 3, &quot;yz&quot;)  = &quot;bat&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 5, &quot;yz&quot;)  = &quot;batyz&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 8, &quot;yz&quot;)  = &quot;batyzyzy&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 1, &quot;yz&quot;)  = &quot;bat&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, -1, &quot;yz&quot;) = &quot;bat&quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 5, null)  = &quot;bat  &quot;
     *    StringUtil.rightPad(&quot;bat&quot;, 5, &quot;&quot;)    = &quot;bat  &quot;
     * </pre>
     *
     * @method Name : rightPad
     * @param str, size, padStr 
     * @return String
     * @throws none
     * 
     */
    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (padStr == null || padStr.length() == 0) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return rightPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return str.concat(padStr);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return str.concat(new String(padding));
        }
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 왼쪽에 space를 덧붙쳐 문자열의 length가 주어진 length(size)가 되도록 한다.
     * 2. 처리내용 : 
     *    StringUtil.leftPad(null, *)   = null
     *    StringUtil.leftPad(&quot;&quot;, 3)     = &quot;   &quot;
     *    StringUtil.leftPad(&quot;bat&quot;, 3)  = &quot;bat&quot;
     *    StringUtil.leftPad(&quot;bat&quot;, 5)  = &quot;  bat&quot;
     *    StringUtil.leftPad(&quot;bat&quot;, 1)  = &quot;bat&quot;
     *    StringUtil.leftPad(&quot;bat&quot;, -1) = &quot;bat&quot;
     * </pre>
     *
     * @method Name : leftPad
     * @param str, size 
     * @return String
     * @throws none
     * 
     */
    public static String leftPad(String str, int size) {
        return leftPad(str, size, ' ');
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 왼쪽에 주어진 문자(padChar)를 덧붙쳐 문자열의 length가 주어진 length(size)가 되도록 한다.
     * 2. 처리내용 : 
     *    StringUtil.leftPad(null, *, *)     = null
     *    StringUtil.leftPad(&quot;&quot;, 3, 'z')     = &quot;zzz&quot;
     *    StringUtil.leftPad(&quot;bat&quot;, 3, 'z')  = &quot;bat&quot;
     *    StringUtil.leftPad(&quot;bat&quot;, 5, 'z')  = &quot;zzbat&quot;
     *    StringUtil.leftPad(&quot;bat&quot;, 1, 'z')  = &quot;bat&quot;
     *    StringUtil.leftPad(&quot;bat&quot;, -1, 'z') = &quot;bat&quot;
     * </pre>
     *
     * @method Name : leftPad
     * @param str, size, padChar 
     * @return String
     * @throws none
     * 
     */
    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads > PAD_LIMIT) {
            return leftPad(str, size, String.valueOf(padChar));
        }
        return padding(pads, padChar).concat(str);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 왼쪽에 주어진 문자열(padStr)를 덧붙쳐 문자열의 length가 주어진 length(size)가 되도록 한다. 
     * 2. 처리내용 : 
     * 				StringUtil.leftPad(null, *, *) = null StringUtil.leftPad("",3, "z") = "zzz" 
     * 				StringUtil.leftPad("bat", 3, "yz") = "bat" StringUtil.leftPad("bat", 5, "yz") = "yzbat" 
     * 				StringUtil.leftPad("bat", 8,"yz") = "yzyzybat" 
     * 				StringUtil.leftPad("bat", 1, "yz") = "bat" 
     * 				StringUtil.leftPad("bat", -1, "yz") = "bat" 
     * 				StringUtil.leftPad("bat", 5,null) = " bat" 
     * 				StringUtil.leftPad("bat", 5, "") = " bat"
     * </pre>
     *
     * @method Name : leftPad
     * @param str, size, padStr
     * @return String
     * @throws none
     * 
     */
    public static String leftPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (padStr == null || padStr.length() == 0) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return leftPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽에 space를 덧붙쳐 문자열의 length가 주어진 length(size)가 되도록 한다. 만약 주어진 length(size)가 문자열의 length보다 작은경우 문자열을 리턴한다. 그리고 length(size)가 0보다 작은 경우 size를 0으로 간주한다. 문자열이 null인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.center(null, *)   = null
     *    StringUtil.center(&quot;&quot;, 4)     = &quot;    &quot;
     *    StringUtil.center(&quot;ab&quot;, -1)  = &quot;ab&quot;
     *    StringUtil.center(&quot;ab&quot;, 4)   = &quot; ab &quot;
     *    StringUtil.center(&quot;abcd&quot;, 2) = &quot;abcd&quot;
     *    StringUtil.center(&quot;a&quot;, 4)    = &quot; a  &quot;
     * </pre>
     *
     * @method Name : center
     * @param str, size 
     * @return String
     * @throws none
     * 
     */
    public static String center(String str, int size) {
        return center(str, size, ' ');
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽에 주어진 문자(padChar)를 덧붙쳐 문자열의 length가 주어진 length(size)가 되도록 한다. 만약 주어진 length(size)가 문자열의 length보다 작은경우 문자열을 리턴한다. 그리고 length(size)가 0보다 작은 경우 size를 0으로 간주한다. 문자열이 null인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.center(null, *, *)     = null
     *    StringUtil.center(&quot;&quot;, 4, ' ')     = &quot;    &quot;
     *    StringUtil.center(&quot;ab&quot;, -1, ' ')  = &quot;ab&quot;
     *    StringUtil.center(&quot;ab&quot;, 4, ' ')   = &quot; ab&quot;
     *    StringUtil.center(&quot;abcd&quot;, 2, ' ') = &quot;abcd&quot;
     *    StringUtil.center(&quot;a&quot;, 4, ' ')    = &quot; a  &quot;
     *    StringUtil.center(&quot;a&quot;, 4, 'y')    = &quot;yayy&quot;
     * </pre>
     *
     * @method Name : center
     * @param str, size, padChar
     * @return String
     * @throws none
     * 
     */
    public static String center(String str, int size, char padChar) {
        if (str == null || size <= 0) {
            return str;
        }
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        str = leftPad(str, strLen + pads / 2, padChar);
        str = rightPad(str, size, padChar);
        return str;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 양쪽에 주어진 문자열(padStr)를 덧붙쳐 문자열의 length가 주어진 length(size)가 되도록 한다. 만약 주어진 length(size)가 문자열의 length보다 작은경우 문자열을 리턴한다. 그리고 length(size)가 0보다 작은 경우 size를 0으로 간주한다. 문자열이 null인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.center(null, *, *)     = null
     *    StringUtil.center(&quot;&quot;, 4, &quot; &quot;)     = &quot;    &quot;
     *    StringUtil.center(&quot;ab&quot;, -1, &quot; &quot;)  = &quot;ab&quot;
     *    StringUtil.center(&quot;ab&quot;, 4, &quot; &quot;)   = &quot; ab&quot;
     *    StringUtil.center(&quot;abcd&quot;, 2, &quot; &quot;) = &quot;abcd&quot;
     *    StringUtil.center(&quot;a&quot;, 4, &quot; &quot;)    = &quot; a  &quot;
     *    StringUtil.center(&quot;a&quot;, 4, &quot;yz&quot;)   = &quot;yayz&quot;
     *    StringUtil.center(&quot;abc&quot;, 7, null) = &quot;  abc  &quot;
     *    StringUtil.center(&quot;abc&quot;, 7, &quot;&quot;)   = &quot;  abc  &quot;
     * </pre>
     *
     * @method Name : center
     * @param str, size, padStr 
     * @return String
     * @throws none
     * 
     */
    public static String center(String str, int size, String padStr) {
        if (str == null || size <= 0) {
            return str;
        }
        if (padStr == null || padStr.length() == 0) {
            padStr = " ";
        }
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        str = leftPad(str, strLen + pads / 2, padStr);
        str = rightPad(str, size, padStr);
        return str;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에 대해 대문자로 치환한 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.upperCase(null)  = null
     *    StringUtil.upperCase(&quot;&quot;)    = &quot;&quot;
     *    StringUtil.upperCase(&quot;aBc&quot;) = &quot;ABC&quot;
     * </pre>
     *
     * @method Name : upperCase
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에 대해 소문자로 치환한 문자열을 리턴한다. 문자열이 null인 경우 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.lowerCase(null)  = null
     *    StringUtil.lowerCase(&quot;&quot;)    = &quot;&quot;
     *    StringUtil.lowerCase(&quot;aBc&quot;) = &quot;abc&quot;
     * </pre>
     *
     * @method Name : lowerCase
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 첫번째문자를 대문자로 치환한 문자열을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.capitalize(null)  = null
     *    StringUtil.capitalize(&quot;&quot;)    = &quot;&quot;
     *    StringUtil.capitalize(&quot;cat&quot;) = &quot;Cat&quot;
     *    StringUtil.capitalize(&quot;cAt&quot;) = &quot;CAt&quot;
     * </pre>
     *
     * @method Name : capitalize
     * @param str
     * @return String
     * @throws none
     * 
     */
    public static String capitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 첫번째문자를 대문자로 치환한 문자열을 리턴한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : capitalise
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String capitalise(String str) {
        return capitalize(str);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 첫번째문자를 소문자로 치환한 문자열을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.uncapitalize(null)  = null
     *    StringUtil.uncapitalize(&quot;&quot;)    = &quot;&quot;
     *    StringUtil.uncapitalize(&quot;Cat&quot;) = &quot;cat&quot;
     *    StringUtil.uncapitalize(&quot;CAT&quot;) = &quot;cAT&quot;
     * </pre>
     *
     * @method Name : uncapitalize
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String uncapitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열의 첫번째문자를 소문자로 치환한 문자열을 리턴한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : uncapitalise
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String uncapitalise(String str) {
        return uncapitalize(str);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 문자열 전체에 대해 소문자는 대문자로, 대문자는 소문자로 치환처리하여 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.swapCase(null)                 = null
     *    StringUtil.swapCase(&quot;&quot;)                   = &quot;&quot;
     *    StringUtil.swapCase(&quot;The dog has a BONE&quot;) = &quot;tHE DOG HAS A bone&quot;
     * </pre>
     *
     * @method Name : swapCase
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String swapCase(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        StringBuffer buffer = new StringBuffer(strLen);

        char ch = 0;
        for (int i = 0; i < strLen; i++) {
            ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
            } else if (Character.isTitleCase(ch)) {
                ch = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            }
            buffer.append(ch);
        }
        return buffer.toString();
    }

    /**
     * <pre>
     * 1. 개요 : space로 나누어진 특정문자열에 대해 단어의 첫번째 문자를 대문자로 치환처리하여 문자열을 리턴한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : capitaliseAllWords
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String capitaliseAllWords(String str) {
        return capitalizeString(str);
    }

    /**
     * <pre>
     * 1. 개요 : space로 나누어진 특정문자열에 대해 단어의 첫번째 문자를 대문자로 치환처리하여 문자열을 리턴한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : capitalizeString
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String capitalizeString(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        StringBuffer buffer = new StringBuffer(strLen);
        boolean whitespace = true;
        for (int i = 0; i < strLen; i++) {
            char ch = str.charAt(i);
            if (Character.isWhitespace(ch)) {
                buffer.append(ch);
                whitespace = true;
            } else if (whitespace) {
                buffer.append(Character.toTitleCase(ch));
                whitespace = false;
            } else {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열에서 비교대상문자열(sub)이 매치되는 횟수를 리턴한다. 문자열이 null이거나 empty("")인 경우 0을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.countMatches(null, *)       = 0
     *    StringUtil.countMatches(&quot;&quot;, *)         = 0
     *    StringUtil.countMatches(&quot;abba&quot;, null)  = 0
     *    StringUtil.countMatches(&quot;abba&quot;, &quot;&quot;)    = 0
     *    StringUtil.countMatches(&quot;abba&quot;, &quot;a&quot;)   = 2
     *    StringUtil.countMatches(&quot;abba&quot;, &quot;ab&quot;)  = 1
     *    StringUtil.countMatches(&quot;abba&quot;, &quot;xxx&quot;) = 0
     * </pre>
     *
     * @method Name : countMatches
     * @param str, sub 
     * @return integer
     * @throws none
     * 
     */
    public static int countMatches(String str, String sub) {
        if (str == null || str.length() == 0 || sub == null || sub.length() == 0) {
            return 0;
        }
        int count = 0;
        int idx = 0;
        while ((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            idx += sub.length();
        }
        return count;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열이 오직 unicode 문자로 구성되어 있는지 검색하여 unicode 문자로 구성되어 있으면 true를 리턴한다. 문자열이 null인 경우 false를 리턴한다. 문자열이 empty("")인 경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isAlpha(null)   = false
     *    StringUtil.isAlpha(&quot;&quot;)     = true
     *    StringUtil.isAlpha(&quot;  &quot;)   = false
     *    StringUtil.isAlpha(&quot;abc&quot;)  = true
     *    StringUtil.isAlpha(&quot;ab2c&quot;) = false
     *    StringUtil.isAlpha(&quot;ab-c&quot;) = false
     * </pre>
     *
     * @method Name : isAlpha
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLetter(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열이 오직 unicode 문자와 space로 구성되어 있는지 검색하여 unicode 문자와 space로 구성되어 있으면 true를 리턴한다. 문자열이 null인 경우 false를 리턴한다. 문자열이 empty("")인 경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isAlphaSpace(null)   = false
     *    StringUtil.isAlphaSpace(&quot;&quot;)     = true
     *    StringUtil.isAlphaSpace(&quot;  &quot;)   = true
     *    StringUtil.isAlphaSpace(&quot;abc&quot;)  = true
     *    StringUtil.isAlphaSpace(&quot;ab c&quot;) = true
     *    StringUtil.isAlphaSpace(&quot;ab2c&quot;) = false
     *    StringUtil.isAlphaSpace(&quot;ab-c&quot;) = false
     * </pre>
     *
     * @method Name : isAlphaSpace
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isAlphaSpace(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isLetter(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열이 오직 unicode 문자와 digits(0-9)로 구성되어 있는지 검색하여 unicode 문자와 digits(0-9)로 구성되어 있으면 true를 리턴한다. 문자열이 null인 경우 false를 리턴한다. 문자열이 empty("")인 경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isAlphanumeric(null)   = false
     *    StringUtil.isAlphanumeric(&quot;&quot;)     = true
     *    StringUtil.isAlphanumeric(&quot;  &quot;)   = false
     *    StringUtil.isAlphanumeric(&quot;abc&quot;)  = true
     *    StringUtil.isAlphanumeric(&quot;ab c&quot;) = false
     *    StringUtil.isAlphanumeric(&quot;ab2c&quot;) = true
     *    StringUtil.isAlphanumeric(&quot;ab-c&quot;) = false
     * </pre>
     *
     * @method Name : isAlphanumeric
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isAlphanumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLetterOrDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열이 오직 unicode 문자와 digits(0-9), space로 구성되어 있는지 검색하여 unicode 문자와 digits(0-9), space로 구성되어 있으면 true를 리턴한다. 문자열이 null인 경우 false를 리턴한다. 문자열이 empty("")인 경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isAlphanumeric(null)   = false
     *    StringUtil.isAlphanumeric(&quot;&quot;)     = true
     *    StringUtil.isAlphanumeric(&quot;  &quot;)   = true
     *    StringUtil.isAlphanumeric(&quot;abc&quot;)  = true
     *    StringUtil.isAlphanumeric(&quot;ab c&quot;) = true
     *    StringUtil.isAlphanumeric(&quot;ab2c&quot;) = true
     *    StringUtil.isAlphanumeric(&quot;ab-c&quot;) = false
     * </pre>
     *
     * @method Name : isAlphanumericSpace
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isAlphanumericSpace(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isLetterOrDigit(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열이 오직 unicode digits(0-9)로 구성되어 있는지 검색하여 unicode digits(0-9)로 구성되어 있으면 true를 리턴한다. 문자열이 null인 경우 false를 리턴한다. 문자열이 empty("")인 경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isNumeric(null)   = false
     *    StringUtil.isNumeric(&quot;&quot;)     = true
     *    StringUtil.isNumeric(&quot;  &quot;)   = false
     *    StringUtil.isNumeric(&quot;123&quot;)  = true
     *    StringUtil.isNumeric(&quot;12 3&quot;) = false
     *    StringUtil.isNumeric(&quot;ab2c&quot;) = false
     *    StringUtil.isNumeric(&quot;12-3&quot;) = false
     *    StringUtil.isNumeric(&quot;12.3&quot;) = false
     * </pre>
     *
     * @method Name : isNumeric
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열이 오직 unicode digits(0-9)와 space로 구성되어 있는지 검색하여 unicode digits(0-9)와 space로 구성되어 있으면 true를 리턴한다. 문자열이 null인 경우 false를 리턴한다. 문자열이 empty("")인 경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isNumeric(null)   = false
     *    StringUtil.isNumeric(&quot;&quot;)     = true
     *    StringUtil.isNumeric(&quot;  &quot;)   = true
     *    StringUtil.isNumeric(&quot;123&quot;)  = true
     *    StringUtil.isNumeric(&quot;12 3&quot;) = true
     *    StringUtil.isNumeric(&quot;ab2c&quot;) = false
     *    StringUtil.isNumeric(&quot;12-3&quot;) = false
     *    StringUtil.isNumeric(&quot;12.3&quot;) = false
     * </pre>
     *
     * @method Name : isNumericSpace
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isNumericSpace(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isDigit(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열이 오직 space로 구성되어 있는지 검색하여 space로 구성되어 있으면 true를 리턴한다. 문자열이 null인 경우 false를 리턴한다. 문자열이 empty("")인 경우 true를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.isWhitespace(null)   = false
     *    StringUtil.isWhitespace(&quot;&quot;)     = true
     *    StringUtil.isWhitespace(&quot;  &quot;)   = true
     *    StringUtil.isWhitespace(&quot;abc&quot;)  = false
     *    StringUtil.isWhitespace(&quot;ab2c&quot;) = false
     *    StringUtil.isWhitespace(&quot;ab-c&quot;) = false
     * </pre>
     *
     * @method Name : isWhitespace
     * @param str 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean isWhitespace(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열이 null인 경우 empty("")를 리턴하고 null이 아닌경우 문자열을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.defaultString(null)  = &quot;&quot;
     *    StringUtil.defaultString(&quot;&quot;)    = &quot;&quot;
     *    StringUtil.defaultString(&quot;bat&quot;) = &quot;bat&quot;
     * </pre>
     *
     * @method Name : defaultString
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String defaultString(String str) {
        return (str == null ? EMPTY : str);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열이 null인 경우 주어진 대체문자(defaultStr)를 리턴하고 null이 아닌경우 문자열을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.defaultString(null, &quot;null&quot;)  = &quot;null&quot;
     *    StringUtil.defaultString(&quot;&quot;, &quot;null&quot;)    = &quot;&quot;
     *    StringUtil.defaultString(&quot;bat&quot;, &quot;null&quot;) = &quot;bat&quot;
     * </pre>
     *
     * @method Name : defaultString
     * @param str, defaultStr 
     * @return String
     * @throws none
     * 
     */
    public static String defaultString(String str, String defaultStr) {
        return (str == null ? defaultStr : str);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열을 반대로 전환처리한 문자열을 리턴한다. 문자열이 null이면 null을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.reverse(null)  = null
     *    StringUtil.reverse(&quot;&quot;)    = &quot;&quot;
     *    StringUtil.reverse(&quot;bat&quot;) = &quot;tab&quot;
     * </pre>
     *
     * @method Name : reverse
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열을 반대 전환처리한 문자열을 리턴한다. 단 구분문자사이에 있는 문자를 반대 전환처리 하지 않는다.
     * 2. 처리내용 : 
     *    StringUtil.reverseDelimited(null, *)      = null
     *    StringUtil.reverseDelimited(&quot;&quot;, *)        = &quot;&quot;
     *    StringUtil.reverseDelimited(&quot;a.b.c&quot;, 'x') = &quot;a.b.c&quot;
     *    StringUtil.reverseDelimited(&quot;a.b.c&quot;, &quot;.&quot;) = &quot;c.b.a&quot;
     * </pre>
     *
     * @method Name : reverseDelimited
     * @param str, separatorChar 
     * @return String
     * @throws none
     * 
     */
    public static String reverseDelimited(String str, char separatorChar) {
        if (str == null) {
            return null;
        }

        String[] strs = split(str, separatorChar);
        reverseArray(strs);
        return join(strs, separatorChar);
    }

    /**
     * <pre>
     * 1. 개요 : 특정배열의 구성요소에 대해 반대 전환 처리한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : reverseArray
     * @param array 
     * @return void
     * @throws none
     * 
     */
    private static void reverseArray(final Object[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        Object tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열을 반대 전환처리한 문자열을 리턴한다. 단 구분문자열사이에 있는 문자를 반대 전환처리 하지 않는다.
     * 2. 처리내용 : 
     *    StringUtil.reverseDelimitedString(null, *)       = null
     *    StringUtil.reverseDelimitedString(&quot;&quot;,*)          = &quot;&quot;
     *    StringUtil.reverseDelimitedString(&quot;a.b.c&quot;, null) = &quot;a.b.c&quot;
     *    StringUtil.reverseDelimitedString(&quot;a.b.c&quot;, &quot;.&quot;)  = &quot;c.b.a&quot;
     * </pre>
     *
     * @method Name : reverseDelimitedString
     * @param str, separatorChars 
     * @return String
     * @throws none
     * 
     */
    public static String reverseDelimitedString(String str, String separatorChars) {
        if (str == null) {
            return null;
        }

        String[] strs = split(str, separatorChars);
        reverseArray(strs);
        if (separatorChars == null) {
            return join(strs, ' ');
        }
        return join(strs, separatorChars);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열을 주어진 사이즈(maxWidth)내에서 말줄임표("...")문자열을 오른쪽으로 붙친 문자열을 리턴한다. 문자열이 주어진 사이즈(maxWidth)보다 짧은 경우 문자열를 그대로 리턴한다. 주어진 사이즈(maxWidth)가 4보다 작은 경우 exception 발생한다.
     * 2. 처리내용 : 
     *    StringUtil.abbreviate(null, *)      = null
     *    StringUtil.abbreviate(&quot;&quot;, 4)        = &quot;&quot;
     *    StringUtil.abbreviate(&quot;abcdefg&quot;, 6) = &quot;abc...&quot;
     *    StringUtil.abbreviate(&quot;abcdefg&quot;, 7) = &quot;abcdefg&quot;
     *    StringUtil.abbreviate(&quot;abcdefg&quot;, 8) = &quot;abcdefg&quot;
     *    StringUtil.abbreviate(&quot;abcdefg&quot;, 4) = &quot;a...&quot;
     *    StringUtil.abbreviate(&quot;abcdefg&quot;, 3) = IllegalArgumentException
     * </pre>
     *
     * @method Name : abbreviate
     * @param str, maxWidth 
     * @return String
     * @throws none
     * 
     */
    public static String abbreviate(String str, int maxWidth) {
        return abbreviate(str, 0, maxWidth);
    }

    /**
     * <pre>
     * 1. 개요 : 특정문자열를 주어진 사이즈(maxWidth)내에서 말줄임표("...")문자열을 양쪽 끝으로 붙친 문자열을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.abbreviate(null, *, *)                = null
     *    StringUtil.abbreviate(&quot;&quot;, 0, 4)                  = &quot;&quot;
     *    StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, -1, 10) = &quot;abcdefg...&quot;
     *    StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 0, 10)  = &quot;abcdefg...&quot;
     *    StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 1, 10)  = &quot;abcdefg...&quot;
     *    StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 4, 10)  = &quot;abcdefg...&quot;
     *    StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 5, 10)  = &quot;...fghi...&quot;
     *    StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 6, 10)  = &quot;...ghij...&quot;
     *    StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 8, 10)  = &quot;...ijklmno&quot;
     *    StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 10, 10) = &quot;...ijklmno&quot;
     *    StringUtil.abbreviate(&quot;abcdefghijklmno&quot;, 12, 10) = &quot;...ijklmno&quot;
     *    StringUtil.abbreviate(&quot;abcdefghij&quot;, 0, 3)        = IllegalArgumentException
     *    StringUtil.abbreviate(&quot;abcdefghij&quot;, 5, 6)        = IllegalArgumentException
     * </pre>
     *
     * @method Name : abbreviate
     * @param str, offset, maxWidth 
     * @return String
     * @throws none
     * 
     */
    public static String abbreviate(String str, int offset, int maxWidth) {
        if (str == null) {
            return null;
        }
        if (maxWidth < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        }
        if (str.length() <= maxWidth) {
            return str;
        }
        if (offset > str.length()) {
            offset = str.length();
        }
        if ((str.length() - offset) < (maxWidth - 3)) {
            offset = str.length() - (maxWidth - 3);
        }
        if (offset <= 4) {
            return str.substring(0, maxWidth - 3) + "...";
        }
        if (maxWidth < 7) {
            throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
        }
        if ((offset + (maxWidth - 3)) < str.length()) {
            return "..." + abbreviate(str.substring(offset), maxWidth - 3);
        }
        return "..." + str.substring(str.length() - (maxWidth - 3));
    }

    /**
     * <pre>
     * 1. 개요 : 두문자열을 비교하여 다른 부분의 문자열를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.difference(null, null) = null
     *    StringUtil.difference(&quot;&quot;, &quot;&quot;) = &quot;&quot;
     *    StringUtil.difference(&quot;&quot;, &quot;abc&quot;) = &quot;abc&quot;
     *    StringUtil.difference(&quot;abc&quot;, &quot;&quot;) = &quot;&quot;
     *    StringUtil.difference(&quot;abc&quot;, &quot;abc&quot;) = &quot;&quot;
     *    StringUtil.difference(&quot;ab&quot;, &quot;abxyz&quot;) = &quot;xyz&quot;
     *    StringUtil.difference(&quot;abcde&quot;, &quot;abxyz&quot;) = &quot;xyz&quot;
     *    StringUtil.difference(&quot;abcde&quot;, &quot;xyz&quot;) = &quot;xyz&quot;
     * </pre>
     *
     * @method Name : difference
     * @param str1, str2 
     * @return String
     * @throws none
     * 
     */
    public static String difference(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }
        if (str2 == null) {
            return str1;
        }
        int at = indexOfDifference(str1, str2);
        if (at == -1) {
            return EMPTY;
        }
        return str2.substring(at);
    }

    /**
     * <pre>
     * 1. 개요 : 두문자열을 비교하여 서로 다른부분의 위치를 리턴한다. 두문자열이 동일하면 -1을 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.indexOfDifference(null, null) = -1
     *    StringUtil.indexOfDifference(&quot;&quot;, &quot;&quot;) = -1
     *    StringUtil.indexOfDifference(&quot;&quot;, &quot;abc&quot;) = 0
     *    StringUtil.indexOfDifference(&quot;abc&quot;, &quot;&quot;) = 0
     *    StringUtil.indexOfDifference(&quot;abc&quot;, &quot;abc&quot;) = -1
     *    StringUtil.indexOfDifference(&quot;ab&quot;, &quot;abxyz&quot;) = 2
     *    StringUtil.indexOfDifference(&quot;abcde&quot;, &quot;abxyz&quot;) = 2
     *    StringUtil.indexOfDifference(&quot;abcde&quot;, &quot;xyz&quot;) = 0
     * </pre>
     *
     * @method Name : indexOfDifference
     * @param str1, str2 
     * @return integer
     * @throws none
     * 
     */
    public static int indexOfDifference(String str1, String str2) {
        if (str1 == str2) {
            return -1;
        }
        if (str1 == null || str2 == null) {
            return 0;
        }
        int i;
        for (i = 0; i < str1.length() && i < str2.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        if (i < str2.length() || i < str1.length()) {
            return i;
        }
        return -1;
    }

    /**
     * <pre>
     * 1. 개요 : 두문자열을 비교하여 기준문자열(s)를 target문자열(t)로 변환해야하는 문자의 갯수를 리턴한다.
     * 2. 처리내용 : 
     *    StringUtil.getLevenshteinDistance(null, *)             = IllegalArgumentException
     *    StringUtil.getLevenshteinDistance(*, null)             = IllegalArgumentException
     *    StringUtil.getLevenshteinDistance(&quot;&quot;,&quot;&quot;)               = 0
     *    StringUtil.getLevenshteinDistance(&quot;&quot;,&quot;a&quot;)              = 1
     *    StringUtil.getLevenshteinDistance(&quot;aaapppp&quot;, &quot;&quot;)       = 7
     *    StringUtil.getLevenshteinDistance(&quot;frog&quot;, &quot;fog&quot;)       = 1
     *    StringUtil.getLevenshteinDistance(&quot;fly&quot;, &quot;ant&quot;)        = 3
     *    StringUtil.getLevenshteinDistance(&quot;elephant&quot;, &quot;hippo&quot;) = 7
     *    StringUtil.getLevenshteinDistance(&quot;hippo&quot;, &quot;elephant&quot;) = 7
     *    StringUtil.getLevenshteinDistance(&quot;hippo&quot;, &quot;zzzzzzzz&quot;) = 8
     *    StringUtil.getLevenshteinDistance(&quot;hello&quot;, &quot;hallo&quot;)    = 1
     * </pre>
     *
     * @method Name : getLevenshteinDistance
     * @param s, t 
     * @return integer
     * @throws none
     * 
     */
    public static int getLevenshteinDistance(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int d[][]; // matrix
        int n; // length of s
        int m; // length of t
        int i; // iterates through s
        int j; // iterates through t
        char s_i; // ith character of s
        char t_j; // jth character of t
        int cost; // cost

        // Step 1
        n = s.length();
        m = t.length();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];

        // Step 2
        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }

        // Step 3
        for (i = 1; i <= n; i++) {
            s_i = s.charAt(i - 1);

            // Step 4
            for (j = 1; j <= m; j++) {
                t_j = t.charAt(j - 1);

                // Step 5
                if (s_i == t_j) {
                    cost = 0;
                } else {
                    cost = 1;
                }

                // Step 6
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + cost);
            }
        }

        // Step 7
        return d[n][m];
    }

    /**
     * <pre>
     * 1. 개요 : 최소 값을 반환
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : min
     * @param a, b, c
     * @return integer
     * @throws none
     * 
     */
    private static int min(int a, int b, int c) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        return a;
    }

    /**
     * <pre>
     * 1. 개요 : 숫자인지 아닌지를 검사하고 true/false Return.
     * 2. 처리내용 : 
     * 				checkNumeric(&quot;abf134&quot;) returns false
     * </pre>
     *
     * @method Name : checkNumber
     * @param chkValue
     * @return boolean
     * @throws none
     * 
     */
    public static boolean checkNumber(String chkValue) {
        try {
            Double.parseDouble(chkValue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * <pre>
     * 1. 개요 : String의 처음부터 len길이만큼 자른 String을 Return.
     * 2. 처리내용 :
     * 				fixLength(&quot;abcd&quot;,2) returns &quot;ab&quot; 
     * </pre>
     *
     * @method Name : fixLength
     * @param str, len
     * @return String
     * @throws none
     * 
     */
    public static String fixLength(String str, int len) {
        return fixLength(str, 0, len);
    }

    /**
     * <pre>
     * 1. 개요 : String의 off 위치부터 len길이만큼 자른 String을 Return.
     * 2. 처리내용 :
     * 				fixLength(&quot;abcd&quot;,1,2) returns &quot;bc&quot; 
     * </pre>
     *
     * @method Name : fixLength
     * @param str, off, len
     * @return String
     * @throws none
     * 
     */
    public static String fixLength(String str, int off, int len) {
        int str_len = str.length();

        if (str_len <= off || len <= 0) {
            return "";
        }
        if (str_len - off < len) {
            return str.substring(off);
        }
        return str.substring(off, len + off);
    }

    /**
     * <pre>
     * 1. 개요 : HashMap에 저장된 Key값들을 String Array로 Return.
     * 2. 처리내용 :
     * 				getHashMapKeys(map) 
     * </pre>
     *
     * @method Name : getHashMapKeys
     * @param map
     * @return String[]
     * @throws none
     * 
     */
    @SuppressWarnings("rawtypes")
	public static String[] getHashMapKeys(HashMap map) {
        if (map == null) {
            return null;
        }
        String[] ret = new String[map.size()];
        int inc = 0;
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            ret[inc++] = (String) i.next();
        }

        return ret;
    }

    /**
     * <pre>
     * 1. 개요 : str에서 숫자만 Return.
     * 2. 처리내용 : 
     * 				getRawDigit(&quot;123,123&quot;) returns &quot;123123&quot;
     * </pre>
     *
     * @method Name : getRawDigit
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String getRawDigit(String str) {
        char[] c = str.toCharArray();
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                buff.append(c[i]);
            }
        }
        return buff.toString();
    }

    /**
     * <pre>
     * 1. 개요 : fileName을 시스템의 파일시스템에 맞게 Return.
     * 2. 처리내용 :
     * 				StringUtil.getSystemFileName(fileNM) 
     * </pre>
     *
     * @method Name : getSystemFileName
     * @param fileName
     * @return String
     * @throws none
     * 
     */
    public static String getSystemFileName(String fileName) {
        String separator = System.getProperty("file.separator");
        fileName = replaceAll(fileName, "\\", separator);
        fileName = replaceAll(fileName, "/", separator);
        return fileName;
    }

    /**
     * <pre>
     * 1. 개요 : str1의 off에서부터 str2를 찾아 replace로 replace한 String을 Return.
     * 2. 처리내용 : 
     * 				replace(&quot;12123&quot;, 1, &quot;2&quot;, &quot;3&quot;) returns &quot;13123&quot;
     * </pre>
     *
     * @method Name : replace
     * @param str1, off, str2, replace 
     * @return String
     * @throws none
     * 
     */
    public static String replace(String str1, int off, String str2, String replace) {
        off = str1.indexOf(str2, off);
        if (off == -1) {
            return str1;
        }

        StringBuffer buff = new StringBuffer(str1);
        buff.replace(off, off + str2.length(), replace);
        return buff.toString();
    }

    /**
     * <pre>
     * 1. 개요 : str1의 off에서부터 모든 str2를 찾아 replace로 replace한 String을 Return.
     * 2. 처리내용 : 
     * 				replaceAll(&quot;12123&quot;, 1, &quot;2&quot;, &quot;3&quot;) returns &quot;13133&quot;
     * </pre>
     *
     * @method Name : replaceAll
     * @param str1, off, str2, replace 
     * @return String
     * @throws none
     * 
     */
    public static String replaceAll(String str1, int off, String str2, String replace) {
        if (str1 == null || str2 == null || replace == null) {
            return str1;
        }

        off = str1.indexOf(str2, off);
        StringBuffer buff = new StringBuffer(str1);
        while (off != -1) {
            buff.replace(off, off + str2.length(), replace);
            str1 = buff.toString();
            if (off + str2.length() < str1.length()) {
                off = str1.indexOf(str2, off + str2.length() + 1);
            } else {
                off = -1;
            }
        }
        return str1;
    }

    /**
     * <pre>
     * 1. 개요 : str1의 처음부터 모든 str2를 찾아 replace로 replace한 String을 Return.
     * 2. 처리내용 : 
     * 				replaceAll(&quot;12123&quot;, 1, &quot;2&quot;, &quot;3&quot;) returns &quot;13133&quot;
     * </pre>
     *
     * @method Name : replaceAll
     * @param str1, str2, replace 
     * @return String
     * @throws none
     * 
     */
    public static String replaceAll(String str1, String str2, String replace) {
        return replaceAll(str1, 0, str2, replace);
    }

    /**
     * <pre>
     * 1. 개요 : 숫자인지 아닌지를 검사하고 true/false Return.
     * 2. 처리내용 : 
     * 				checkNumeric(&quot;abf134&quot;) returns false
     * </pre>
     *
     * @method Name : checkNumeric
     * @param chkValue 
     * @return boolean
     * @throws none
     * 
     */
    public static boolean checkNumeric(String chkValue) {
        if (chkValue.equals("")) {
            return false;
        }

        char[] chkBuff = chkValue.toCharArray();

        for (int i = 0; i < chkBuff.length; i++) {
            if (Character.isDigit(chkBuff[i]) == false) {
                return false;
            }
        }
        return true;
    }

    public static String toString(int value) {
        return Integer.toString(value);
    }

    /**
     * <pre>
     * 1. 개요 : US7ASCII용 DATABASE에 Korean Insert시 사용
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : toEng
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String toEng(String str) {
        try {
            if (str == null)
                str = "";
            return new String(str.getBytes("EUC-KR"), "Cp1252");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * <pre>
     * 1. 개요 : US7ASCII용 DATABASE에 Korean Select시 사용
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : toKor
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String toKor(String str) {
        try {
            if (str == null)
                str = "";
            return new String(str.getBytes("8859_1"), "EUC-KR");
             //return new String(str.getBytes("Cp1252"),"EUC_KR");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    
    /**
     * <pre>
     * 1. 개요 : UTF-8용  DATABASE에 Korean Select시 사용
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : utfToksc
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String utfToksc(String str) {
        try {
            if (str == null)
                str = "";
            return new String(str.getBytes("UTF-8"), "EUC-KR");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    
    /**
     * <pre>
     * 1. 개요 : UTF-8용  DATABASE에 ASCII로 사용
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : utfToasc
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String utfToasc(String str) {
        try {
            if (str == null)
                str = "";
            return new String(str.getBytes("UTF-8"), "8859_1");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * <pre>
     * 1. 개요 : delimeter에 의해서 구성된 String을 String[]로 변환한다. <BR>
     * 2. 처리내용 : 
     * 				(예) 12:23 --> String[0] = "12", String[1] = 23 <BR>
     * </pre>
     *
     * @method Name : StrToStrArray
     * @param str, delimeter
     * @return String[]
     * @throws none
     * 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static String[] StrToStrArray(String str, String delimeter) {
        StringTokenizer st = new StringTokenizer(str, delimeter);
        Vector vt = new Vector();

        String temp = null;
        // 끊어서 Vector에 집어넣는다.
        while (st.hasMoreTokens()) {
            temp = st.nextToken();
            vt.addElement(temp);
        }

        String[] out = new String[vt.size()];

        // 집어넣은 data를 String[]로 변환한다.
        for (int i = 0; i < vt.size(); i++) {
            out[i] = (String) vt.elementAt(i);
        }

        return out;
    }

    /**
     * <pre>
     * 1. 개요 : String[]를 delimeter에 의해서 구성된 String로 변환한다. <BR>
     * 2. 처리내용 :
     * 				(예) String[0] = "12", String[1] = 23 --> 12:23 <BR> 
     * </pre>
     *
     * @method Name : StrArrayToStr
     * @param str, delimeter 
     * @return String
     * @throws none
     * 
     */
    public static String StrArrayToStr(String[] Str, String delimeter) {
        String out = "";

        for (int i = 0; i < Str.length; i++) {
            out += Str[i];
            out += delimeter;
        }
        out = out.substring(0, out.length() - 1);

        return out;
    }

    /**
     * <pre>
     * 1. 개요 : 날짜문자열을 날짜표시타입으로 변환한다. <BR>
     * 2. 처리내용 :
     * 				(예) 1998-12-10 --> 12/10/1999 <BR> 
     * </pre>
     *
     * @method Name : convertDateType
     * @param dateString 
     * @return String
     * @throws none
     * 
     */
    public static String convertDateType(String dateString) {
        if (dateString.length() == 0 || dateString == null)
            return "";
        if (dateString.length() != 10)
            return "invalid length";

        String year = dateString.substring(0, 4);
        String month = dateString.substring(5, 7);
        String date = dateString.substring(8, 10);

        return (month + "/" + date + "/" + year);
    }

    /**
     * <pre>
     * 1. 개요 : 날짜문자열을 informix DATETIME형태로 변환 <BR>
     * 2. 처리내용 :
     * 				(예) 1998-12-10 10:10:10.0 --> 1998-12-10 10:10:10 <BR> 
     * </pre>
     *
     * @method Name : convertDateTimeType
     * @param dateString 
     * @return String
     * @throws none
     * 
     */
    public static String convertDateTimeType(String dateString) {
        if (dateString.length() == 0)
            return "";
        // if (dateString.length() != 21) return "invalid length";

        String year = dateString.substring(0, 4);
        String month = dateString.substring(5, 7);
        String date = dateString.substring(8, 10);
        String hour = dateString.substring(11, 13);
        String min = dateString.substring(14, 16);
        String sec = dateString.substring(17, 19);

        return (year + "-" + month + "-" + date + " " + hour + ":" + min + ":" + sec);
    }

    /**
     * <pre>
     * 1. 개요 : 문자열을 받아서 Enter Key를 특정문자열(`)로 변환하거나 특정문자열을 Enter key로 변환함...  
     * 2. 처리내용 : 
     * 				- Informix thin driver Bug 때문에 SQL문을 생성시 사용키 위함.
     * </pre>
     *
     * @method Name : convertRN
     * @param str, nFlag
     * @return String
     * @throws none
     * 
     */
    public static String convertRN(String str, int nFlag) {
        StringBuffer dbStr = new StringBuffer();
        int i = 0;

        if (str == null) {
            return "";
        } else {
            if (nFlag > 0) { // 양수이면 Enter Key를 `로 변환
                str = str.replace('\r', '`');
                str = str.replace('\n', '`');

                return str;
            } else { // 음수이면 `를 Enter Key로 변환
                for (; i < str.length(); i++) {
                    if ((str.charAt(i) == '`') && ((i + 1) < str.length()) && (str.charAt(i + 1) == '`')) {
                        i++;
                        dbStr.append("\r\n");
                    } else {
                        dbStr.append(str.charAt(i));
                    }
                }// end for
            }// end sub if-else
        }// end main if-else
        return dbStr.toString();
    }// end convertRN method

    /**
     * <pre>
     * 1. 개요 : 문자열을 받아서 Enter Key와 &quot;'&quot;를  특정문자열(:)로 변환하거나
     * 			특정문자열을 Enter key로 변환함...
     * 2. 처리내용 : 
     * 				- 스트립트변수에 엔터키가 있는 문장을 넣을때 에러 발생을 방지하기 위해
     * 				- 스트립트변수에 '가 있는 문장을 넣을때 에러 발생을 방지하기 위해
     * </pre>
     *
     * @method Name : convertRN4js
     * @param str, nFlag 
     * @return String
     * @throws none
     * 
     */
    public static String convertRN4js(String str, int nFlag) {
        StringBuffer dbStr = new StringBuffer();
        String dbStr2 = new String();

        int i = 0;
        if (str == null) {
            return "";
        } else {
            if (nFlag > 0) { // 양수이면 Enter Key를 `로 변환
                str = str.replace('\r', ':');
                str = str.replace('\n', ':');
                str = str.replace('\'', '`');
                return str;
            } else { // 음수이면 `를 Enter Key로 변환
                for (; i < str.length(); i++) {
                    if ((str.charAt(i) == ':') && ((i + 1) < str.length()) && (str.charAt(i + 1) == ':')) {
                        i++;
                        dbStr.append("\r\n");
                    } else {
                        dbStr.append(str.charAt(i));
                    }
                }// end for
                dbStr2 = dbStr.toString();
                dbStr2 = dbStr2.replace('`', '\'');
            }// end sub if-else
        }// end main if-else
        return dbStr2.toString();
    }// end convertRN method

    /**
     * <pre>
     * 1. 개요 : 문자열을 받아서 Enter Key를 특정문자열(<BR>)로 변환하거나 특정문자열을 Enter key로 변환함...
     * 2. 처리내용 : 
     * 				- Informix thin driver Bug 때문에 SQL문을 생성시 사용키 위함.
     * </pre>
     *
     * @method Name : convertBR
     * @param str, nFlag 
     * @return String
     * @throws none
     * 
     */
    public static String convertBR(String str, int nFlag) {
        StringBuffer fileStr = new StringBuffer();

        int i = 0;
        int lasti = 0;

        if (str == null) {
            return "";
        } else {
            if (nFlag > 0) { // 양수이면 Enter Key를 `<BR>`로 변환
                for (; i < str.length(); i++) {
                    if (str.charAt(i) == '\r') {
                    	;
                    } else if (str.charAt(i) == '\n') {
                    	fileStr.append("<br />");
                    } else {
                        fileStr.append(str.charAt(i));
                    }

                }// end for

                return fileStr.toString();
            } else { // 음수이면 <BR>를 Enter Key로 변환
                i = str.indexOf("<br />");
                System.out.println("br == " + i);

                while ((i != -1) && (i < str.length())) {
                    fileStr.append(str.substring(lasti, i));
                    fileStr.append("\r\n");

                    i += 4;
                    lasti = i;

                    i = str.indexOf("<br />", lasti);
                    System.out.println("br == " + i);
                } // end while

                if (i < str.length()) {
                    fileStr.append(str.substring(lasti, str.length()));
                }

            }// end sub if-else

        }// end main if-else

        System.out.println(" convertBR : " + fileStr.toString() + "==");
        return fileStr.toString();
    }// end convertRN method

    /**
     * <pre>
     * 1. 개요 : 문자열을 받아서 Enter Key를 유닉스용 Enter로 변환
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : convertUnixRN
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String convertUnixRN(String str) {
        StringBuffer fileStr = new StringBuffer();

        int i = 0;

        if (str == null) {
            return "";
        } else {
            for (; i < str.length(); i++) {
                if (str.charAt(i) == '\r') {
                    ;
                }
                // if ( str.charAt(i) == '\n' )
                // { ;}
                else {
                    fileStr.append(str.charAt(i));
                }

            }// end for

            return fileStr.toString();

        }// end main if-else

    }// end convertRN method

    /**
     * <pre>
     * 1. 개요 : 에러대신 Zero String을 리턴하는 substring 함수 <BR>
     * 2. 처리내용 : 
     * 				(예) getSubstring("1234",4,2) --> ""<BR>
     * </pre>
     *
     * @method Name : getSubstring
     * @param Str, start, len 
     * @return String
     * @throws none
     * 
     */
    public static String getSubstring(String Str, int start, int len) {
        if (Str == null)
            return "";
        int slen = Str.length();

        if ((slen < 1) || (start < 0) || (len < 1))
            return "";

        if ((slen - 1) < start)
            return "";

        if (slen < (start + len)) {
            return Str.substring(start, Str.length());
        } else {
            return Str.substring(start, start + len);
        }
    }

    /**
     * <pre>
     * 1. 개요 : 총길이에 맞게 String 앞을 문자로 채워주는 함수 <BR>
     * 2. 처리내용 : 
     * 				(예) makeFPading("1234",6,"0") --> "001234" <BR>
     * </pre>
     *
     * @method Name : makeFPading
     * @param Str, totlen, pad 
     * @return String
     * @throws none
     * 
     */
    public static String makeFPading(String Str, int totlen, String pad) {
        String retStr = "";

        if (Str == null)
            return "";
        int slen = Str.length();

        if ((totlen < 1) || (slen >= totlen))
            return Str;

        for (int i = 0; i < (totlen - slen); i++) {
            retStr += pad;
        }
        retStr += Str;

        return retStr;
    }

    /**
     * <pre>
     * 1. 개요 : 총길이에 맞게 String 뒤를 문자로 채워주는 함수 <BR>
     * 2. 처리내용 :
     * 				(예) makeEPading("1234",6,"0") --> "123400" <BR> 
     * </pre>
     *
     * @method Name : makeEPading
     * @param Str, totlen, pad 
     * @return String
     * @throws none
     * 
     */
    public static String makeEPading(String Str, int totlen, String pad) {
        String retStr = "";

        if (Str == null)
            return "";
        int slen = Str.length();

        if ((totlen < 1) || (slen >= totlen))
            return Str;

        for (int i = 0; i < (totlen - slen); i++) {
            retStr += pad;
        }
        retStr = Str + retStr;

        return retStr;
    }

    /**
     * <pre>
     * 1. 개요 : 문자열의 일정 길이 마다 다른 문자를 채워 넣는 함수 <BR>
     * 			<TD>에서 문자열에 LINE변경이 없는 경우 이용 <BR>
     * 2. 처리내용 : 
     * 				(예) insLenDeli("1234567890",2,"\r\n") --> "12\r\n34\r\n56\r\n78\r\n90" <BR>
     * 				(예) insLenDeli("1234567890",2," <br>") --> "12 <br>
     * </pre>
     *
     * @method Name : insLenDeli
     * @param str, slen, deli 
     * @return String
     * @throws none
     * 
     */
    public static String insLenDeli(String str, int slen, String deli) {
        StringBuffer sb = new StringBuffer();

        if (str.equals(""))
            return "";

        while (!str.equals("")) {
            if (str.length() > slen) {
                sb.append(str.substring(0, slen - 1) + deli);
                str = str.substring(slen);
            } else {
                sb.append(str);
                str = "";
            }
        }
        return sb.toString();
    }

    /**
     * <pre>
     * 1. 개요 : 문자가 NULL인 경우 공백을 반환하는 함수 <BR>
     * 2. 처리내용 : 
     * 				(예) Null2Space("ABCD") --> ABCD <BR>
     * </pre>
     *
     * @method Name : Null2Space
     * @param str 
     * @return String
     * @throws none
     * 
     */
    public static String Null2Space(String str) {
 
    	if (str == null)
            return "";
		else if ( str.equals("null") || str.equals("NULL") )
			return  "";          	
        else
            return str;
    }
    
    /**
     * <pre>
     * 1. 개요 : commonBiz/fileDownload.do 파일다운로드 시 파일정보를 URLEncode로 UTF-8로 엔코딩한다.
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : createFileDownloadInfo
     * @param saveFolderType, filePath, fileName 
     * @return String
     * @throws none
     * 
     */
    public static String createFileDownloadInfo(String saveFolderType, String filePath, String fileName) {
    	StringBuffer sb = new StringBuffer();
    	sb.append(saveFolderType);
    	sb.append("#");
    	sb.append(filePath);
    	sb.append("#");
    	sb.append(fileName);
    	try {
    		return URLEncoder.encode(sb.toString(), "UTF-8");
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
	/**
	 * <pre>
	 * 1. 개요 : 파일의 확장자를 구분
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @method Name : getExt
	 * @param extension
	 * @return String
	 * @throws none
	 * 
	 */
	public static String getExt(String extension) {
		if (extension == null)
			return "";
		String ext = extension.toLowerCase();
		if (ext.equals("image/jpeg")) 
			return "jpg"; 
		if (ext.equals("image/png"))
			return "png";
		if (ext.equals("image/gif"))
			return "gif";
		return "";
	}
	
    /**
     * <pre>
     * 1. 개요 : 문자열 자르기 (한글, 영문 고려)
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : cutStr
     * @param str, len, type 
     * @return String
     * @throws none
     * 
     */
    public static String cutStr(String str, int len, char type) { 
        byte[] bytes = str.getBytes(); 
        int lenTmp = bytes.length; 
        int counter = 0; 
        String f_str = null;
        
        try {
            if (len >= lenTmp) { 
                StringBuffer sb = new StringBuffer(); 
                sb.append(str); 
                
                for(int i=0;i<len-lenTmp;i++){ 
                    sb.append(' '); 
                } 
                return sb.toString(); 
            } 
        
            for (int i = len - 1; i >= 0; i--) { 
                if (((int)bytes[i] & 0x80) != 0) 
                counter++; 
            } 
             
            if (type == '+'){ 
                f_str = new String(bytes, 0, len + (counter % 2)); 
            } else { 
                f_str = new String(bytes, 0, len - (counter % 2)); 
            }
            
            if (lenTmp > len) {
                f_str = f_str + "...";
            }
        } catch(Exception e) {
        	log.error("[Method : cutStr] ==> " + e.toString());
        }
        return f_str; 
    }
    
    /**
     * <pre>
     * 1. 개요 : 문자열 자르기
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : strCut
     * @param szText, szKey, nLength, nPrev, isNoTag, isAdddot
     * @return String
     * @throws none
     * 
     */
    public static String strCut(String szText, String szKey, int nLength, int nPrev, boolean isNotag, boolean isAdddot) {
    	 
    	String r_val = szText;
    	int oF = 0, oL = 0, rF = 0, rL = 0;
    	int nLengthPrev = 0;
    	Pattern p = Pattern.compile("<(/?)([^<>]*)?>", Pattern.CASE_INSENSITIVE);
    	 
    	if (isNotag) {
    		r_val = p.matcher(r_val).replaceAll("");
    	}
    	
    	r_val = r_val.replaceAll("&amp;", "&");
    	r_val = r_val.replaceAll("(!/|\r|\n|&nbsp;)", "");
    	 
    	try {
    		byte[] bytes = r_val.getBytes("UTF-8");
    		if (szKey != null && !szKey.equals("")) {
    		nLengthPrev = (r_val.indexOf(szKey) == -1)? 0: r_val.indexOf(szKey);
    		nLengthPrev = r_val.substring(0, nLengthPrev).getBytes("MS949").length;
    		nLengthPrev = (nLengthPrev-nPrev >= 0)? nLengthPrev-nPrev:0;
    		}
    		 
    		int j = 0;
    		 
    		if (nLengthPrev > 0) while(j < bytes.length) {
    		if ((bytes[j] & 0x80) != 0) {
    			oF+=2; rF+=3; if (oF+2 > nLengthPrev) {break;} j+=3;
    			} else {if (oF+1 > nLengthPrev) {break;} ++oF; ++rF; ++j;}
    		}
    		 
    		j = rF;
    		 
    		while(j < bytes.length) {
    			if ((bytes[j] & 0x80) != 0) {
    			if (oL+2 > nLength) {break;} oL+=2; rL+=3; j+=3;
    			} else {if (oL+1 > nLength) {break;} ++oL; ++rL; ++j;}
    		}
    		 
    		r_val = new String(bytes, rF, rL, "UTF-8");
    		 
    		if (isAdddot && rF+rL+3 <= bytes.length) {
    			r_val+="...";
    		}
    	} catch(UnsupportedEncodingException e){ e.printStackTrace(); }  
    	 
    	return r_val;
    }

    /**
     * <pre>
     * 1. 개요 : base64 방식으로 encode
     * 2. 처리내용 : 
     * </pre>
     *
     * @method Name : encodeBase64
     * @param str 
     * @return String
     * @throws none
     * 
     */
    /*public static String encodeBase64(String str) throws Exception{
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	OutputStream b64os = MimeUtility.encode(baos, "base64");
    	b64os.write(str.getBytes());
    	b64os.close();
    	return baos.toString().trim();
    }*/
    
	/**
	 * <pre>
	 * 1. 개요 : Null or Whitespace check
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @method Name : isEmptyOrWhitespace
	 * @param value 
	 * @return boolean
	 * @throws none
	 * 
	 */
	public boolean isEmptyOrWhitespace(String value){
		if (value == null || value.trim().length() == 0 || "null".equals(value)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : Null or Whitespace check
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @method Name : isStringCompare
	 * @param value, worth 
	 * @return 
	 * @throws
	 * 
	 */
	public boolean isStringCompare(String value, String worth) {
		if (value==null || value.trim().length() == 0){
			value = "";
		}

		if (worth==null || worth.trim().length() == 0){
			worth = "";
		}
		
		if (value.equals(worth)) { 
			return true;
		} else {
			return false;
		}
	}    
}