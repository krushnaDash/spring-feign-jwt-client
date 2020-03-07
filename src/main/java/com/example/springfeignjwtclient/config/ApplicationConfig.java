package com.example.springfeignjwtclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.springfeignjwtclient.interceptor.AuthInterceptor;
import com.example.springfeignjwtclient.model.JwtToken;
import com.example.springfeignjwtclient.payload.AuthenticaionPayload;

@Configuration
public class ApplicationConfig {
	
	@Value("#appId")
	String appId;
	@Value("#password")
	String password;
	

	@Bean
	AuthInterceptor authFeign() {
		return new AuthInterceptor();
	}

	@Bean
	@Scope(value = "singleton")
	public JwtToken jwtToken() {
		return new JwtToken();
	}
	
	@Bean
	public AuthenticaionPayload getauthenticaionPayload() {
		return new AuthenticaionPayload(appId, password);
	}
	

}