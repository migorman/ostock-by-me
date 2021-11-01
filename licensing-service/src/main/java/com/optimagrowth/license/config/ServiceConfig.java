package com.optimagrowth.license.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ServiceConfig {

	private String property;

	@Value("${redis.server}")
	private String redisServer = "";

	@Value("${redis.port}")
	private String redisPort = "";

}