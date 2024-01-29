package com.example.demo.controller;

// static
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import com.example.demo.data.dto.ProductDto;
import com.example.demo.service.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


@WebMvcTest(ProductController.class)	// 테스트하고자하는 controller 클래스
//@AutoConfigureWebMvc	// 이 어노테이션을 통해 MockMvc를 Builder 없이 주입받을 수 있음, 지금은 주석처리해도 정상적으로 동작
public class ProductControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean	// ProductController에서 잡고 있는 Bean 객체에 대해 Mock 형태의 객체를 생성해줌 -> 그의 구현체를 받아서 씀
	/* ProductController 클래스 내에서
		public ProductController(ProductService productService) { this.productService = productService; } 로
		@Autowired 되어 있는 service 클래스를 뜻함 */
	ProductServiceImpl productService;
	

	
	@Test	// 실질적으로 테스트하는 메소드
	@DisplayName("Product 데이터 가져오기 테스트")	// 메소드 이름 변경해서 출력
	void getProductTest() throws Exception {
		
		// given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
		given(productService.getProduct("12345")).willReturn(new ProductDto("54321", "name3", 2000, 9999));
		// getProduct("12345")를 호출하면, db에서 값을 가져오지 않아도
		// new ProductDto("54321", "name3", 2000, 9999) 라는 객체를 자동으로 생성해서 리턴함
		
		String productId = "12345";
		
		// andExpect : 기대하는 값이 나왔는지 체크해볼 수 있는 메소드
		mockMvc.perform(
				get("/api/v1/product-api/product/" + productId))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.productId").exists())	// json path의 depth가 깊어지면 .을 추가하여 탐색할 수 있음
			.andExpect(jsonPath("$.productName").exists())	// json 형태로 해당 키값이 존재하는지 조회
			.andExpect(jsonPath("$.productPrice").exists())
			.andExpect(jsonPath("$.productStock").exists())
			.andDo(print());
		
		// verify : 해당 객체의 메소드가 실행되었는지 체크
		verify(productService).getProduct("12345");
	}
	
	 @Test
	 @DisplayName("Product 데이터 생성 테스트")
	 void createProductTest() throws Exception {
		 // Mock 객체에서 특정 메소드가 실행되는 경우 실제 Return을 줄 수가 없기 때문에
		 // 아래와 같이 가정 사항을 만들어줌
		 given(productService.saveProduct("78910", "name4", 5000, 2000)).willReturn(
				 new ProductDto("78910", "name4", 5000, 2000));
		 
		 ProductDto productDto = ProductDto.builder().productId("78910").productName("name4")
				.productPrice(5000).productStock(2000).build();
		 
		 // <Dto를 json으로 변환하는 방법>
		 
		 // 1. 구글에서 만든 json을 자유롭게 사용하기 위한 라이브러리
		 Gson gson = new Gson();
		 String content = gson.toJson(productDto);
		 
		 // 2. 아래 코드로 json 형태 변경 작업을 대체할 수 있음
		 String json = new ObjectMapper().writeValueAsString(productDto);
		 
			mockMvc.perform(
					post("/api/v1/product-api/product")
					.content(content)
					.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").exists())	// json path의 depth가 깊어지면 .을 추가하여 탐색할 수 있음
				.andExpect(jsonPath("$.productName").exists())	// json 형태로 해당 키값이 존재하는지 조회
				.andExpect(jsonPath("$.productPrice").exists())
				.andExpect(jsonPath("$.productStock").exists())
				.andDo(print());
			
			verify(productService).saveProduct("78910", "name4", 5000, 2000);


	 }
}
