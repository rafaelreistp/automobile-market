package com.rrsystems.zul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZulApplication.class, args);
	}

}
