/**
 * 
 */
package com.example.demo.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.olingo.commons.api.edmx.EdmxReference;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataHttpHandler;
import org.apache.olingo.server.api.ServiceMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.secTest1.DBEdmProvider;
import com.example.demo.secTest1.DBEntityCollectionProcessor;
import com.example.demo.secTest1.DemoEdmProvider;
import com.example.demo.secTest1.DemoEntityCollectionProcessor;

/**
 * @author Emmanuel Neiza
 *
 */
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(DemoServlet.class);
	public void service(final HttpServletRequest  req, final HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("I START DB SERVLET!!!!!!!!!!!!!!!!!!!!!!!!!"); 
		try {
		      // create odata handler and configure it with CsdlEdmProvider and Processor
		      OData odata = OData.newInstance();
		      ServiceMetadata edm = odata.createServiceMetadata(new DBEdmProvider(), new ArrayList<EdmxReference>());
		      ODataHttpHandler handler = odata.createHandler(edm);
		      handler.register(new DBEntityCollectionProcessor());

		      // let the handler do the work
		      handler.process(req, resp);
		    } catch (RuntimeException e) {
		      LOG.error("Server Error occurred in ExampleServlet", e);
		      throw new ServletException(e);
		    }
	}
	
}
