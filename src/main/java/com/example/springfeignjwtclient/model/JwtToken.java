package com.example.springfeignjwtclient.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtToken {

	private String token;

	private LocalDateTime expirationTime;

}