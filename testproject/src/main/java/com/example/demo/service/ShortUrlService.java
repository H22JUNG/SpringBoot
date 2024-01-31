package com.example.demo.service;

import com.example.demo.data.dto.ShortUrlResponseDto;

public interface ShortUrlService {

	ShortUrlResponseDto getShortUrl(String clientId, String clientSecret, String originalUrl);
	
	ShortUrlResponseDto generateShortUrl(String clientId, String clientSecret, String originalUrl);
	
	ShortUrlResponseDto updateShortUrl(String clientId, String clientSecret, String originalUrl);
	
	ShortUrlResponseDto deleteByShortUrl(String clientId);
	
	ShortUrlResponseDto deleteByOriginalUrl(String originalUrl);
	
}
