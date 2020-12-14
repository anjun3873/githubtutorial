package com.elsys.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  ETRI Distributed Resource/Mediation System for new re-generation Energy Exchange
 *
 *  Copyright ⓒ [2017] ETRI. All rights reserved.
 *
 *    This is a proprietary software of ETRI, and you may not use this file except in
 *  compliance with license agreement with ETRI. Any redistribution or use of this
 *  software, with or without modification shall be strictly prohibited without prior written
 *  approval of ETRI, and the copyright notice above does not evidence any actual or
 *  intended publication of such software.
 *
 * com.nc.common.utils : HtmlDataUtil.java
 * @author creme55
 * @since 2017. 1. 20.
 * @version 1.0
 * @see 
 * @Copyright © [2017] By ETRI. All rights reserved.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *      수정일              수정자                  수정내용
 *  -------------        -----------       ------------------------------------------
 *  2017. 1. 20.          creme55          최초생성 (KPX Site's to gathering to data)
 *
 * </pre>
 **/
public class HtmlDataUtil {
	private static final Logger log = LoggerFactory.getLogger(HtmlDataUtil.class);
	
	public static String getTable(String urlStr) throws IOException {
	    URL url = new URL(urlStr);
	    BufferedReader reader = null;
	    
	    if (log.isDebugEnabled()) {
	    	log.debug("==========================================================================================");
	    	log.debug("= urlStr : [{}] =", urlStr);
	    	log.debug("==========================================================================================");
	    }
	    
	    try {
	        reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

	        String line = null;
	        String retStr = "";
	        boolean writeYn = false;
	        
	        while ((line = reader.readLine()) != null) {
	            int start = line.indexOf("<table ");

	            if (start != -1) {
	            	writeYn = true;
	            }
	            
	            if (writeYn) {
	                retStr += line;
	                
	            	if (line.trim().equals("</table>")) {
	            		writeYn = false;
	            		break;
	            	}
	            }
	        }
	        
	        return retStr;
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
	public static String getTable2(String urlStr) throws IOException {
	    URL url = new URL(urlStr);
	    BufferedReader reader = null;
	    
	    if (log.isDebugEnabled()) {
	    	log.debug("==========================================================================================");
	    	log.debug("= urlStr : [{}] =", urlStr);
	    	log.debug("==========================================================================================");
	    }
	    
	    try {
	        reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

	        String line = null;
	        String retStr = "";
	        boolean writeYn = false;
	        
	        while ((line = reader.readLine()) != null) {
	            int start = line.indexOf("(단위:REC, 원/REC)</p>");

	            if (start != -1) {
	            	writeYn = true;
	            }
	            
	            if (writeYn) {
	                retStr += line;
	                
	            	if (line.trim().equals("</table>")) {
	            		writeYn = false;
	            		break;
	            	}
	            }
	        }
	        
	        return retStr;
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
}