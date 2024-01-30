package com.example.demo.delete;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	@PostMapping("/exception")
	public void exceptionTest() throws Exception {
		// exception이 발생하면 exceptionHandler로 던짐
		throw new Exception();
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
		
		// HttpHeaders, HttpStatus는 ResponseEntity를 썼기 때문에
		// 헤더, 스테이터스, 바디값을 채워넣는게 좋아서 사용한 것임. 별 의미X
		HttpHeaders responseHeaders = new HttpHeaders();
		// 400 에러로 설정
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		
		LOGGER.info("Controller 내 ExceptionHandler 호출");
		
		Map<String, String> map = new HashMap<>();
		// 맵 안에 에러타입, 코드, 메시지를 담아서 클라이언트쪽으로 리턴
		map.put("error type", httpStatus.getReasonPhrase());
		// getReasonPhrase() : 상태 코드에 대한 이유를 가져옴
		map.put("code", "400");
		map.put("message", "에러 발생");
		
		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}
	

}
