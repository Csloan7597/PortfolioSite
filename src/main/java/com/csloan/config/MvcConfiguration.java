package com.csloan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.csloan.data.Message;

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
		//ds.setUrl("jdbc:mysql://localhost:3306/csloan-portfolio");
		//ds.setUsername("root");
		//ds.setPassword("passwd01");
		ds.setUsername("adminKTKzVXd");
		ds.setPassword("quSB7MC3JMwV");
		ds.setUrl("jdbc:mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/");  
		return ds;
	}
	
	/***
	 * Java Mail
	 * 
	 */
	@Bean
	public JavaMailSenderImpl getMailSender() {
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		jms.setHost("smtp.gmail.com");
		jms.setPort(465);
		jms.setProtocol("smtp");
		jms.setUsername("conorsloansite@gmail.com");
		jms.setPassword("passwd01");
		return jms;
	}
	
	@Bean
	public SimpleMailMessage getTemplateMailMessage() {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom("conorsloansite@gmail.com");
		smm.setTo("c.sloan7597@googlemail.com");
		smm.setSubject("Message from a site visitor!");
		return smm;
	}
	
	@Bean
	public Message getTemplateMessage() {
		Message message = new Message();
		message.setSubject("Subject");
		message.setMessage("Message");
		message.setName("Name");
		message.setEmail("Email");
		return message;
	}
}
