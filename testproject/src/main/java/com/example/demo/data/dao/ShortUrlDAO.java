package com.example.demo.data.dao;

public interface ShortUrlDAO {

	// repository로 entity 객체를 넘겨 DB에 저장
	saveShortUrl(ShortURLEntity shortUrlEntity)
	
	// DB조회 후 shortUrl 리턴
	getShortUrl(String originalUrl)
	
	// DB조회 후 originalUrl 리턴
	getOriginalUrl(String shortUrl)
	
	
}
