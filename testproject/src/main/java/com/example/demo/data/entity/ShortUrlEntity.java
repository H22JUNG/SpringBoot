package com.example.demo.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class ShortUrlEntity {

	@Id
	@GeneratedValue
	private String id;
	
	@Column
	private String orgUrl;
	
	@Column
	private String shortUrl;
	
}
