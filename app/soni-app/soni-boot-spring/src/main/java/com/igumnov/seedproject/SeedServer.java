package com.igumnov.seedproject;

import java.util.Locale;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@EnableAutoConfiguration
@ComponentScan("com.igumnov.seedproject")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SeedServer extends WebMvcConfigurerAdapter {
    public static void main(String[] args) throws Exception {
	new SpringApplicationBuilder(SeedServer.class).run(args);
    }

    @Bean
    public ApplicationSecurity applicationSecurity() {
	return new ApplicationSecurity();
    }

    @Bean
    public LocaleResolver localeResolver() {
	SessionLocaleResolver slr = new SessionLocaleResolver();
	slr.setDefaultLocale(Locale.ENGLISH);
	return slr;
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Configuration
    protected static class AuthenticationSecurity extends GlobalAuthenticationConfigurerAdapter {

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication().withUser("demo").password("demo").roles("demo");
	}
    }

    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable().authorizeRequests().antMatchers("/report").permitAll().antMatchers("/jasper/**").permitAll().antMatchers("/webjars/**")
		    .permitAll().antMatchers("/ng-templates/**").permitAll().antMatchers("/rest/**").permitAll().antMatchers("/js/**").permitAll().anyRequest()
		    .fullyAuthenticated().and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and().logout()
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll().logoutSuccessUrl("/login?logout");

	}
    }

}