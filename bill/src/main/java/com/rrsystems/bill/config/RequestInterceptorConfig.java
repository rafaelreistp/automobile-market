package com.rrsystems.bill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class RequestInterceptorConfig {
	
	@Bean
	public RequestInterceptor getRequestInterceptor() {
		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate template) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if (authentication == null) {
					return;
				} else {
					OAuth2AuthenticationDetails authDetails = (OAuth2AuthenticationDetails) authentication.getDetails();
					template.header("Authorization", "Bearer" + authDetails.getTokenValue());
				}
				
			}
		};
	}

}
