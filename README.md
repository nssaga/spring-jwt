# spring-jwt
Spring JWT microservice with custom validation.

Step 1: Import the spring-jwt project
Step 2: Create a spring boot project.
Step 3: Add dependency to project for JWT
		<dependency>
			<groupId>com.nssaga</groupId>
			<artifactId>spring-jwt</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
Step 4: Add "@Import(EnableJWT.class)" to main class file.
Step 5: Create a controller and call "TokenAuthenticationService.addAuthenticationToken(response, "username")" from login service to generate a token in response header where response "HttpServletResponse".
Step 6: Check the JWTConstant.class for excluded URL and add to your new project controller URL.
Step 7: Run your project
		