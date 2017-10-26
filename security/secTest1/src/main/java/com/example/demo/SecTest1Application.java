package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecTest1Application extends SpringBootServletInitializer  {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		   return application.sources(application);
	}
	public static void main(String[] args) {
		SpringApplication.run(SecTest1Application.class, args);
	}
	@Bean
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
