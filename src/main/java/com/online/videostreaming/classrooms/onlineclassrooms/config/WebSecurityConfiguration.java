package com.online.videostreaming.classrooms.onlineclassrooms.config;

import static com.online.videostreaming.classrooms.onlineclassrooms.utils.WebConstant.LOGIN_URL;
import static com.online.videostreaming.classrooms.onlineclassrooms.utils.WebConstant.LOGOUT_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.InMemoryApprovalStore;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl.CaptchaService;
import com.online.videostreaming.classrooms.onlineclassrooms.csrf.service.CsrfSecretService;
import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service.EndUserDetailsService;
import com.online.videostreaming.classrooms.onlineclassrooms.filters.CaptchaValidationFilter;
import com.online.videostreaming.classrooms.onlineclassrooms.security.LoginFailureHandler;
import com.online.videostreaming.classrooms.onlineclassrooms.security.LoginSuccessHandlar;
import com.online.videostreaming.classrooms.onlineclassrooms.security.OnLogoutSuccessHandler;
import com.online.videostreaming.classrooms.onlineclassrooms.security.RestAuthenticationEntryPoint;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.RequestUtils;
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final EndUserDetailsService endUserDetailsService;

	public WebSecurityConfiguration(
			@Autowired @Qualifier("endUserDetailsService") EndUserDetailsService endUserDetailsService
			) {
		this.endUserDetailsService = endUserDetailsService;
	}

	@Autowired
	private CaptchaService captchaService;
	@Autowired
    CsrfTokenRepository jwtCsrfTokenRepository;
	@Autowired
    CsrfSecretService secretService;
	@Autowired
	public OAuth2RequestFactory requestFactory;
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers( "/resources/**", "/resources/", "/admin/captchaImage", "/admin/captcha",
				"/imgCaptcha", "/admin/validateCaptcha", "/actuator/**","/");
	}


    
	
	@Bean
	public ApprovalStore approvalStore() throws Exception {
		InMemoryApprovalStore store = new InMemoryApprovalStore();
		return store; 
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf(csrf->csrf.csrfTokenRepository(jwtCsrfTokenRepository));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		http.headers().httpStrictTransportSecurity().disable();
		http.sessionManagement().sessionFixation().none().and().formLogin(formLogin -> formLogin.loginPage(LOGIN_URL).permitAll()
				.successHandler(authenticationSuccessHandler()).failureHandler(loginFailureHandler()))
				.userDetailsService(this.endUserDetailsService)
				.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher(LOGOUT_URL))
						.logoutSuccessHandler(logoutSuccessHandler)
						.deleteCookies("SESSION", "JSESSIONID")
						.defaultLogoutSuccessHandlerFor(new HttpStatusReturningLogoutSuccessHandler(),
								RequestUtils::isAjaxRequest)
						.permitAll())

				.requestMatchers(requestMatchers -> requestMatchers
						.mvcMatchers(LOGIN_URL, LOGOUT_URL,"/oauth/authorize", "/oauth/confirm_access", "/token_keys",
								"/.well-known/*", "/oauth/token/.well-known/*", "/otp_authentication",
								"/oauth/approval_page", "/admin/imgCaptcha", "/actuator/**")
						.requestMatchers(EndpointRequest.toAnyEndpoint()))
				.authorizeRequests(authorize -> {
					try {
						authorize
								.mvcMatchers(LOGIN_URL,LOGOUT_URL, "/oauth/authorize", "/oauth/confirm_access", "/token_keys",
										"/.well-known/*", "/oauth/token/.well-known/*",
										"/otp_authentication", "/oauth/approval_page",
										"/admin/imgCaptcha", "/actuator/**")
								.permitAll().requestMatchers(EndpointRequest.to("info", "health", "prometheus"))
								.permitAll().anyRequest().authenticated().and().authenticationProvider(authProvider())
								.httpBasic().disable().exceptionHandling()
								.authenticationEntryPoint(restAuthenticationEntryPoint)//
								.accessDeniedHandler(accessDeniedHandler());
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		
		http.addFilterBefore(getBeforeAuthenticationFilter(), CaptchaValidationFilter.class);
	}
	
	
	 @Autowired
	 private OnLogoutSuccessHandler logoutSuccessHandler; 

	
	 @Autowired
	 private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		
		OAuth2AccessDeniedHandler  defaultAccessDeniedHandler=	new OAuth2AccessDeniedHandler();
		defaultAccessDeniedHandler.setExceptionTranslator(loggingExceptionTranslator());
		return defaultAccessDeniedHandler ;
	}

	@Bean
	public AuthenticationProvider authProvider() throws Exception {

		DaoAuthenticationProvider  authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(passwordEncoder());
		authProvider.setUserDetailsService(this.endUserDetailsService);
		return authProvider;

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	@Override
	@Bean(name = "authenticationManagerBean")
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public UsernamePasswordAuthenticationFilter getBeforeAuthenticationFilter() throws Exception {
		CaptchaValidationFilter filter = new CaptchaValidationFilter(captchaService);
		filter.setAuthenticationManager(authenticationManagerBean());
		filter.setAuthenticationFailureHandler(loginFailureHandler());
		filter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
		
		return filter;
	}

	@Bean(name = "authenticationSuccessHandler")
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new LoginSuccessHandlar();
	}

	@Bean(name = "loginFailureHandler")
	public AuthenticationFailureHandler loginFailureHandler() {
		return new LoginFailureHandler();
	}

	
	

	@Bean
	public WebResponseExceptionTranslator loggingExceptionTranslator() {
		return new DefaultWebResponseExceptionTranslator() {

			@Override
			public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
				e.printStackTrace();
				ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
				HttpHeaders headers = new HttpHeaders();
				headers.setAll(responseEntity.getHeaders().toSingleValueMap());
				OAuth2Exception excBody = responseEntity.getBody();
				return new ResponseEntity<>(excBody, headers, responseEntity.getStatusCode());
			}
		};
	}

}
