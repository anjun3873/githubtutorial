package com.elsys.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import com.elsys.common.exception.NCException;

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
 * com.nc.common.utils : FileDown.java
 * @author creme55
 * @since 2016. 10. 20.
 * @version 1.0
 * @see 
 * @Copyright © [2016] By ETRI. All rights reserved.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *      수정일              수정자                  수정내용
 *  -------------        -----------       -------------------------
 *  2016. 10. 20.          creme55         최초 생성 (파일다운로드)
 *
 * </pre>
 **/
public class FileDown {

	/**
	 * <pre>
	 * 1. 개요 : 파일 존재여부 체크 
	 * 2. 처리내용 : 파일 다운로드를 위한 파일 확인
	 * </pre>
	 *
	 * @method Name : downCheck
	 * @param fileUrl 
	 * @return int
	 * @throws Exception
	 * 
	 */
	public static int downCheck(String fileUrl) throws Exception {
		if (fileUrl != null) {
			File file = new File(fileUrl);
			
			if (file.isFile()) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 파일 삭제
	 * 2. 처리내용 : 주어진 위치의 파일을 삭제한다.
	 * </pre>
	 *
	 * @method Name : fileDel
	 * @param fileUrl
	 * @return int
	 * @throws Exception
	 * 
	 */
	public static int fileDel(String fileUrl) throws Exception {
		if (fileUrl != null) {
			File file = new File(fileUrl);
			
			if (file.delete()) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 파일 다운로드 (절대경로) 
	 * 2. 처리내용 : 파일 다운로드를 위한 파일 확인
	 * </pre>
	 *
	 * @method Name : down
	 * @param response, fileUrl 
	 * @return void
	 * @throws Exception
	 * 
	 */
	public static void down(HttpServletResponse response, String fileUrl) throws Exception {
		if (fileUrl != null) {
			File file = new File(fileUrl);
			
			if (file.isFile()) {
				down(response, file, file.getName());
			}
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 파일 다운로드 (절대경로)
	 * 2. 처리내용 : 파일 다운로드를 위한 파일 확인
	 * </pre>
	 *
	 * @method Name : down
	 * @param response, fileUrl, fileName
	 * @return void
	 * @throws Exception
	 * 
	 */
	public static void down(HttpServletResponse response, String fileUrl, String fileName) throws Exception {
		if (fileUrl != null && fileName != null) {
			File file = new File(fileUrl);
			
			if (file.isFile()) {
				down(response, file, fileName);
			}
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 파일 다운로드 (절대경로)
	 * 2. 처리내용 : 파일 다운로드를 위한 파일 확인
	 * </pre>
	 *
	 * @method Name : down
	 * @param response, fileUrl, file
	 * @return void
	 * @throws Exception
	 * 
	 */
	public static void down(HttpServletResponse response, File file) throws Exception{
		down(response, file, file.getName());
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 파일 다운로드 (절대경로)
	 * 2. 처리내용 : 파일 다운로드를 위한 파일 확인
	 * </pre>
	 *
	 * @method Name : down
	 * @param response, fileUrl, file, fileName
	 * @return void
	 * @throws Exception
	 * 
	 */
	public static void down(HttpServletResponse response, File file, String fileName) throws Exception{
		if(file != null){
			FileInputStream fis = null;
			byte[] buf          = new byte[8192];
			int bytesread       = 0;
			int bytesBufferd    = 0;
			OutputStream out    = null;
			
			try{
				fileName = URLEncoder.encode(fileName, "utf-8");
				
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
				response.setHeader("Content-Transfer-Encoding", "binary");
				
				out = response.getOutputStream();
				fis = new FileInputStream(file);
				
				while((bytesread = fis.read(buf)) > -1){
					out.write(buf, 0, bytesread);
					bytesBufferd += bytesread;
					
					if(bytesBufferd > (1024 * 1024)){ // flush after 1M
						bytesBufferd = 0;
						out.flush();
					}
				}
				
				out.flush();
			} catch(Exception e) {
				e.printStackTrace();
				throw new NCException("FileDown > down 에러");
			} finally {
				if(fis != null) {
					try {
						fis.close();
					} catch(Exception e){
						
					}
				}
				
				if(out != null) {
					try {
						out.close();
					} catch(Exception e) {
						
					}
				}
			}
		}
	}
}