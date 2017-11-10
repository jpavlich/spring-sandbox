package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.apache.olingo.odata2.core.edm.provider.EdmxProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.secTest1.DemoEdmProvider;
import com.example.demo.secTest1.DemoEntityCollectionProcessor;
import com.example.demo.utils.JPAServiceFactory;
import com.example.demo.web.DBServlet;
import com.example.demo.web.OdataServlet;
@ComponentScan(basePackages = "com.example.demo") 
@SpringBootApplication
public class SecTest1Application extends SpringBootServletInitializer  {
	private static final String[] REQUEST_METHOD_SUPPORTED = { "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD" };

	  @Autowired
	    private  EntityManagerFactory entityManagerFactory;
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
    @Bean
    public ServletRegistrationBean servletRegistrationBean4(){
        return new ServletRegistrationBean(new com.example.demo.web.DemoServlet(),"/DemoService.svc/*");
    }
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean6(){
        return new ServletRegistrationBean(new DBServlet(),"/list.svc/*");
    }
    @Bean
	public ServletRegistrationBean odataServlet() {
		ServletRegistrationBean odataServletRegistrationBean = new ServletRegistrationBean(new CXFNonSpringJaxrsServlet(), "/emplist.svc/*");
		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("javax.ws.rs.Application", "org.apache.olingo.odata2.core.rest.app.ODataApplication");
		initParameters.put("org.apache.olingo.odata2.service.factory", "utils.JPAServiceFactory");
		odataServletRegistrationBean.setInitParameters(initParameters);
		return odataServletRegistrationBean;
	}
    @Bean
    public ServletRegistrationBean odataServlet2() {
	return new ServletRegistrationBean(
		new OdataServlet(new JPAServiceFactory(entityManagerFactory, "Spring_Boot_OData")), "/example.svc/*");
    }
	@Bean()
    public DemoEdmProvider demoProvider(){
        return new DemoEdmProvider();  
    }
	@Bean()
    public DemoEntityCollectionProcessor entityCollection(){
        return new DemoEntityCollectionProcessor();  
    }
    /*@Bean
    public org.apache.olingo.odata2.core.edm.provider.EdmxProvider x() {
    	return new EdmxProvider();
    }
    @Bean
    public org.apache.olingo.server.api.processor.EntityCollectionProcessor x2() {
    	return new org.apache.olingo.server.api.processor.EntityCollectionProcessor();
    }
   @Bean
    public WebMvcConfigurer corsConfigurer() {
    	System.out.println("Cors Config");
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200","http://localhost:4200/reporte","http://localhost:8080/example.svc/","http://localhost:8080/example.svc/$metadata").allowedHeaders("*").allowedMethods(REQUEST_METHOD_SUPPORTED);;
            }
        };
    }*/
}
