# spring-jwt
## Spring JWT microservice with custom validation.

1. Step 1: Import the spring-jwt project.

2. Step 2: Create a spring boot project.

3. Step 3: Add dependency to project for JWT

		<dependency>

			<groupId>com.nssaga</groupId>

			<artifactId>spring-jwt</artifactId>

			<version>0.0.1-SNAPSHOT</version>

		</dependency>

4. Step 4: Add "@Import(EnableJWT.class)" to main class file.

5. Step 5: Create a controller and call "TokenAuthenticationService.addAuthenticationToken(response, "username")" from login service to generate a token in response header where response "HttpServletResponse".

6. Step 6: Check the JWTConstant.class for excluded URL and add to your new project controller URL.

7. Step 7: Run your project
		