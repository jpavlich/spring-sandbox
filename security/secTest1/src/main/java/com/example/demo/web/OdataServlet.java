/**
 * 
 */
package com.example.demo.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.api.commons.ODataHttpMethod;
import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author Emmanuel Neiza
 *
 */

//@CrossOrigin(allowCredentials = "true")
public class OdataServlet extends ODataServlet {
	private static final long serialVersionUID = 1L;

	private final ODataServiceFactory serviceFactory;

	public OdataServlet(ODataServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if (!ODataHttpMethod.GET.name().equals(req.getMethod())) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		req.setAttribute(ODataServiceFactory.FACTORY_INSTANCE_LABEL, serviceFactory);
		super.service(req, res);
	}
}
