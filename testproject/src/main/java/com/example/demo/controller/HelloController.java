package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	// 로그 설정(org.slf4j.Logger 확인)
	private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	// logback-spring.xml 파일에 들어가는
	// <pattern>%green([%d{yyyy-MM-dd HH:mm:ss.SSS}]) %magenta([%-5level]) %highlight([%thread]) %cyan(%logger{30}) %yellow(%msg%n)</pattern>
	// 에서 %logger에 getLogger(클래스명.class)의 클래스명이 들어감


	@RequestMapping(value = "/hello")
	// @GetMapping("hello")
	public String hello(){

		return "hello world";		
	}
	
	@PostMapping("/log-test")
	public void logTest() {
		LOGGER.trace("Trace Log");
		LOGGER.debug("Debug Log");
		LOGGER.info("Info Log");
		LOGGER.warn("Warn Log");
		LOGGER.error("Error Log");
	}
	

}
