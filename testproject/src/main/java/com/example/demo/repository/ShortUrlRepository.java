package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entity.ShortUrlEntity;

public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {
	// <Entity클래스, PK타입>
	
	ShortUrlEntity findByUrl(String url);
	
	ShortUrlEntity findByOrgUrl(String OriginalUrl);
}
