package com.example.demo.service.impl;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.data.dto.ProductDto;
import com.example.demo.data.entity.ProductEntity;
import com.example.demo.data.handler.impl.ProductDataHandlerImpl;

// 어떤 객체를 가져올지 정확히 모를 때 매개변수 없이 SpringBootTest 사용
// @SpringBootTest(classes = {ProductDataHandlerImpl.class, ProductServiceImpl.class})

// 필요한 것만 가져다 쓰는 어노테이션
@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {
	
	@MockBean
	ProductDataHandlerImpl productDataHandler;	// 구현체
	
	@Autowired
	ProductServiceImpl productService;	// 테스트하고자 하는 객체
	
	@Test
	public void getProductTest() {
		// given
		// 사전세팅 : productDataHandler가 getProductEntity("123")을 호출할 때,
		Mockito.when(productDataHandler.getProductEntity("123"))
		// 리턴
		.thenReturn(new ProductEntity("123", "pen", 2000, 3000));
		
		ProductDto productDto = productService.getProduct("123");
		
		// 단정문
		// productDto.getProductId() 와 "123"이 같은지 확인
		Assertions.assertEquals(productDto.getProductId(), "123");
		Assertions.assertEquals(productDto.getProductName(), "pen");
		Assertions.assertEquals(productDto.getProductPrice(), 2000);
		Assertions.assertEquals(productDto.getProductStock(), 3000); //false
		
		verify(productDataHandler).getProductEntity("123");
		
	}
	
	@Test
	public void saveProductTest() {
		// given
		Mockito.when(productDataHandler.saveProductEntity("123", "pen", 2000, 3000))
		.thenReturn(new ProductEntity("123", "pen", 2000, 3000));
		
		ProductDto productDto = productService.saveProduct("123", "pen", 2000, 3000);
		
		Assertions.assertEquals(productDto.getProductId(), "123");
		Assertions.assertEquals(productDto.getProductName(), "pen");
		Assertions.assertEquals(productDto.getProductPrice(), 2000);
		Assertions.assertEquals(productDto.getProductStock(), 3000);
		
		verify(productDataHandler).saveProductEntity("123", "pen", 2000, 3000);

	}


}
