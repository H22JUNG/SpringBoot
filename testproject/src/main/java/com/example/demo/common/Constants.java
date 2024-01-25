package com.example.demo.common;

// 상수를 정의하여 사용할 클래스
public class Constants {

	// Exception의 형식을 짜기 위해 만든 클래스. 선택 사항임
	public enum ExceptionClass {
		
		// product 클래스를 사용할 때 exception이 발생하면, 이 클래스에 대해 예외가 발생함을 알리겠다
		PRODUCT("Product");
		
		private String exceptionClass;
		
		ExceptionClass(String exceptionClass) {
			this.exceptionClass = exceptionClass;
		}
		
		public String getExceptionClass() {
			return exceptionClass;
		}
		
		@Override
		public String toString() {
			return getExceptionClass() + " Exception.";
		}
	}
}
