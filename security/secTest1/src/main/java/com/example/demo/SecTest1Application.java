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

import com.sdl.odata.datasource.jpa.JPADataSourceModification;
import com.sdl.odata.service.ODataServiceConfiguration;


@SpringBootApplication
@Import({
        JPADataSourceModification.class,
        ODataServiceConfiguration.class
})
@EntityScan("com.example.demo.model")
@ComponentScan("com.example.demo.rest")
public class SecTest1Application extends SpringBootServletInitializer  {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		   return application.sources(application);
	}
	public static void main(String[] args) {
		SpringApplication.run(SecTest1Application.class, args);
	}
	@Bean()
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new com.stimulsoft.web.servlet.StiWebResourceServlet(),"/stimulsoft_web_resource/*");
        
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean2(){
        return new ServletRegistrationBean(new com.stimulsoft.webdesigner.servlet.StiWebDesignerActionServlet(),"/stimulsoft_webdesigner_action");
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean3(){
        return new ServletRegistrationBean(new com.stimulsoft.webviewer.servlet.StiWebViewerActionServlet(),"/stimulsoft_webviewer_action");
    }
}
