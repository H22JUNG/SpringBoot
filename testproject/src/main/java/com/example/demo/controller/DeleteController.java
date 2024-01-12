package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get-api")
public class DeleteController {
	
	@DeleteMapping(value="/delete/{variable}")
	public String DeleteVariable(@PathVariable String variable) {
		
		// 예시용 delete 메서드입니다.
		return variable;
	}

}
