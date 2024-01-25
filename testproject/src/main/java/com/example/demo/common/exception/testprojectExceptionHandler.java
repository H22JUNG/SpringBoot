package com.example.demo.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @ControllerAdvice : Controller 내부에서 먼저 예외처리를 실행한 후, 처리되지 않는 Exception에 대해 Advice에서 실행함
@RestControllerAdvice
public class testprojectExceptionHandler {
	
	private final Logger LOGGER = LoggerFactory.getLogger(testprojectExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {

		// HelloController와 로직 동일, Log만 다르게 출력
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		
		LOGGER.info("Advice 내 ExceptionHandler 호출");
		
		Map<String, String> map = new HashMap<>();
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("code", "400");
		map.put("message", "에러 발생");
		
		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}
	
	@ExceptionHandler(value = testProjectException.class)
	public ResponseEntity<Map<String, String>> ExceptionHandler(testProjectException e) {
		HttpHeaders responseHeaders = new HttpHeaders();
		
		Map<String, String> map = new HashMap<>();
		// 에러 타입을 가져옴(ReasonPhrase)
		map.put("error type", e.getHttpStatusType());
		
		// 에러의 value를 가져옴(숫자)
		map.put("error code", Integer.toString(e.getHttpStatusCode()));
		
		// Throwable의  getMessage() {  return detailMessage;  }
		// testProjectException -> Exception.class -> Throwable
		map.put("message", e.getMessage());
		
		return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
	}

}
