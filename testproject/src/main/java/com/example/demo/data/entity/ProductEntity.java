package com.example.demo.data.entity;

import com.example.demo.data.dto.ProductDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity : 해당 클래스가 entity임을 뜻함
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity extends BaseEntity {

	@Id		// pk
	// @GeneratedValue(strategy = GenerationType.IDENTITY) Long타입일 경우 자동 생성
	String productId;
	String productName;
	Integer productPrice;
	Integer productStock;
	
	
	public ProductDto toDto() {
		return ProductDto.builder()
				.productId(productId)
				.productName(productName)
				.productPrice(productPrice)
				.productStock(productStock)
				.build();
	}
	
}
