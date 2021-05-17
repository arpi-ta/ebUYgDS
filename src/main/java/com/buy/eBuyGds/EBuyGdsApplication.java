package com.buy.eBuyGds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableOAuth2Sso
public class EBuyGdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBuyGdsApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		MyFilter myFilter = new MyFilter();
		filterRegistrationBean.setFilter(myFilter);
		return filterRegistrationBean;
	}
}
