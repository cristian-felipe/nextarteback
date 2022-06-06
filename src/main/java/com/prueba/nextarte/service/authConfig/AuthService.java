package com.prueba.nextarte.service.authConfig;

import org.springframework.stereotype.Service;

import com.prueba.nextarte.model.JwtResponse;

@Service
public class AuthService {
	
	public JwtResponse login(String clientId,String clientSecret) {
		
		JwtResponse jwt	=JwtResponse.builder()
				.tokenType("bearer")
				.accesToken("")
				.issuedAt(System.currentTimeMillis()+"")
				.clientId(clientId)
				.expiresIn(3600)
				.build();
		return jwt;
	}

}
