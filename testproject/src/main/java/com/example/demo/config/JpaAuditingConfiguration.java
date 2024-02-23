package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing  
public class JpaAuditingConfiguration {

	/*
	 * 원래 메인메서드에서 @EnableJpaAuditing 설정했었는데,
	 * 이럴 경우 테스트 커버리지 수행 시 JPA객체에 없는데도
	 * enable이 되는 경우가 있어서 제대로 동작하지 않을 수 있음
	 * 
	 * => config클래스를 별도로 생성하여 @EnableJpaAuditing 어노테이션 붙여주는 방법 권장
	 */
	
	
	
}
