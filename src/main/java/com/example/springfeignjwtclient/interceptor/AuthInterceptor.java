package com.example.springfeignjwtclient.interceptor;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.example.springfeignjwtclient.model.JwtToken;
import com.example.springfeignjwtclient.payload.AuthenticaionPayload;
import com.example.springfeignjwtclient.service.ProductFeignService;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthInterceptor implements RequestInterceptor {

	@Autowired
	JwtToken jwtToken;

	@Autowired
	private ProductFeignService productService;
	
	@Autowired
	
	AuthenticaionPayload authenticaionPayload;

	@Override
	public void apply(RequestTemplate template) {
		LocalDateTime expirationTime = jwtToken.getExpirationTime();

		String path = template.path();
		log.debug("Request path: " + path);

		if (!path.contains("authenticate") && ((null != expirationTime && LocalDateTime.now().isAfter(expirationTime))
				|| expirationTime == null)) {
			log.info("Token expired. Regenerating token");
			// Regenerate Token
			productService.refreshJWTTokent(authenticaionPayload);
		}


		String token = jwtToken.getToken();

		if (!StringUtils.isEmpty(token)) {
			template.header("Authorization", token);
		}
	}
}
