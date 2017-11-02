package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.JPAServiceFactory;
import com.example.demo.web.OdataServlet;

@SpringBootApplication
public class SecTest1Application extends SpringBootServletInitializer  {

	  @Autowired
	    private  EntityManagerFactory entityManagerFactory;
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("asdasdasdas"+entityManagerFactory);
		   return application.sources(application);
	}
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SecTest1Application.class, args);
		
	
		/*System.out.println("List of beans provided by Spring Boot:");
	        String[] beanNames = ctx.getBeanDefinitionNames();
	        Arrays.sort(beanNames);
	        for (String beanName : beanNames) {
	            System.out.print(beanName);
	            System.out.print(" ");
	        }

	        System.out.println("");*/
	}
	@Bean()
    public ServletRegistrationBean servletRegistrationBean(){
		System.out.println("asdasdasdas"+entityManagerFactory);
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
}
