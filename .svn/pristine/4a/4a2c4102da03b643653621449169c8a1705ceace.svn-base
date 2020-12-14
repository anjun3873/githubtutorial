package com.elsys.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

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
 * com.nc.common.utils : FileMngUtil.java
 * @author creme55
 * @since 2016. 10. 20.
 * @version 1.0
 * @see 
 * @Copyright © [2016] By ETRI. All rights reserved.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *      수정일              수정자                  수정내용
 *  -------------        -----------       ------------------------------
 *  2016. 10. 20.          creme55         최초 생성 (파일 다운로드 관리)
 *
 * </pre>
 **/
public class FileMngUtil {
	private static final Logger log = LoggerFactory.getLogger(FileMngUtil.class);

    public static final int BUFF_SIZE = 2048;
    
    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리 
     * 2. 처리내용 : 첨부파일을 서버에 저장한다. 
     * </pre>
     *
     * @method Name : writeUploadedFile
     * @param file, newName, storedFilePath 
     * @return none
     * @throws Exception
     * 
     */
    protected void writeUploadedFile(MultipartFile file, String newName, String stordFilePath) throws Exception {
		InputStream stream = null;
		OutputStream bos = null;
		String stordFilePathReal = (stordFilePath == null ? "" : stordFilePath).replaceAll("..", "");
		try {
		    stream = file.getInputStream();
		    File cFile = new File(stordFilePathReal);
	
		    if (!cFile.isDirectory()) {
				boolean _flag = cFile.mkdir();
				if (!_flag) {
				    throw new IOException("Directory creation Failed ");
				}
		    }
	
		    bos = new FileOutputStream(stordFilePathReal + File.separator + newName);
	
		    int bytesRead = 0;
		    byte[] buffer = new byte[BUFF_SIZE];
	
		    while ((bytesRead = stream.read(buffer, 0, BUFF_SIZE)) != -1) {
		    	bos.write(buffer, 0, bytesRead);
		    }
		} catch (FileNotFoundException fnfe) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= file do not exist : [{}] =", fnfe);
				log.debug("==========================================================================================");
			}
		} catch (IOException ioe) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug(" IO Exception : [{}] =", ioe);
				log.debug("==========================================================================================");
			}
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Common Exception : [{}] =", e);
				log.debug("==========================================================================================");
			}
		} finally {
		    if (bos != null) {
				try {
				    bos.close();
				} catch (Exception ignore) {
					if (log.isDebugEnabled()) {
						log.debug("==========================================================================================");
						log.debug("= final Exception (bos) : [{}] =", ignore.getMessage());
						log.debug("==========================================================================================");
					}
				}
		    }
		    
		    if (stream != null) {
				try {
				    stream.close();
				} catch (Exception ignore) {
					if (log.isDebugEnabled()) {
						log.debug("==========================================================================================");
						log.debug("= final Exception (stream) : {}", ignore.getMessage());
						log.debug("==========================================================================================");
					}
				}
		    }
		}
    }

    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리
     * 2. 처리내용 : 첨부파일을 서버에서 삭제한다. 
     * </pre>
     *
     * @method Name : fileDelete
     * @param filePath
     * @return boolean
     * @throws Exception
     * 
     */
    public static boolean fileDelete(String filePath) throws Exception {
    	boolean deleteFlag = false;
		File file = new File(filePath);

		if (file.exists()) {
			deleteFlag = file.delete();
		}
		
		if (deleteFlag) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= 파일이 정상 삭제 되었습니다. =");
				log.debug("==========================================================================================");
			}
		} else {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= 파일이 존재하지 않습니다. =");
				log.debug("==========================================================================================");
			}
		}
		
		return deleteFlag;
    }
    
    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리
     * 2. 처리내용 : 서버의 파일을 다운로드한다. 
     * </pre>
     *
     * @method Name : downFile
     * @param request, response, streFileNm, orignFileNm 
     * @return none
     * @throws Exception
     * 
     */
    public static void downFile(HttpServletRequest request, HttpServletResponse response, String streFileNm, String orignFileNm) throws Exception {

	    String downFileName = streFileNm;
	    String orgFileName = orignFileNm;

	    File file = new File(downFileName);

		if (!file.exists()) {
		    throw new FileNotFoundException(downFileName);
		}

		if (!file.isFile()) {
		    throw new FileNotFoundException(downFileName);
		}

		byte[] b = new byte[BUFF_SIZE]; 
		
		String userAgent = request.getHeader("User-Agent");
	
	    boolean ie = userAgent.indexOf("MSIE") > -1;
	
	    String fName = null;
	
	    /*if (ie) {
	    	fName = URLEncoder.encode(name, "UTF-8");
	    } else {
	    	fName = new String(orgFileName.getBytes("utf-8"));
	    }*/
	    
	    fName = URLEncoder.encode(orgFileName, "UTF-8");
	    fName = fName.replaceAll("\\+", " ");

	    response.setHeader("Content-Disposition", "attachment; filename=\"" + fName + "\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");

		BufferedInputStream fin = null;
		BufferedOutputStream outs = null;

		try {
			fin = new BufferedInputStream(new FileInputStream(file));
		    outs = new BufferedOutputStream(response.getOutputStream());
		    int read = 0;
	
			while ((read = fin.read(b)) != -1) {
			    outs.write(b, 0, read);
			}
		} finally {
		    if (outs != null) {
				try {
				    outs.close();
				} catch (Exception ignore) {
					if (log.isDebugEnabled()) {
						log.debug("==========================================================================================");
						log.debug("= File Output Exception : [{}] =", ignore.getMessage());
						log.debug("==========================================================================================");
					}
				}
	    	}
			if (fin != null) {
				try {
				    fin.close();
				} catch (Exception ignore) {
					if (log.isDebugEnabled()) {
						log.debug("==========================================================================================");
						log.debug("File Input Exception : [{}] =", ignore.getMessage());
						log.debug("==========================================================================================");
					}
				}
			}
		}
	}
    
    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리
     * 2. 처리내용 : 파일을 실제 물리적인 경로에 생성한다.
     * </pre>
     *
     * @method Name : writeFile
     * @param file, newName, storedFilePath 
     * @return none
     * @throws Exception
     * 
     */
    protected static void writeFile(MultipartFile file, String newName, String stordFilePath) throws Exception {
		InputStream stream = null;
		OutputStream bos = null;
		newName = "" ; 
		stordFilePath = "" ;
		
		try {
		    stream = file.getInputStream();
		    File cFile = new File(stordFilePath);
	
		    if (!cFile.isDirectory())
			cFile.mkdir();
	
		    bos = new FileOutputStream(stordFilePath + File.separator + newName);
	
		    int bytesRead = 0;
		    byte[] buffer = new byte[BUFF_SIZE];
	
		    while ((bytesRead = stream.read(buffer, 0, BUFF_SIZE)) != -1) {
		    	bos.write(buffer, 0, bytesRead);
		    }
		} catch (FileNotFoundException fnfe) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= FileNotFoundException : [{}] =", fnfe);
				log.debug("==========================================================================================");
			}
		} catch (IOException ioe) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= IOException : [{}] =", ioe);
				log.debug("==========================================================================================");
			}
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug("==========================================================================================");
				log.debug("= Exception : [{}] =", e);
				log.debug("==========================================================================================");
			}
		} finally {
		    if (bos != null) {
				try {
				    bos.close();
				} catch (Exception ignore) {
					if (log.isDebugEnabled()) {
						log.debug("==========================================================================================");
						log.debug("= Binary Output Exception : {}", ignore.getMessage());
						log.debug("==========================================================================================");
					}
				}
		    }
		    if (stream != null) {
				try {
				    stream.close();
				} catch (Exception ignore) {
					if (log.isDebugEnabled()) {
						log.debug("==========================================================================================");
						log.debug("= stream Exception : [{}] =", ignore.getMessage());
						log.debug("==========================================================================================");
					}
				}
		    }
		}
    }

    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리
     * 2. 처리내용 : 파일에 확장자 확인
     * </pre>
     *
     * @method Name : isValidFileExtension
     * @param fileName, extensions 
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isValidFileExtension(String fileName, String[] extensions) throws Exception {
        boolean result = false;
        if ( fileName.trim() != "" && fileName != null && !"".equals( fileName.trim() ) && isContainFileExtension(fileName, extensions)) {
            result = true;
        } else {
            result = false;
        }
        
        return result;
    }
    
    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리
     * 2. 처리내용 : 파일에 확장자 포함 여부 확인
     * </pre>
     *
     * @method Name : isContainFileExtension
     * @param fileName, extensions
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isContainFileExtension(String fileName, String[] extensions) throws Exception {
        boolean result = false;
        String fileExtension = getFileExtension(fileName);
        
        for(String ex : extensions) {
            if (fileExtension.equals(ex)) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리
     * 2. 처리내용 : 파일에 확장자 가져오기
     * </pre>
     *
     * @method Name : getFileExtension
     * @param fileName 
     * @return String
     * @throws Exception
     * 
     */
    public String getFileExtension(String fileName) throws Exception {
        String fileExtension = "";
        
        if (fileName != null && !"".equals(fileName)) {
            if(fileName.lastIndexOf( "." ) != -1) {
                fileExtension = fileName.toLowerCase().substring( fileName.lastIndexOf( "." ) + 1, fileName.length() );
            } else {
                fileExtension = "";
            }
        } else {
            fileExtension = "";
        }
        
        return fileExtension;
    }
    
    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리
     * 2. 처리내용 : 파일 이름 가져오기
     * </pre>
     *
     * @method Name : getFileName
     * @param fileName 
     * @return String
     * @throws Exception
     * 
     */
    public String getFileName(String fileName) throws Exception {
        String fileExtension = "";
        
        if (fileName != null && !"".equals(fileName)) {
            if (fileName.lastIndexOf( "/" ) != -1) {
                fileExtension = fileName.toLowerCase().substring( fileName.lastIndexOf( "/" ) + 1, fileName.length() );
            } else {
                fileExtension = "";
            }
        } else {
            fileExtension = "";
        }
        
        return fileExtension;
    }    
    
    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리
     * 2. 처리내용 : 이미지 파일에 확장자
     * </pre>
     *
     * @method Name : getImgFileExt
     * @param  
     * @return String[] 
     * @throws none
     * 
     */
    public String[] getImgFileExt() {
        String[] imgFileExt = {"jpg", "jpeg", "png", "bmp", "gif"};
        return imgFileExt;
    } 
    
    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리
     * 2. 처리내용 : 문서 파일에 확장자 
     * </pre>
     *
     * @method Name : getDocFileExt
     * @param  
     * @return String[]
     * @throws none
     * 
     */
    public String[] getDocFileExt() {
        String[] imgFileExt = {"txt", "doc", "dotx", "hwp", "pdf", "xls", "xlsx", "xlsm", "docx", "zip", "ppt", "pdf", "pptx"};
        return imgFileExt;
    }   
    
    /**
     * <pre>
     * 1. 개요 : 첨부파일 관리
     * 2. 처리내용 : 문서 파일(엑셀)에 확장자
     * </pre>
     *
     * @method Name : getXlsFileExt
     * @param 
     * @return String[]
     * @throws none
     * 
     */
    public String[] getXlsFileExt() {
        String[] imgFileExt = {"xls", "xlsx", "xlsm"};
        return imgFileExt;
    } 
    
	/**
	 * <pre>
	 * 1. 개요 : 첨부파일 관리
	 * 2. 처리내용 : 파일을 복사
	 * </pre>
	 *
	 * @method Name : copyFile
	 * @param orginalFilePath, replicaPath, replicaFileName
	 * @return boolean
	 * @throws none
	 * 
	 */
	public static boolean copyFile(String orginalFilePath, String replicaPath, String replicaFileName) {
		File originalFile = new File(orginalFilePath);
		File replicatePath = new File(replicaPath);
		File replicaFile = new File(replicaPath + replicaFileName);
		
		if (StringUtil.isEmpty(orginalFilePath) || StringUtil.isEmpty(replicaPath)) {
			/* 인자가 잘못 입력되었음 */
			return false;
		}
		
		if (!originalFile.exists()){
			/* 파일 없음 */
			return false;
		}
		
		if (!originalFile.isFile()){
			/* 파일이 아님 */
			return false;
		}
		
		/* 디렉토리 생성 */
		if (!replicatePath.exists() || replicatePath.isFile()){
			replicatePath.mkdirs();
		}
		
		try {
			replicaFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();

			/* 파일복사중 오류가 났음을 로그 메시지 처리 */
			return false;
		}
		
		try {
			FileCopyUtils.copy(originalFile, replicaFile);
		} catch(IOException e) {
			/* 파일 IO 오류 발생 로그 처리 */
			e.printStackTrace();
			
			return false;
		} catch(Exception e2){
			/* 기타 오류 발생 로그 처리 */
			e2.printStackTrace();
			
			return false;
		}
		
		return true;
	}
	
	 /**
	 * <pre>
	 * 1. 개요 : 첨부파일 관리
	 * 2. 처리내용 : 디렉토리의 파일 리스트를 읽는 메소드
	 * </pre>
	 *
	 * @method Name : getDirFileList
	 * @param dirPath
	 * @return List<File>
	 * @throws none
	 * 
	 */
	public static List<File> getDirFileList(String dirPath) {
		 /* 디렉토리 파일 리스트 */
		 List<File> dirFileList = null;
		 
		 if (!StringUtil.isEmpty(dirPath)) {
			 /* 파일 목록을 요청한 디렉토리를 가지고 파일 객체를 생성함 */
			 File dir = new File(dirPath);
	  
			 /* 디렉토리가 존재한다면 */
			 if (dir.exists()) {
				 /* 파일 목록을 구함 */
				 File[] files = dir.listFiles();
				 
				 /* 파일 배열을 파일 리스트로 변화함 */ 
				 dirFileList = Arrays.asList(files);
			 }
		 }
		 
		 return dirFileList;
	}
}