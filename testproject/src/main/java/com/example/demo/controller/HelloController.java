package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/hello")
	// @GetMapping("hello")
	public String hello(){
		
		String getVersion = org.springframework.core.SpringVersion.getVersion();

		System.out.println(getVersion);
		return getVersion;		
	}

}
