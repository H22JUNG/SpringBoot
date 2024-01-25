package com.example.demo.common.exception;

import org.springframework.http.HttpStatus;

import com.example.demo.common.Constants;

// Exception 클래스를 상속받아서 Custom Exception 클래스를 사용함
public class testProjectException extends Exception{
	
	// 직렬화를 위해 시리얼버전 UID 정의
	private static final long serialVersionUID = 11111111111111L;
	
	private Constants.ExceptionClass exceptionClass;
	private HttpStatus httpStatus;
	
	// 당장 필요한 생성자
	public testProjectException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
		// 현재 클래스에서는 message를 정의하지 않아서, Exception 클래스에서 toString()을 받아와서 씀
		// 디테일한 message를 붙여줌
		super(exceptionClass.toString() + message);
		this.exceptionClass = exceptionClass;
		this.httpStatus = httpStatus;
	}
	
// 형식적인 getter
//	public Constants.ExceptionClass getExceptionClass() {
//		return exceptionClass;
//	}

	// httpStatus의 에러 코드 가져옴
	public int getHttpStatusCode() {
		return httpStatus.value();
	}
	
	// httpStatus의 ReasonPhrase를 가져옴
	public String getHttpStatusType() {
		return httpStatus.getReasonPhrase();
	}
	
	// httpStatus 자체를 리턴
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
