package dev.angelcruzl.realestate.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
  @Value("${service.security.secure-key-username-admin}")
  private String SECURE_KEY_USERNAME_ADMIN;

  @Value("${service.security.secure-key-password-admin}")
  private String SECURE_KEY_PASSWORD_ADMIN;

  @Value("${service.security.secure-key-username-dev}")
  private String SECURE_KEY_USERNAME_DEV;

  @Value("${service.security.secure-key-password-dev}")
  private String SECURE_KEY_PASSWORD_DEV;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder auth = http.getSharedObject(
      AuthenticationManagerBuilder.class
    );

    auth.inMemoryAuthentication()
      .withUser(SECURE_KEY_USERNAME_ADMIN)
      .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD_ADMIN))
      .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
      .and()
      .withUser(SECURE_KEY_USERNAME_DEV)
      .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD_DEV))
      .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DEV"))
      .and()
      .passwordEncoder(new BCryptPasswordEncoder());

    return http.authorizeHttpRequests()
      .requestMatchers("/**")
      .hasRole("ADMIN")
      .and()
      .csrf()
      .disable()
      .httpBasic()
      .and()
      .exceptionHandling()
      .accessDeniedHandler((request, response, exception) -> {
        response.sendRedirect("https://angelcruzl.dev");
      })
      .and()
      .build();
  }
}
