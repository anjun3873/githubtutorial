package com.elsys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@ImportResource("classpath:root-context.xml")
public class HemsPcsEssSchedulerApplication {
	private static final Logger logger = LoggerFactory.getLogger(HemsPcsEssSchedulerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(HemsPcsEssSchedulerApplication.class, args);
		logger.info("Hems API 스케줄러 애플리케이션이 실행되었습니다.");
	}
}
