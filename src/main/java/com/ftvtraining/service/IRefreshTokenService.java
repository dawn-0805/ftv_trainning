package com.ftvtraining.service;



import com.ftvtraining.enity.RefreshToken;

public interface IRefreshTokenService {

	RefreshToken createRefreshToken(String username);
	
}
