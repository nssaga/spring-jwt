package com.nssaga.login.config.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authHeader = request.getHeader(JWTConstant.HEADER_STRING);

		if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			filterChain.doFilter(request, response);

		} else {
			if (authHeader == null || !authHeader.startsWith(JWTConstant.TOKEN_PREFIX)) {
				throw new ServletException("Missing or Invalid Authorization Header");
			}
			final String token = authHeader.substring(7);

			try {
				final Claims claims = Jwts.parser().setSigningKey(JWTConstant.SECRET_KEY).parseClaimsJws(token)
						.getBody();
				request.setAttribute("claims", claims);
			} catch (final SignatureException e) {
				throw new ServletException("Invalid Token");
			}

			filterChain.doFilter(request, response);
		}
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		Collection<String> excludeUrlPatterns = new ArrayList<>();
		//excludeUrlPatterns.add(JWTConstant.EXCLUDE_URL);
		Collection<String> excludeUrl = Stream.of(JWTConstant.EXCLUDE_URL.split(",")).collect(Collectors.toList());
		excludeUrlPatterns.addAll(excludeUrl);
		
		
		AntPathMatcher pathMatcher = new AntPathMatcher();
		return excludeUrlPatterns.stream().anyMatch(p -> pathMatcher.match(p, request.getServletPath()));
	}
}
