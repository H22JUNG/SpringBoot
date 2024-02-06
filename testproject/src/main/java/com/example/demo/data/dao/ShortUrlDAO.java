package com.example.demo.data.dao;

import com.example.demo.data.entity.ShortUrlEntity;

public interface ShortUrlDAO {

	// repository로 entity 객체를 넘겨 DB에 저장
	ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity);
	
	// DB조회 후 shortUrl 리턴
	ShortUrlEntity getShortUrl(String originalUrl);
	
	// DB조회 후 originalUrl 리턴
	ShortUrlEntity getOriginalUrl(String shortUrl);
	
	ShortUrlEntity updateOriginalUrl(ShortUrlEntity newShortUrl);
	
	void deleteByShortUrl(String shortUrl);
	
	void deleteByOriginalUrl(String originalUrl);
	
}
