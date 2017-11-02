/**
 * 
 */
package com.example.demo.utils;


import javax.persistence.EntityManagerFactory;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;


import com.example.demo.rest.TestService;

/**
 * @author Emmanuel Neiza
 *
 */

public class JPAServiceFactory extends ODataJPAServiceFactory {
	private static final String PERSISTENCE_UNIT_NAME = "wo";
	
	
	private final EntityManagerFactory entityManagerFactory;
    private final String namespace;

    public JPAServiceFactory(EntityManagerFactory entityManagerFactory, String namespace) {
		this.entityManagerFactory = entityManagerFactory;
		this.namespace = namespace;
    }
    @Override
    public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		ODataJPAContext context = getODataJPAContext();
		context.setEntityManagerFactory(entityManagerFactory);
		context.setPersistenceUnitName(namespace);
		return context;
    }

}
