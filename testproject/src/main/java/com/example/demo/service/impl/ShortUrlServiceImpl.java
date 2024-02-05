package com.example.demo.service.impl;

import java.net.URI;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.data.dao.ShortUrlDAO;
import com.example.demo.data.dto.NaverUriDto;
import com.example.demo.data.dto.ShortUrlResponseDto;
import com.example.demo.data.entity.ShortUrlEntity;
import com.example.demo.service.ShortUrlService;

public class ShortUrlServiceImpl implements ShortUrlService{

	private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlServiceImpl.class);
	
	// api로 shorturl 요청하여 값을 받아옴, DB에 저장(DTO -> Entity)
	@Override
	public ShortUrlResponseDto generateShortUrl(String clientId, String clientSecret, String originalUrl) {
		LOGGER.info("[generateShortUrl] request data : {}", originalUrl);
		
		ResponseEntity<NaverUriDto> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);
		
		String orgUrl = responseEntity.getBody().getResult().getOrgUrl();
		String shortUrl = responseEntity.getBody().getResult().getUrl();
		String hash = responseEntity.getBody().getResult().getHash();
		
		ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
		shortUrlEntity.setOrgUrl(orgUrl);
		shortUrlEntity.setUrl(shortUrl);
		shortUrlEntity.setHash(hash);
		
		//shortUrlDAO.saveShortUrl(shortUrlEntity);
		
		ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);
		LOGGER.info("[generateShortUrl] Response DTO : {}", shortUrlResponseDto.toString());
		
		return shortUrlResponseDto;
	}
	
	
	// DB조회 후 shortUrl 리턴, DB에 값이 없다면 generateShortUrl() 호출
	@Override
	public ShortUrlResponseDto getShortUrl(String clientId, String clientSecret, String originalUrl) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ShortUrlResponseDto updateShortUrl(String clientId, String clientSecret, String originalUrl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShortUrlResponseDto deleteByShortUrl(String clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShortUrlResponseDto deleteByOriginalUrl(String originalUrl) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private ResponseEntity<NaverUriDto> requestShortUrl(String clientId, String clientSecret, String originalUrl) {
		LOGGER.info("[requestShortUrl] client ID : ***, client Secret : ***, originalUrl : {}", originalUrl);
		
		URI uri = UriComponentsBuilder
				.fromUriString("https://openapi.naver.com")
				.path("/v1/util/shorturl")
				.queryParam("url", originalUrl)
				.encode()
				.build()
				.toUri();
		
		
		LOGGER.info("[requestShortUrl] set HTTP Request Header");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON}));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Naver-Client-Id", clientId);
		headers.set("X-Naver-Client-Secret", clientSecret);
		
		// 바디와 헤더 조합해주는 객체 : new HttpEntity<>(body, headers);
		HttpEntity<String> entity = new HttpEntity<>("", headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		LOGGER.info("[requestShortUrl] request by restTemplate");
		// get메서드로 호출, entity를 담아서 NaverUriDto의 형태로 리턴받겠다
		
		ResponseEntity<NaverUriDto> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, NaverUriDto.class);
		
		LOGGER.info("[requestShortUrl] request has been successfully complate.");
		
		return responseEntity;
	}
	

}
