package com.elsys.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

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
 * com.nc.common.utils : EncryptionUtil.java
 * @author creme55
 * @since 2016. 10. 21.
 * @version 1.0
 * @see 
 * @Copyright © [2016] By ETRI. All rights reserved.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *      수정일              수정자                  수정내용
 *  -------------        -----------       -------------------------
 *  2016. 10. 21.          creme55         최초 생성(암호화 관리)
 *
 * </pre>
 **/
public class EncryptionUtil {

	/**
	 * <pre>
	 * 1. 개요 : 암호화 처리
	 * 2. 처리내용 : MD5 방식의 암호화
	 * </pre>
	 *
	 * @method Name : encrypt_md5
	 * @param strData
	 * @return String
	 * @throws none
	 * 
	 */
	public static String encrypt_md5(String strData) {
		 String strENCData = "";
		 try {
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 
	         byte[] bytData = strData.getBytes();
	         md.update(bytData);
	         
	         byte[] digest = md.digest();
	         for (int i = 0; i < digest.length; i++) {
	        	 strENCData += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
	         }
		 } catch (NoSuchAlgorithmException e) {
			 e.printStackTrace();
		 }
		 
		 return strENCData;
	 }
	 
	 /**
	 * <pre>
	 * 1. 개요 : 암호화 처리
	 * 2. 처리내용 : SHA1 방식의 암호화
	 * </pre>
	 *
	 * @method Name : encrypt_sha1
	 * @param strData
	 * @return String
	 * @throws none
	 * 
	 */
	public static String encrypt_sha1(String strData) {
		 String strENCData = "";
	      try {
	    	  MessageDigest md = MessageDigest.getInstance("SHA1");
	    	  
	    	  byte[] bytData = strData.getBytes();
	    	  md.update(bytData);
	    	  
	    	  byte[] digest = md.digest();
	    	  for (int i = 0; i < digest.length; i++) {
	    		  strENCData += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
	    	  }
	      } catch (NoSuchAlgorithmException e) {
	    	  e.printStackTrace();
	      }
	      
	      return strENCData;
	 }
	 
	 /**
	 * <pre>
	 * 1. 개요 : 암호화 처리
	 * 2. 처리내용 : SHA256 방식의 암호화 - salt값을 사용하지 않는 경우
	 * </pre>
	 *
	 * @method Name : encrypt_sha2
	 * @param strData 
	 * @return String
	 * @throws none
	 * 
	 */
	public static String encrypt_sha2(String strData) {
		 String strENCData = "";
	      try {
	    	  MessageDigest md = MessageDigest.getInstance("SHA-256");
	    	  
	    	  byte[] bytData = strData.getBytes("UTF-8");
	    	  md.update(bytData);
	    	  
	    	  byte[] digest = md.digest();
	    	  for (int i = 0; i < digest.length; i++) {
	    		  strENCData += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
	    	  }
	      } catch (NoSuchAlgorithmException e) {
	    	  e.printStackTrace();
	      } catch ( UnsupportedEncodingException e) {
	    	  e.printStackTrace();
	      }
	      
	      return strENCData;
	 }
	 
	 /**
	 * <pre>
	 * 1. 개요 : 암호화 처리
	 * 2. 처리내용 : SHA256 방식의 암호화 - salt값을 사용하는 경우
	 * </pre>
	 *
	 * @method Name : encrypt_sha2
	 * @param strData, salt
	 * @return String
	 * @throws none
	 * 
	 */
	public static String encrypt_sha2(String strData, byte[] salt) {
		 String strENCData = "";
	      try {
	    	  MessageDigest md = MessageDigest.getInstance("SHA-256");
	    	  
	    	  byte[] bytData = strData.getBytes("UTF-8");
	    	  md.update(salt);
	    	  md.update(bytData);
	    	  
	    	  byte[] digest = md.digest();
	    	  for (int i = 0; i < digest.length; i++) {
	    		  strENCData += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
	    	  }
	      } catch (NoSuchAlgorithmException e) {
	    	  e.printStackTrace();
	      } catch ( UnsupportedEncodingException e) {
	    	  e.printStackTrace();
	      }
	      
	      return strENCData;
	 }
	 
	 /**
	 * <pre>
	 * 1. 개요 : 암화화 처리
	 * 2. 처리내용 : SHA256 방식의 암호화 - salt값을 사용하지 않고 iterationNb만큼 암호화 시키는 경우
	 * </pre>
	 *
	 * @method Name : encrypt_sha2
	 * @param iterationNb, strData
	 * @return String
	 * @throws none
	 * 
	 */
	public static String encrypt_sha2(int iterationNb, String strData) {
		 String strENCData = "";
		 
	      try {
	    	  MessageDigest md = MessageDigest.getInstance("SHA-256");
	    	  
	    	  byte[] bytData = strData.getBytes("UTF-8");
	    	  md.update(bytData);
	    	  
	    	  byte[] digest = md.digest();
	    	  
	    	  for (int i = 0; i < iterationNb; i++) {
	    		  md.reset();
	    		  digest = md.digest(digest);
	    	  }
		       
	    	  for (int i = 0; i < digest.length; i++) {
	    		  strENCData += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
	    	  }
	      } catch (NoSuchAlgorithmException e) {
	    	  e.printStackTrace();
	      } catch ( UnsupportedEncodingException e) {
	    	  e.printStackTrace();
	      }
	      
	      return strENCData;
	 }
	 
	 /**
	 * <pre>
	 * 1. 개요 : 암호화 처리
	 * 2. 처리내용 : SHA256 방식의 암호화 - salt값을 사용하고 iterationNb만큼 암호화 시키는 경우
	 * </pre>
	 *
	 * @method Name : encrypt_sha2
	 * @param iterationNb, strData, salt
	 * @return String
	 * @throws none
	 * 
	 */
	public static String encrypt_sha2(int iterationNb, String strData, byte[] salt) {
		 String strENCData = "";
		 
	      try {
	    	  MessageDigest md = MessageDigest.getInstance("SHA-256");
	    	  
	    	  byte[] bytData = strData.getBytes("UTF-8");
	    	  md.update(salt);
	    	  md.update(bytData);
	    	  
	    	  byte[] digest = md.digest();
	    	  
	    	  for (int i = 0; i < iterationNb; i++) {
	    		  md.reset();
	    		  digest = md.digest(digest);
	    	  }
		       
	    	  for (int i = 0; i < digest.length; i++) {
	    		  strENCData += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
	    	  }
	      } catch (NoSuchAlgorithmException e) {
	    	  e.printStackTrace();
	      } catch ( UnsupportedEncodingException e) {
	    	  e.printStackTrace();
	      }
	      
	      return strENCData;
	 }
	 
	 /**
	 * <pre>
	 * 1. 개요 : 암호화 처리
	 * 2. 처리내용 : AES KEY Generator (128)
	 * 				passwd 가 변경될 경우 아래의 메소드를 실행하여 재생성해야한다.
	 * 				모듈 효율성을 위해 생성된 키값을 미리 선전하여 키생성 로직을 제외
	 * </pre>
	 *
	 * @method Name : getRawKey
	 * @param passwd
	 * @return byte[]
	 * @throws Exception
	 * 
	 */
	public static byte[] getRawKey(String passwd) throws Exception {
		 KeyGenerator kgen = KeyGenerator.getInstance("AES");
		 SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		 byte[] seed = passwd.getBytes();
		 sr.setSeed(seed);
		 kgen.init(128, sr); // 192 and 256 bits may not be available
		 SecretKey skey = kgen.generateKey();
		 byte[] raw = skey.getEncoded();
		 return raw;
	 }
}