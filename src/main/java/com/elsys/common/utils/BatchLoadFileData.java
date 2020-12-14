package com.elsys.common.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
 * com.nc.common.utils : BatchLoadFileData.java
 * @author creme55
 * @since 2016. 11. 8.
 * @version 1.0
 * @see 
 * @Copyright © [2016] By ETRI. All rights reserved.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *      수정일              수정자                  수정내용
 *  -------------        -----------       ------------------------------------------------------------
 *  2016. 11. 8.          creme55          최초 생성(우편번호 데이터 적재를 위한 문자열을 Query로 변환)
 *
 * </pre>
 **/
@Service("convertService")
public class BatchLoadFileData {
	private static final Logger log = LoggerFactory.getLogger(BatchLoadFileData.class);
	
	@Value(value="#{app['convert_path']}")
	//@Value(value="EgovProperties.getProperty('convert_path')")
	private String textFilePath;
	
	public void fileReadNWrite() throws Exception {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
				
		try {
				String lineStr;
				String[] srcFileName = {
										"/강원도.txt"
										,"/경기도.txt"
										,"/경상남도.txt"
										,"/경상북도.txt"
										,"/광주광역시.txt"
										,"/대구광역시.txt"
										,"/대전광역시.txt"
										,"/부산광역시.txt"
										,"/서울특별시.txt"
										,"/세종특별자치시.txt"
										,"/울산광역시.txt"
										,"/인천광역시.txt"
										,"/전라남도.txt"
										,"/전라북도.txt"
										,"/제주특별자치도.txt"
										,"/충청남도.txt"
										,"/충청북도.txt"
									};
				
				for (int j = 0; j < srcFileName.length; j++) {
					
					int chkNo = 1;
	
					fileInputStream = new FileInputStream(textFilePath + srcFileName[j]);
					InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "EUC-KR");
					bufferedReader = new BufferedReader(inputStreamReader);
					
					fileOutputStream = new FileOutputStream("D:\\temp\\" + srcFileName[j]);
					OutputStreamWriter OutputStreamWriter = new OutputStreamWriter(fileOutputStream, "EUC-KR");
					bufferedWriter = new BufferedWriter(OutputStreamWriter);
					
					if (log.isDebugEnabled()) {
						log.debug("==========================================================================================");
						log.debug(" Convert Test : test =");
						log.debug("==========================================================================================");
					}
	
					while ((lineStr = bufferedReader.readLine()) != null) {
						if (chkNo > 1) {
							String[] splitStr = lineStr.split("\\|");
							
							for (int i = 0; i < splitStr.length; i++) {
								if (i == 0) {
									bufferedWriter.write("INSERT INTO TB_A_ZIP_CD(");
									bufferedWriter.write("ZIP_CD");
									bufferedWriter.write(",SIDO");
									bufferedWriter.write(",SIDO_ENG");
									bufferedWriter.write(",SIGUNGU");
									bufferedWriter.write(",SIGUNGU_ENG");
									bufferedWriter.write(",EUPMYEUN");
									bufferedWriter.write(",EUPMYEUN_ENG");
									bufferedWriter.write(",DORO_CD");
									bufferedWriter.write(",DORO_NM");
									bufferedWriter.write(",DORO_NM_ENG");
									bufferedWriter.write(",BASE_YN");
									bufferedWriter.write(",BLDG_MN_NO");
									bufferedWriter.write(",BLDG_SB_NO");
									bufferedWriter.write(",BLDG_MNG_NO");
									bufferedWriter.write(",MNY_DLVY_NM");
									bufferedWriter.write(",SIGUNGU_BLDG_NM");
									bufferedWriter.write(",LW_CD");
									bufferedWriter.write(",LW_NM");
									bufferedWriter.write(",RI_NM");
									bufferedWriter.write(",ADM_NM");
									bufferedWriter.write(",MNT_YN");
									bufferedWriter.write(",ADS_MN_NO");
									bufferedWriter.write(",EUPMYEUNGDONG_SRL_NO");
									bufferedWriter.write(",ADS_SB_NO");
									bufferedWriter.write(",OLD_ZIP_CD");
									bufferedWriter.write(",ZIP_SRL_NO) VALUES('" + splitStr[i] + "'");
								} else {
									bufferedWriter.write(", '" + splitStr[i] + "'");
								}
							}
							bufferedWriter.write(", '', '');\n");
						}
						chkNo++;
						
						if ((chkNo % 100) == 0) {
							bufferedWriter.write("COMMIT WORK;\n");
						}
					}
					bufferedWriter.flush();

					bufferedReader.close();
					bufferedWriter.close();
				}
		} catch (IOException e) {
		    System.err.println(e); // 에러가 있다면 메시지 출력
		    System.exit(1);
		} finally {
			bufferedReader.close();
			bufferedWriter.close();
		}
	}
}