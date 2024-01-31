package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.ProductDto;
import com.example.demo.data.entity.ProductEntity;
import com.example.demo.data.handler.ProductDataHandler;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	// 데이터를 핸들링 할 작업이 필요할 경우 핸들러 사용
	ProductDataHandler productDataHandler;
	
	@Autowired
	public ProductServiceImpl(ProductDataHandler productDataHandler) {
		this.productDataHandler = productDataHandler;
	}
	
	@Override
	public ProductDto getProduct(String productId) {
		ProductEntity productEntity = productDataHandler.getProductEntity(productId);
		
		ProductDto productDto = new ProductDto(productEntity.getProductId(),
											productEntity.getProductName(),
											productEntity.getProductPrice(),
											productEntity.getProductStock());
		return productDto;
	}
	
	@Override
	public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
		ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);
		
		ProductDto productDto = new ProductDto(productEntity.getProductId(),
												productEntity.getProductName(),
												productEntity.getProductPrice(),
												productEntity.getProductStock());
		return productDto;
	}

}
