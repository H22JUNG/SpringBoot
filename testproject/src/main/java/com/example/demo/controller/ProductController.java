package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.ProductDto;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	private ProductService productService;
	
	@Autowired	// 위에서 선언한 service 객체를 new()로 생성하지 않아도, 아래에서 쓸 수 있도록 자동 연결
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(value = "/product/{productId}")
	public ProductDto getProduct(@PathVariable String productId) {
		
		long startTime = System.currentTimeMillis();
		LOGGER.info("[ProductController] perform {} of test API.", "getProduct");
		// 결과:[INFO ][http-nio-8080-exec-1]c.e.d.c.ProductController[ProductController] perform getProduct of test API.
		// {}로 결과값을 넣을 자리를 설정해주고, " ," 후에 차례대로 들어갈 값을 설정해주면 차례로 출력됨
		
		ProductDto productDto = productService.getProduct(productId);

		// 로그 응용
		LOGGER.info("[ProductController] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
				productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(),
				(System.currentTimeMillis() - startTime));
		
		return productDto;
	}
	
	 @PostMapping("/product")
	 public ProductDto createProduct(@RequestBody ProductDto productDto) {
		 
		 String productId = productDto.getProductId();
		 String productName = productDto.getProductName();
		 int productPrice = productDto.getProductPrice();
		 int productStock = productDto.getProductStock();

		 
		 return productService.saveProduct(productId, productName, productPrice, productStock);
	 }
	

	 @DeleteMapping("/product/{productId}")
	 public ProductDto deleteProduct(@PathVariable String productId) {
		 return null;
	 }
}
