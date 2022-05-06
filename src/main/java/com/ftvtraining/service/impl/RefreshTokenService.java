package com.ftvtraining.service.impl;

import java.time.Instant;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ftvtraining.enity.RefreshToken;
import com.ftvtraining.service.IRefreshTokenService;


@Service
public class RefreshTokenService implements IRefreshTokenService {

	@Value("${ftvtraining.app.jwtRefreshExpirationMs}")
	private Long refreshTokenDurationMs;
	  
	@Override
	public RefreshToken createRefreshToken(String username) {
		 RefreshToken refreshToken = new RefreshToken();
		 refreshToken.setUsername(username);
		 refreshToken.setRefreshToken(UUID.randomUUID().toString());
		 refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
		 return refreshToken;
	}


}
