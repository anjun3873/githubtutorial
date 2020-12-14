package com.elsys.common;

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
 * com.nc.common : CommonConstants.java
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
 *  2016. 10. 12.          creme55         최초 생성 (공통 상수 정의)                  
 *
 * </pre>
 **/
public class CommonConstants {

	public static final String DEFAULT_CHARSET = "UTF-8";
	public static final String PAGINATE = "PAGINATE";
	
	public static String[] cronConfig = {
										"0 5 * * * ?"
										,"0 10 5 * * ?"
										,"0 50 * * * ?"
										,"0 15 * * * ?"
										,"0 30 1 * * ?"
										};
	
	public static String[] jobName = {
										"orderAndTenderProc"
										,"smpProc"
										,"futureWeatherProc"
										,"spaceWeatherProc"
										,"mediateCheckProc"
									};
	
	public static String[] jobGroupName = {
											"orderAndTenderGroup"
											,"smpGroup"
											,"futureWeatherGroup"
											,"spaceWeatherGroup"
											,"mediateCheckGroup"
										};
	
	public static boolean orderFlag = true;
	
	public static String mdteEnprId = "ENPR2017010300000001";
	
	public static String mdtrLoginId = "aggregator1";
	
	public static String sleWntDt = "";
	
	public static String mdteStaccDt = "";
	
	public static String kpxSmpUrl = "http://www.kpx.or.kr/www/contents.do?key=225";
	public static String kpxSmpJejuUrl = "http://www.kpx.or.kr/www/contents.do?key=226";
	public static String kpxRecUrl = "http://www.kpx.or.kr";
}