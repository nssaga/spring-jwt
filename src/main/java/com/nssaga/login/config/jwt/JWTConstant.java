/**
 * Created Date 02-Feb-2018
 * @author Nawal Sah 
 */
package com.nssaga.login.config.jwt;

/**
 * @author nawalsah
 *
 */
public class JWTConstant {
	static final long EXPIRATIONTIME = 600_000; // 3 Minutes
	static final String SECRET_KEY = "secretkey";
	static final String HEADER_STRING = "Authorization";
	static final String TOKEN_PREFIX = "Bearer ";
	//static final String EXCLUDE_URL = "/**";
	static final String EXCLUDE_URL = "/api/v1/login,/api/v1/register";
}
