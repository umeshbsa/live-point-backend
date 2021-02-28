package com.app.livepoint.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	static final String CLIEN_ID = "live_point";
	static final String CLIENT_SECRET = "123456";
	static final String GRANT_TYPE = "password";
	static final String AUTHORIZATION_CODE = "authorization_code";
	static final String REFRESH_TOKEN = "refresh_token";
	static final String IMPLICIT = "implicit";
	static final String SCOPE_READ = "read";
	static final String SCOPE_WRITE = "write";
	static final String TRUST = "trust";
	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 2 * 60 * 60;
	static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		System.out.println("DDDDDD 44 ");
		configurer.inMemory()
				.withClient(CLIEN_ID).secret(passwordEncoder.encode(CLIENT_SECRET))
				.authorizedGrantTypes(GRANT_TYPE, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT)
				.scopes(SCOPE_READ, SCOPE_WRITE, TRUST).accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
				.refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		System.out.println("DDDDDD 55 " + tokenStore.toString());
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager);
	}
}

// INSERT INTO User (id, username, password, salary, age) VALUES (1, 'Alex123', '123456', 3456, 33);
