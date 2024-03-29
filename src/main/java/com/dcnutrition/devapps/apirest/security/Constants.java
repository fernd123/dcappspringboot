package com.dcnutrition.devapps.apirest.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String USER_URL = "/users/";
	public static final String FILE_URL = "/api/files/{type}/{id}";

	
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

	public static final String ISSUER_INFO = "https://www.autentia.com/";
	public static final String SUPER_SECRET_KEY = "1234";
	public static final long TOKEN_EXPIRATION_TIME = 2 * 24 * 60 * 60 * 1000; //2days //864_000_000; // 10 day

}
