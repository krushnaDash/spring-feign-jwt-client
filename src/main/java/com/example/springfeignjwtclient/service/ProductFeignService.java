package com.example.springfeignjwtclient.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springfeignjwtclient.client.ProductServiceFeignClient;
import com.example.springfeignjwtclient.model.JwtToken;
import com.example.springfeignjwtclient.payload.ProductPayload;
import com.example.springfeignjwtclient.payload.AuthenticaionPayload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductFeignService {

	@Autowired
	ProductServiceFeignClient productServiceClient;

	@Autowired
	private Environment env;

	@Autowired
	JwtToken jwtTokenBean;

	public void refreshJWTTokent(AuthenticaionPayload authenticaionPayload) {
		log.info("Entering refreshJWTTokent");
		ResponseEntity<Void> response = productServiceClient.authenticate(authenticaionPayload);
		String token = response.getHeaders().getFirst("authorization");

		String tokenExpTimeStr = env.getProperty("token.expiration.time");
		int tokenExpTime = Integer.parseInt(tokenExpTimeStr);

		log.info("Token expiration time: " + tokenExpTime);

		LocalDateTime expirationTime = LocalDateTime.now().plusSeconds(tokenExpTime);

		jwtTokenBean.setToken(token);
		jwtTokenBean.setExpirationTime(expirationTime);

		log.info("Token has been created. > " + token.substring(token.lastIndexOf('.')));
		log.info("JWT token has been created successfully.");
	}

	
	/**
	 * retrieves a Product's information in Product Service
	 * 
	 * @param productId
	 * @return
	 */
	public ProductPayload getProduct(String productId) {
		ResponseEntity<ProductPayload> response = productServiceClient.getProduct(productId);
		if (response.getStatusCode() == HttpStatus.OK) {
			log.info("Product found");
			return response.getBody();
		} else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
			log.info("Product not found");
		}

		return null;
	}

	
}
