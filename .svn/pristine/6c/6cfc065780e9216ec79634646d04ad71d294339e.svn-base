package com.elsys.scheduler.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.elsys.common.utils.StaticVO;
import com.elsys.scheduler.service.BackUpTaskService;


@Controller("BackUpTask")
public class BackUpTask {
	
	protected StaticVO staticVO = new StaticVO();

	@Resource(name="backUpTaskService")
	
	private BackUpTaskService backUpService;
	// backup 기능 활성화 ( true , false )
	@Value("true")
	private boolean isEnabled;
	
	private static final Logger log = LoggerFactory.getLogger(PcsEssTask.class);
	

	/**
	 *  rawData데이터 백업
	 * @throws Exception
	 */
	public void backUpRun() throws Exception {
		if(isEnabled) backUpService.backup();
	}
}
