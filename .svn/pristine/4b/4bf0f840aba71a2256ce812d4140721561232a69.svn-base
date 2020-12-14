 package com.elsys.common.utils;

import java.io.Serializable;

/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


public class StaticVO implements Serializable {


	/**
	 *  serialVersion UID
	 */
	private static final long serialVersionUID = 1L;

	private int pageSize			= 10;					//글 보여줄 갯수
	private int blockPage			= 10;					//페이지수
	private int nowPage				= 1;					//현재 페이지
	private int totalCount			= 0;					// 총 레코드 수
	private int firstRecord			= 0;					//처음 데이터
	private int lastRecord			= 20;					//마지막 테이터
	private int totalPage			= 0;					//블럭 마지막 체크

    public String getDbId() {
		return dbId;
	}

	public void setDbId(String dbId) {
		this.dbId = dbId;
	}

	public String getDbPwd() {
		return dbPwd;
	}

	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}



	private String dbId;                                  //DB  아이디
    private String dbPwd;                           //DB  비번
    private String driverClassName;     //DB  드라이버 패키지
    private String dbUrl;                                 //DB URL

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getFirstRecord() {
		return firstRecord;
	}

	public void setFirstRecord(int firstRecord) {
		this.firstRecord = firstRecord;
	}

	public int getLastRecord() {
		return lastRecord;
	}

	public void setLastRecord(int lastRecord) {
		this.lastRecord = lastRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
