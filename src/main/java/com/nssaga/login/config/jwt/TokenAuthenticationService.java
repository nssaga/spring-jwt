/**
 * Created Date 11-Jan-2018
 * @author Nawal Sah 
 */
package com.nssaga.login.config.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author nawalsah
 *
 */

public class TokenAuthenticationService {

	public static void addAuthenticationToken(HttpServletResponse response, String username) {
		String JWT_TOKEN = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + JWTConstant.EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS256, JWTConstant.SECRET_KEY).compact();
		response.setHeader(JWTConstant.HEADER_STRING, JWTConstant.TOKEN_PREFIX + JWT_TOKEN);
	}

}
