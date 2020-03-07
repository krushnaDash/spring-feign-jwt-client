package com.example.springfeignjwtclient.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class AuthenticaionPayload {
	
	String appId;
	String password;
}
