package com.example.springfeignjwtclient.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springfeignjwtclient.payload.ProductPayload;
import com.example.springfeignjwtclient.service.ProductFeignService;

@RestController
public class TestApi {
	
	@Autowired
	ProductFeignService productFeignService;
	
	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<ProductPayload> getProduct(@PathVariable String productId) {
		return ResponseEntity.ok(productFeignService.getProduct(productId));
	}
}
