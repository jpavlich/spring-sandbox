package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.sdl.odata.datasource.jpa.JPADataSourceModification;
import com.sdl.odata.service.ODataServiceConfiguration;


@SpringBootApplication
/*@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class })*/
@Import({
        JPADataSourceModification.class,
        ODataServiceConfiguration.class
})
@EntityScan("com.example.demo.model2")
@ComponentScan("com.example.demo.rest")
@ComponentScan("com.example.demo.security")
@ComponentScan("com.sdl.odata.datasource.jpa")
@ComponentScan("com.sdl.odata.datasource.jpa.builders")
@ComponentScan("com.sdl.odata.datasource.jpa.exceptions")
@ComponentScan("com.sdl.odata.datasource.jpa.mapper")
@ComponentScan("com.sdl.odata.datasource.jpa.query")
@ComponentScan("com.sdl.odata.datasource.jpa.util")
public class SecTest1Application extends SpringBootServletInitializer  {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		   return application.sources(application);
	}
	public static void main(String[] args) {
		SpringApplication.run(SecTest1Application.class, args);
	}
}
