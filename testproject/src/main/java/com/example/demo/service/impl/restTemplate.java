package com.example.demo.service.impl;

import java.net.URI;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.data.dto.ProductDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

// RestTemplate 테스트용 클래스
public class restTemplate {
	private final Logger LOGGER = LoggerFactory.getLogger(restTemplate.class);
	
	public ResponseEntity<ProductDto> addHeader() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api")			
				.encode() 
				.build()	
				.toUri();	
		
		ProductDto dto = new ProductDto();
		dto.setProductId("ID");
		dto.setProductName("NAME");
		dto.setProductPrice(2000);
		dto.setProductStock(100);
				
		RequestEntity<ProductDto> requestEntity = RequestEntity
				.post(uri)
				.header("product-header", "product project")	// request 받을 컨트롤러에서 @RequestHeader로 매핑
				.body(dto);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProductDto> responseEntity = restTemplate.exchange(requestEntity, ProductDto.class);
				
		return responseEntity;
	}
	
	
	@PostMapping(value = "/add-header")
	public ResponseEntity<ProductDto> addHeader(@RequestHeader("product-heaber") String header,
												@RequestBody ProductDto dto) {
		
		LOGGER.info("header 값 : {}", header);
	
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	
	}

}
