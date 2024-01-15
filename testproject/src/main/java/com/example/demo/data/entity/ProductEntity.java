package com.example.demo.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity : 해당 클래스가 entity임을 뜻함
@Entity

// 아래 4개는 @Data로 퉁쳐도 됨
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
@Table(name = "shop")
public class ProductEntity {

	@Id		// pk
	String productId;
	String productName;
	Integer productPrice;
	Integer productStock;
	
}
