package com.csloan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@ComponentScan(basePackages="com.csloan")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	/***
	 *  Basic Spring Config Beans
	 * 
	 */
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	/**
	 * Here we define tiles beans config
	 */
	
	@Bean
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer conf = new TilesConfigurer();
		String[] definitions = {"/WEB-INF/tiles.xml"};
		conf.setDefinitions(definitions);
		//conf.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
		return conf;
	}
	@Bean
	public ViewResolver getTilesViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}
	
	/***
	 * Database connection & Service beans
	 */

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/csloan-portfolio");
		ds.setUsername("root");
		ds.setPassword("passwd01");
		return ds;
	}
}
