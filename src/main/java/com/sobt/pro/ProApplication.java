package com.sobt.pro;

import com.sobt.pro.filter.MyCORSFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.Filter;

@SpringBootApplication
@EnableScheduling
@MapperScan({"com.sobt.**.dao.func","com.sobt.**.dao"})
public class ProApplication {

	/**
	 * 配置过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(myCORSFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("myCORSFilter");
		return registration;
	}

	/**
	 * 创建一个bean
	 * @return
	 */
	@Bean(name = "sessionFilter")
	public Filter myCORSFilter() {
		return new MyCORSFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProApplication.class, args);
	}
}
