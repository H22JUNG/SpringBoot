package com.example.demo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NaverUriDto {

	private String messsage;
	
	private String code;
	
	private Result result;
	
	
	@Getter
	@Setter
	public static class Result {
		
		// 리턴받는 형식에 { result: {}} 형태가 있어서 객체 안의 객체 생성 
		
		private String hash;
		
		private String url;
		
		private String orgUrl;
	}
}
