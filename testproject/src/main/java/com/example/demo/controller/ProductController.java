package com.example.demo.controller;

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
	
	private ProductService productService;
	
	@Autowired	// 위에서 선언한 service 객체를 new()로 생성하지 않아도, 아래에서 쓸 수 있도록 자동 연결
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(value = "/product/{productId}")
	public ProductDto getProduct(@PathVariable String productId) {
		
		return productService.getProduct(productId);
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
