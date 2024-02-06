package com.example.demo.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.data.dao.ShortUrlDAO;
import com.example.demo.data.entity.ShortUrlEntity;
import com.example.demo.repository.ShortUrlRepository;

@Component
public class ShortUrlDAOImpl implements ShortUrlDAO{

	private final ShortUrlRepository shortUrlRepository;
	
	@Autowired
	public ShortUrlDAOImpl(ShortUrlRepository shortUrlRepository) {
		this.shortUrlRepository = shortUrlRepository;
	}
	
	@Override
	public ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity) {
		ShortUrlEntity foundShortUrl = shortUrlRepository.save(shortUrlEntity);
		
		return foundShortUrl;
	}

	@Override
	public ShortUrlEntity getShortUrl(String originalUrl) {
		ShortUrlEntity foundShortUrl = shortUrlRepository.findByOrgUrl(originalUrl);
		return foundShortUrl;
	}

	@Override
	public ShortUrlEntity getOriginalUrl(String shortUrl) {
		ShortUrlEntity foundShortUrl = shortUrlRepository.findByUrl(shortUrl);
		return foundShortUrl;
	}

	@Override
	public ShortUrlEntity updateOriginalUrl(ShortUrlEntity newShortUrl) {
		ShortUrlEntity foundShortUrl = shortUrlRepository.findByOrgUrl(newShortUrl.getOrgUrl());
		
		foundShortUrl.setUrl(newShortUrl.getUrl());
		
		ShortUrlEntity savedShortUrl  = shortUrlRepository.save(foundShortUrl);
		
		return savedShortUrl;
	}

	@Override
	public void deleteByShortUrl(String shortUrl) {
		ShortUrlEntity foundShortUrl = shortUrlRepository.findByUrl(shortUrl);
		shortUrlRepository.delete(foundShortUrl);
	}

	@Override
	public void deleteByOriginalUrl(String originalUrl) {
		ShortUrlEntity foundShortUrl = shortUrlRepository.findByOrgUrl(originalUrl);
		shortUrlRepository.delete(foundShortUrl);
	}

}
