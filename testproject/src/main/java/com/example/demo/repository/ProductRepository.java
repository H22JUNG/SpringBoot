package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

	// JpaRepository를 사용할 경우 메서드를 작성하지 않아도 기본적인 CRUD기능 제공
	// <Entity클래스, pk타입>
}
