package com.example.springfeignjwtclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springfeignjwtclient.payload.ProductPayload;
import com.example.springfeignjwtclient.payload.AuthenticaionPayload;

/**
 * feign client interface for product service
 */
@FeignClient(name = "ServiceName", url = "${PRODUCT_SERVICE_URL}", decode404 = true)
public interface ProductServiceFeignClient {

	@PostMapping("/v1/authenticate")
	public ResponseEntity<Void> authenticate(@RequestBody AuthenticaionPayload authenticaionPayload);

	@GetMapping("/v1/product/{productId}")
	public ResponseEntity<ProductPayload> getProduct(@PathVariable String productId);

}
